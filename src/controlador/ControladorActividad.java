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
    /**
     * Metodo para obtener la ActividadModelo de la clase
     * @return un objeto de tipo ActividadModelo de la clase
     */
    public ActividadModelo getActividad() {
        if(actividad == null){
            actividad = new ActividadModelo();
        }
        return actividad;
    }
    /**
     * Metodo para enviar una ActividadModelo a la clase
     * @param actividad un objeto de tipo ActividadModelo
     */
    public void setActividad(ActividadModelo actividad) {
        this.actividad = actividad;
    }
    /**
     * Metodo para guardar actividad
     * @return un true en caso de que se guardo correctamente en caso contrario false
     */
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
