package controlador.DAO.objetosDAO;

import controlador.DAO.AdaptadorDAO;
import controlador.DAO.ConexionDAO;

public class ProyectoDAO extends AdaptadorDAO {

    private ProyectoModelo proyecto;

    public ProyectoDAO() {
        super(new ConexionDAO(), ProyectoModelo.class);
    }

    public ProyectoModelo getProyecto() {
        if (proyecto == null) {
            proyecto = new ProyectoModelo();
        }
        return proyecto;
    }

    public void setProyecto(ProyectoModelo proyecto) {
        this.proyecto = proyecto;
    }

    public Boolean guardarProyecto() {
        try {
            this.getProyecto().setId(Integer.parseInt(String.valueOf(listarObjetos().tamanio() + 1)));
            this.guardarObjeto(this.getProyecto());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar proyecto: " + e);
            return false;
        }
    }

//    public ListaSimple ordenar(ListaSimple lista, int tipo_ordenacion, String atributo) {
//        lista.ordenar(tipo_ordenacion, atributo);
//        return lista;
//    }
}
