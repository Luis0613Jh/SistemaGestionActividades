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
        hito.setActivo(false);
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
}
