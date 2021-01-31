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
    
    public ProyectoModelo buscarProyecto(Object dato, String atributo, ListaSimple lista) {
        lista = ordenarProyectos(lista, atributo);
        ProyectoModelo proyecto = (ProyectoModelo) UtilidadesControlador.buscarObjetoPorBusquedaBinariaPorDato(dato, atributo, lista);
        return proyecto;
    }
    
    public Boolean modificarProyecto (Object objeto, String atributo, ListaSimple lista) {
        try {
            lista.editarPorDato(UtilidadesControlador.extraerDato(objeto, atributo), atributo, objeto);
            modificarObjetos(lista);
            return true;
        } catch (Exception e) {
            System.out.println("Error en modificar proyecto: " + e);
            return false;
        }
    }
    
    public Boolean darDeBajaProyecto(Object dato, String atributo, ListaSimple lista) {
        ProyectoModelo proyecto = buscarProyecto(dato, atributo, lista);
        proyecto.setActivo(false);
        try {
            // Se modifica
            modificarProyecto(proyecto, atributo, lista);
            return true;
        } catch (Exception e) {
            System.out.println("Error en dar de baja el proyecto: " + e);
            return false;
        }
    }
    
    public ListaSimple listarProyectosCoincidentes(ListaSimple lista, Object dato, String atributo) {
        ordenarProyectos(lista, atributo);
        return listarCoincidencias(lista, dato, atributo);
    }
}
