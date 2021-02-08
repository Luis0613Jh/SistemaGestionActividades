package controlador.servicio;

import controlador.DAO.objetosDAO.HitoDAO;
import controlador.listaSimple.ListaSimple;
import modelo.HitoModelo;

public class HitoServicio {

    public static String IDENTIFICADOR = "id";
    public static String NOMBRE = "nombre";
    public static String DESCRIPCION = "decripcion";
    public static String FECHA_INICIO = "fechaInicio";
    public static String EXTERNAL_ID = "external_id";
    public static String PRIORIDAD = "prioridad";
    public static String RESPONSABLE = "responsable";
    public static String ACTIVO = "activo";
    private HitoDAO hitoDAO = new HitoDAO();

    /**
     * Método que permite obtener el objeto de tipo HitoModelo almacenado en la clase HitoDAO. 
     * @return Retorna el objeto de tipo HitoModelo instanciado en la clase HitoDAO.
     */
    public HitoModelo getHito() {
        return hitoDAO.getHito();
    }
    
    /**
     * Método que permite sobreescribir el objeto de tipo HitoModelo instanciado en la clase HitoDAO.
     * @param hito Objeto de tipo HitoModelo que se va a sobreescribir en el objeto instanciado en la clase HitoDAO.
     */
    public void setHito(HitoModelo hito) {
        hitoDAO.setHito(hito);
    }

    /**
     * Método que permite guardar un objeto de tipo HitoModelo en su archivo contenedor.
     * @return Retorna true en caso de que se haya guardado con éxito el objeto de tipo HitoModelo, caso contrario, retorna false.
     */
    public Boolean guardarHito() {
        return hitoDAO.guardarHito();
    }

    /**
     * Método que permite obtener todos los objetos de tipo HitoModelo almacenados en su archivo contenedor.
     * @return Retorna una lista con todos los objetos de tipo HitoModelo encontrados, en caso de no existir hitos, retorna null.
     */
    public ListaSimple listarHitos() {
        return hitoDAO.listarObjetos();
    }

    /**
     * Método que busca los objetos de tipo HitoModelo conincidentes en su archivo contenedor, según el dato y atributo indicado.
     * @param lista Lista en donde se va a buscar las coincidencias, es de tipo ListaSimple.
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la lista.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @return Retorna una lista con todas las coincidencias encontrados, en caso de no existir coincidencias, retorna null.
     */
    public ListaSimple listarHitosCoincidencias(ListaSimple lista, Object dato, String atributo) {
        return hitoDAO.listarHitosCoincidentes(lista, dato, atributo);
    }
    
    /**
     * Método que busca los objetos de tipo HitoModelo con estado "activo" en el archivo contenedor.
     * @param lista Lista en donde se va a buscar las coincidencias, es de tipo ListaSimple.
     * @return Retorna una lista con todos los objetos de tipo HitoModelo con estado "activo", en caso de no existir coincidencias, retorna null.
     */
    public ListaSimple listarHitosActivos(ListaSimple lista) {
        return hitoDAO.listarHitosActivos(lista);
    }

    /**
     * Método que busca los objetos de tipo HitoModelo con estado "inactivo" en el archivo contenedor.
     * @param lista ListaSimple en donde se va a buscar las coincidencias.
     * @return Retorna una lista con todos los objetos de tipo HitoModelo con estado "inactivo", en caso de no existir coincidencias, retorna null.
     */
    public ListaSimple listarHitosInactivos(ListaSimple lista) {
        return hitoDAO.listarHitosInactivos(lista);
    }
    
    /**
     * Método que permite ordenar los objetos de tipo HitoModelo según el atributo especificado de forma ascendente.
     * @param lista Lista original que se desea ordenar de forma ascendente.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @return Retorna una lista ordenada según el atributo indicado a partir de la lista original, es de tipo ListaSimple.
     */
    public ListaSimple ordenarListadoHitos(String atributo) {
        return hitoDAO.ordenarHitos(hitoDAO.listarObjetos(), atributo);
    }

    /**
     * Método que permite buscar un objeto de tipo HitoModelo según el dato indicado.
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la lista.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @param lista Lista en donde se va a buscar el objeto de tipo HitoModelo según el dato y atributo indicados, es de tipo ListaSimple.
     * @return Retorna un objeto de tipo HitoModelo con toda la información de la hito encontrado, en caso de no existir coincidencia, retorna null.
     */
    public HitoModelo buscarHito(Object dato, String atributo) {
        return hitoDAO.buscarHito(dato, atributo, listarHitos());
    }
    
    /**
     * Método que permite modificar un objeto de tipo HitoModelo en su archivo contenedor.
     * @param objeto Objeto que va a ser modificado en el archivo contenedor.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @param lista Lista en donde se va a buscar las coincidencias, es de tipo ListaSimple.
     * @return Retorna true en caso de que se haya modificado con éxito el objeto de tipo HitoModelo, caso contrario, retorna false.
     */
    public Boolean modificarHito (Object objeto, String atributo, ListaSimple lista) {
        return hitoDAO.modificarHito(objeto, atributo, lista);
    }
    
    /**
     * Método que permite dar de baja a un objeto de tipo HitoModelo del sistema, cambiando su estado de "activo" a "inactivo".
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la lista.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @param lista Lista en donde se va a buscar la coincidencia, es de tipo ListaSimple.
     * @return Retorna true en caso de que se haya dado de baja con éxito el objeto de tipo HitoModelo, caso contrario, retorna false.
     */
    public Boolean darDeBajaHito (Object dato, String atributo, ListaSimple lista) {
        return hitoDAO.darDeBajaHito(dato, atributo, lista);
    }
    
    /**
     * Método que permite obtener el id del objeto de tipo HitoModelo, según un dato especíco del mismo.
     * @param lista Lista en donde se va a buscar el objeto de tipo HitoModelo.
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la lista.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @return Retorna el id del objeto de tipo HitoModelo que se buscó en la lista en caso de que exista, caso contrario, retorna -1; 
     */
    public int obtenerIdHito(ListaSimple lista, Object dato, String atributo) {
        return hitoDAO.obtenerIdHito(lista, dato, atributo);
    }

}
