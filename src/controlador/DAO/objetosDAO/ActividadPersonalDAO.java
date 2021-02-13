package controlador.DAO.objetosDAO;

import controlador.DAO.AdaptadorDAO;
import controlador.DAO.ConexionDAO;
import controlador.listaSimple.ListaSimple;
import controlador.utilidades.UtilidadesControlador;
import modelo.ActividadPersonalModelo;

public class ActividadPersonalDAO extends AdaptadorDAO {

    private ActividadPersonalModelo actividadPersonal;

    /**
     * Construye un objeto de tipo ActividadPersonalDAO, instanciando en su clase padre (AdaptadorDAO): un nuevo objeto de tipo ConexionDAO,
     * la clase del objeto de tipo ActividadPersonalModelo y una String con la carpeta contenedora "Archivos".  
     */
    public ActividadPersonalDAO() {
        super(new ConexionDAO(), ActividadPersonalModelo.class, new ConexionDAO().getCARPETA_PROYECTOS());
    }

    /**
     * Método que permite obtener el objeto de tipo ActividadPersonalModelo almacenado en la clase. 
     * @return Retorna el objeto de tipo ActividadPersonalModelo instanciado en la clase, en caso de que no exista, se crea un nuevo objeto ActividadPersonalModelo.
     */
    public ActividadPersonalModelo getActividadPersonal() {
        if (actividadPersonal == null) {
            actividadPersonal = new ActividadPersonalModelo();
        }
        return actividadPersonal;
    }

    /**
     * Método que permite sobreescribir el objeto de tipo PerModelo instanciado en la clase.
     * @param actividadPersonal Objeto de tipo ActividadPersonalModelo que se va a sobreescribir en el objeto instanciado en la clase.
     */
    public void setActividadPersonal(ActividadPersonalModelo actividadPersonal) {
        this.actividadPersonal = actividadPersonal;
    }

    /**
     * Método que permite guardar una actividadPersonal en su archivo contenedor.
     * @return Retorna true en caso de que se haya guardado con éxito la actividadPersonal, caso contrario, retorna false.
     */
    public Boolean guardarActividadPersonal() {
        try {
            this.guardarObjeto(this.getActividadPersonal());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar actividadPersonal: " + e);
            return false;
        }
    }

    /**
     * Método que permite ordenar las actividadesesPersonals según el atributo especificado de forma ascendente.
     * @param lista Lista original que se desea ordenar de forma ascendente.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @return Retorna una lista ordenada según el atributo indicado a partir de la lista original, es de tipo ListaSimple.
     */
    public ListaSimple ordenarActividadesPersonales(ListaSimple lista, String atributo) {
        UtilidadesControlador.ordenarQuicksort(0, lista.tamanio() - 1, lista, atributo);
        return lista;
    }

    /**
     * Método que permite buscar una actividadPersonal según el dato indicado.
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la lista.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @param lista Lista en donde se va a buscar la actividadPersonal según el dato y atributo indicados, es de tipo ListaSimple.
     * @return Retorna un objeto de tipo ActividadPersonalModelo con toda la información de la actividadPersonal encontrada, en caso de no existir coincidencia, retorna null.
     */
    public ActividadPersonalModelo buscarActividadPersonal(Object dato, String atributo, ListaSimple lista) {
        lista = ordenarActividadesPersonales(lista, atributo);
        ActividadPersonalModelo cuenta = (ActividadPersonalModelo) UtilidadesControlador.buscarObjetoPorBusquedaBinariaPorDato(dato, atributo, lista);
        return cuenta;
    }
    
    /**
     * Método que permite modificar una actividadPersonal en el documento que lo contiene.
     * @param objeto Objeto que va a ser modificado en el archivo contenedor.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @param lista Lista en donde se va a buscar las coincidencias, es de tipo ListaSimple.
     * @return Retorna true en caso de que se haya modificado con éxito la actividadPersonal, caso contrario, retorna false.
     */
    public Boolean modificarActividadPersonal (Object objeto, String atributo, ListaSimple lista) {
        try {
            lista.editarPorDato(UtilidadesControlador.extraerDato(objeto, atributo), atributo, objeto);
            modificarObjetos(lista);
            return true;
        } catch (Exception e) {
            System.out.println("Error en modificar actividadPersonal: " + e);
            return false;
        }
    }
    
    /**
     * Método que permite dar de baja a una actividadPersonal del sistema, cambiando su estado de "activo" a "inactivo".
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la lista.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @param lista Lista en donde se va a buscar las coincidencias, es de tipo ListaSimple.
     * @return Retorna true en caso de que se haya dado de baja con éxito a la actividadPersonal, caso contrario, retorna false.
     */
    public Boolean darDeBajaActividadPersonal(Object dato, String atributo, ListaSimple lista) {
        ActividadPersonalModelo actividadPersonal = buscarActividadPersonal(dato, atributo, lista);
        actividadPersonal.setEstado("inactivo");
        try {
            // Se modifica
            modificarActividadPersonal(actividadPersonal, atributo, lista);
            return true;
        } catch (Exception e) {
            System.out.println("Error en dar de baja el actividadPersonal: " + e);
            return false;
        }
    }
    
    /**
     * Método que busca las actividadesPersonals conincidentes con el dato a buscar según el atributo indicado.
     * @param lista Lista en donde se va a buscar las coincidencias, es de tipo ListaSimple.
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la lista.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @return Retorna una lista con todas las coincidencias encontradas, en caso de no existir coincidencias, retorna null.
     */
    public ListaSimple listarActividadPersonalesCoincidentes(ListaSimple lista, Object dato, String atributo) {
        ordenarActividadesPersonales(lista, atributo);
        return listarCoincidencias(lista, dato, atributo);
    }
    
    /**
     * Método que busca las actividadesPersonales con estado "activo" en el archivo contenedor.
     * @param lista ListaSimple en donde se va a buscar las coincidencias.
     * @return Retorna una lista con todas las actividadesPersonales con estado "activo", en caso de no existir coincidencias, retorna null.
     */
    public ListaSimple listarActividadPersonalesActivos(ListaSimple lista) {
        ordenarActividadesPersonales(lista, "estado");
        return listarCoincidencias(lista, "activo", "estado");
    }
    
    /**
     * Método que busca las actividadesPersonales con estado "inactivo" en el archivo contenedor.
     * @param lista ListaSimple en donde se va a buscar las coincidencias.
     * @return Retorna una lista con todas las actividadesPersonales con estado "inactivo", en caso de no existir coincidencias, retorna null.
     */
    public ListaSimple listarActividadPersonalesInactivos(ListaSimple lista) {
        ordenarActividadesPersonales(lista, "estado");
        return listarCoincidencias(lista, "inactivo", "estado");
    }
    
    /**
     * Método que permite obtener el id de la actividadPersonal según un dato especíco de la misma.
     * @param lista Lista en donde se va a buscar la actividadPersonal deseada.
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la lista.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @return Retorna el id de la actividadPersonal que se buscó en la lista en caso de que exista, caso contrario, retorna -1; 
     */
    public int obtenerIdActividadPersonal(ListaSimple lista, Object dato, String atributo) {
        ActividadPersonalModelo actividadPersonal = buscarActividadPersonal(dato, atributo, lista);
        return (actividadPersonal != null) ? actividadPersonal.getId() : -1;
    }
}
