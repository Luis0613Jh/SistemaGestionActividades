/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.tabla;

import controlador.listaSimple.ListaSimple;
import javax.swing.table.AbstractTableModel;
import modelo.HitoModelo;

/**
 * 
 * @author Patricio
 */
public class tabla_hitos extends AbstractTableModel{
ListaSimple lista = new ListaSimple();
    
    public ListaSimple getLista() {
        return lista;
    }

    public void setLista(ListaSimple lista) {
        this.lista = lista;
    }
    @Override
    public int getColumnCount(){
        return 5;
    }
    @Override
    public int getRowCount(){
        return lista.tamanio();
    }

    @Override
    public Object getValueAt(int i, int i1) {        
        HitoModelo actividad = (HitoModelo)lista.buscarPorPosicion(i);
        if(actividad == null) {
              return "vacio";              
        } 
        switch(i1){
            case 0 : return actividad.getNombre();
            case 1 : return actividad.getFechaInicio().toString();
            case 2 : return actividad.getPrioridad();
            case 3 : return actividad.getDecripcion();
            case 4 : return actividad.getEstado();
            default: return null;
        }
    }
    @Override
    public String getColumnName(int titulo) {
        switch (titulo) {
            case 0 : return "Nombre del hito";
            case 1 : return "Fecha de inicio";
            case 2 : return "Prioridad";
            case 3 : return "Descripcion";
            case 4 : return "Estado";
            default:
                return null;
        }
    }
}
