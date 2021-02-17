
package controlador.utilidades;

import controlador.servicio.PersonaServicio;
import controlador.servicio.RolServicio;
import modelo.CuentaModelo;
import modelo.PersonaModelo;
import modelo.RolModelo;

public class Sesion {
    
    private PersonaModelo persona;
    private RolModelo rol;
    private CuentaModelo cuenta;

    /**
     * Método que permite obtener el objeto de tipo PersonaModelo almacenado en
     * la clase.
     *
     * @return Retorna el objeto de tipo PersonaModelo instanciado en la clase,
     * en caso de que no exista, se crea un nuevo objeto PersonaModelo.
     */
    public PersonaModelo getPersona() {
        return persona;
    }

    /**
     * Método que permite sobreescribir el objeto de tipo PersonaModelo
     * instanciado en la clase.
     *
     * @param persona Objeto de tipo PersonaModelo que se va a sobreescribir en
     * el objeto instanciado en la clase.
     */
    public void setPersona(PersonaModelo persona) {
        this.persona = persona;
    }

    /**
     * Método que permite obtener el objeto de tipo RolModelo almacenado en la clase. 
     * @return Retorna el objeto de tipo RolModelo instanciado en la clase, en caso de que no exista, se crea un nuevo objeto RolModelo.
     */
    public RolModelo getRol() {
        return rol;
    }

    /**
     * Método que permite sobreescribir el objeto de tipo RolModelo instanciado en la clase.
     * @param rol Objeto de tipo RolModelo que se va a sobreescribir en el objeto instanciado en la clase.
     */
    public void setRol(RolModelo rol) {
        this.rol = rol;
    }

    /**
     * Método que permite obtener el objeto de tipo CuentaModelo almacenado en
     * la clase.
     *
     * @return Retorna el objeto de tipo CuentaModelo instanciado en la clase,
     * en caso de que no exista, se crea un nuevo objeto CuentaModelo.
     */
    public CuentaModelo getCuenta() {
        return cuenta;
    }

    /**
     * Método que permite sobreescribir el objeto de tipo CuentaModelo
     * instanciado en la clase.
     *
     * @param cuenta Objeto de tipo CuentaModelo que se va a sobreescribir en
     * el objeto instanciado en la clase.
     */
    public void setCuenta(CuentaModelo cuenta) {
        this.cuenta = cuenta;
    }
    
    /**
     * Método que permite obtener los datos correspondientes a la cuenta almacenada en la clase.
     */
    public void obtenerDatos () {
        persona = new PersonaServicio().buscarPersona(cuenta.getId(), PersonaServicio.ID_CUENTA);
        rol = new RolServicio().buscarRol(persona.getId_rol(), RolServicio.IDENTIFICADOR);
    }
    
}
