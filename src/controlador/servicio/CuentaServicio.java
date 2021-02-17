
package controlador.servicio;

import controlador.DAO.objetosDAO.CuentaDAO;
import controlador.listaSimple.ListaSimple;
import modelo.CuentaModelo;

public class CuentaServicio {
    public static String IDENTIFICADOR = "id";
    public static String NOMBRE = "nombre";
    public static String EXTERNAL_ID = "external_id";
    public static String USUARIO = "usuario";
    public static String CLAVE = "clave";
    public static String ACTIVO = "activo";
    private CuentaDAO cuentaDAO = new CuentaDAO();

    /**
     * Método que permite obtener el objeto de tipo CuentaModelo almacenado en
     * la clase.
     *
     * @return Retorna el objeto de tipo CuentaModelo instanciado en la clase,
     * en caso de que no exista, se crea un nuevo objeto CuentaModelo.
     */
    public CuentaModelo getCuentaDAO() {
        return cuentaDAO.getCuenta();
    }

    /**
     * Método que permite guardar una cuenta en su archivo contenedor.
     *
     * @return Retorna true en caso de que se haya guardado con éxito la
     * cuenta, caso contrario, retorna false.
     */
    public Boolean guardarCuenta() {
        return cuentaDAO.guardarCuenta();
    }
    
    /**
     * Método que permite a un usuario del sistema iniciar sesión.
     * @param usuario Usuario, es de tipo String.
     * @param clave Clave, es de tipo String.
     * @return Retorna un objeto de tipo CuentaModelo en caso de que exista una cuenta con dichos datos,
     * caso contrario, retorna null;
     */
    public CuentaModelo inicarSesion(String usuario, String clave) {
        return cuentaDAO.iniciarSesion(usuario, clave);
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
        return cuentaDAO.modificarCuenta(objeto, atributo, lista);
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
    public Boolean darDeBajaCuenta (Object dato, String atributo, ListaSimple lista) {
        return cuentaDAO.darDeBajaCuenta(dato, atributo, lista);
    }
    
    /**
     * Método que busca las cuentas con estado "activo" en el archivo contenedor.
     * @param lista ListaSimple en donde se va a buscar las coincidencias.
     * @return Retorna una lista con todas las cuentas con estado "activo", en caso de no existir coincidencias, retorna una lista vacía.
     */
    public ListaSimple listarCuentasActivas(ListaSimple lista) {
        return cuentaDAO.listarCuentasActivas(lista);
    }

    /**
     * Método que busca las cuentas con estado "inactivo" en el archivo contenedor.
     * @param lista ListaSimple en donde se va a buscar las coincidencias.
     * @return Retorna una lista con todas las cuentas con estado "inactivo", en caso de no existir coincidencias, retorna una lista vacía.
     */
    public ListaSimple listarCuentasInactivas(ListaSimple lista) {
        return cuentaDAO.listarCuentasInactivas(lista);
    }
    
    /**
     * método que permite obtenr las cuentas registradas en el sistema.
     * @return Retorna una lista con todas las cuentas registradas en el sistema, es de tipo ListaSimple.
     */
    public ListaSimple listarCuentas() {
        return cuentaDAO.listarObjetos();
    }
}
