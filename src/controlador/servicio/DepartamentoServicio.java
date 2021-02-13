package controlador.servicio;

import controlador.DAO.objetosDAO.DepartamentoDAO;
import controlador.listaSimple.ListaSimple;
import modelo.DepartamentoModelo;

public class DepartamentoServicio {

    public static String IDENTIFICADOR = "id";
    public static String NOMBRE_DEPARTAMENTO = "nombreDepartamento";
    public static String DESCRIPCION = "decripcion";
    public static String EXTERNAL_ID = "external_id";
    public static String NOMBRE_ENCARGADO = "encargado";
    public static String ACTIVO = "activo";
    private DepartamentoDAO departamentoDAO = new DepartamentoDAO();

    public DepartamentoModelo getDepartamento() {
        return departamentoDAO.getDepartamento();
    }
    
    public void setDepartamento(DepartamentoModelo departamento) {
        departamentoDAO.setDepartamento(departamento);
    }

    public Boolean guardarDepartamento() {
        return departamentoDAO.guardarDepartamento();
    }

    public ListaSimple listarDepartamentos() {
        return departamentoDAO.listarObjetos();
    }
    
    public ListaSimple listarsCoincidencias(ListaSimple lista, Object dato, String atributo) {
        return departamentoDAO.listarDepartamentosCoincidentes(lista, dato, atributo);
    }

    public ListaSimple listarDepartamentosActivos(ListaSimple lista) {
        return departamentoDAO.listarDepartamentosActivos(lista);
    }

    public ListaSimple listarDepartamentosInactivos(ListaSimple lista) {
        return departamentoDAO.listarDepartamentosInactivos(lista);
    }
    
    public ListaSimple ordenarListadoDepartamentos(String atributo) {
        return departamentoDAO.ordenarDepartamentos(departamentoDAO.listarObjetos(), atributo);
    }

    public DepartamentoModelo buscarDepartamento(Object dato, String atributo) {
        return departamentoDAO.buscarDepartamento(dato, atributo, listarDepartamentos());
    }

    public Boolean modificarDepartamento (Object objeto, String atributo, ListaSimple lista) {
        return departamentoDAO.modificarDepartamento(objeto, atributo, lista);
    }
    
    public Boolean darDeBajaDepartamento (Object dato, String atributo, ListaSimple lista) {
        return departamentoDAO.darDeBajaDepartamento(dato, atributo, lista);
    }
    
    public int obtenerIdDepartamento(ListaSimple lista, Object dato, String atributo) {
        return departamentoDAO.obtenerIdDepartamento(lista, dato, atributo);
    }
}
