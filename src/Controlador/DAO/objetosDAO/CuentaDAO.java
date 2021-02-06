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
    
    public Boolean modificarCuenta (Object objeto, String atributo, ListaSimple lista) {
        try {
            lista.editarPorDato(UtilidadesControlador.extraerDato(objeto, atributo), atributo, objeto);
            modificarObjetos(lista);
            return true;
        } catch (Exception e) {
            System.out.println("Error en modificar cuenta: " + e);
            return false;
        }
    }
    
    public Boolean darDeBajaCuenta(String dato, String atributo, ListaSimple lista) {
        CuentaModelo cuenta = buscarCuenta(dato, atributo, lista);
        cuenta.setEstado("inactivo");
        try {
            // Se modifica
            modificarCuenta(cuenta, atributo, lista);
            return true;
        } catch (Exception e) {
            System.out.println("Error en dar de baja el cuenta: " + e);
            return false;
        }
    }
    
    /**
     * Método que busca las cuentas con estado "activo" en el archivo contenedor.
     * @param lista ListaSimple en donde se va a buscar las coincidencias.
     * @return Retorna una lista con todas las cuentas con estado "activo", en caso de no existir coincidencias, retorna una lista vacía.
     */
    public ListaSimple listarCuentasActivas(ListaSimple lista) {
        ordenarCuentas(lista, "estado");
        return listarCoincidencias(lista, "activo", "estado");
    }
    
    /**
     * Método que busca las cuentas con estado "inactivo" en el archivo contenedor.
     * @param lista ListaSimple en donde se va a buscar las coincidencias.
     * @return Retorna una lista con todas las cuentas con estado "inactivo", en caso de no existir coincidencias, retorna una lista vacía.
     */
    public ListaSimple listarCuentasInactivas(ListaSimple lista) {
        ordenarCuentas(lista, "estado");
        return listarCoincidencias(lista, "inactivo", "estado");
    }
}
