package controlador;


import controlador.DAO.objetosDAO.RolDAO;
import controlador.listaSimple.ListaSimple;
import modelo.RolModelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author Patricio
 */
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
                rol.setRol(aux.getRol());
                break;
            }
        }
    }
}
