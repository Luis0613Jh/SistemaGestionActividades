
package controlador.servicio;

import controlador.DAO.objetosDAO.RolDAO;
import controlador.listaSimple.ListaSimple;
import modelo.RolModelo;

public class RolServicio {

    public static String IDENTIFICADOR = "id";
    public static String TIPO = "tipo";
    public static String EXTERNAL_ID = "external_id";
    public static String ACTIVO = "activo";
    private RolDAO rolDAO = new RolDAO();

    /**
     * Método que permite obtener el objeto de tipo RolModelo almacenado en la clase RolDAO. 
     * @return Retorna el objeto de tipo RolModelo instanciado en la clase RolDAO.
     */
    public RolModelo getRol() {
        return rolDAO.getRol();
    }
    
    /**
     * Método que permite sobreescribir el objeto de tipo RolModelo instanciado en la clase RolDAO.
     * @param rol Objeto de tipo RolModelo que se va a sobreescribir en el objeto instanciado en la clase RolDAO.
     */
    public void setRol(RolModelo rol) {
        rolDAO.setRol(rol);
    }

    /**
     * Método que permite guardar un objeto de tipo RolModelo en su archivo contenedor.
     * @return Retorna true en caso de que se haya guardado con éxito el objeto de tipo RolModelo, caso contrario, retorna false.
     */
    public Boolean guardarRol() {
        return rolDAO.guardarRol();
    }

    /**
     * Método que permite obtener todos los objetos de tipo RolModelo almacenados en su archivo contenedor.
     * @return Retorna una lista con todos los objetos de tipo RolModelo encontrados, en caso de no existir rols, retorna null.
     */
    public ListaSimple listarRoles() {
        return rolDAO.listarObjetos();
    }

    /**
     * Método que busca los objetos de tipo RolModelo con estado "activo" en el archivo contenedor.
     * @param lista Lista en donde se va a buscar las coincidencias, es de tipo ListaSimple.
     * @return Retorna una lista con todos los objetos de tipo RolModelo con estado "activo", en caso de no existir coincidencias, retorna null.
     */
    public ListaSimple listarRolesActivos(ListaSimple lista) {
        return rolDAO.listarRolesActivos(lista);
    }

    /**
     * Método que busca los objetos de tipo RolModelo con estado "inactivo" en el archivo contenedor.
     * @param lista ListaSimple en donde se va a buscar las coincidencias.
     * @return Retorna una lista con todos los objetos de tipo RolModelo con estado "inactivo", en caso de no existir coincidencias, retorna null.
     */
    public ListaSimple listarRolesInactivos(ListaSimple lista) {
        return rolDAO.listarRolesInactivos(lista);
    }
    
    /**
     * Método que permite ordenar los objetos de tipo RolModelo según el atributo especificado de forma ascendente.
     * @param lista Lista original que se desea ordenar de forma ascendente.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @return Retorna una lista ordenada según el atributo indicado a partir de la lista original, es de tipo ListaSimple.
     */
    public ListaSimple ordenarListadoRoles(String atributo) {
        return rolDAO.ordenarRoles(rolDAO.listarObjetos(), atributo);
    }

    public Boolean crearRoles() {
        return rolDAO.crearRoles();
    }
    
    /**
     * Método que permite buscar un objeto de tipo RolModelo según el dato indicado.
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la lista.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @param lista Lista en donde se va a buscar el objeto de tipo RolModelo según el dato y atributo indicados, es de tipo ListaSimple.
     * @return Retorna un objeto de tipo RolModelo con toda la información de la rol encontrado, en caso de no existir coincidencia, retorna null.
     */
    public RolModelo buscarRol(Object dato, String atributo) {
        return rolDAO.buscarRol(dato, atributo, listarRoles());
    }
    
    /**
     * Método que permite modificar un objeto de tipo RolModelo en su archivo contenedor.
     * @param objeto Objeto que va a ser modificado en el archivo contenedor.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @param lista Lista en donde se va a buscar las coincidencias, es de tipo ListaSimple.
     * @return Retorna true en caso de que se haya modificado con éxito el objeto de tipo RolModelo, caso contrario, retorna false.
     */
    public Boolean modificarRol (Object objeto, String atributo, ListaSimple lista) {
        return rolDAO.modificarRol(objeto, atributo, lista);
    }
    
    /**
     * Método que permite dar de baja a un objeto de tipo RolModelo del sistema, cambiando su estado de "activo" a "inactivo".
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la lista.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @param lista Lista en donde se va a buscar la coincidencia, es de tipo ListaSimple.
     * @return Retorna true en caso de que se haya dado de baja con éxito el objeto de tipo RolModelo, caso contrario, retorna false.
     */
    public Boolean darDeBajaRol (Object dato, String atributo, ListaSimple lista) {
        return rolDAO.darDeBajaRol(dato, atributo, lista);
    }
    
    /**
     * Método que permite obtener el id del objeto de tipo RolModelo, según un dato especíco del mismo.
     * @param lista Lista en donde se va a buscar el objeto de tipo RolModelo.
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la lista.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @return Retorna el id del objeto de tipo RolModelo que se buscó en la lista en caso de que exista, caso contrario, retorna -1; 
     */
    public int obtenerIdRol(ListaSimple lista, Object dato, String atributo) {
        return rolDAO.obtenerIdRol(lista, dato, atributo);
    }
}
