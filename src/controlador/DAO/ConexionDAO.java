package controlador.DAO;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;

public class ConexionDAO {

    private final String CARPETA_CONTENEDORA = "Archivos";
    private final String CARPETA_EMPLEADOS = "Empleados";
    private final String CARPETA_CUENTAS = "Cuentas";
    private final String CARPETA_ROLES = "Roles";
    private final String CARPETA_PROYECTOS = "Proyectos";
    private final String CARPETA_ACTIVIDADES = "Actividades";
    private final String CARPETA_DEPARTAMENTOS = "Departamentos";
    private XStream xstream;

    /**
     * Cronstruye un objeto ConexionDAO, instanciando el objeto XStream.
     */
    public ConexionDAO() {
        instanciarObjetoXStream();
    }

    /**
     * Método para obtener el objeto XStream.
     * @return Retorna un objeto XStream.
     */
    public XStream getXstream() {
        return xstream;
    }

    /**
     * Método para obtener la carpeta contenedora.
     * @return Retorna un String con el nombre de la carpeta contenedora.
     */
    public String getCARPETA_CONTENEDORA() {
        return CARPETA_CONTENEDORA;
    }

    /**
     * Método para obtener la carpeta empleados.
     * @return Retorna un String con el nombre de la carpeta empleados.
     */
    public String getCARPETA_EMPLEADOS() {
        return CARPETA_EMPLEADOS;
    }

    /**
     * Método para obtener la carpeta cuentas.
     * @return Retorna un String con el nombre de la carpeta cuentas.
     */
    public String getCARPETA_CUENTAS() {
        return CARPETA_CUENTAS;
    }

    /**
     * Método para obtener la carpeta roles.
     * @return Retorna un String con el nombre de la carpeta roles.
     */
    public String getCARPETA_ROLES() {
        return CARPETA_ROLES;
    }

    /**
     * Método para obtener la carpeta proyectos.
     * @return Retorna un String con el nombre de la carpeta proyectos.
     */
    public String getCARPETA_PROYECTOS() {
        return CARPETA_PROYECTOS;
    }

    /**
     * Método para obtener la carpeta actividades.
     * @return Retorna un String con el nombre de la carpeta actividades.
     */
    public String getCARPETA_ACTIVIDADES() {
        return CARPETA_ACTIVIDADES;
    }

    /**
     * Método para obtener la carpeta departamentos.
     * @return Retorna un String con el nombre de la carpeta departamentos.
     */
    public String getCARPETA_DEPARTAMENTOS() {
        return CARPETA_DEPARTAMENTOS;
    }
    
    /**
     * Instancia el objeto XStream.
     */
    public void instanciarObjetoXStream() {
        xstream = new XStream(new JettisonMappedXmlDriver());
        //xstream = new XStream(new JsonHierarchicalStreamDriver());
        xstream.setMode(XStream.NO_REFERENCES);
    }
}
