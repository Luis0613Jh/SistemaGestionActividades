/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import controlador.listaSimple.ListaSimple;
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
        ListaSimple lista = controlador.listarProyectos();
        if(lista == null){
            return 0;
        }else{
            return lista.tamanio();
        }
    }
    public ListaSimple proyectosJefeproyecto(int jefeProyecto){
        ListaSimple salida = new ListaSimple();
        ProyectoServicio aux = new ProyectoServicio();
        ListaSimple entrada = aux.listarProyectos();
        for(int i = 0 ; i < entrada.tamanio() ; i++){
            ProyectoModelo x = (ProyectoModelo)entrada.buscarPorPosicion(i);
            if(x.getId_jefeProyecto() == jefeProyecto && x.getEstado().equals("activo")){
                salida.insertarFinal(x);
            }
        }
        return salida;
    }
}
