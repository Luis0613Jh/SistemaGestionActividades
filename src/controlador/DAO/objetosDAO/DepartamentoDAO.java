package controlador.DAO.objetosDAO;

import controlador.DAO.AdaptadorDAO;
import controlador.DAO.ConexionDAO;
import controlador.listaSimple.ListaSimple;
import controlador.utilidades.UtilidadesControlador;
import modelo.DepartamentoModelo;

public class DepartamentoDAO extends AdaptadorDAO {

    private DepartamentoModelo departamento;

    /**
     * Construye un objeto de tipo DepartamentoDAO, instanciando en su clase padre (AdaptadorDAO): un nuevo objeto de tipo ConexionDAO,
     * la clase del objeto de tipo DepartamentoModelo y una String con la carpeta contenedora "Archivos".  
     */
    public DepartamentoDAO() {
        super(new ConexionDAO(), DepartamentoModelo.class, new ConexionDAO().getCARPETA_DEPARTAMENTOS());
    }

    /**
     * Método que permite obtener el objeto de tipo DepartamentoModelo almacenado en la clase. 
     * @return Retorna el objeto de tipo DepartamentoModelo instanciado en la clase, en caso de que no exista, se crea un nuevo objeto DepartamentoModelo.
     */
    public DepartamentoModelo getDepartamento() {
        if (departamento == null) {
            departamento = new DepartamentoModelo();
        }
        return departamento;
    }

    /**
     * Método que permite sobreescribir el objeto de tipo DepartamentoModelo instanciado en la clase.
     * @param departamento Objeto de tipo DepartamentoModelo que se va a sobreescribir en el objeto instanciado en la clase.
     */
    public void setDepartamento(DepartamentoModelo departamento) {
        this.departamento = departamento;
    }

    /**
     * Método que permite guardar una departamento en su archivo contenedor.
     * @return Retorna true en caso de que se haya guardado con éxito la departamento, caso contrario, retorna false.
     */
    public Boolean guardarDepartamento() {
        try {
            this.guardarObjeto(this.getDepartamento());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar departamento: " + e);
            return false;
        }
    }

    /**
     * Método que permite ordenar las departamentos según el atributo especificado de forma ascendente.
     * @param lista Lista original que se desea ordenar de forma ascendente.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @return Retorna una lista ordenada según el atributo indicado a partir de la lista original, es de tipo ListaSimple.
     */
    public ListaSimple ordenarDepartamentos(ListaSimple lista, String atributo) {
        UtilidadesControlador.ordenarQuicksort(0, lista.tamanio() - 1, lista, atributo);
        return lista;
    }

    /**
     * Método que permite buscar una departamento según el dato indicado.
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la lista.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @param lista Lista en donde se va a buscar la departamento según el dato y atributo indicados, es de tipo ListaSimple.
     * @return Retorna un objeto de tipo DepartamentoModelo con toda la información del departamento encontrada, en caso de no existir coincidencia, retorna null.
     */
    public DepartamentoModelo buscarDepartamento(Object dato, String atributo, ListaSimple lista) {
        lista = ordenarDepartamentos(lista, atributo);
        DepartamentoModelo cuenta = (DepartamentoModelo) UtilidadesControlador.buscarObjetoPorBusquedaBinariaPorDato(dato, atributo, lista);
        return cuenta;
    }
    
    /**
     * Método que permite modificar una departamento en el documento que lo contiene.
     * @param objeto Objeto que va a ser modificado en el archivo contenedor.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @param lista Lista en donde se va a buscar las coincidencias, es de tipo ListaSimple.
     * @return Retorna true en caso de que se haya modificado con éxito la departamento, caso contrario, retorna false.
     */
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
    
    /**
     * Método que permite dar de baja a una departamento del sistema, cambiando su estado de "activo" a "inactivo".
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la lista.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @param lista Lista en donde se va a buscar las coincidencias, es de tipo ListaSimple.
     * @return Retorna true en caso de que se haya dado de baja con éxito a la departamento, caso contrario, retorna false.
     */
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
    
    /**
     * Método que busca las departamentos conincidentes con el dato a buscar según el atributo indicado.
     * @param lista Lista en donde se va a buscar las coincidencias, es de tipo ListaSimple.
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la lista.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @return Retorna una lista con todas las coincidencias encontradas, en caso de no existir coincidencias, retorna null.
     */
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
    
    /**
     * Método que permite obtener el id del departamento según un dato especíco del mismo.
     * @param lista Lista en donde se va a buscar la departamento deseada.
     * @param dato Dato mediante el cual se va a realizar la búsqueda en la lista.
     * @param atributo Atributo que especifica el nombre del variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @return Retorna el id del departamento que se buscó en la lista en caso de que exista, caso contrario, retorna -1; 
     */
    public int obtenerIdDepartamento(ListaSimple lista, Object dato, String atributo) {
        DepartamentoModelo departamento = buscarDepartamento(dato, atributo, lista);
        return (departamento != null) ? departamento.getId() : -1;
    }
}
