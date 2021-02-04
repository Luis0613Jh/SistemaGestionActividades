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

    public DepartamentoModelo buscarDepartamento(Object dato, String atributo, ListaSimple lista) {
        lista = ordenarDepartamentos(lista, atributo);
        DepartamentoModelo cuenta = (DepartamentoModelo) UtilidadesControlador.buscarObjetoPorBusquedaBinariaPorDato(dato, atributo, lista);
        return cuenta;
    }
    
    public Boolean modificarDepartamento (Object objeto, String atributo, ListaSimple lista) {
        try {
            lista.editarPorDato(UtilidadesControlador.extraerDato(objeto, atributo), atributo, objeto);
            modificarObjetos(lista);
            return true;
        } catch (Exception e) {
            System.out.println("Error en modificar departamento: " + e);
            return false;
        }
    }
    
    public Boolean darDeBajaDepartamento(Object dato, String atributo, ListaSimple lista) {
        DepartamentoModelo departamento = buscarDepartamento(dato, atributo, lista);
        departamento.setEstado("inactivo");
        try {
            // Se modifica
            modificarDepartamento(departamento, atributo, lista);
            return true;
        } catch (Exception e) {
            System.out.println("Error en modificar el departamento: " + e);
            return false;
        }
    }
    
    public ListaSimple listarDepartamentosCoincidentes(ListaSimple lista, Object dato, String atributo) {
        ordenarDepartamentos(lista, atributo);
        return listarCoincidencias(lista, dato, atributo);
    }
    
    /**
     * Método que busca los departamentos con estado "activo" en el archivo contenedor.
     * @param lista ListaSimple en donde se va a buscar las coincidencias.
     * @return Retorna una lista con todas los departamentos con estado "activo", en caso de no existir coincidencias, retorna una lista vacía.
     */
    public ListaSimple listarDepartamentosActivos(ListaSimple lista) {
        ordenarDepartamentos(lista, "estado");
        return listarCoincidencias(lista, "activo", "estado");
    }
    
    /**
     * Método que busca los departamentos con estado "inactivo" en el archivo contenedor.
     * @param lista ListaSimple en donde se va a buscar las coincidencias.
     * @return Retorna una lista con todas los departamentos con estado "inactivo", en caso de no existir coincidencias, retorna una lista vacía.
     */
    public ListaSimple listarDepartamentosInactivos(ListaSimple lista) {
        ordenarDepartamentos(lista, "estado");
        return listarCoincidencias(lista, "inactivo", "estado");
    }
    
    public int obtenerIdDepartamento(ListaSimple lista, Object dato, String atributo) {
        DepartamentoModelo departamento = buscarDepartamento(dato, atributo, lista);
        return departamento.getId();
    }
}
