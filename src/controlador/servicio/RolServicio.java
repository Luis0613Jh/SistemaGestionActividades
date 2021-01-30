
package controlador.servicio;

import controlador.DAO.objetosDAO.RolDAO;
import controlador.listaSimple.ListaSimple;
import modelo.RolModelo;

public class RolServicio {

    public static String IDENTIFICADOR = "id";
    public static String TIPO = "tipo";
    public static String EXTERNAL_ID = "external_id";
    private RolDAO rolDAO = new RolDAO();

    public RolModelo getRol() {
        return rolDAO.getRol();
    }
    
    public void setRol(RolModelo rol) {
        rolDAO.setRol(rol);
    }

    public Boolean guardarRol() {
        return rolDAO.guardarRol();
    }

    public ListaSimple listarRoles() {
        return rolDAO.listarObjetos();
    }

    public ListaSimple ordenarListadoRoles(String atributo) {
        return rolDAO.ordenarRoles(rolDAO.listarObjetos(), atributo);
    }

    public RolModelo buscarRol(String dato, String atributo) {
        return rolDAO.buscarRol(dato, atributo, listarRoles());
    }
}
