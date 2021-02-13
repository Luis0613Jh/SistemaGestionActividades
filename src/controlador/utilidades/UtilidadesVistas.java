/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.utilidades;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author Patricio
 */
public class UtilidadesVistas {
    public static void cargarImagen(String path , JLabel jLabel1) {
        if (path != null) {
            ImageIcon foto = new ImageIcon(path);
            Icon fondo1 = new ImageIcon(foto.getImage().getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_DEFAULT));
            jLabel1.setIcon(fondo1);
        } else {
            jLabel1.setText("Empleado sin \n foto cargada");
        }
    }
}
