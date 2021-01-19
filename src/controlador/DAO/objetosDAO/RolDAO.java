package controlador.DAO.objetosDAO;

import controlador.DAO.AdaptadorDAO;
import controlador.DAO.ConexionDAO;
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
            this.getRol().setId(Integer.parseInt(String.valueOf(listarObjetos().tamanio() + 1)));
            this.guardarObjeto(this.getRol());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar rol: " + e);
            return false;
        }
    }

//    public ListaSimple ordenar(ListaSimple lista, int tipo_ordenacion, String atributo) {
//        lista.ordenar(tipo_ordenacion, atributo);
//        return lista;
//    }
}
