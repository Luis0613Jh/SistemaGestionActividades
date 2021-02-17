package controlador;


import controlador.DAO.objetosDAO.RolDAO;
import controlador.listaSimple.ListaSimple;
import modelo.RolModelo;

public class ControladorRol {
    private RolModelo rol = new RolModelo();
    /**
     * Metodo obtener el rol
     * @return el RolModelo de la clase
     */
    public RolModelo getRol() {
        if(rol == null){
            rol = new RolModelo(); 
        }
        return rol;
    }
    /**
     * Metodo para enviar un RolModelo
     * @param rol un objeto de tio RolModelo
     */
    public void setRol(RolModelo rol) {
        this.rol = rol;
    }
    /**
     * Metodo para llenar  RolModelo de la clase por id
     * @param id un atributo de tipo int
     */
    public void obtenerRolPorId(int id){
        RolDAO leer = new RolDAO();
        ListaSimple temp = leer.listarObjetos();
        for(int i = 0 ; i < temp.tamanio() ; i++){
            RolModelo aux = (RolModelo)temp.buscarPorPosicion(i);
            if(aux.getId() == id){
                rol.setExternal_id(aux.getExternal_id());
                rol.setId(aux.getId());
                rol.setTipo(aux.getTipo());
                break;
            }
        }
    }
    /**
     * Metodo para obtenr un RolModelo por id
     * @param id un atributo de tipo int
     * @return Retorna un objeto de tipo RolModelo
     */
    public RolModelo obtenerRolPor_Id(int id){
        RolDAO leer = new RolDAO();
        ListaSimple temp = leer.listarObjetos();
        for(int i = 0 ; i < temp.tamanio() ; i++){
            RolModelo aux = (RolModelo)temp.buscarPorPosicion(i);
            if(aux.getId() == id){
                return aux;
            }
        }
        return null;
    }
    
}
