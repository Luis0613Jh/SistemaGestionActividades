package controlador.DAO.objetosDAO;

import controlador.DAO.AdaptadorDAO;
import controlador.DAO.ConexionDAO;
import controlador.listaSimple.ListaSimple;
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
            this.getCuenta().setId(Integer.parseInt(String.valueOf(listarObjetos().tamanio() + 1)));
            this.guardarObjeto(this.getCuenta());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar cuenta: " + e);
            return false;
        }
    }

//    public CuentaModelo iniciarSesion(String usuario, String clave) {
//        ListaSimple cuentas = listarObjetos();
//
//        //cuentas = ordenar(cuentas, ListaSimple.ORDENAR_ASCENDENTE, "usuario");
//        CuentaModelo cuenta = (CuentaModelo) cuentas.busquedaBinaria(usuario, "usuario");
//        if (cuenta != null) {
//            if (!cuenta.getClave().equals(clave)) {
//                cuenta = null;
//            }
//        }
//        return cuenta;
//    }

//    public ListaSimple ordenar(ListaSimple lista, int tipo_ordenacion, String atributo) {
//        lista.ordenar(tipo_ordenacion, atributo);
//        return lista;
//    }
}
