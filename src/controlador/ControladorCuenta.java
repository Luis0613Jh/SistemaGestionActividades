/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import controlador.DAO.objetosDAO.CuentaDAO;
import controlador.DAO.objetosDAO.RolDAO;
import controlador.listaSimple.ListaSimple;
import modelo.CuentaModelo;
import modelo.RolModelo;

/**
 * 
 * @author Patricio
 */
public class ControladorCuenta {
    CuentaModelo cuenta = new CuentaModelo();

    public CuentaModelo getCuenta() {
        return cuenta;
    }

    public void setCuenta(CuentaModelo cuenta) {
        this.cuenta = cuenta;
    }
    
    public void obtenerCuentaPorId(int id){
        CuentaDAO leer = new CuentaDAO();
        ListaSimple temp = leer.listarObjetos();
        for(int i = 0 ; i < temp.tamanio() ; i++){
           CuentaModelo aux = (CuentaModelo)temp.buscarPorPosicion(i);
            if(aux.getId() == id){
                cuenta.setId(aux.getId());
                cuenta.setUsuario(aux.getUsuario());
                cuenta.setClave(aux.getClave());
                cuenta.setExternal_id(aux.getExternal_id());
                break;
            }
        }
    }
}
