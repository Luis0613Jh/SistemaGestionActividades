package controlador.servicio;

import controlador.DAO.objetosDAO.DepartamentoDAO;
import controlador.listaSimple.ListaSimple;
import modelo.DepartamentoModelo;

public class DepartamentoServicio {

    public static String IDENTIFICADOR = "id";
    public static String NOMBRE_DEPARTAMENTO = "nombreDepartamento";
    public static String DESCRIPCION = "decripcion";
    public static String EXTERNAL_ID = "external_id";
    public static String NOMBRE_ENCARGADO = "encargado";
    public static String ACTIVO = "activo";
    private DepartamentoDAO departamentoDAO = new DepartamentoDAO();

    /**
     * Método que permite obtener el objeto de tipo DepartamentoModelo almacenado en la clase DepartamentoDAO. 
     * @return Retorna el objeto de tipo DepartamentoModelo instanciado en la clase DepartamentoDAO.
     */
    public DepartamentoModelo getDepartamento() {
        return departamentoDAO.getDepartamento();
    }
    
    /**
     * Método que permite sobreescribir el objeto de tipo DepartamentoModelo instanciado en la clase DepartamentoDAO.
     * @param departamento Objeto de tipo DepartamentoModelo que se va a sobreescribir en el objeto instanciado en la clase DepartamentoDAO.
     */
    public void setDepartamento(DepartamentoModelo departamento) {
        departamentoDAO.setDepartamento(departamento);
    }

    /**
     * Método que permite guardar un objeto de tipo DepartamentoModelo en su archivo contenedor.
     * @return Retorna true en caso de que se haya guardado con éxito el objeto de tipo DepartamentoModelo, caso contrario, retorna false.
     */
    public Boolean guardarDepartamento() {
        return departamentoDAO.guardarDepartamento();
    }

    /**
     * Método que permite obtener todos los objetos de tipo DepartamentoModelo almacenados en su archivo contenedor.
     * @return Retorna una lista con todos los objetos de tipo DepartamentoModelo encontrados, en caso de no existir departamentos, retorna null.
     */
    public ListaSimple listarDepartamentos() {
        return departamentoDAO.listarObjetos();
    }
    
    /**
     * Método que busca los objetos de tipo DepartamentoModelo conincidentes en su archivo contenedor, según el dato y atributo indicado.
     * @param lista Lista en donde se va a buscar las coincidencias, es de tipo ListaSimple.
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la lista.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @return Retorna una lista con todas las coincidencias encontrados, en caso de no existir coincidencias, retorna null.
     */
    public ListaSimple listarsCoincidencias(ListaSimple lista, Object dato, String atributo) {
        return departamentoDAO.listarDepartamentosCoincidentes(lista, dato, atributo);
    }

    /**
     * Método que busca los objetos de tipo DepartamentoModelo con estado "activo" en el archivo contenedor.
     * @param lista Lista en donde se va a buscar las coincidencias, es de tipo ListaSimple.
     * @return Retorna una lista con todos los objetos de tipo DepartamentoModelo con estado "activo", en caso de no existir coincidencias, retorna null.
     */
    public ListaSimple listarDepartamentosActivos(ListaSimple lista) {
        return departamentoDAO.listarDepartamentosActivos(lista);
    }

    /**
     * Método que busca los objetos de tipo DepartamentoModelo con estado "inactivo" en el archivo contenedor.
     * @param lista ListaSimple en donde se va a buscar las coincidencias.
     * @return Retorna una lista con todos los objetos de tipo DepartamentoModelo con estado "inactivo", en caso de no existir coincidencias, retorna null.
     */
    public ListaSimple listarDepartamentosInactivos(ListaSimple lista) {
        return departamentoDAO.listarDepartamentosInactivos(lista);
    }
    
    /**
     * Método que permite ordenar los objetos de tipo DepartamentoModelo según el atributo especificado de forma ascendente.
     * @param lista Lista original que se desea ordenar de forma ascendente.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @return Retorna una lista ordenada según el atributo indicado a partir de la lista original, es de tipo ListaSimple.
     */
    public ListaSimple ordenarListadoDepartamentos(String atributo) {
        return departamentoDAO.ordenarDepartamentos(departamentoDAO.listarObjetos(), atributo);
    }

    /**
     * Método que permite buscar un objeto de tipo DepartamentoModelo según el dato indicado.
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la lista.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @param lista Lista en donde se va a buscar el objeto de tipo DepartamentoModelo según el dato y atributo indicados, es de tipo ListaSimple.
     * @return Retorna un objeto de tipo DepartamentoModelo con toda la información de la departamento encontrado, en caso de no existir coincidencia, retorna null.
     */
    public DepartamentoModelo buscarDepartamento(Object dato, String atributo) {
        return departamentoDAO.buscarDepartamento(dato, atributo, listarDepartamentos());
    }

    /**
     * Método que permite modificar un objeto de tipo DepartamentoModelo en su archivo contenedor.
     * @param objeto Objeto que va a ser modificado en el archivo contenedor.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @param lista Lista en donde se va a buscar las coincidencias, es de tipo ListaSimple.
     * @return Retorna true en caso de que se haya modificado con éxito el objeto de tipo DepartamentoModelo, caso contrario, retorna false.
     */
    public Boolean modificarDepartamento (Object objeto, String atributo, ListaSimple lista) {
        return departamentoDAO.modificarDepartamento(objeto, atributo, lista);
    }
    
    /**
     * Método que permite dar de baja a un objeto de tipo DepartamentoModelo del sistema, cambiando su estado de "activo" a "inactivo".
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la lista.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @param lista Lista en donde se va a buscar la coincidencia, es de tipo ListaSimple.
     * @return Retorna true en caso de que se haya dado de baja con éxito el objeto de tipo DepartamentoModelo, caso contrario, retorna false.
     */
    public Boolean darDeBajaDepartamento (Object dato, String atributo, ListaSimple lista) {
        return departamentoDAO.darDeBajaDepartamento(dato, atributo, lista);
    }
    
    /**
     * Método que permite obtener el id del objeto de tipo DepartamentoModelo, según un dato especíco del mismo.
     * @param lista Lista en donde se va a buscar el objeto de tipo DepartamentoModelo.
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la lista.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @return Retorna el id del objeto de tipo DepartamentoModelo que se buscó en la lista en caso de que exista, caso contrario, retorna -1; 
     */
    public int obtenerIdDepartamento(ListaSimple lista, Object dato, String atributo) {
        return departamentoDAO.obtenerIdDepartamento(lista, dato, atributo);
    }
}
