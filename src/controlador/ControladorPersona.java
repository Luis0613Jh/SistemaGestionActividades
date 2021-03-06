package controlador;

import controlador.DAO.objetosDAO.CuentaDAO;
import controlador.DAO.objetosDAO.PersonaDAO;
import controlador.DAO.objetosDAO.RolDAO;
import controlador.listaSimple.ListaSimple;
import controlador.servicio.RolServicio;
import controlador.utilidades.UtilidadesControlador;
import modelo.CuentaModelo;
import modelo.PersonaModelo;
import modelo.RolModelo;

public class ControladorPersona {

    PersonaModelo persona = new PersonaModelo();
    CuentaModelo cuenta = new CuentaModelo();
    RolModelo rol = new RolModelo();

    /**
     * Metodo obtener rol
     *
     * @return Un RolModelo correspondiente a rol
     */
    public RolModelo getRol() {
        return rol;
    }

    /**
     * Metodo enviar rol
     *
     * @param rol
     */
    public void setRol(RolModelo rol) {
        this.rol = rol;
    }

    /**
     * Metodo obtener cuenta
     *
     * @return Un CuentaModelo correspondiente a cuenta
     */
    public CuentaModelo getCuenta() {
        return cuenta;
    }

    /**
     * Metodo enviar cuenta
     *
     * @param cuenta recibe un objeto de tipo CuentaModelo
     */
    public void setCuenta(CuentaModelo cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * Metodo obtener persona
     *
     * @return Un PersonaModelo correspondiente a persona
     */
    public PersonaModelo getPersona() {
        if (persona == null) {
            persona = new PersonaModelo();
        }
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
     * Metodo para guardar el empleado escribiendo en el json
     *
     * @return Retorna si se guardo el empeado
     */
    public boolean guardarEmpleado() {
        boolean bandera;
        try {
            PersonaDAO ad = new PersonaDAO();
            ad.setPersona(persona);
            CuentaDAO adc = new CuentaDAO();
            adc.setCuenta(cuenta);
            bandera = ad.guardarPersona();
            System.out.println("bandera 1" + bandera);
            bandera = adc.guardarCuenta();
            System.out.println("bandera 2" + bandera);
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
        aux.setEstado(cuenta.getEstado());
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
        aux.setTipo(rol.getTipo());
        return aux;
    }
    /**
     * Metodo retorna en numero de empleados
     * @return 
     */
    public int numeroEmpleados() {
        PersonaDAO ad = new PersonaDAO();
        ListaSimple lista = ad.listarObjetos();
        if(lista == null){
            return 0;
        }else{
            int numero = lista.tamanio();
            return numero;
        }                
    }
    /**
     * Metodo que retorna un arreglo con el tipo de rol existente
     * @return  arreglo con los roles
     */
    public String[] ObtenerRoles() {
        RolDAO r = new RolDAO();
        ListaSimple rol = r.listarObjetos();
        String[] roles = new String[rol.tamanio()];
        for (int i = 0; i < rol.tamanio(); i++) {
            RolModelo aux = (RolModelo)rol.buscarPorPosicion(i);
            roles[i] = aux.getTipo();
        }
        return roles;
    }
    /**
     * Metodo para obtener el id
     * @param i recibe la posicion
     * @return retorna el RolModelo de la posicion solicitada
     */
    public int obtenerID(int i) {
        RolDAO r = new RolDAO();
        ListaSimple rol = r.listarObjetos();

        return ((RolModelo) rol.buscarPorPosicion(i)).getId();
    }
    /**
     * Metodo para obtener la lista de cuentas
     * @return la lista de cuentas
     */
    public ListaSimple obtenerListaCuentas() {
        CuentaDAO adc = new CuentaDAO();
        return adc.listarObjetos();
    }
    /**
     * Metodo para obtener la lista de empleados
     * @return lista empleados
     */
    public ListaSimple obtenerListaEmpleados() {
        PersonaDAO ad = new PersonaDAO();
        return ad.listarObjetos();
    }
    /**
     * Metodo validar Usuario y clave
     * @return true en caso se encuentra parametros en a lista caso contrario false
     */
    public boolean validarUsuarioClave() {
        CuentaModelo aux = (CuentaModelo) UtilidadesControlador.buscarObjetoPorBusquedaBinariaPorDato(cuenta, "id", obtenerListaCuentas());
        if (aux != null) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Metodo obtener personas
     * @return array de personas
     */    
    public String[] ObtenerPersonas() {
        PersonaDAO r = new PersonaDAO();
        RolServicio serRol = new RolServicio();
        ListaSimple rol = r.listarPersonasActivas(r.listarCoincidencias(r.listarObjetos(),serRol.obtenerIdRol(serRol.listarRoles(),"Personal","tipo"), "id_rol"));
        String[] roles = new String[rol.tamanio()];
        for (int i = 0; i < rol.tamanio(); i++) {
            PersonaModelo aux = (PersonaModelo)rol.buscarPorPosicion(i);
            roles[i] = aux.getNombre();
        }
        return roles;
    }
   
}
