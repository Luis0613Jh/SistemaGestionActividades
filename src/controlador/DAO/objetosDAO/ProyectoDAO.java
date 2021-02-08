package controlador.DAO.objetosDAO;

import controlador.DAO.AdaptadorDAO;
import controlador.DAO.ConexionDAO;
import controlador.listaSimple.ListaSimple;
import controlador.utilidades.UtilidadesControlador;
import modelo.ProyectoModelo;

public class ProyectoDAO extends AdaptadorDAO {

    private ProyectoModelo proyecto;

    /**
     * Construye un objeto de tipo ProyectoDAO, instanciando en su clase padre (AdaptadorDAO): un nuevo objeto de tipo ConexionDAO,
     * la clase del objeto de tipo ProyectoModelo y una String con la carpeta contenedora "Archivos".  
     */
    public ProyectoDAO() {
        super(new ConexionDAO(), ProyectoModelo.class, new ConexionDAO().getCARPETA_PROYECTOS());
    }

    /**
     * Método que permite obtener el objeto de tipo ProyectoModelo almacenado en la clase. 
     * @return Retorna el objeto de tipo ProyectoModelo instanciado en la clase, en caso de que no exista, se crea un nuevo objeto ProyectoModelo.
     */
    public ProyectoModelo getProyecto() {
        if (proyecto == null) {
            proyecto = new ProyectoModelo();
        }
        return proyecto;
    }

    /**
     * Método que permite sobreescribir el objeto de tipo ProyectoModelo instanciado en la clase.
     * @param proyecto Objeto de tipo ProyectoModelo que se va a sobreescribir en el objeto instanciado en la clase.
     */
    public void setProyecto(ProyectoModelo proyecto) {
        this.proyecto = proyecto;
    }

    /**
     * Método que permite guardar una proyecto en su archivo contenedor.
     * @return Retorna true en caso de que se haya guardado con éxito la proyecto, caso contrario, retorna false.
     */
    public Boolean guardarProyecto() {
        try {
            this.guardarObjeto(this.getProyecto());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar proyecto: " + e);
            return false;
        }
    }

    /**
     * Método que permite ordenar las proyectos según el atributo especificado de forma ascendente.
     * @param lista Lista original que se desea ordenar de forma ascendente.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @return Retorna una lista ordenada según el atributo indicado a partir de la lista original, es de tipo ListaSimple.
     */
    public ListaSimple ordenarProyectos(ListaSimple lista, String atributo) {
        UtilidadesControlador.ordenarQuicksort(0, lista.tamanio() - 1, lista, atributo);
        return lista;
    }
    
    /**
     * Método que permite buscar una proyecto según el dato indicado.
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la lista.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @param lista Lista en donde se va a buscar la proyecto según el dato y atributo indicados, es de tipo ListaSimple.
     * @return Retorna un objeto de tipo ProyectoModelo con toda la información del proyecto encontrada, en caso de no existir coincidencia, retorna null.
     */
    public ProyectoModelo buscarProyecto(Object dato, String atributo, ListaSimple lista) {
        lista = ordenarProyectos(lista, atributo);
        ProyectoModelo proyecto = (ProyectoModelo) UtilidadesControlador.buscarObjetoPorBusquedaBinariaPorDato(dato, atributo, lista);
        return proyecto;
    }
    
    /**
     * Método que permite modificar una proyecto en el documento que lo contiene.
     * @param objeto Objeto que va a ser modificado en el archivo contenedor.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @param lista Lista en donde se va a buscar las coincidencias, es de tipo ListaSimple.
     * @return Retorna true en caso de que se haya modificado con éxito la proyecto, caso contrario, retorna false.
     */
    public Boolean modificarProyecto (Object objeto, String atributo, ListaSimple lista) {
        try {
            lista.editarPorDato(UtilidadesControlador.extraerDato(objeto, atributo), atributo, objeto);
            modificarObjetos(lista);
            return true;
        } catch (Exception e) {
            System.out.println("Error en modificar proyecto: " + e);
            return false;
        }
    }
    
    /**
     * Método que permite dar de baja a una proyecto del sistema, cambiando su estado de "activo" a "inactivo".
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la lista.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @param lista Lista en donde se va a buscar las coincidencias, es de tipo ListaSimple.
     * @return Retorna true en caso de que se haya dado de baja con éxito a la proyecto, caso contrario, retorna false.
     */
    public Boolean darDeBajaProyecto(Object dato, String atributo, ListaSimple lista) {
        ProyectoModelo proyecto = buscarProyecto(dato, atributo, lista);
        proyecto.setEstado("inactivo");
        try {
            // Se modifica
            modificarProyecto(proyecto, atributo, lista);
            return true;
        } catch (Exception e) {
            System.out.println("Error en dar de baja el proyecto: " + e);
            return false;
        }
    }
    
    /**
     * Método que busca las proyectos conincidentes con el dato a buscar según el atributo indicado.
     * @param lista Lista en donde se va a buscar las coincidencias, es de tipo ListaSimple.
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la lista.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @return Retorna una lista con todas las coincidencias encontradas, en caso de no existir coincidencias, retorna null.
     */
    public ListaSimple listarProyectosCoincidentes(ListaSimple lista, Object dato, String atributo) {
        ordenarProyectos(lista, atributo);
        return listarCoincidencias(lista, dato, atributo);
    }
    
    /**
     * Método que busca los proyectos con estado "activo" en el archivo contenedor.
     * @param lista ListaSimple en donde se va a buscar las coincidencias.
     * @return Retorna una lista con todas los proyectos con estado "activo", en caso de no existir coincidencias, retorna null.
     */
    public ListaSimple listarProyectosActivos(ListaSimple lista) {
        ordenarProyectos(lista, "estado");
        return listarCoincidencias(lista, "activo", "estado");
    }
    
    /**
     * Método que busca los proyectos con estado "inactivo" en el archivo contenedor.
     * @param lista ListaSimple en donde se va a buscar las coincidencias.
     * @return Retorna una lista con todas los proyectos con estado "inactivo", en caso de no existir coincidencias, retorna null.
     */
    public ListaSimple listarProyectosInactivos(ListaSimple lista) {
        ordenarProyectos(lista, "estado");
        return listarCoincidencias(lista, "inactivo", "estado");
    }
    
    /**
     * Método que permite obtener el id del proyecto según un dato especíco del mismo.
     * @param lista Lista en donde se va a buscar la proyecto deseada.
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la lista.
     * @param atributo Atributo que especifica el nombre del variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @return Retorna el id del proyecto que se buscó en la lista en caso de que exista, caso contrario, retorna -1; 
     */
    public int obtenerIdProyecto(ListaSimple lista, Object dato, String atributo) {
        ProyectoModelo proyecto = buscarProyecto(dato, atributo, lista);
        return (proyecto != null) ? proyecto.getId() : -1;
    }
}
