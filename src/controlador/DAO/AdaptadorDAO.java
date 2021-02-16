package controlador.DAO;

import controlador.listaSimple.ListaSimple;
import controlador.utilidades.UtilidadesControlador;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

public class AdaptadorDAO implements InterfazDAO {

    private ConexionDAO conexionDAO;
    private Class claseObjeto;
    private String carpeta;

    /**
     * Construye un objeto AdaptadorDAO, indicando: conexionDAO, claseObjeto,
     * carpeta.
     *
     * @param conexionDAO Objeto que conecta el objeto XStream con el
     * AdaptadorDAO, es de tipo ConexionDAO.
     * @param claseObjeto Objeto que contiene toda la información de la clase de
     * un objeto, es de tipo class.
     * @param carpeta String que indica el nombre de la carpeta a crear.
     */
    public AdaptadorDAO(ConexionDAO conexionDAO, Class claseObjeto, String carpeta) {
        this.conexionDAO = conexionDAO;
        this.claseObjeto = claseObjeto;
        this.carpeta = carpeta;
    }

    /**
     * Construye un objeto AdaptadorDAO sin recibir ningún parámetro.
     */
    public AdaptadorDAO() {
    }

    /**
     * Método que permite recuperar todos los objetos de un archivo especificado.
     * @return Una lista con todos los objetos almacenados en el archivo a buscar, en caso de que no existan objetos, retorna null.
     */
    @Override
    public ListaSimple listarObjetos() {
        ListaSimple listaAux = null;
        File archivo = new File(conexionDAO.getCARPETA_CONTENEDORA() + File.separatorChar + carpeta + File.separatorChar + claseObjeto.getSimpleName() + ".json");
        try {
            if (archivo.exists()) {
                listaAux = (ListaSimple) conexionDAO.getXstream().fromXML(new FileReader(conexionDAO.getCARPETA_CONTENEDORA() + File.separatorChar + carpeta + File.separatorChar + claseObjeto.getSimpleName() + ".json"));
                return listaAux;
            }
        } catch (Exception e) {
            System.out.println("ERROR al listar: " + e.getMessage());
        }
        return listaAux;
    }

    /**
     * Método que permite guardar un objeto en un archivo especificado.
     * @param objeto Objeto a guardar en el archivo especificado.
     */
    @Override
    public void guardarObjeto(Object objeto) throws Exception {
        if (verificarRutaArchivo()) {
            File archivo = new File(conexionDAO.getCARPETA_CONTENEDORA() + File.separatorChar + carpeta + File.separatorChar + claseObjeto.getSimpleName() + ".json");
            if (archivo.exists() == true) {
                ListaSimple listaAux = listarObjetos();
                listaAux.insertarFinal(objeto);
                conexionDAO.getXstream().toXML(listaAux, new FileOutputStream(conexionDAO.getCARPETA_CONTENEDORA() + File.separatorChar + carpeta + File.separatorChar + claseObjeto.getSimpleName() + ".json"));
            } else {
                ListaSimple listaAux = new ListaSimple();
                listaAux.insertarFinal(objeto);
                conexionDAO.getXstream().toXML(listaAux, new FileOutputStream(conexionDAO.getCARPETA_CONTENEDORA() + File.separatorChar + carpeta + File.separatorChar + claseObjeto.getSimpleName() + ".json"));
            }
        } else {
            crearRutaArchivo();
            guardarObjeto(objeto);
        }
    }

    /**
     * Método que permite modificar los objetos almacenados en un archivo especificado.
     * @param lista Lista que contiene todos los objetos ya modificados, es de tipo ListaSimple.
     */
    @Override
    public void modificarObjetos(ListaSimple lista) {
        File archivo = new File(conexionDAO.getCARPETA_CONTENEDORA() + File.separatorChar + carpeta + File.separatorChar + claseObjeto.getSimpleName() + ".json");
        try {
            if (archivo.exists()) {
                conexionDAO.getXstream().toXML(lista, new FileOutputStream(conexionDAO.getCARPETA_CONTENEDORA() + File.separatorChar + carpeta + File.separatorChar + claseObjeto.getSimpleName() + ".json"));
            }
        } catch (Exception e) {
            System.out.println("ERROR al listar: " + e.getMessage());
        }
    }

    /**
     * Método que permite buscar objetos en una lista, mediante el dato indicado.
     * @param lista Lista en donde se van a buscar las coincidencias indicadas.
     * @param dato Dato a buscar en la lista, es de tipo Object.
     * @param atributo Atributo que especifica el nombre de la variable que contiene el dato a buscar (variable instanciada en el modelo), es de tipo String.
     * @return Retorna una lista con todos los objetos que coinciden con el dato a buscar, es de tipo ListaSimple, en caso de no existir coincidencias, retorna null.
     */
    @Override
    public ListaSimple listarCoincidencias(ListaSimple lista, Object dato, String atributo) {
        ListaSimple listaTemporal = new ListaSimple();

        while (lista.tamanio() > 0) {
            Object objeto = UtilidadesControlador.buscarObjetoPorBusquedaBinariaPorDato(dato, atributo, lista);
            if (objeto != null) {
                listaTemporal.insertarFinal(objeto);
                lista.eliminarPorObjeto(objeto);
            } else {
                break;
            }
        }
        return listaTemporal;
    }
    
    /**
     * Método que verifica si la ruta del archivo especificado exxiste.
     * @return Retorna true si la ruta especificada existe, o false en caso de que no exista, es de tipo boolean.
     */
    public boolean verificarRutaArchivo() {
        boolean bandera = false;
        File carpetaContenedora = new File(conexionDAO.getCARPETA_CONTENEDORA());
        if (carpetaContenedora.exists()) {
            File carpetaArchivo = new File(conexionDAO.getCARPETA_CONTENEDORA() + File.separatorChar + carpeta);
            if (carpetaArchivo.exists()) {
                return true;
            } else {
                carpetaArchivo.mkdir();
                verificarRutaArchivo();
            }
        } else {
            carpetaContenedora.mkdir();
            verificarRutaArchivo();
        }
        return bandera;
    }

    /**
     * Método que crea la ruta de archivo especificada.
     */
    public void crearRutaArchivo() {
        File carpetaContenedora = new File(conexionDAO.getCARPETA_CONTENEDORA());
        if (carpetaContenedora.exists()) {
            File carpetaArchivo = new File(conexionDAO.getCARPETA_CONTENEDORA() + File.separatorChar + carpeta);
            if (!carpetaArchivo.exists()) {
                carpetaArchivo.mkdir();
                verificarRutaArchivo();
            }
        } else {
            carpetaContenedora.mkdir();
            verificarRutaArchivo();
        }
    }
}
