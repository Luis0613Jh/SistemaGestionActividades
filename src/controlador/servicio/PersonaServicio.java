package controlador.servicio;

import controlador.DAO.objetosDAO.PersonaDAO;
import controlador.listaSimple.ListaSimple;
import modelo.PersonaModelo;

public class PersonaServicio {

    public static String IDENTIFICADOR = "id";
    public static String NOMBRE = "nombre";
    public static String CORREO = "correo";
    public static String TELEFONO = "telefono";
    public static String EXTERNAL_ID = "external_id";
    public static String CEDULA = "cedula";
    public static String ID_CUENTA = "id_cuenta";
    public static String ID_ROL = "id_rol";
    public static String PATH_IMAGEN = "path_imagen";
    public static String ESTADO = "estado";
    private PersonaDAO personaDAO = new PersonaDAO();

    /**
     * Método que permite obtener el objeto de tipo PersonaModelo almacenado en la clase PersonaDAO. 
     * @return Retorna el objeto de tipo PersonaModelo instanciado en la clase PersonaDAO.
     */
    public PersonaModelo getPersona() {
        return personaDAO.getPersona();
    }
    
    /**
     * Método que permite sobreescribir el objeto de tipo PersonaModelo instanciado en la clase PersonaDAO.
     * @param persona Objeto de tipo PersonaModelo que se va a sobreescribir en el objeto instanciado en la clase PersonaDAO.
     */
    public void setPersona(PersonaModelo persona) {
        personaDAO.setPersona(persona);
    }

    /**
     * Método que permite guardar un objeto de tipo PersonaModelo en su archivo contenedor.
     * @return Retorna true en caso de que se haya guardado con éxito la persona, caso contrario, retorna false.
     */
    public Boolean guardarPersona() {
        return personaDAO.guardarPersona();
    }

    /**
     * Método que permite obtener todos los objetos de tipo PersonaModelo almacenados en su archivo contenedor.
     * @return Retorna una lista con todos los objetos de tipo PersonaModelo encontrados, en caso de no existir personas, retorna null.
     */
    public ListaSimple listarPersonas() {
        return personaDAO.listarObjetos();
    }
    
    /**
     * Método que busca los objetos de tipo PersonaModelo conincidentes en su archivo contenedor, según el dato y atributo indicado.
     * @param lista Lista en donde se va a buscar las coincidencias, es de tipo ListaSimple.
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la lista.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @return Retorna una lista con todas las coincidencias encontradas, en caso de no existir coincidencias, retorna null.
     */
    public ListaSimple listarPersonasCoincidencias(ListaSimple lista, Object dato, String atributo) {
        return personaDAO.listarPersonasCoincidentes(lista, dato, atributo);
    }
    
    /**
     * Método que busca los objetos de tipo PersonaModelo con estado "activo" en el archivo contenedor.
     * @param lista Lista en donde se va a buscar las coincidencias, es de tipo ListaSimple.
     * @return Retorna una lista con todos los objetos de tipo PersonaModelo con estado "activo", en caso de no existir coincidencias, retorna null.
     */
    public ListaSimple listarPersonasActivas(ListaSimple lista) {
        return personaDAO.listarPersonasActivas(lista);
    }

    /**
     * Método que busca los objetos de tipo PersonaModelo con estado "inactivo" en el archivo contenedor.
     * @param lista ListaSimple en donde se va a buscar las coincidencias.
     * @return Retorna una lista con todos los objetos de tipo PersonaModelo con estado "inactivo", en caso de no existir coincidencias, retorna null.
     */
    public ListaSimple listarPersonasInactivas(ListaSimple lista) {
        return personaDAO.listarPersonasInactivas(lista);
    }

    /**
     * Método que permite ordenar los objetos de tipo PersonaModelo según el atributo especificado de forma ascendente.
     * @param lista Lista original que se desea ordenar de forma ascendente.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @return Retorna una lista ordenada según el atributo indicado a partir de la lista original, es de tipo ListaSimple.
     */
    public ListaSimple ordenarListadoPersonas(String atributo) {
        return personaDAO.ordenarPersonas(personaDAO.listarObjetos(), atributo);
    }

    /**
     * Método que permite buscar un objeto de tipo PersonaModelo según el dato indicado.
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la lista.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @param lista Lista en donde se va a buscar el objeto de tipo PersonaModelo según el dato y atributo indicados, es de tipo ListaSimple.
     * @return Retorna un objeto de tipo PersonaModelo con toda la información de la persona encontrada, en caso de no existir coincidencia, retorna null.
     */
    public PersonaModelo buscarPersona(Object dato, String atributo) {
        return personaDAO.buscarPersona(dato, atributo, listarPersonas());
    }

    /**
     * Método que permite modificar un objeto de tipo PersonaModelo en su archivo contenedor.
     * @param objeto Objeto que va a ser modificado en el archivo contenedor.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @param lista Lista en donde se va a buscar las coincidencias, es de tipo ListaSimple.
     * @return Retorna true en caso de que se haya modificado con éxito el objeto de tipo PersonaModelo, caso contrario, retorna false.
     */
    public Boolean modificarPersona (Object objeto, String atributo, ListaSimple lista) {
        return personaDAO.modificarPersona(objeto, atributo, lista);
    }
    
    /**
     * Método que permite dar de baja a un objeto de tipo PersonaModelo del sistema, cambiando su estado de "activo" a "inactivo".
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la lista.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @param lista Lista en donde se va a buscar la coincidencia, es de tipo ListaSimple.
     * @return Retorna true en caso de que se haya dado de baja con éxito el objeto de tipo PersonaModelo, caso contrario, retorna false.
     */
    public Boolean darDeBajaPersona (Object dato, String atributo, ListaSimple lista) {
        return personaDAO.darDeBajaPersona(dato, atributo, lista);
    }
    
    /**
     * Método que permite obtener el id del objeto de tipo PersonaModelo, según un dato especíco del mismo.
     * @param lista Lista en donde se va a buscar el objeto de tipo PersonaModelo.
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la lista.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @return Retorna el id del objeto de tipo PersonaModelo que se buscó en la lista en caso de que exista, caso contrario, retorna -1; 
     */
    public int obtenerIdPersona(ListaSimple lista, Object dato, String atributo) {
        return personaDAO.obtenerIdPersona(lista, dato, atributo);
    }
}
