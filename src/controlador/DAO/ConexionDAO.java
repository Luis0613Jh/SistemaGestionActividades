package controlador.DAO;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class ConexionDAO {

    private final String CARPETA_CONTENEDORA = "Archivos";
    private final String CARPETA_EMPLEADOS = "Empleados";
    private final String CARPETA_CUENTAS = "Cuentas";
    private final String CARPETA_ROLES = "Roles";
    private final String CARPETA_PROYECTOS = "Proyectos";
    private final String CARPETA_ACTIVIDADES = "Actividades";
    private final String CARPETA_DEPARTAMENTOS = "Departamentos";
    private XStream xstream;

    public ConexionDAO() {
        instanciarObjetoXStream();
    }

    public XStream getXstream() {
        return xstream;
    }

    public String getCARPETA_CONTENEDORA() {
        return CARPETA_CONTENEDORA;
    }

    public String getCARPETA_EMPLEADOS() {
        return CARPETA_EMPLEADOS;
    }

    public String getCARPETA_CUENTAS() {
        return CARPETA_CUENTAS;
    }

    public String getCARPETA_ROLES() {
        return CARPETA_ROLES;
    }

    public String getCARPETA_PROYECTOS() {
        return CARPETA_PROYECTOS;
    }

    public String getCARPETA_ACTIVIDADES() {
        return CARPETA_ACTIVIDADES;
    }

    public String getCARPETA_DEPARTAMENTOS() {
        return CARPETA_DEPARTAMENTOS;
    }
       
    public void instanciarObjetoXStream() {
        xstream = new XStream(new JettisonMappedXmlDriver());
        xstream.setMode(XStream.NO_REFERENCES);
    }
}
