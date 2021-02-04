package controlador.DAO.objetosDAO;

import controlador.DAO.AdaptadorDAO;
import controlador.DAO.ConexionDAO;
import controlador.listaSimple.ListaSimple;
import controlador.utilidades.UtilidadesControlador;
import modelo.ActividadModelo;

public class ActividadDAO extends AdaptadorDAO {

    private ActividadModelo actividad;

    public ActividadDAO() {
        super(new ConexionDAO(), ActividadModelo.class, new ConexionDAO().getCARPETA_PROYECTOS());
    }

    public ActividadModelo getActividad() {
        if (actividad == null) {
            actividad = new ActividadModelo();
        }
        return actividad;
    }

    public void setActividad(ActividadModelo actividad) {
        this.actividad = actividad;
    }

    public Boolean guardarActividad() {
        try {
            this.guardarObjeto(this.getActividad());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar actividad: " + e);
            return false;
        }
    }

    public ListaSimple ordenarActividades(ListaSimple lista, String atributo) {
        UtilidadesControlador.ordenarQuicksort(0, lista.tamanio() - 1, lista, atributo);
        return lista;
    }

    public ActividadModelo buscarActividad(Object dato, String atributo, ListaSimple lista) {
        lista = ordenarActividades(lista, atributo);
        ActividadModelo cuenta = (ActividadModelo) UtilidadesControlador.buscarObjetoPorBusquedaBinariaPorDato(dato, atributo, lista);
        return cuenta;
    }
    
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
    
    public ListaSimple listarActividadesCoincidentes(ListaSimple lista, Object dato, String atributo) {
        ordenarActividades(lista, atributo);
        return listarCoincidencias(lista, dato, atributo);
    }
    
    /**
     * Método que busca las actividades con estado "activo" en el archivo contenedor.
     * @param lista ListaSimple en donde se va a buscar las coincidencias.
     * @return Retorna una lista con todas las actividades con estado "activo", en caso de no existir coincidencias, retorna una lista vacía.
     */
    public ListaSimple listarActividadesActivos(ListaSimple lista) {
        ordenarActividades(lista, "estado");
        return listarCoincidencias(lista, "activo", "estado");
    }
    
    /**
     * Método que busca las actividades con estado "inactivo" en el archivo contenedor.
     * @param lista ListaSimple en donde se va a buscar las coincidencias.
     * @return Retorna una lista con todas las actividades con estado "inactivo", en caso de no existir coincidencias, retorna una lista vacía.
     */
    public ListaSimple listarActividadesInactivos(ListaSimple lista) {
        ordenarActividades(lista, "estado");
        return listarCoincidencias(lista, "inactivo", "estado");
    }
    
    public int obtenerIdActividad(ListaSimple lista, Object dato, String atributo) {
        ActividadModelo actividad = buscarActividad(dato, atributo, lista);
        return actividad.getId();
    }
}
