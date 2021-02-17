package controlador.DAO.objetosDAO;

import controlador.DAO.AdaptadorDAO;
import controlador.DAO.ConexionDAO;
import controlador.listaSimple.ListaSimple;
import controlador.utilidades.UtilidadesControlador;
import modelo.HitoModelo;

public class HitoDAO extends AdaptadorDAO {

    private HitoModelo hito;

    /**
     * Construye un objeto de tipo HitoDAO, instanciando en su clase padre (AdaptadorDAO): un nuevo objeto de tipo ConexionDAO,
     * la clase del objeto de tipo HitoModelo y una String con la carpeta contenedora "Archivos".  
     */
    public HitoDAO() {
        super(new ConexionDAO(), HitoModelo.class, new ConexionDAO().getCARPETA_HITOS());
    }

    /**
     * Método que permite obtener el objeto de tipo HitoModelo almacenado en la clase. 
     * @return Retorna el objeto de tipo HitoModelo instanciado en la clase, en caso de que no exista, se crea un nuevo objeto HitoModelo.
     */
    public HitoModelo getHito() {
        if (hito == null) {
            hito = new HitoModelo();
        }
        return hito;
    }

    /**
     * Método que permite sobreescribir el objeto de tipo HitoModelo instanciado en la clase.
     * @param hito Objeto de tipo HitoModelo que se va a sobreescribir en el objeto instanciado en la clase.
     */
    public void setHito(HitoModelo hito) {
        this.hito = hito;
    }

    /**
     * Método que permite guardar una hito en su archivo contenedor.
     * @return Retorna true en caso de que se haya guardado con éxito la hito, caso contrario, retorna false.
     */
    public Boolean guardarHito() {
        try {
            this.guardarObjeto(this.getHito());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar hito: " + e);
            return false;
        }
    }

    /**
     * Método que permite ordenar las hitos según el atributo especificado de forma ascendente.
     * @param lista Lista original que se desea ordenar de forma ascendente.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @return Retorna una lista ordenada según el atributo indicado a partir de la lista original, es de tipo ListaSimple.
     */
    public ListaSimple ordenarHitos(ListaSimple lista, String atributo) {
        UtilidadesControlador.ordenarQuicksort(0, lista.tamanio() - 1, lista, atributo);
        return lista;
    }

    /**
     * Método que permite buscar una hito según el dato indicado.
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la lista.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @param lista Lista en donde se va a buscar la hito según el dato y atributo indicados, es de tipo ListaSimple.
     * @return Retorna un objeto de tipo HitoModelo con toda la información del hito encontrada, en caso de no existir coincidencia, retorna null.
     */
    public HitoModelo buscarHito(Object dato, String atributo, ListaSimple lista) {
        lista = ordenarHitos(lista, atributo);
        HitoModelo cuenta = (HitoModelo) UtilidadesControlador.buscarObjetoPorBusquedaBinariaPorDato(dato, atributo, lista);
        return cuenta;
    }
    
    /**
     * Método que permite modificar una hito en el documento que lo contiene.
     * @param objeto Objeto que va a ser modificado en el archivo contenedor.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @param lista Lista en donde se va a buscar las coincidencias, es de tipo ListaSimple.
     * @return Retorna true en caso de que se haya modificado con éxito la hito, caso contrario, retorna false.
     */
    public Boolean modificarHito (Object objeto, String atributo, ListaSimple lista) {
        try {
            lista.editarPorDato(UtilidadesControlador.extraerDato(objeto, atributo), atributo, objeto);
            modificarObjetos(lista);
            return true;
        } catch (Exception e) {
            System.out.println("Error en modificar hito: " + e);
            return false;
        }
    }
    
    /**
     * Método que permite dar de baja a una hito del sistema, cambiando su estado de "activo" a "inactivo".
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la lista.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @param lista Lista en donde se va a buscar las coincidencias, es de tipo ListaSimple.
     * @return Retorna true en caso de que se haya dado de baja con éxito a la hito, caso contrario, retorna false.
     */
    public Boolean darDeBajaHito(Object dato, String atributo, ListaSimple lista) {
        HitoModelo hito = buscarHito(dato, atributo, lista);
        hito.setEstado("inactivo");
        try {
            // Se modifica
            modificarHito(hito, atributo, lista);
            return true;
        } catch (Exception e) {
            System.out.println("Error en dar de baja el hito: " + e);
            return false;
        }
    }
    
    /**
     * Método que busca las hitos conincidentes con el dato a buscar según el atributo indicado.
     * @param lista Lista en donde se va a buscar las coincidencias, es de tipo ListaSimple.
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la lista.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @return Retorna una lista con todas las coincidencias encontradas, en caso de no existir coincidencias, retorna null.
     */
    public ListaSimple listarHitosCoincidentes(ListaSimple lista, Object dato, String atributo) {
        ordenarHitos(lista, atributo);
        return listarCoincidencias(lista, dato, atributo);
    }
    
    /**
     * Método que busca los hitos con estado "activo" en el archivo contenedor.
     * @param lista ListaSimple en donde se va a buscar las coincidencias.
     * @return Retorna una lista con todas los hitos con estado "activo", en caso de no existir coincidencias, retorna una lista vacía.
     */
    public ListaSimple listarHitosActivos(ListaSimple lista) {
        ordenarHitos(lista, "estado");
        return listarCoincidencias(lista, "activo", "estado");
    }
    
    /**
     * Método que busca los hitos con estado "inactivo" en el archivo contenedor.
     * @param lista ListaSimple en donde se va a buscar las coincidencias.
     * @return Retorna una lista con todas los hitos con estado "inactivo", en caso de no existir coincidencias, retorna una lista vacía.
     */
    public ListaSimple listarHitosInactivos(ListaSimple lista) {
        ordenarHitos(lista, "estado");
        return listarCoincidencias(lista, "inactivo", "estado");
    }
    
    /**
     * Método que permite obtener el id del hito según un dato especíco del mismo.
     * @param lista Lista en donde se va a buscar la hito deseada.
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la lista.
     * @param atributo Atributo que especifica el nombre del variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @return Retorna el id del hito que se buscó en la lista en caso de que exista, caso contrario, retorna -1; 
     */
    public int obtenerIdHito(ListaSimple lista, Object dato, String atributo) {
        HitoModelo hito = buscarHito(dato, atributo, lista);
        return (hito != null) ? hito.getId() : -1;
    }
}
