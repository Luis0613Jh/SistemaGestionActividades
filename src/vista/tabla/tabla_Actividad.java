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

/**
 * 
 * @author Patricio
 */
public class tabla_Actividad extends AbstractTableModel{
    ListaSimple lista = new ListaSimple();
    
    public ListaSimple getLista() {
        return lista;
    }

    public void setLista(ListaSimple lista) {
        this.lista = lista;
    }
    @Override
    public int getColumnCount(){
        return 7;
    }
    @Override
    public int getRowCount(){
        return lista.tamanio();
    }

    @Override
    public Object getValueAt(int i, int i1) {        
        ActividadModelo actividad = (ActividadModelo)lista.buscarPorPosicion(i);
        DepartamentoServicio servicioDepartamento = new DepartamentoServicio();
        if(actividad == null) {
              return "vacio";              
        } 
        switch(i1){
            case 0 : return servicioDepartamento.buscarDepartamento(actividad.getDepartamento_id(),"id").getNombreDepartamento();
            case 1 : return actividad.getNombre();
            case 2 : return actividad.getPrioridad();
            case 3 : return actividad.getFechaInicio().toString();
            case 4 : return actividad.getFechaEntrega().toString();
            case 5 : return actividad.getPrioridad();
            case 6 : return actividad.getDescripcion();
            default: return null;
        }
    }
    @Override
    public String getColumnName(int titulo) {
        switch (titulo) {
            case 0 : return "Nombre Departamento";
            case 1 : return "Nombre Actividad";
            case 2 : return "Prioridad";
            case 3 : return "Fecha de inicio";
            case 4 : return "Fecha limite";
            case 5 : return "Prioridad";
            case 6 : return "Descripcion";
            default:
                return null;
        }
    }
}
