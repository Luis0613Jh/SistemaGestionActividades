package controlador.DAO.objetosDAO;

import controlador.DAO.AdaptadorDAO;
import controlador.DAO.ConexionDAO;
import controlador.listaSimple.ListaSimple;
import controlador.utilidades.UtilidadesControlador;
import modelo.RolModelo;

public class RolDAO extends AdaptadorDAO {

    private RolModelo rol;

    public RolDAO() {
        super(new ConexionDAO(), RolModelo.class, new ConexionDAO().getCARPETA_ROLES());
    }

    public RolModelo getRol() {
        if (rol == null) {
            rol = new RolModelo();
        }
        return rol;
    }

    public void setRol(RolModelo rol) {
        this.rol = rol;
    }

    public Boolean guardarRol() {
        try {
            this.guardarObjeto(this.getRol());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar rol: " + e);
            return false;
        }
    }

    public ListaSimple ordenarRoles(ListaSimple lista, String atributo) {
        UtilidadesControlador.ordenarQuicksort(0, lista.tamanio() - 1, lista, atributo);
        return lista;
    }
    
    public RolModelo buscarRol(String dato, String atributo, ListaSimple lista) {
        lista = ordenarRoles(lista, atributo);
        RolModelo cuenta = (RolModelo) UtilidadesControlador.buscarObjetoPorBusquedaBinariaPorDato(dato, atributo, lista);
        return cuenta;
    }
}
