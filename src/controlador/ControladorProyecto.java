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
    /**
     * Metodo para obtener el ProyectoModelo
     * @return el proyectoModelo de la clase
     */
    public ProyectoModelo getProyecto() {
        if(proyecto == null){
            proyecto = new ProyectoModelo();
        }
        return proyecto;
    }
    /**
     * Metodo para enviar un ProyectoModelo a la clase
     * @param proyecto un objeto de tipo ProyectoModelo
     */
    public void setProyecto(ProyectoModelo proyecto) {
        this.proyecto = proyecto;
    }
    /**
     * Metodo para guardar el proyecto
     * @return true en caso de guardar exitosamente false de lo contrario
     */
    public boolean guardarProyecto(){
        try {
            ProyectoServicio controlador = new ProyectoServicio();
            controlador.setProyecto(proyecto);
            return controlador.guardarProyecto();
        } catch (Exception e) {
            return false;
        }
    }
    
    public int numeroProyectos(){
        ProyectoServicio controlador = new ProyectoServicio();
        return controlador.listarProyectos().tamanio();
    }
}
