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

    public ListaSimple ordenarListadoDepartamentos(String atributo) {
        return departamentoDAO.ordenarDepartamentos(departamentoDAO.listarObjetos(), atributo);
    }

    public DepartamentoModelo buscarDepartamento(String dato, String atributo) {
        return departamentoDAO.buscarDepartamento(dato, atributo, listarDepartamentos());
    }

}
