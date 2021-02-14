/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.tabla;

import controlador.listaSimple.ListaSimple;
import java.util.Date;
import javax.swing.table.AbstractTableModel;
import modelo.PersonaModelo;
import modelo.ProyectoModelo;

/**
 * 
 * @author Patricio
 */
public class tabla_Proyectos extends AbstractTableModel{
    ListaSimple lista = new ListaSimple();
    
    public ListaSimple getLista() {
        return lista;
    }

    public void setLista(ListaSimple lista) {
        this.lista = lista;
    }
    @Override
    public int getColumnCount(){
        return 3;
    }
    @Override
    public int getRowCount(){
        return lista.tamanio();
    }

    @Override
    public Object getValueAt(int i, int i1) {        
        ProyectoModelo proyecto = (ProyectoModelo)lista.buscarPorPosicion(i);
        if(proyecto == null) {
              return "vacio";              
        } 
        switch(i1){
            case 0 : return (String)proyecto.getNombreProyecto();
            case 1 : return (String)proyecto.getFechaInicio().toString();
            case 2 : return (String)proyecto.getFechaFinal().toString();
            
            default: return null;
        }
    }
    @Override
    public String getColumnName(int titulo) {
        switch (titulo) {
            case 0:
                return "nombreProyecto";
            case 1:
                return "fechaInicio";
            case 2:
                return "fechaFinal";            
            default:
                return null;
        }
    }
//    private int id;
//    private int id_jefeProyecto;
//    private String nombreProyecto;
//    private Date fechaInicio;
//    private Date fechaFinal;
//    private int external_id;
//    private String codigo;
//    private String estado;
}
