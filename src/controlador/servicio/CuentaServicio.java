
package controlador.servicio;

import controlador.DAO.objetosDAO.CuentaDAO;
import modelo.CuentaModelo;

public class CuentaServicio {
    private CuentaDAO cuentaDAO = new CuentaDAO();

    public CuentaModelo inicarSesion(String usuario, String clave) {
        return cuentaDAO.iniciarSesion(usuario, clave);
    }
    
}
