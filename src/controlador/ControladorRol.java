package controlador;


import controlador.DAO.objetosDAO.RolDAO;
import controlador.listaSimple.ListaSimple;
import modelo.RolModelo;

public class ControladorRol {
    private RolModelo rol = new RolModelo();

    public RolModelo getRol() {
        if(rol == null){
            rol = new RolModelo(); 
        }
        return rol;
    }

    public void setRol(RolModelo rol) {
        this.rol = rol;
    }
    
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
