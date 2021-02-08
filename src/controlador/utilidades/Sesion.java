
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

    public PersonaModelo getPersona() {
        return persona;
    }

    public void setPersona(PersonaModelo persona) {
        this.persona = persona;
    }

    public RolModelo getRol() {
        return rol;
    }

    public void setRol(RolModelo rol) {
        this.rol = rol;
    }

    public CuentaModelo getCuenta() {
        return cuenta;
    }

    public void setCuenta(CuentaModelo cuenta) {
        this.cuenta = cuenta;
    }
    
    public void obtenerDatos () {
        persona = new PersonaServicio().buscarPersona(cuenta.getId(), PersonaServicio.ID_CUENTA);
        rol = new RolServicio().buscarRol(persona.getId_rol(), RolServicio.IDENTIFICADOR);
    }
    
}
