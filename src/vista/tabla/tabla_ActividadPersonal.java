/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.tabla;

import controlador.listaSimple.ListaSimple;
import controlador.servicio.DepartamentoServicio;
import javax.swing.table.AbstractTableModel;
import modelo.ActividadModelo;
import modelo.ActividadPersonalModelo;

/**
 * 
 * @author Patricio
 */
public class tabla_ActividadPersonal extends AbstractTableModel{
    ListaSimple lista = new ListaSimple();
    
    public ListaSimple getLista() {
        return lista;
    }

    public void setLista(ListaSimple lista) {
        this.lista = lista;
    }
    @Override
    public int getColumnCount(){
        return 4;
    }
    @Override
    public int getRowCount(){
        return lista.tamanio();
    }

    @Override
    public Object getValueAt(int i, int i1) {        
        ActividadPersonalModelo actividad = (ActividadPersonalModelo)lista.buscarPorPosicion(i);
        DepartamentoServicio servicioDepartamento = new DepartamentoServicio();
        if(actividad == null) {
              return "vacio";              
        } 
        switch(i1){
            case 0 : return actividad.getNombre();
            case 1 : return actividad.getHora();
            case 2 : return actividad.getFechaEntrega().toString();
            case 3 : return actividad.getDescripcion();
            default: return null;
        }
    }
    @Override
    public String getColumnName(int titulo) {
        switch (titulo) {
            case 0 : return "Nombre actividad personal";
            case 1 : return "Hora";
            case 2 : return "Fecha entrega";
            case 3 : return "Descripcion";
            default:
                return null;
        }
    }
}
