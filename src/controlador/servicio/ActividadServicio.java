package controlador.servicio;

import controlador.DAO.objetosDAO.ActividadDAO;
import controlador.listaSimple.ListaSimple;
import modelo.ActividadModelo;

public class ActividadServicio {

    public static String IDENTIFICADOR = "id";
    public static String NOMBRE = "nombre";
    public static String FECHA_INICIO = "fechaInicio";
    public static String FECHA_ENTREGA = "fechaEntrega";
    public static String EXTERNAL_ID = "external_id";
    public static String DESCRIPCION = "descripcion";
    public static String PRIORIDAD = "prioridad";
    public static String ACTIVO = "activo";
    private ActividadDAO actividadDAO = new ActividadDAO();

    /**
     * Método que permite obtener el objeto de tipo ActividadModelo almacenado en la clase ActividadDAO. 
     * @return Retorna el objeto de tipo ActividadModelo instanciado en la clase ActividadDAO.
     */
    public ActividadModelo getActividad() {
        return actividadDAO.getActividad();
    }
    
    /**
     * Método que permite sobreescribir el objeto de tipo ActividadModelo instanciado en la clase ActividadDAO.
     * @param actividad Objeto de tipo ActividadModelo que se va a sobreescribir en el objeto instanciado en la clase ActividadDAO.
     */
    public void setActividad(ActividadModelo actividad) {
        actividadDAO.setActividad(actividad);
    }

    /**
     * Método que permite guardar un objeto de tipo ActividadModelo en su archivo contenedor.
     * @return Retorna true en caso de que se haya guardado con éxito el objeto de tipo ActividadModelo, caso contrario, retorna false.
     */
    public Boolean guardarActividad() {
        return actividadDAO.guardarActividad();
    }

    /**
     * Método que permite obtener todos los objetos de tipo ActividadModelo almacenados en su archivo contenedor.
     * @return Retorna una lista con todos los objetos de tipo ActividadModelo encontrados, en caso de no existir actividads, retorna null.
     */
    public ListaSimple listarActividades() {
        return actividadDAO.listarObjetos();
    }
    
    /**
     * Método que busca los objetos de tipo ActividadModelo conincidentes en su archivo contenedor, según el dato y atributo indicado.
     * @param lista Lista en donde se va a buscar las coincidencias, es de tipo ListaSimple.
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la lista.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @return Retorna una lista con todas las coincidencias encontradas, en caso de no existir coincidencias, retorna null.
     */
    public ListaSimple listarActividadesCoincidencias(ListaSimple lista, Object dato, String atributo) {
        return actividadDAO.listarActividadesCoincidentes(lista, dato, atributo);
    }

    /**
     * Método que busca los objetos de tipo ActividadModelo con estado "activo" en el archivo contenedor.
     * @param lista Lista en donde se va a buscar las coincidencias, es de tipo ListaSimple.
     * @return Retorna una lista con todos los objetos de tipo ActividadModelo con estado "activo", en caso de no existir coincidencias, retorna null.
     */
    public ListaSimple listarActividadesActivos(ListaSimple lista) {
        return actividadDAO.listarActividadesActivos(lista);
    }

    /**
     * Método que busca los objetos de tipo ActividadModelo con estado "inactivo" en el archivo contenedor.
     * @param lista ListaSimple en donde se va a buscar las coincidencias.
     * @return Retorna una lista con todos los objetos de tipo ActividadModelo con estado "inactivo", en caso de no existir coincidencias, retorna null.
     */
    public ListaSimple listarActividadesInactivos(ListaSimple lista) {
        return actividadDAO.listarActividadesInactivos(lista);
    }
    
    /**
     * Método que permite ordenar los objetos de tipo ActividadModelo según el atributo especificado de forma ascendente.
     * @param lista Lista original que se desea ordenar de forma ascendente.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @return Retorna una lista ordenada según el atributo indicado a partir de la lista original, es de tipo ListaSimple.
     */
    public ListaSimple ordenarListadoActividads(String atributo) {
        return actividadDAO.ordenarActividades(actividadDAO.listarObjetos(), atributo);
    }

    /**
     * Método que permite buscar un objeto de tipo ActividadModelo según el dato indicado.
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la lista.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @param lista Lista en donde se va a buscar el objeto de tipo ActividadModelo según el dato y atributo indicados, es de tipo ListaSimple.
     * @return Retorna un objeto de tipo ActividadModelo con toda la información de la actividad encontrada, en caso de no existir coincidencia, retorna null.
     */
    public ActividadModelo buscarActividad(Object dato, String atributo) {
        return actividadDAO.buscarActividad(dato, atributo, listarActividades());
    }

    /**
     * Método que permite modificar un objeto de tipo ActividadModelo en su archivo contenedor.
     * @param objeto Objeto que va a ser modificado en el archivo contenedor.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @param lista Lista en donde se va a buscar las coincidencias, es de tipo ListaSimple.
     * @return Retorna true en caso de que se haya modificado con éxito el objeto de tipo ActividadModelo, caso contrario, retorna false.
     */
    public Boolean modificarActividad (Object objeto, String atributo, ListaSimple lista) {
        return actividadDAO.modificarActividad(objeto, atributo, lista);
    }
    
    /**
     * Método que permite dar de baja a un objeto de tipo ActividadModelo del sistema, cambiando su estado de "activo" a "inactivo".
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la lista.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @param lista Lista en donde se va a buscar la coincidencia, es de tipo ListaSimple.
     * @return Retorna true en caso de que se haya dado de baja con éxito el objeto de tipo ActividadModelo, caso contrario, retorna false.
     */
    public Boolean darDeBajaActividad (Object dato, String atributo, ListaSimple lista) {
        return actividadDAO.darDeBajaActividad(dato, atributo, lista);
    }
    
    /**
     * Método que permite obtener el id del objeto de tipo ActividadModelo, según un dato especíco del mismo.
     * @param lista Lista en donde se va a buscar el objeto de tipo ActividadModelo.
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la lista.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @return Retorna el id del objeto de tipo ActividadModelo que se buscó en la lista en caso de que exista, caso contrario, retorna -1; 
     */
    public int obtenerIdActividad(ListaSimple lista, Object dato, String atributo) {
        return actividadDAO.obtenerIdActividad(lista, dato, atributo);
    }
}
