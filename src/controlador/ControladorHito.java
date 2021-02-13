/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import controlador.servicio.HitoServicio;
import modelo.HitoModelo;

/**
 * 
 * @author Patricio
 */
public class ControladorHito {
    private HitoModelo hito = new HitoModelo();
    /**
     * Metodo para obtener un hito
     * @return un objeto de tipo HitoModelo
     */
    public HitoModelo getHito() {
        if(hito == null){
            hito = new HitoModelo();
        }
        return hito;
    }
    /**
     * Metodo para enviar un Hito a la clase
     * @param hito parametro de tipo HitoModelo
     */
    public void setHito(HitoModelo hito) {
        this.hito = hito;
    }
    /**
     * Metodo para guardar el hito
     * @return un true en caso de guardarse correctamente y false de lo contrario
     */
    public boolean guardarHito(){
        try {
            HitoServicio  guardar = new HitoServicio();
            guardar.setHito(hito);
            return guardar.guardarHito();
        } catch (Exception e) {
            return false;
        }
    }
    public int numeroHitos(){
        HitoServicio  guardar = new HitoServicio();
        return guardar.listarHitos().tamanio();
    }
}
