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

    public ListaSimple ordenarListadoProyectos(String atributo) {
        return proyectoDAO.ordenarProyectos(proyectoDAO.listarObjetos(), atributo);
    }

    public ProyectoModelo buscarProyecto(String dato, String atributo) {
        return proyectoDAO.buscarProyecto(dato, atributo, listarProyectos());
    }

}
