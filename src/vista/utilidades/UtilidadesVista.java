
package vista.utilidades;

import controlador.listaSimple.ListaSimple;
import javax.swing.JComboBox;

public class UtilidadesVista {
    
    public void cargarCbx(ListaSimple lista, JComboBox cbx) {
        cbx.removeAllItems();               
        for(int i = 0 ; i < lista.tamanio() ; i++){
            cbx.addItem(lista.buscarPorPosicion(i));
        }
    }
}
