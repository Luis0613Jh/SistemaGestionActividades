package controlador.DAO.objetosDAO;

import controlador.DAO.AdaptadorDAO;
import controlador.DAO.ConexionDAO;
import controlador.listaSimple.ListaSimple;
import controlador.utilidades.UtilidadesControlador;
import modelo.PersonaModelo;

public class PersonaDAO extends AdaptadorDAO {

    private PersonaModelo persona;

    public PersonaDAO() {
        super(new ConexionDAO(), PersonaModelo.class, new ConexionDAO().getCARPETA_EMPLEADOS());
    }

    public PersonaModelo getPersona() {
        if (persona == null) {
            persona = new PersonaModelo();
        }
        return persona;
    }

    public void setPersona(PersonaModelo persona) {
        this.persona = persona;
    }

    public Boolean guardarPersona() {
        try {
            this.guardarObjeto(this.getPersona());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar persona: " + e);
            return false;
        }
    }

    public ListaSimple ordenarPersonas(ListaSimple lista, String atributo) {
        UtilidadesControlador.ordenarQuicksort(0, lista.tamanio() - 1, lista, atributo);
        return lista;
    }
}
