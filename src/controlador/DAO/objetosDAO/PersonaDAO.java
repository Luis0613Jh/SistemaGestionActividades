package controlador.DAO.objetosDAO;

import controlador.DAO.AdaptadorDAO;
import controlador.DAO.ConexionDAO;
import controlador.listaSimple.ListaSimple;
import controlador.servicio.CuentaServicio;
import controlador.servicio.RolServicio;
import controlador.utilidades.UtilidadesControlador;
import java.io.File;
import modelo.CuentaModelo;
import modelo.PersonaModelo;

public class PersonaDAO extends AdaptadorDAO {

    private PersonaModelo persona;

    /**
     * Construye un objeto de tipo PersonaDAO, instanciando en su clase padre
     * (AdaptadorDAO): un nuevo objeto de tipo ConexionDAO, la clase del objeto
     * de tipo PersonaModelo y una String con la carpeta contenedora "Archivos".
     */
    public PersonaDAO() {
        super(new ConexionDAO(), PersonaModelo.class, new ConexionDAO().getCARPETA_EMPLEADOS());
    }

    /**
     * Método que permite obtener el objeto de tipo PersonaModelo almacenado en
     * la clase.
     *
     * @return Retorna el objeto de tipo PersonaModelo instanciado en la clase,
     * en caso de que no exista, se crea un nuevo objeto PersonaModelo.
     */
    public PersonaModelo getPersona() {
        if (persona == null) {
            persona = new PersonaModelo();
        }
        return persona;
    }

    /**
     * Método que permite sobreescribir el objeto de tipo PersonaModelo
     * instanciado en la clase.
     *
     * @param persona Objeto de tipo PersonaModelo que se va a sobreescribir en
     * el objeto instanciado en la clase.
     */
    public void setPersona(PersonaModelo persona) {
        this.persona = persona;
    }

    /**
     * Método que permite guardar una persona en su archivo contenedor.
     *
     * @return Retorna true en caso de que se haya guardado con éxito la
     * persona, caso contrario, retorna false.
     */
    public Boolean guardarPersona() {
        try {
            this.guardarObjeto(this.getPersona());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar persona: " + e);
            return false;
        }
    }

    /**
     * Método que permite crear un administrador por defecto (datos quemados)
     *
     * @return Retorna true en caso de que se haya creado con éxito el archivo
     * que contiene al administrador, caso contrario, retorna false.
     */
    public Boolean crearAdministrador() {
        boolean bandera = false;
        File archivo = new File(new ConexionDAO().getCARPETA_CONTENEDORA() + File.separatorChar + new ConexionDAO().getCARPETA_EMPLEADOS() + File.separatorChar + PersonaModelo.class.getSimpleName() + ".json");

        if (!archivo.exists()) {
            ListaSimple listaPersonas = listarObjetos();
            System.out.println("Se ha creado el administrador");
            PersonaModelo administrador = new PersonaModelo();
            administrador.setNombre("Pedro");
            administrador.setCorreo("pedrito9876@gmail.com");
            administrador.setTelefono("0954329856");
            administrador.setCedula("1150543865");
            if (listaPersonas != null) {
                administrador.setId(listaPersonas.tamanio() + 1);
                administrador.setId_cuenta(listaPersonas.tamanio() + 1);
            } else {
                administrador.setId(1);
                administrador.setId_cuenta(1);
            }
            administrador.setId_rol(new RolServicio().obtenerIdRol(new RolServicio().listarRoles(), "Administrador", "tipo"));
            administrador.setId_departamento(-1);
            //administrador.setPath_imagen(-1);
            administrador.setEstado("activo");

            setPersona(administrador);

            CuentaModelo cuentaAdministrador = new CuentaModelo();
            cuentaAdministrador.setId(administrador.getId_cuenta());
            cuentaAdministrador.setUsuario("admin");
            cuentaAdministrador.setClave("administracion2021");
            cuentaAdministrador.setEstado("activo");

            CuentaDAO cuentaDAO = new CuentaDAO();
            cuentaDAO.setCuenta(cuentaAdministrador);

            if (cuentaDAO.guardarCuenta()) {
                System.out.println("Se guardo correctamente la cuenta del administrador");
                bandera = true;
                if (guardarPersona()) {
                    System.out.println("Se guardo correctamente el administrador");
                    bandera = true;
                } else {
                    System.out.println("No se pudo guardar el administrador");
                    bandera = false;
                }
            } else {
                System.out.println("No se pudo guardar la cuenta del administrador");
                bandera = false;
            }
            setPersona(null);
        } else {
            System.out.println("Administrador ya creado");
        }
        return bandera;
    }

    /**
     * Método que permite ordenar las personas según el atributo especificado de
     * forma ascendente.
     *
     * @param lista Lista original que se desea ordenar de forma ascendente.
     * @param atributo Atributo que especifica el nombre de la variable que
     * contiene el dato a buscar (variable instanciada en el modelo), es de tipo
     * String.
     * @return Retorna una lista ordenada según el atributo indicado a partir de
     * la lista original, es de tipo ListaSimple.
     */
    public ListaSimple ordenarPersonas(ListaSimple lista, String atributo) {
        UtilidadesControlador.ordenarQuicksort(0, lista.tamanio() - 1, lista, atributo);
        return lista;
    }

    /**
     * Método que permite buscar una persona según el dato indicado.
     *
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la
     * lista.
     * @param atributo Atributo que especifica el nombre de la variable que
     * contiene el dato a buscar (variable instanciada en el modelo), es de tipo
     * String.
     * @param lista Lista en donde se va a buscar la persona según el dato y
     * atributo indicados, es de tipo ListaSimple.
     * @return Retorna un objeto de tipo PersonaModelo con toda la información
     * de la persona encontrada, en caso de no existir coincidencia, retorna
     * null.
     */
    public PersonaModelo buscarPersona(Object dato, String atributo, ListaSimple lista) {
        lista = ordenarPersonas(lista, atributo);
        return (PersonaModelo) UtilidadesControlador.buscarObjetoPorBusquedaBinariaPorDato(dato, atributo, lista);
    }

    /**
     * Método que permite modificar una persona en el documento que lo contiene.
     *
     * @param objeto Objeto que va a ser modificado en el archivo contenedor.
     * @param atributo Atributo que especifica el nombre de la variable que
     * contiene el dato a buscar (variable instanciada en el modelo), es de tipo
     * String.
     * @param lista Lista en donde se va a buscar las coincidencias, es de tipo
     * ListaSimple.
     * @return Retorna true en caso de que se haya modificado con éxito la
     * persona, caso contrario, retorna false.
     */
    public Boolean modificarPersona(Object objeto, String atributo, ListaSimple lista) {
        try {
            lista.editarPorDato(UtilidadesControlador.extraerDato(objeto, atributo), atributo, objeto);
            lista.imprimir();
            modificarObjetos(lista);
            return true;
        } catch (Exception e) {
            System.out.println("Error en modificar persona: " + e);
            return false;
        }
    }

    /**
     * Método que permite dar de baja a una persona del sistema, cambiando su
     * estado de "activo" a "inactivo".
     *
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la
     * lista.
     * @param atributo Atributo que especifica el nombre de la variable que
     * contiene el dato a buscar (variable instanciada en el modelo), es de tipo
     * String.
     * @param lista Lista en donde se va a buscar las coincidencias, es de tipo
     * ListaSimple.
     * @return Retorna true en caso de que se haya dado de baja con éxito a la
     * persona, caso contrario, retorna false.
     */
    public Boolean darDeBajaPersona(Object dato, String atributo, ListaSimple lista) {
        PersonaModelo persona = buscarPersona(dato, atributo, lista);
        persona.setEstado("inactivo");
        try {
            modificarPersona(persona, atributo, lista);
            return true;
        } catch (Exception e) {
            System.out.println("Error en dar de baja el persona: " + e);
            return false;
        }
    }

    /**
     * Método que busca las personas conincidentes con el dato a buscar según el
     * atributo indicado.
     *
     * @param lista Lista en donde se va a buscar las coincidencias, es de tipo
     * ListaSimple.
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la
     * lista.
     * @param atributo Atributo que especifica el nombre de la variable que
     * contiene el dato a buscar (variable instanciada en el modelo), es de tipo
     * String.
     * @return Retorna una lista con todas las coincidencias encontradas, en
     * caso de no existir coincidencias, retorna null.
     */
    public ListaSimple listarPersonasCoincidentes(ListaSimple lista, Object dato, String atributo) {
        ordenarPersonas(lista, atributo);
        return listarCoincidencias(lista, dato, atributo);
    }

    /**
     * Método que busca las personas con estado "activo" en el archivo
     * contenedor.
     *
     * @param lista Lista en donde se va a buscar las coincidencias, es de tipo
     * ListaSimple.
     * @return Retorna una lista con todas las personas con estado "activo", en
     * caso de no existir coincidencias, retorna null.
     */
    public ListaSimple listarPersonasActivas(ListaSimple lista) {
        ordenarPersonas(lista, "estado");
        return listarCoincidencias(lista, "activo", "estado");
    }

    /**
     * Método que busca las personas con estado "inactivo" en el archivo
     * contenedor.
     *
     * @param lista ListaSimple en donde se va a buscar las coincidencias.
     * @return Retorna una lista con todas las personas con estado "inactivo",
     * en caso de no existir coincidencias, retorna null.
     */
    public ListaSimple listarPersonasInactivas(ListaSimple lista) {
        ordenarPersonas(lista, "estado");
        return listarCoincidencias(lista, "inactivo", "estado");
    }

    /**
     * Método que permite obtener el id de la persona según un dato especíco de
     * la misma.
     *
     * @param lista Lista en donde se va a buscar la persona deseada.
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la
     * lista.
     * @param atributo Atributo que especifica el nombre de la variable que
     * contiene el dato a buscar (variable instanciada en el modelo), es de tipo
     * String.
     * @return Retorna el id de la persona que se buscó en la lista en caso de
     * que exista, caso contrario, retorna -1;
     */
    public int obtenerIdPersona(ListaSimple lista, Object dato, String atributo) {
        PersonaModelo persona = buscarPersona(dato, atributo, lista);
        return (persona != null) ? persona.getId() : -1;
    }

}
