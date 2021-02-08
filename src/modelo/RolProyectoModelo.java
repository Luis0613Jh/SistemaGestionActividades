package modelo;

public class RolProyectoModelo {

    private PersonaModelo persona;
    private ProyectoModelo proyecto;

    /**
     * Metodo obtener persona
     *
     * @return Un PersonaModelo correspondiente a persona
     */
    public PersonaModelo getPersona() {
        return persona;
    }

    /**
     * Metodo enviar persona
     *
     * @param persona
     */
    public void setPersona(PersonaModelo persona) {
        this.persona = persona;
    }

    /**
     * Metodo obtener proyecto
     *
     * @return Un ProyectoModelo correspondiente a proyecto
     */
    public ProyectoModelo getProyecto() {
        return proyecto;
    }

    /**
     * Metodo enviar proyecto
     *
     * @param proyecto
     */
    public void setProyecto(ProyectoModelo proyecto) {
        this.proyecto = proyecto;
    }
    
    
}
