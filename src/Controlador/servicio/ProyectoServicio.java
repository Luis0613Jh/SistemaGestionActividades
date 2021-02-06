package controlador.servicio;

import controlador.DAO.objetosDAO.ProyectoDAO;
import controlador.listaSimple.ListaSimple;
import modelo.ProyectoModelo;

public class ProyectoServicio {

    public static String IDENTIFICADOR = "id";
    public static String JEFE_PROYECTO = "jefeProyecto";
    public static String FECHA_INICIO = "fechaInicio";
    public static String FECHA_FINAL = "fechaFinal";
    public static String EXTERNAL_ID = "external_id";
    public static String CODIGO = "codigo";
    public static String ACTIVO = "activo";
    private ProyectoDAO proyectoDAO = new ProyectoDAO();

    public ProyectoModelo getProyecto() {
        return proyectoDAO.getProyecto();
    }
    
    public void setProyecto(ProyectoModelo proyecto) {
        proyectoDAO.setProyecto(proyecto);
    }

    public Boolean guardarProyecto() {
        return proyectoDAO.guardarProyecto();
    }

    public ListaSimple listarProyectos() {
        return proyectoDAO.listarObjetos();
    }
    
    public ListaSimple listarProyectosCoincidencias(ListaSimple lista, Object dato, String atributo) {
        return proyectoDAO.listarProyectosCoincidentes(lista, dato, atributo);
    }

    public ListaSimple listarProyectosActivos(ListaSimple lista) {
        return proyectoDAO.listarProyectosActivos(lista);
    }

    public ListaSimple listarProyectosInactivos(ListaSimple lista) {
        return proyectoDAO.listarProyectosInactivos(lista);
    }
    
    public ListaSimple ordenarListadoProyectos(String atributo) {
        return proyectoDAO.ordenarProyectos(proyectoDAO.listarObjetos(), atributo);
    }

    public ProyectoModelo buscarProyecto(Object dato, String atributo) {
        return proyectoDAO.buscarProyecto(dato, atributo, listarProyectos());
    }

    public Boolean modificarProyecto (Object objeto, String atributo, ListaSimple lista) {
        return proyectoDAO.modificarProyecto(objeto, atributo, lista);
    }
    
    public Boolean darDeBajaProyecto (Object dato, String atributo, ListaSimple lista) {
        return proyectoDAO.darDeBajaProyecto(dato, atributo, lista);
    }
    
    public int obtenerIdProyecto(ListaSimple lista, Object dato, String atributo) {
        return proyectoDAO.obtenerIdProyecto(lista, dato, atributo);
    }
}
