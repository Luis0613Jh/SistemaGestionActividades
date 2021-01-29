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

    public HitoModelo buscarHito(String dato, String atributo, ListaSimple lista) {
        lista = ordenarHitos(lista, atributo);
        HitoModelo cuenta = (HitoModelo) UtilidadesControlador.buscarObjetoPorBusquedaBinariaPorDato(dato, atributo, lista);
        return cuenta;
    }
}
