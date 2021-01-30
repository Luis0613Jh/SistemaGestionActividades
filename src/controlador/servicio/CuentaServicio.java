
package controlador.servicio;

import controlador.DAO.objetosDAO.CuentaDAO;
import modelo.CuentaModelo;

public class CuentaServicio {
    private CuentaDAO cuentaDAO = new CuentaDAO();

    // No se ocupa aún
    public CuentaModelo getCuentaDAO() {
        return cuentaDAO.getCuenta();
    }

    public CuentaModelo inicarSesion(String usuario, String clave) {
        return cuentaDAO.iniciarSesion(usuario, clave);
    }
    
}
