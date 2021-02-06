/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import controlador.servicio.ActividadServicio;
import modelo.ActividadModelo;

/**
 * 
 * @author Patricio
 */
public class ControladorActividad {
    private ActividadModelo actividad = new ActividadModelo();

    public ActividadModelo getActividad() {
        if(actividad == null){
            actividad = new ActividadModelo();
        }
        return actividad;
    }

    public void setActividad(ActividadModelo actividad) {
        this.actividad = actividad;
    }
    public boolean guardarActividad(){
        try {
            ActividadServicio guardar = new ActividadServicio();
            guardar.setActividad(actividad);
            return guardar.guardarActividad();
        } catch (Exception e) {
            return false;
        }
    }
    
}
