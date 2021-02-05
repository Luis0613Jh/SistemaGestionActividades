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
        proyecto.setEstado("inactivo");
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
    
    /**
     * Método que busca los proyectos con estado "activo" en el archivo contenedor.
     * @param lista ListaSimple en donde se va a buscar las coincidencias.
     * @return Retorna una lista con todas los proyectos con estado "activo", en caso de no existir coincidencias, retorna una lista vacía.
     */
    public ListaSimple listarProyectosActivos(ListaSimple lista) {
        ordenarProyectos(lista, "estado");
        return listarCoincidencias(lista, "activo", "estado");
    }
    
    /**
     * Método que busca los proyectos con estado "inactivo" en el archivo contenedor.
     * @param lista ListaSimple en donde se va a buscar las coincidencias.
     * @return Retorna una lista con todas los proyectos con estado "inactivo", en caso de no existir coincidencias, retorna una lista vacía.
     */
    public ListaSimple listarProyectosInactivos(ListaSimple lista) {
        ordenarProyectos(lista, "estado");
        return listarCoincidencias(lista, "inactivo", "estado");
    }
    
    public int obtenerIdProyecto(ListaSimple lista, Object dato, String atributo) {
        ProyectoModelo proyecto = buscarProyecto(dato, atributo, lista);
        return proyecto.getId();
    }
}
