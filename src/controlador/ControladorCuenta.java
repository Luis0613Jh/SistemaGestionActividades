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
    /**
     * Metodo para obtener la cuenta de la clase
     * @return un objeto de tipo CuentaModelo
     */
    public CuentaModelo getCuenta() {
        return cuenta;
    }
    /**
     * Metodo para enviar la cuenta
     * @param cuenta un objeto de tipo CuentaModelo
     */
    public void setCuenta(CuentaModelo cuenta) {
        this.cuenta = cuenta;
    }
    /**
     * Metodo para guardar cuenta por id
     * @param id  atributo de tipo int
     */
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
//    public void obtenerIdDeTipo(String tipo){
//        CuentaDAO c = new CuentaDAO();
//        ListaSimple lista = c.listarObjetos();
//        for(int i = 0; i < lista.tamanio() ; i++){
//            CuentaModelo aux = (CuentaModelo)lista.buscarPorPosicion(i);
//            if(aux.g){
//                
//            }
//        }
//    }
}
