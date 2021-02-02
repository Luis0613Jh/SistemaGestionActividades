package controlador.servicio;

import controlador.DAO.objetosDAO.HitoDAO;
import controlador.listaSimple.ListaSimple;
import modelo.HitoModelo;

public class HitoServicio {

    public static String IDENTIFICADOR = "id";
    public static String NOMBRE = "nombre";
    public static String DESCRIPCION = "decripcion";
    public static String FECHA_INICIO = "fechaInicio";
    public static String EXTERNAL_ID = "external_id";
    public static String PRIORIDAD = "prioridad";
    public static String RESPONSABLE = "responsable";
    public static String ACTIVO = "activo";
    private HitoDAO hitoDAO = new HitoDAO();

    public HitoModelo getHito() {
        return hitoDAO.getHito();
    }
    
    public void setHito(HitoModelo hito) {
        hitoDAO.setHito(hito);
    }

    public Boolean guardarHito() {
        return hitoDAO.guardarHito();
    }

    public ListaSimple listarHitos() {
        return hitoDAO.listarObjetos();
    }

    public ListaSimple listarHitosCoincidencias(ListaSimple lista, Object dato, String atributo) {
        return hitoDAO.listarHitosCoincidentes(lista, dato, atributo);
    }
    
    public ListaSimple ordenarListadoHitos(String atributo) {
        return hitoDAO.ordenarHitos(hitoDAO.listarObjetos(), atributo);
    }

    public HitoModelo buscarHito(Object dato, String atributo) {
        return hitoDAO.buscarHito(dato, atributo, listarHitos());
    }
    
    public Boolean modificarHito (Object objeto, String atributo, ListaSimple lista) {
        return hitoDAO.modificarHito(objeto, atributo, lista);
    }
    
    public Boolean darDeBajaHito (Object dato, String atributo, ListaSimple lista) {
        return hitoDAO.darDeBajaHito(dato, atributo, lista);
    }
    
    public int obtenerIdHito(ListaSimple lista, Object dato, String atributo) {
        return hitoDAO.obtenerIdHito(lista, dato, atributo);
    }

}
