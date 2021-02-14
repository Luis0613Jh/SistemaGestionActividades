package controlador.DAO.objetosDAO;

import controlador.DAO.AdaptadorDAO;
import controlador.DAO.ConexionDAO;
import controlador.listaSimple.ListaSimple;
import controlador.utilidades.UtilidadesControlador;
import java.io.File;
import modelo.RolModelo;

public class RolDAO extends AdaptadorDAO {

    private RolModelo rol;

    /**
     * Construye un objeto de tipo RolDAO, instanciando en su clase padre (AdaptadorDAO): un nuevo objeto de tipo ConexionDAO,
     * la clase del objeto de tipo RolModelo y una String con la carpeta contenedora "Archivos".  
     */
    public RolDAO() {
        super(new ConexionDAO(), RolModelo.class, new ConexionDAO().getCARPETA_ROLES());
    }

    /**
     * Método que permite obtener el objeto de tipo RolModelo almacenado en la clase. 
     * @return Retorna el objeto de tipo RolModelo instanciado en la clase, en caso de que no exista, se crea un nuevo objeto RolModelo.
     */
    public RolModelo getRol() {
        if (rol == null) {
            rol = new RolModelo();
        }
        return rol;
    }

    /**
     * Método que permite sobreescribir el objeto de tipo RolModelo instanciado en la clase.
     * @param rol Objeto de tipo RolModelo que se va a sobreescribir en el objeto instanciado en la clase.
     */
    public void setRol(RolModelo rol) {
        this.rol = rol;
    }

    /**
     * Método que permite guardar una rol en su archivo contenedor.
     * @return Retorna true en caso de que se haya guardado con éxito la rol, caso contrario, retorna false.
     */
    public Boolean guardarRol() {
        try {
            this.guardarObjeto(this.getRol());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar rol: " + e);
            return false;
        }
    }

    /**
     * Método que permite ordenar los roles según el atributo especificado de forma ascendente.
     * @param lista Lista original que se desea ordenar de forma ascendente.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @return Retorna una lista ordenada según el atributo indicado a partir de la lista original, es de tipo ListaSimple.
     */
    public ListaSimple ordenarRoles(ListaSimple lista, String atributo) {
        UtilidadesControlador.ordenarQuicksort(0, lista.tamanio() - 1, lista, atributo);
        return lista;
    }

    /**
     * Método que permite buscar una rol según el dato indicado.
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la lista.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @param lista Lista en donde se va a buscar el rol según el dato y atributo indicados, es de tipo ListaSimple.
     * @return Retorna un objeto de tipo RolModelo con toda la información de la rol encontrada, en caso de no existir coincidencia, retorna null.
     */
    public RolModelo buscarRol(Object dato, String atributo, ListaSimple lista) {
        lista = ordenarRoles(lista, atributo);
        RolModelo cuenta = (RolModelo) UtilidadesControlador.buscarObjetoPorBusquedaBinariaPorDato(dato, atributo, lista);
        return cuenta;
    }

    /**
     * Método que permite crear cuatro roles quemados en código: Administrador, Jefe de proyecto, Encargado, Personal
     * @return Retorna true en caso de que se haya creado con éxito el archivo que contiene los roles, caso contrario, retorna false.
     */
    public Boolean crearRoles(){
        boolean bandera = false;
        File archivo = new File(new ConexionDAO().getCARPETA_CONTENEDORA() + File.separatorChar + new ConexionDAO().getCARPETA_ROLES() + File.separatorChar + RolModelo.class.getSimpleName() + ".json");
        
        if (!archivo.exists()) {
            System.out.println("Se han creado roles");
            
            RolModelo administradorRol = new RolModelo();
            administradorRol.setEstado("activo");
            administradorRol.setExternal_id(654984);
            administradorRol.setId(1);
            administradorRol.setTipo("Administrador");
            setRol(administradorRol);
            bandera = guardarRol();
            
            RolModelo jefeProyectoRol = new RolModelo();
            jefeProyectoRol.setEstado("activo");
            jefeProyectoRol.setExternal_id(3657);
            jefeProyectoRol.setId(2);
            jefeProyectoRol.setTipo("Jefe de Proyecto");
            setRol(jefeProyectoRol);
            bandera = guardarRol();
            
            RolModelo encargadoRol = new RolModelo();
            encargadoRol.setEstado("activo");
            encargadoRol.setExternal_id(1234);
            encargadoRol.setId(3);
            encargadoRol.setTipo("Encargado");
            setRol(encargadoRol);
            bandera = guardarRol();
            
            RolModelo rollRol = new RolModelo();
            rollRol.setEstado("activo");
            rollRol.setExternal_id(13254);
            rollRol.setId(4);
            rollRol.setTipo("Roll");
            setRol(rollRol);
            bandera = guardarRol();
            
        } else {
            System.out.println("Roles ya creados");
        }
        return bandera;
    }

    /**
     * Método que permite modificar una rol en el documento que lo contiene.
     * @param objeto Objeto que va a ser modificado en el archivo contenedor.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @param lista Lista en donde se va a buscar las coincidencias, es de tipo ListaSimple.
     * @return Retorna true en caso de que se haya modificado con éxito el rol, caso contrario, retorna false.
     */
    public Boolean modificarRol(Object objeto, String atributo, ListaSimple lista) {
        try {
            lista.editarPorDato(UtilidadesControlador.extraerDato(objeto, atributo), atributo, objeto);
            modificarObjetos(lista);
            return true;
        } catch (Exception e) {
            System.out.println("Error en modificar rol: " + e);
            return false;
        }
    }

    /**
     * Método que busca los roles con estado "activo" en el archivo contenedor.
     * @param lista ListaSimple en donde se va a buscar las coincidencias.
     * @return Retorna una lista con todas los roles con estado "activo", en caso de no existir coincidencias, retorna null.
     */
    public ListaSimple listarRolesActivos(ListaSimple lista) {
        ordenarRoles(lista, "estado");
        return listarCoincidencias(lista, "activo", "estado");
    }
    
    /**
     * Método que busca los roles con estado "inactivo" en el archivo contenedor.
     * @param lista ListaSimple en donde se va a buscar las coincidencias.
     * @return Retorna una lista con todas los roles con estado "inactivo", en caso de no existir coincidencias, retorna null.
     */
    public ListaSimple listarRolesInactivos(ListaSimple lista) {
        ordenarRoles(lista, "estado");
        return listarCoincidencias(lista, "inactivo", "estado");
    }
    
    /**
     * Método que permite dar de baja a una rol del sistema, cambiando su estado de "activo" a "inactivo".
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la lista.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @param lista Lista en donde se va a buscar las coincidencias, es de tipo ListaSimple.
     * @return Retorna true en caso de que se haya dado de baja con éxito el rol, caso contrario, retorna false.
     */
    public Boolean darDeBajaRol(Object dato, String atributo, ListaSimple lista) {
        RolModelo rol = buscarRol(dato, atributo, lista);
        rol.setEstado("inactivo");
        try {
            modificarRol(rol, atributo, lista);
            return true;
        } catch (Exception e) {
            System.out.println("Error en dar de baja el rol: " + e);
            return false;
        }
    }
    
    /**
     * Método que permite obtener el id del rol según un dato especíco del mismo.
     * @param lista Lista en donde se va a buscar el rol deseado.
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la lista.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @return Retorna el id del rol que se buscó en la lista en caso de que exista, caso contrario, retorna -1; 
     */
    public int obtenerIdRol(ListaSimple lista, Object dato, String atributo) {
        RolModelo rol = buscarRol(dato, atributo, lista);
        return (rol != null) ? rol.getId() : -1;
    }
}
