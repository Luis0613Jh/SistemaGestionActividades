package controlador.servicio;

import controlador.DAO.objetosDAO.ActividadPersonalDAO;
import controlador.listaSimple.ListaSimple;
import modelo.ActividadPersonalModelo;

public class ActividadPersonalServicio {

    public static String IDENTIFICADOR = "id";
    public static String NOMBRE = "nombre";
    public static String FECHA_INICIO = "fechaInicio";
    public static String FECHA_ENTREGA = "fechaEntrega";
    public static String EXTERNAL_ID = "external_id";
    public static String DESCRIPCION = "descripcion";
    public static String PRIORIDAD = "prioridad";
    public static String ACTIVO = "activo";
    private ActividadPersonalDAO actividadPersonalDAO = new ActividadPersonalDAO();

    /**
     * Método que permite obtener el objeto de tipo ActividadPersonalModelo almacenado en la clase ActividadPersonalDAO. 
     * @return Retorna el objeto de tipo ActividadPersonalModelo instanciado en la clase ActividadPersonalDAO.
     */
    public ActividadPersonalModelo getActividadPersonal() {
        return actividadPersonalDAO.getActividadPersonal();
    }
    
    /**
     * Método que permite sobreescribir el objeto de tipo ActividadPersonalModelo instanciado en la clase ActividadPersonalDAO.
     * @param actividadPersonal Objeto de tipo ActividadPersonalModelo que se va a sobreescribir en el objeto instanciado en la clase ActividadPersonalDAO.
     */
    public void setActividadPersonal(ActividadPersonalModelo actividadPersonal) {
        actividadPersonalDAO.setActividadPersonal(actividadPersonal);
    }

    /**
     * Método que permite guardar un objeto de tipo ActividadPersonalModelo en su archivo contenedor.
     * @return Retorna true en caso de que se haya guardado con éxito el objeto de tipo ActividadPersonalModelo, caso contrario, retorna false.
     */
    public Boolean guardarActividadPersonal() {
        return actividadPersonalDAO.guardarActividadPersonal();
    }

    /**
     * Método que permite obtener todos los objetos de tipo ActividadPersonalModelo almacenados en su archivo contenedor.
     * @return Retorna una lista con todos los objetos de tipo ActividadPersonalModelo encontrados, en caso de no existir actividadPersonals, retorna null.
     */
    public ListaSimple listarActividadesPersonales() {
        return actividadPersonalDAO.listarObjetos();
    }
    
    /**
     * Método que busca los objetos de tipo ActividadPersonalModelo coincidentes en su archivo contenedor, según el dato y atributo indicado.
     * @param lista Lista en donde se va a buscar las coincidencias, es de tipo ListaSimple.
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la lista.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @return Retorna una lista con todas las coincidencias encontradas, en caso de no existir coincidencias, retorna null.
     */
    public ListaSimple listarActividadesPersonalesCoincidencias(ListaSimple lista, Object dato, String atributo) {
        return actividadPersonalDAO.listarActividadPersonalesCoincidentes(lista, dato, atributo);
    }

    /**
     * Método que busca los objetos de tipo ActividadPersonalModelo con estado "activo" en el archivo contenedor.
     * @param lista Lista en donde se va a buscar las coincidencias, es de tipo ListaSimple.
     * @return Retorna una lista con todos los objetos de tipo ActividadPersonalModelo con estado "activo", en caso de no existir coincidencias, retorna null.
     */
    public ListaSimple listarActividadesPersonalesActivas(ListaSimple lista) {
        return actividadPersonalDAO.listarActividadPersonalesActivos(lista);
    }

    /**
     * Método que busca los objetos de tipo ActividadPersonalModelo con estado "inactivo" en el archivo contenedor.
     * @param lista ListaSimple en donde se va a buscar las coincidencias.
     * @return Retorna una lista con todos los objetos de tipo ActividadPersonalModelo con estado "inactivo", en caso de no existir coincidencias, retorna null.
     */
    public ListaSimple listarActividadesPersonalesInactivas(ListaSimple lista) {
        return actividadPersonalDAO.listarActividadPersonalesInactivos(lista);
    }
    
    /**
     * Método que permite ordenar los objetos de tipo ActividadPersonalModelo según el atributo especificado de forma ascendente.
     * @param lista Lista original que se desea ordenar de forma ascendente.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @return Retorna una lista ordenada según el atributo indicado a partir de la lista original, es de tipo ListaSimple.
     */
    public ListaSimple ordenarListadoActividadesPersonales(String atributo) {
        return actividadPersonalDAO.ordenarActividadesPersonales(actividadPersonalDAO.listarObjetos(), atributo);
    }

    /**
     * Método que permite buscar un objeto de tipo ActividadPersonalModelo según el dato indicado.
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la lista.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @param lista Lista en donde se va a buscar el objeto de tipo ActividadPersonalModelo según el dato y atributo indicados, es de tipo ListaSimple.
     * @return Retorna un objeto de tipo ActividadPersonalModelo con toda la información de la actividadPersonal encontrada, en caso de no existir coincidencia, retorna null.
     */
    public ActividadPersonalModelo buscarActividadPersonal(Object dato, String atributo) {
        return actividadPersonalDAO.buscarActividadPersonal(dato, atributo, listarActividadesPersonales());
    }

    /**
     * Método que permite modificar un objeto de tipo ActividadPersonalModelo en su archivo contenedor.
     * @param objeto Objeto que va a ser modificado en el archivo contenedor.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @param lista Lista en donde se va a buscar las coincidencias, es de tipo ListaSimple.
     * @return Retorna true en caso de que se haya modificado con éxito el objeto de tipo ActividadPersonalModelo, caso contrario, retorna false.
     */
    public Boolean modificarActividadPersonal (Object objeto, String atributo, ListaSimple lista) {
        return actividadPersonalDAO.modificarActividadPersonal(objeto, atributo, lista);
    }
    
    /**
     * Método que permite dar de baja a un objeto de tipo ActividadPersonalModelo del sistema, cambiando su estado de "activo" a "inactivo".
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la lista.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @param lista Lista en donde se va a buscar la coincidencia, es de tipo ListaSimple.
     * @return Retorna true en caso de que se haya dado de baja con éxito el objeto de tipo ActividadPersonalModelo, caso contrario, retorna false.
     */
    public Boolean darDeBajaActividadPersonal (Object dato, String atributo, ListaSimple lista) {
        return actividadPersonalDAO.darDeBajaActividadPersonal(dato, atributo, lista);
    }
    
    /**
     * Método que permite obtener el id del objeto de tipo ActividadPersonalModelo, según un dato especíco del mismo.
     * @param lista Lista en donde se va a buscar el objeto de tipo ActividadPersonalModelo.
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la lista.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @return Retorna el id del objeto de tipo ActividadPersonalModelo que se buscó en la lista en caso de que exista, caso contrario, retorna -1; 
     */
    public int obtenerIdActividadPersonal(ListaSimple lista, Object dato, String atributo) {
        return actividadPersonalDAO.obtenerIdActividadPersonal(lista, dato, atributo);
    }
}
