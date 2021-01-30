package controlador.DAO.objetosDAO;

import controlador.DAO.AdaptadorDAO;
import controlador.DAO.ConexionDAO;
import controlador.listaSimple.ListaSimple;
import controlador.utilidades.UtilidadesControlador;
import modelo.DepartamentoModelo;

public class DepartamentoDAO extends AdaptadorDAO {

    private DepartamentoModelo departamento;

    public DepartamentoDAO() {
        super(new ConexionDAO(), DepartamentoModelo.class, new ConexionDAO().getCARPETA_DEPARTAMENTOS());
    }

    public DepartamentoModelo getDepartamento() {
        if (departamento == null) {
            departamento = new DepartamentoModelo();
        }
        return departamento;
    }

    public void setDepartamento(DepartamentoModelo departamento) {
        this.departamento = departamento;
    }

    public Boolean guardarDepartamento() {
        try {
            this.guardarObjeto(this.getDepartamento());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar departamento: " + e);
            return false;
        }
    }

    public ListaSimple ordenarDepartamentos(ListaSimple lista, String atributo) {
        UtilidadesControlador.ordenarQuicksort(0, lista.tamanio() - 1, lista, atributo);
        return lista;
    }

    public DepartamentoModelo buscarDepartamento(String dato, String atributo, ListaSimple lista) {
        lista = ordenarDepartamentos(lista, atributo);
        DepartamentoModelo cuenta = (DepartamentoModelo) UtilidadesControlador.buscarObjetoPorBusquedaBinariaPorDato(dato, atributo, lista);
        return cuenta;
    }
}
