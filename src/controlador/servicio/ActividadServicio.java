package controlador.servicio;

import controlador.DAO.objetosDAO.ActividadDAO;
import controlador.listaSimple.ListaSimple;
import modelo.ActividadModelo;

public class ActividadServicio {

    public static String IDENTIFICADOR = "id";
    public static String NOMBRE = "nombre";
    public static String FECHA_INICIO = "fechaInicio";
    public static String FECHA_ENTREGA = "fechaEntrega";
    public static String EXTERNAL_ID = "external_id";
    public static String DESCRIPCION = "descripcion";
    public static String PRIORIDAD = "prioridad";
    public static String ACTIVO = "activo";
    private ActividadDAO actividadDAO = new ActividadDAO();

    public ActividadModelo getActividad() {
        return actividadDAO.getActividad();
    }
    
    public void setActividad(ActividadModelo actividad) {
        actividadDAO.setActividad(actividad);
    }

    public Boolean guardarActividad() {
        return actividadDAO.guardarActividad();
    }

    public ListaSimple listarActividads() {
        return actividadDAO.listarObjetos();
    }

    public ListaSimple ordenarListadoActividads(String atributo) {
        return actividadDAO.ordenarActividads(actividadDAO.listarObjetos(), atributo);
    }

    public ActividadModelo buscarActividad(String dato, String atributo) {
        return actividadDAO.buscarActividad(dato, atributo, listarActividads());
    }

    public Boolean modificarActividad (Object objeto, String atributo, ListaSimple lista) {
        return actividadDAO.modificarActividad(objeto, atributo, lista);
    }
    
    public Boolean darDeBajaActividad (String dato, String atributo, ListaSimple lista) {
        return actividadDAO.darDeBajaActividad(dato, atributo, lista);
    }
}
