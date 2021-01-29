package controlador.servicio;

import controlador.DAO.objetosDAO.PersonaDAO;
import controlador.listaSimple.ListaSimple;
import modelo.PersonaModelo;

public class PersonaServicio {

    public static String IDENTIFICADOR = "id";
    public static String NOMBRE = "nombre";
    public static String CORREO = "correo";
    public static String TELEFONO = "telefono";
    public static String EXTERNAL_ID = "external_id";
    public static String CEDULA = "cedula";
    public static String ID_CUENTA = "id_cuenta";
    public static String ID_ROL = "id_rol";
    public static String PATH_IMAGEN = "path_imagen";
    private PersonaDAO personaDAO = new PersonaDAO();

    public PersonaModelo getPersona() {
        return personaDAO.getPersona();
    }
    
    public void setPersona(PersonaModelo persona) {
        personaDAO.setPersona(persona);
    }

    public Boolean guardarPersona() {
        return personaDAO.guardarPersona();
    }

    public ListaSimple listarPersonas() {
        return personaDAO.listarObjetos();
    }

    public ListaSimple ordenarListadoPersonas(String atributo) {
        return personaDAO.ordenarPersonas(personaDAO.listarObjetos(), atributo);
    }

    public PersonaModelo buscarPersona(String dato, String atributo) {
        return personaDAO.buscarPersona(dato, atributo, listarPersonas());
    }

}
