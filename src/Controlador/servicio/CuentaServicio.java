
package controlador.servicio;

import controlador.DAO.objetosDAO.CuentaDAO;
import controlador.listaSimple.ListaSimple;
import modelo.CuentaModelo;

public class CuentaServicio {
    public static String IDENTIFICADOR = "id";
    public static String NOMBRE = "nombre";
    public static String EXTERNAL_ID = "external_id";
    public static String USUARIO = "usuario";
    public static String CLAVE = "clave";
    public static String ACTIVO = "activo";
    private CuentaDAO cuentaDAO = new CuentaDAO();

    // No se ocupa aún
    public CuentaModelo getCuentaDAO() {
        return cuentaDAO.getCuenta();
    }

    public CuentaModelo inicarSesion(String usuario, String clave) {
        return cuentaDAO.iniciarSesion(usuario, clave);
    }
    
    public Boolean modificarCuenta (Object objeto, String atributo, ListaSimple lista) {
        return cuentaDAO.modificarCuenta(objeto, atributo, lista);
    }
    
    public Boolean darDeBajaCuenta (String dato, String atributo, ListaSimple lista) {
        return cuentaDAO.darDeBajaCuenta(dato, atributo, lista);
    }
    
    public ListaSimple listarCuentasActivas(ListaSimple lista) {
        return cuentaDAO.listarCuentasActivas(lista);
    }

    public ListaSimple listarCuentasInactivas(ListaSimple lista) {
        return cuentaDAO.listarCuentasInactivas(lista);
    }
    public ListaSimple listarCuentas() {
        return cuentaDAO.listarObjetos();
    }
}
