package controlador;

import controlador.DAO.AdaptadorDAO;
import controlador.DAO.InterfazDAO;
import controlador.DAO.objetosDAO.CuentaDAO;
import controlador.DAO.objetosDAO.PersonaDAO;
import controlador.DAO.objetosDAO.RolDAO;
import controlador.utilidades.UtilidadesControlador;
import javax.swing.JOptionPane;
import modelo.CuentaModelo;
import modelo.DepartamentoModelo;
import modelo.PersonaModelo;
import modelo.RolModelo;

public class ControladorPersona {

    PersonaModelo persona = new PersonaModelo();
    CuentaModelo cuenta = new CuentaModelo();
    RolModelo rol = new RolModelo();

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

    public PersonaModelo getPersona() {
        if (persona == null) {
            persona = new PersonaModelo();
        }
        return persona;
    }

    public void setPersona(PersonaModelo persona) {
        this.persona = persona;
    }

    /**
     * Metodo para clonar el objeto empleado que se enviara al guardar
     *
     * @return
     */
    public PersonaModelo clonarEmpleado() {
        PersonaModelo aux = new PersonaModelo();
        aux.setCedula(persona.getCedula());
        aux.setCorreo(persona.getCorreo());
        aux.setExternal_id(UtilidadesControlador.generarId());
        persona.setExternal_id(aux.getExternal_id());
        aux.setId(UtilidadesControlador.generarId());
        persona.setId(aux.getId());
        aux.setId_rol(UtilidadesControlador.generarId());
        persona.setId_rol(aux.getId_rol());
        aux.setId_cuenta(UtilidadesControlador.generarId());
        persona.setId_cuenta(aux.getId());
        aux.setNombre(persona.getNombre());
        aux.setPath(persona.getPath());
        aux.setTelefono(persona.getTelefono());
        return aux;
    }

    /**
     * Metodo para guardar el empleado escribiendo en el json
     *
     * @return Retorna si se guardo el empeado
     */
    public boolean guardarEmpleado() {
        boolean bandera;
        try {
            PersonaDAO ad = new PersonaDAO();
            ad.setPersona(clonarEmpleado());
            CuentaDAO adc = new CuentaDAO();
            adc.setCuenta(obtenerCuenta());
            RolDAO adr = new RolDAO();
            adr.setRol(obtenerRol());
            bandera = ad.guardarPersona();
            System.out.println("bandera 1" + bandera);;
            bandera = adc.guardarCuenta();
            System.out.println("bandera 2" + bandera);
            bandera = adr.guardarRol();
            System.out.println("bandera 3" + bandera);
            return bandera;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Metodo para obtener el modelo cuenta del respectivo empleado
     *
     * @return Un onjeto CuentaModelo correspndiente a este empleado
     */
    public CuentaModelo obtenerCuenta() {
        CuentaModelo aux = new CuentaModelo();
        aux.setId(persona.getId_cuenta());
        aux.setUsuario(cuenta.getUsuario());
        aux.setClave(cuenta.getClave());
        aux.setExternal_id(persona.getExternal_id());
        return aux;
    }

    /**
     * Metodo para obtener el modelo rol del respectivo empleado
     *
     * @return Un objeto RolModelo correspondiente al empleado
     */
    public RolModelo obtenerRol() {
        RolModelo aux = new RolModelo();
        aux.setExternal_id(persona.getExternal_id());
        aux.setId(persona.getId());
        aux.setRol(rol.getRol());
        return aux;
    }
}
