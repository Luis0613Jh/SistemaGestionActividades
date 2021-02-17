package controlador.servicio;

import controlador.DAO.objetosDAO.ProyectoDAO;
import controlador.listaSimple.ListaSimple;
import modelo.ProyectoModelo;

public class ProyectoServicio {

    public static String IDENTIFICADOR = "id";
    public static String JEFE_PROYECTO = "id_jefeProyecto";
    public static String FECHA_INICIO = "fechaInicio";
    public static String FECHA_FINAL = "fechaFinal";
    public static String EXTERNAL_ID = "external_id";
    public static String CODIGO = "codigo";
    public static String ACTIVO = "activo";
    private ProyectoDAO proyectoDAO = new ProyectoDAO();

    /**
     * Método que permite obtener el objeto de tipo ProyectoModelo almacenado en la clase ProyectoDAO. 
     * @return Retorna el objeto de tipo ProyectoModelo instanciado en la clase ProyectoDAO.
     */
    public ProyectoModelo getProyecto() {
        return proyectoDAO.getProyecto();
    }
    
    /**
     * Método que permite sobreescribir el objeto de tipo ProyectoModelo instanciado en la clase ProyectoDAO.
     * @param proyecto Objeto de tipo ProyectoModelo que se va a sobreescribir en el objeto instanciado en la clase ProyectoDAO.
     */
    public void setProyecto(ProyectoModelo proyecto) {
        proyectoDAO.setProyecto(proyecto);
    }

    /**
     * Método que permite guardar un objeto de tipo ProyectoModelo en su archivo contenedor.
     * @return Retorna true en caso de que se haya guardado con éxito el objeto de tipo ProyectoModelo, caso contrario, retorna false.
     */
    public Boolean guardarProyecto() {
        return proyectoDAO.guardarProyecto();
    }

    /**
     * Método que permite obtener todos los objetos de tipo ProyectoModelo almacenados en su archivo contenedor.
     * @return Retorna una lista con todos los objetos de tipo ProyectoModelo encontrados, en caso de no existir proyectos, retorna null.
     */
    public ListaSimple listarProyectos() {
        return proyectoDAO.listarObjetos();
    }
    
    /**
     * Método que busca los objetos de tipo ProyectoModelo conincidentes en su archivo contenedor, según el dato y atributo indicado.
     * @param lista Lista en donde se va a buscar las coincidencias, es de tipo ListaSimple.
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la lista.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @return Retorna una lista con todas las coincidencias encontrados, en caso de no existir coincidencias, retorna null.
     */
    public ListaSimple listarProyectosCoincidencias(ListaSimple lista, Object dato, String atributo) {
        return proyectoDAO.listarProyectosCoincidentes(lista, dato, atributo);
    }

    /**
     * Método que busca los objetos de tipo ProyectoModelo con estado "activo" en el archivo contenedor.
     * @param lista Lista en donde se va a buscar las coincidencias, es de tipo ListaSimple.
     * @return Retorna una lista con todos los objetos de tipo ProyectoModelo con estado "activo", en caso de no existir coincidencias, retorna null.
     */
    public ListaSimple listarProyectosActivos(ListaSimple lista) {
        return proyectoDAO.listarProyectosActivos(lista);
    }

    /**
     * Método que busca los objetos de tipo ProyectoModelo con estado "inactivo" en el archivo contenedor.
     * @param lista ListaSimple en donde se va a buscar las coincidencias.
     * @return Retorna una lista con todos los objetos de tipo ProyectoModelo con estado "inactivo", en caso de no existir coincidencias, retorna null.
     */
    public ListaSimple listarProyectosInactivos(ListaSimple lista) {
        return proyectoDAO.listarProyectosInactivos(lista);
    }
    
    /**
     * Método que permite ordenar los objetos de tipo ProyectoModelo según el atributo especificado de forma ascendente.
     * @param lista Lista original que se desea ordenar de forma ascendente.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @return Retorna una lista ordenada según el atributo indicado a partir de la lista original, es de tipo ListaSimple.
     */
    public ListaSimple ordenarListadoProyectos(String atributo) {
        return proyectoDAO.ordenarProyectos(proyectoDAO.listarObjetos(), atributo);
    }

    /**
     * Método que permite buscar un objeto de tipo ProyectoModelo según el dato indicado.
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la lista.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @param lista Lista en donde se va a buscar el objeto de tipo ProyectoModelo según el dato y atributo indicados, es de tipo ListaSimple.
     * @return Retorna un objeto de tipo ProyectoModelo con toda la información de la proyecto encontrado, en caso de no existir coincidencia, retorna null.
     */
    public ProyectoModelo buscarProyecto(Object dato, String atributo) {
        return proyectoDAO.buscarProyecto(dato, atributo, listarProyectos());
    }

    /**
     * Método que permite modificar un objeto de tipo ProyectoModelo en su archivo contenedor.
     * @param objeto Objeto que va a ser modificado en el archivo contenedor.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @param lista Lista en donde se va a buscar las coincidencias, es de tipo ListaSimple.
     * @return Retorna true en caso de que se haya modificado con éxito el objeto de tipo ProyectoModelo, caso contrario, retorna false.
     */
    public Boolean modificarProyecto (Object objeto, String atributo, ListaSimple lista) {
        return proyectoDAO.modificarProyecto(objeto, atributo, lista);
    }
    
    /**
     * Método que permite dar de baja a un objeto de tipo ProyectoModelo del sistema, cambiando su estado de "activo" a "inactivo".
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la lista.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @param lista Lista en donde se va a buscar la coincidencia, es de tipo ListaSimple.
     * @return Retorna true en caso de que se haya dado de baja con éxito el objeto de tipo ProyectoModelo, caso contrario, retorna false.
     */
    public Boolean darDeBajaProyecto (Object dato, String atributo, ListaSimple lista) {
        return proyectoDAO.darDeBajaProyecto(dato, atributo, lista);
    }
    
    /**
     * Método que permite obtener el id del objeto de tipo ProyectoModelo, según un dato especíco del mismo.
     * @param lista Lista en donde se va a buscar el objeto de tipo ProyectoModelo.
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la lista.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @return Retorna el id del objeto de tipo ProyectoModelo que se buscó en la lista en caso de que exista, caso contrario, retorna -1; 
     */
    public int obtenerIdProyecto(ListaSimple lista, Object dato, String atributo) {
        return proyectoDAO.obtenerIdProyecto(lista, dato, atributo);
    }
}
