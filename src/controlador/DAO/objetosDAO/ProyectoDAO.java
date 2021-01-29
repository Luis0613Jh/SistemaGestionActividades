package controlador.DAO.objetosDAO;

import controlador.DAO.AdaptadorDAO;
import controlador.DAO.ConexionDAO;
import controlador.listaSimple.ListaSimple;
import controlador.utilidades.UtilidadesControlador;
import modelo.ProyectoModelo;

public class ProyectoDAO extends AdaptadorDAO {

    private ProyectoModelo proyecto;

    public ProyectoDAO() {
        super(new ConexionDAO(), ProyectoModelo.class, new ConexionDAO().getCARPETA_PROYECTOS());
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
            this.guardarObjeto(this.getProyecto());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar proyecto: " + e);
            return false;
        }
    }

    public ListaSimple ordenarProyectos(ListaSimple lista, String atributo) {
        UtilidadesControlador.ordenarQuicksort(0, lista.tamanio() - 1, lista, atributo);
        return lista;
    }
    
    public ProyectoModelo buscarProyecto(String dato, String atributo, ListaSimple lista) {
        lista = ordenarProyectos(lista, atributo);
        ProyectoModelo cuenta = (ProyectoModelo) UtilidadesControlador.buscarObjetoPorBusquedaBinariaPorDato(dato, atributo, lista);
        return cuenta;
    }
}
