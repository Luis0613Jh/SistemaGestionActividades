/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.tabla;

import controlador.listaSimple.ListaSimple;
import controlador.servicio.PersonaServicio;
import javax.swing.table.AbstractTableModel;
import modelo.DepartamentoModelo;
import modelo.PersonaModelo;

/**
 * 
 * @author Patricio
 */
public class tabla_Departamento extends AbstractTableModel{
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
        DepartamentoModelo departamento = (DepartamentoModelo)lista.buscarPorPosicion(i);
        if(departamento == null) {
              return "vacio";              
        } 
        switch(i1){
            case 0 : return departamento.getNombreDepartamento();
            case 1 : PersonaServicio s = new PersonaServicio();                    
                     return ((PersonaModelo)s.buscarPersona(departamento.getId_Encargado(),"id")).getNombre();
            case 2 : return departamento.getDescripcion();
            default: return null;
        }
    }
    @Override
    public String getColumnName(int titulo) {
        switch (titulo) {
            case 0 : return "Nombre Departamento";
            case 1 : return "Nombre de encargado";
            case 2 : return "Descripcion";
            default:
                return null;
        }
    }
}
