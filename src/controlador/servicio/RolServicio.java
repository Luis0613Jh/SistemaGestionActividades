
package controlador.servicio;

import controlador.DAO.objetosDAO.RolDAO;
import controlador.listaSimple.ListaSimple;
import modelo.RolModelo;

public class RolServicio {

    public static String IDENTIFICADOR = "id";
    public static String TIPO = "tipo";
    public static String EXTERNAL_ID = "external_id";
    public static String ACTIVO = "activo";
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

    public Boolean crearRoles() {
        return rolDAO.crearRoles();
    }
    
    public RolModelo buscarRol(String dato, String atributo) {
        return rolDAO.buscarRol(dato, atributo, listarRoles());
    }
    
    public Boolean modificarRol (Object objeto, String atributo, ListaSimple lista) {
        return rolDAO.modificarRol(objeto, atributo, lista);
    }
    
    public Boolean darDeBajaRol (String dato, String atributo, ListaSimple lista) {
        return rolDAO.darDeBajaRol(dato, atributo, lista);
    }
}
