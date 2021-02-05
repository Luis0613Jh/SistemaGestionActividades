package controlador.DAO.objetosDAO;

import controlador.DAO.AdaptadorDAO;
import controlador.DAO.ConexionDAO;
import controlador.listaSimple.ListaSimple;
import controlador.utilidades.UtilidadesControlador;
import modelo.HitoModelo;

public class HitoDAO extends AdaptadorDAO {

    private HitoModelo hito;

    public HitoDAO() {
        super(new ConexionDAO(), HitoModelo.class, new ConexionDAO().getCARPETA_PROYECTOS());
    }

    public HitoModelo getHito() {
        if (hito == null) {
            hito = new HitoModelo();
        }
        return hito;
    }

    public void setHito(HitoModelo hito) {
        this.hito = hito;
    }

    public Boolean guardarHito() {
        try {
            this.guardarObjeto(this.getHito());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar hito: " + e);
            return false;
        }
    }

    public ListaSimple ordenarHitos(ListaSimple lista, String atributo) {
        UtilidadesControlador.ordenarQuicksort(0, lista.tamanio() - 1, lista, atributo);
        return lista;
    }

    public HitoModelo buscarHito(Object dato, String atributo, ListaSimple lista) {
        lista = ordenarHitos(lista, atributo);
        HitoModelo cuenta = (HitoModelo) UtilidadesControlador.buscarObjetoPorBusquedaBinariaPorDato(dato, atributo, lista);
        return cuenta;
    }
    
    public Boolean modificarHito (Object objeto, String atributo, ListaSimple lista) {
        try {
            lista.editarPorDato(UtilidadesControlador.extraerDato(objeto, atributo), atributo, objeto);
            modificarObjetos(lista);
            return true;
        } catch (Exception e) {
            System.out.println("Error en modificar hito: " + e);
            return false;
        }
    }
    
    public Boolean darDeBajaHito(Object dato, String atributo, ListaSimple lista) {
        HitoModelo hito = buscarHito(dato, atributo, lista);
        hito.setEstado("inactivo");
        try {
            // Se modifica
            modificarHito(hito, atributo, lista);
            return true;
        } catch (Exception e) {
            System.out.println("Error en dar de baja el hito: " + e);
            return false;
        }
    }
    
    public ListaSimple listarHitosCoincidentes(ListaSimple lista, Object dato, String atributo) {
        ordenarHitos(lista, atributo);
        return listarCoincidencias(lista, dato, atributo);
    }
    
    /**
     * Método que busca los hitos con estado "activo" en el archivo contenedor.
     * @param lista ListaSimple en donde se va a buscar las coincidencias.
     * @return Retorna una lista con todas los hitos con estado "activo", en caso de no existir coincidencias, retorna una lista vacía.
     */
    public ListaSimple listarHitosActivos(ListaSimple lista) {
        ordenarHitos(lista, "estado");
        return listarCoincidencias(lista, "activo", "estado");
    }
    
    /**
     * Método que busca los hitos con estado "inactivo" en el archivo contenedor.
     * @param lista ListaSimple en donde se va a buscar las coincidencias.
     * @return Retorna una lista con todas los hitos con estado "inactivo", en caso de no existir coincidencias, retorna una lista vacía.
     */
    public ListaSimple listarHitosInactivos(ListaSimple lista) {
        ordenarHitos(lista, "estado");
        return listarCoincidencias(lista, "inactivo", "estado");
    }
    
    public int obtenerIdHito(ListaSimple lista, Object dato, String atributo) {
        HitoModelo hito = buscarHito(dato, atributo, lista);
        return hito.getId();
    }
}
