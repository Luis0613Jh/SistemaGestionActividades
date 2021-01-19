package controlador.DAO.objetosDAO;

import controlador.DAO.AdaptadorDAO;
import controlador.DAO.ConexionDAO;
import modelo.PersonaModelo;

public class PersonaDAO extends AdaptadorDAO {

    private PersonaModelo persona;

    public PersonaDAO() {
        super(new ConexionDAO(), PersonaModelo.class);
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
            this.getPersona().setId(Integer.parseInt(String.valueOf(listarObjetos().tamanio() + 1)));
            this.guardarObjeto(this.getPersona());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar persona: " + e);
            return false;
        }
    }

//    public ListaSimple ordenar(ListaSimple lista, int tipo_ordenacion, String atributo) {
//        lista.ordenar(tipo_ordenacion, atributo);
//        return lista;
//    }
}
