
package controlador.utilidades;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class UtilidadesVistas {
    
    /**
     * Método que permite cargar una imágen en un JLabel a paratir de una ruta path.
     * @param path Ruta donde se encuentra la imágen a cargar.
     * @param jLabel1 Componente donde se va a cargar la imágen, es de tipo JLabel
     */
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
