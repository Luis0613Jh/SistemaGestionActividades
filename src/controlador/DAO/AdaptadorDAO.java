package controlador.DAO;

import controlador.listaSimple.ListaSimple;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

public class AdaptadorDAO implements InterfazDAO {

    private ConexionDAO conexionDAO;
    private Class claseObjeto;
    private String carpeta;

    /**
     * Construye un objeto AdaptadorDAO, indicando: conexionDAO, claseObjeto, carpeta.
     * @param conexionDAO Objeto que conecta el objeto XStream con el AdaptadorDAO.
     * @param claseObjeto Objeto que contiene toda la inforamción de la clase de un objeto.
     * @param carpeta Indica el nombre de la carpeta a crear, es de tipo string.
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

    @Override
    public ListaSimple listarObjetos() {
        ListaSimple listaAux = new ListaSimple();
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
