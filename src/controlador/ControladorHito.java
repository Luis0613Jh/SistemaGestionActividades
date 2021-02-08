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

    public HitoModelo getHito() {
        if(hito == null){
            hito = new HitoModelo();
        }
        return hito;
    }

    public void setHito(HitoModelo hito) {
        this.hito = hito;
    }
    public boolean guardarHito(){
        try {
            HitoServicio  guardar = new HitoServicio();
            guardar.setHito(hito);
            return guardar.guardarHito();
        } catch (Exception e) {
            return false;
        }
    }
}
