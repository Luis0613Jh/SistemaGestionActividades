/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.tabla;

import controlador.listaSimple.ListaSimple;
import javax.swing.table.AbstractTableModel;
import modelo.PersonaModelo;

/**
 * 
 * @author Patricio
 */
public class tabla_GestionarEmpleado extends AbstractTableModel{
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
        PersonaModelo empleado = (PersonaModelo)lista.buscarPorPosicion(i);
        if(empleado == null) {
              return "vacio";              
        } 
        switch(i1){
            case 0 : return (String)empleado.getCedula();
            case 1 : return (String)empleado.getNombre();
            case 2 : return (String)empleado.getTelefono();
            case 3 : return (String)empleado.getCorreo(); 
            default: return null;
        }
    }
    @Override
    public String getColumnName(int titulo) {
        switch (titulo) {
            case 0:
                return "Cedula";
            case 1:
                return "Nombre";
            case 2:
                return "Telefono";
            case 3:
                return "Correo";
            default:
                return null;
        }
    }
}
