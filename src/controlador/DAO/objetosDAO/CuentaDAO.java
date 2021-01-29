package controlador.DAO.objetosDAO;

import controlador.DAO.AdaptadorDAO;
import controlador.DAO.ConexionDAO;
import controlador.listaSimple.ListaSimple;
import controlador.utilidades.UtilidadesControlador;
import modelo.CuentaModelo;

public class CuentaDAO extends AdaptadorDAO {

    private CuentaModelo cuenta;

    public CuentaDAO() {
        super(new ConexionDAO(), CuentaModelo.class, new ConexionDAO().getCARPETA_CUENTAS());
    }

    public CuentaModelo getCuenta() {
        if (cuenta == null) {
            cuenta = new CuentaModelo();
        }
        return cuenta;
    }

    public void setCuenta(CuentaModelo cuenta) {
        this.cuenta = cuenta;
    }

    public Boolean guardarCuenta() {
        try {
            this.guardarObjeto(this.getCuenta());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar cuenta: " + e);
            return false;
        }
    }

    public CuentaModelo iniciarSesion(String usuario, String clave) {
        ListaSimple listaCuentas = listarObjetos();

        CuentaModelo cuenta = buscarCuenta(usuario, "usuario", listaCuentas);
        
        if (cuenta != null) {
            if (!cuenta.getClave().equals(clave)) {
                cuenta = null;
            }
        }
        return cuenta;
    }

    public ListaSimple ordenarCuentas(ListaSimple lista, String atributo) {
        UtilidadesControlador.ordenarQuicksort(0, lista.tamanio() - 1, lista, atributo);
        return lista;
    }
    
    public CuentaModelo buscarCuenta(String dato, String atributo, ListaSimple lista) {
        lista = ordenarCuentas(lista, atributo);
        CuentaModelo cuenta = (CuentaModelo) UtilidadesControlador.buscarObjetoPorBusquedaBinariaPorDato(dato, atributo, lista);
        return cuenta;
    }
}
