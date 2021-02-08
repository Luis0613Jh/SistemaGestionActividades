/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import controlador.servicio.ProyectoServicio;
import modelo.ProyectoModelo;

/**
 * 
 * @author Patricio
 */
public class ControladorProyecto {
    ProyectoModelo proyecto = new ProyectoModelo();

    public ProyectoModelo getProyecto() {
        if(proyecto == null){
            proyecto = new ProyectoModelo();
        }
        return proyecto;
    }

    public void setProyecto(ProyectoModelo proyecto) {
        this.proyecto = proyecto;
    }
    public boolean guardarProyecto(){
        try {
            ProyectoServicio controlador = new ProyectoServicio();
            controlador.setProyecto(proyecto);
            return controlador.guardarProyecto();
        } catch (Exception e) {
            return false;
        }
    }
}
