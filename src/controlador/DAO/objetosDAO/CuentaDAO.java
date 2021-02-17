package controlador.DAO.objetosDAO;

import controlador.DAO.AdaptadorDAO;
import controlador.DAO.ConexionDAO;
import controlador.listaSimple.ListaSimple;
import controlador.utilidades.UtilidadesControlador;
import modelo.CuentaModelo;

public class CuentaDAO extends AdaptadorDAO {

    private CuentaModelo cuenta;

    public CuentaDAO() {
        super(new ConexionDAO(), CuentaModelo.class, new ConexionDAO().getCARPETA_CUENTAS());
    }

    /**
     * Método que permite obtener el objeto de tipo CuentaModelo almacenado en
     * la clase.
     *
     * @return Retorna el objeto de tipo CuentaModelo instanciado en la clase,
     * en caso de que no exista, se crea un nuevo objeto CuentaModelo.
     */
    public CuentaModelo getCuenta() {
        if (cuenta == null) {
            cuenta = new CuentaModelo();
        }
        return cuenta;
    }

    /**
     * Método que permite sobreescribir el objeto de tipo CuentaModelo
     * instanciado en la clase.
     *
     * @param cuenta Objeto de tipo CuentaModelo que se va a sobreescribir en
     * el objeto instanciado en la clase.
     */
    public void setCuenta(CuentaModelo cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * Método que permite guardar una cuenta en su archivo contenedor.
     *
     * @return Retorna true en caso de que se haya guardado con éxito la
     * cuenta, caso contrario, retorna false.
     */
    public Boolean guardarCuenta() {
        try {
            this.guardarObjeto(this.getCuenta());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar cuenta: " + e);
            return false;
        }
    }

    /**
     * Método que permite a un usuario del sistema iniciar sesión.
     * @param usuario Usuario, es de tipo String.
     * @param clave Clave, es de tipo String.
     * @return Retorna un objeto de tipo CuentaModelo en caso de que exista una cuenta con dichos datos,
     * caso contrario, retorna null;
     */
    public CuentaModelo iniciarSesion(String usuario, String clave) {
        ListaSimple listaCuentas = listarObjetos();

        CuentaModelo cuenta = buscarCuenta(usuario, "usuario", listaCuentas);
        
        if (cuenta != null) {
            if (!cuenta.getClave().equals(clave)) {
                cuenta = null;
            }
        }
        return cuenta;
    }

    /**
     * Método que permite ordenar las cuentas según el atributo especificado de
     * forma ascendente.
     *
     * @param lista Lista original que se desea ordenar de forma ascendente.
     * @param atributo Atributo que especifica el nombre de la variable que
     * contiene el dato a buscar (variable instanciada en el modelo), es de tipo
     * String.
     * @return Retorna una lista ordenada según el atributo indicado a partir de
     * la lista original, es de tipo ListaSimple.
     */
    public ListaSimple ordenarCuentas(ListaSimple lista, String atributo) {
        UtilidadesControlador.ordenarQuicksort(0, lista.tamanio() - 1, lista, atributo);
        return lista;
    }
    
    /**
     * Método que permite buscar una cuenta según el dato indicado.
     *
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la
     * lista.
     * @param atributo Atributo que especifica el nombre de la variable que
     * contiene el dato a buscar (variable instanciada en el modelo), es de tipo
     * String.
     * @param lista Lista en donde se va a buscar la cuenta según el dato y
     * atributo indicados, es de tipo ListaSimple.
     * @return Retorna un objeto de tipo CuentaModelo con toda la información
     * de la cuenta encontrada, en caso de no existir coincidencia, retorna
     * null.
     */
    public CuentaModelo buscarCuenta(Object dato, String atributo, ListaSimple lista) {
        lista = ordenarCuentas(lista, atributo);
        CuentaModelo cuenta = (CuentaModelo) UtilidadesControlador.buscarObjetoPorBusquedaBinariaPorDato(dato, atributo, lista);
        return cuenta;
    }
    
    /**
     * Método que permite modificar una cuenta en el documento que lo contiene.
     *
     * @param objeto Objeto que va a ser modificado en el archivo contenedor.
     * @param atributo Atributo que especifica el nombre de la variable que
     * contiene el dato a buscar (variable instanciada en el modelo), es de tipo
     * String.
     * @param lista Lista en donde se va a buscar las coincidencias, es de tipo
     * ListaSimple.
     * @return Retorna true en caso de que se haya modificado con éxito la
     * cuenta, caso contrario, retorna false.
     */
    public Boolean modificarCuenta (Object objeto, String atributo, ListaSimple lista) {
        try {
            lista.editarPorDato(UtilidadesControlador.extraerDato(objeto, atributo), atributo, objeto);
            modificarObjetos(lista);
            return true;
        } catch (Exception e) {
            System.out.println("Error en modificar cuenta: " + e);
            return false;
        }
    }
    
    /**
     * Método que permite dar de baja a una cuenta del sistema, cambiando su
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
     * cuenta, caso contrario, retorna false.
     */
    public Boolean darDeBajaCuenta(Object dato, String atributo, ListaSimple lista) {
        CuentaModelo cuenta = buscarCuenta(dato, atributo, lista);
        cuenta.setEstado("inactivo");
        try {
            // Se modifica
            modificarCuenta(cuenta, atributo, lista);
            return true;
        } catch (Exception e) {
            System.out.println("Error en dar de baja el cuenta: " + e);
            return false;
        }
    }
    
    /**
     * Método que busca las cuentas con estado "activo" en el archivo contenedor.
     * @param lista ListaSimple en donde se va a buscar las coincidencias.
     * @return Retorna una lista con todas las cuentas con estado "activo", en caso de no existir coincidencias, retorna una lista vacía.
     */
    public ListaSimple listarCuentasActivas(ListaSimple lista) {
        ordenarCuentas(lista, "estado");
        return listarCoincidencias(lista, "activo", "estado");
    }
    
    /**
     * Método que busca las cuentas con estado "inactivo" en el archivo contenedor.
     * @param lista ListaSimple en donde se va a buscar las coincidencias.
     * @return Retorna una lista con todas las cuentas con estado "inactivo", en caso de no existir coincidencias, retorna una lista vacía.
     */
    public ListaSimple listarCuentasInactivas(ListaSimple lista) {
        ordenarCuentas(lista, "estado");
        return listarCoincidencias(lista, "inactivo", "estado");
    }
}
