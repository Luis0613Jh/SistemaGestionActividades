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

    public PersonaModelo buscarPersona(Object dato, String atributo, ListaSimple lista) {
        lista = ordenarPersonas(lista, atributo);
        PersonaModelo cuenta = (PersonaModelo) UtilidadesControlador.buscarObjetoPorBusquedaBinariaPorDato(dato, atributo, lista);
        return cuenta;
    }

    public Boolean modificarPersona(Object objeto, String atributo, ListaSimple lista) {
        try {
            lista.editarPorDato(UtilidadesControlador.extraerDato(objeto, atributo), atributo, objeto);
            modificarObjetos(lista);
            return true;
        } catch (Exception e) {
            System.out.println("Error en modificar persona: " + e);
            return false;
        }
    }

    public Boolean darDeBajaPersona(String dato, String atributo, ListaSimple lista) {
        PersonaModelo persona = buscarPersona(dato, atributo, lista);
        persona.setActivo(false);
        try {
            // Se modifica
            modificarPersona(persona, atributo, lista);
            return true;
        } catch (Exception e) {
            System.out.println("Error en dar de baja el persona: " + e);
            return false;
        }
    }
    
    public ListaSimple listarPersonasCoincidentes(ListaSimple lista, Object dato, String atributo) {
        ordenarPersonas(lista, atributo);
        return listarCoincidencias(lista, dato, atributo);
    }
    
}
