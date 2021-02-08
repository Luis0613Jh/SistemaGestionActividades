package controlador.DAO.objetosDAO;

import controlador.DAO.AdaptadorDAO;
import controlador.DAO.ConexionDAO;
import controlador.listaSimple.ListaSimple;
import controlador.utilidades.UtilidadesControlador;
import modelo.ActividadModelo;

public class ActividadDAO extends AdaptadorDAO {

    private ActividadModelo actividad;

    /**
     * Construye un objeto de tipo ActividadDAO, instanciando en su clase padre (AdaptadorDAO): un nuevo objeto de tipo ConexionDAO,
     * la clase del objeto de tipo ActividadModelo y una String con la carpeta contenedora "Archivos".  
     */
    public ActividadDAO() {
        super(new ConexionDAO(), ActividadModelo.class, new ConexionDAO().getCARPETA_PROYECTOS());
    }

    /**
     * Método que permite obtener el objeto de tipo ActividadModelo almacenado en la clase. 
     * @return Retorna el objeto de tipo ActividadModelo instanciado en la clase, en caso de que no exista, se crea un nuevo objeto ActividadModelo.
     */
    public ActividadModelo getActividad() {
        if (actividad == null) {
            actividad = new ActividadModelo();
        }
        return actividad;
    }

    /**
     * Método que permite sobreescribir el objeto de tipo ActividadModelo instanciado en la clase.
     * @param actividad Objeto de tipo ActividadModelo que se va a sobreescribir en el objeto instanciado en la clase.
     */
    public void setActividad(ActividadModelo actividad) {
        this.actividad = actividad;
    }

    /**
     * Método que permite guardar una actividad en su archivo contenedor.
     * @return Retorna true en caso de que se haya guardado con éxito la actividad, caso contrario, retorna false.
     */
    public Boolean guardarActividad() {
        try {
            this.guardarObjeto(this.getActividad());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar actividad: " + e);
            return false;
        }
    }

    /**
     * Método que permite ordenar las actividads según el atributo especificado de forma ascendente.
     * @param lista Lista original que se desea ordenar de forma ascendente.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @return Retorna una lista ordenada según el atributo indicado a partir de la lista original, es de tipo ListaSimple.
     */
    public ListaSimple ordenarActividades(ListaSimple lista, String atributo) {
        UtilidadesControlador.ordenarQuicksort(0, lista.tamanio() - 1, lista, atributo);
        return lista;
    }

    /**
     * Método que permite buscar una actividad según el dato indicado.
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la lista.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @param lista Lista en donde se va a buscar la actividad según el dato y atributo indicados, es de tipo ListaSimple.
     * @return Retorna un objeto de tipo ActividadModelo con toda la información de la actividad encontrada, en caso de no existir coincidencia, retorna null.
     */
    public ActividadModelo buscarActividad(Object dato, String atributo, ListaSimple lista) {
        lista = ordenarActividades(lista, atributo);
        ActividadModelo cuenta = (ActividadModelo) UtilidadesControlador.buscarObjetoPorBusquedaBinariaPorDato(dato, atributo, lista);
        return cuenta;
    }
    
    /**
     * Método que permite modificar una actividad en el documento que lo contiene.
     * @param objeto Objeto que va a ser modificado en el archivo contenedor.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @param lista Lista en donde se va a buscar las coincidencias, es de tipo ListaSimple.
     * @return Retorna true en caso de que se haya modificado con éxito la actividad, caso contrario, retorna false.
     */
    public Boolean modificarActividad (Object objeto, String atributo, ListaSimple lista) {
        try {
            lista.editarPorDato(UtilidadesControlador.extraerDato(objeto, atributo), atributo, objeto);
            modificarObjetos(lista);
            return true;
        } catch (Exception e) {
            System.out.println("Error en modificar actividad: " + e);
            return false;
        }
    }
    
    /**
     * Método que permite dar de baja a una actividad del sistema, cambiando su estado de "activo" a "inactivo".
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la lista.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @param lista Lista en donde se va a buscar las coincidencias, es de tipo ListaSimple.
     * @return Retorna true en caso de que se haya dado de baja con éxito a la actividad, caso contrario, retorna false.
     */
    public Boolean darDeBajaActividad(Object dato, String atributo, ListaSimple lista) {
        ActividadModelo actividad = buscarActividad(dato, atributo, lista);
        actividad.setEstado("inactivo");
        try {
            // Se modifica
            modificarActividad(actividad, atributo, lista);
            return true;
        } catch (Exception e) {
            System.out.println("Error en dar de baja el actividad: " + e);
            return false;
        }
    }
    
    /**
     * Método que busca las actividads conincidentes con el dato a buscar según el atributo indicado.
     * @param lista Lista en donde se va a buscar las coincidencias, es de tipo ListaSimple.
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la lista.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @return Retorna una lista con todas las coincidencias encontradas, en caso de no existir coincidencias, retorna null.
     */
    public ListaSimple listarActividadesCoincidentes(ListaSimple lista, Object dato, String atributo) {
        ordenarActividades(lista, atributo);
        return listarCoincidencias(lista, dato, atributo);
    }
    
    /**
     * Método que busca las actividades con estado "activo" en el archivo contenedor.
     * @param lista ListaSimple en donde se va a buscar las coincidencias.
     * @return Retorna una lista con todas las actividades con estado "activo", en caso de no existir coincidencias, retorna null.
     */
    public ListaSimple listarActividadesActivos(ListaSimple lista) {
        ordenarActividades(lista, "estado");
        return listarCoincidencias(lista, "activo", "estado");
    }
    
    /**
     * Método que busca las actividades con estado "inactivo" en el archivo contenedor.
     * @param lista ListaSimple en donde se va a buscar las coincidencias.
     * @return Retorna una lista con todas las actividades con estado "inactivo", en caso de no existir coincidencias, retorna null.
     */
    public ListaSimple listarActividadesInactivos(ListaSimple lista) {
        ordenarActividades(lista, "estado");
        return listarCoincidencias(lista, "inactivo", "estado");
    }
    
    /**
     * Método que permite obtener el id de la actividad según un dato especíco de la misma.
     * @param lista Lista en donde se va a buscar la actividad deseada.
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la lista.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @return Retorna el id de la actividad que se buscó en la lista en caso de que exista, caso contrario, retorna -1; 
     */
    public int obtenerIdActividad(ListaSimple lista, Object dato, String atributo) {
        ActividadModelo actividad = buscarActividad(dato, atributo, lista);
        return (actividad != null) ? actividad.getId() : -1;
    }
}
