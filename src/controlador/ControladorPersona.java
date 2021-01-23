
package controlador;


import controlador.DAO.AdaptadorDAO;
import controlador.DAO.InterfazDAO;
import controlador.DAO.objetosDAO.PersonaDAO;
import javax.swing.JOptionPane;
import modelo.CuentaModelo;
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
        if(persona == null){
            persona = new PersonaModelo();
        }
        return persona;
    }

    public void setPersona(PersonaModelo persona) {
        this.persona = persona;
    }
    
    public PersonaModelo clonarEmpleado(){
        PersonaModelo aux = new PersonaModelo();
        aux.setCedula(persona.getCedula());
        aux.setCorreo(persona.getCorreo());
        aux.setExternal_id(355);
        aux.setId(252);
        aux.setId_rol(44484);
        aux.setId_cuenta(5545454);
        aux.setNombre(persona.getNombre());
        aux.setPath(persona.getPath());
        aux.setTelefono(persona.getTelefono());
        return aux;
    }
    public boolean guardarEmpleado(){
        try {
            //AdaptadorDAO ad = new AdaptadorDAO();
            //ad.guardarObjeto(clonarEmpleado());
            PersonaDAO ad = new PersonaDAO();
            ad.getPersona();
            ad.setPersona(clonarEmpleado());
            ad.guardarPersona();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en try de guardar empleado");
            return false;
        }
        
    }
}
