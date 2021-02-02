package vista;

import controlador.ControladorCuenta;
import controlador.ControladorPersona;
import controlador.ControladorRol;
import controlador.servicio.CuentaServicio;
import controlador.servicio.PersonaServicio;
import controlador.utilidades.UtilidadesControlador;
import java.awt.Image;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class EditarEmpleadoVista extends javax.swing.JFrame {

    /**
     * Creates new form CrearAdministrador
     */
    ControladorPersona controlador;
    ControladorRol controladorRol = new ControladorRol();
    ControladorCuenta controladorCuenta = new ControladorCuenta();
    PersonaServicio perSer = new PersonaServicio();
    CuentaServicio cuentSer = new CuentaServicio();

    public EditarEmpleadoVista(ControladorPersona controlador) {
        initComponents();
        this.setLocationRelativeTo(this);
        this.controlador = controlador;
        llenarDatos();

    }

    private EditarEmpleadoVista() {

    }

    public void llenarDatos() {
        jTextField2.setText(controlador.getPersona().getNombre());
        jTextField3.setText(controlador.getPersona().getCedula());
        jTextField4.setText(controlador.getPersona().getCorreo());
        jTextField7.setText(controlador.getPersona().getTelefono());
        controladorRol.obtenerRolPorId(controlador.getPersona().getId_rol());
        jTextField5.setText(controladorRol.getRol().getTipo());
        controladorCuenta.obtenerCuentaPorId(controlador.getPersona().getId_cuenta());
        jTextField6.setText(controladorCuenta.getCuenta().getUsuario());
        jTextField1.setText(controladorCuenta.getCuenta().getClave());
        cargarImagen(controlador.getPersona().getPath_imagen());
    }

    public boolean camposEnBlanco() {
        if (jTextField1.getText().length() > 0 && jTextField2.getText().length() > 0 && jTextField3.getText().length() > 0 && jTextField4.getText().length() > 0 && jTextField5.getText().length() > 0 && jTextField6.getText().length() > 0 && jTextField7.getText().length() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void cargarImagen(String path) {
        if (path != null) {
            ImageIcon foto = new ImageIcon(path);
            Icon fondo1 = new ImageIcon(foto.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT));
            lblFoto.setIcon(fondo1);
        } else {
            lblFoto.setText("Empeado sin \n foto cargada");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        lblFoto = new javax.swing.JLabel();
        btnElegirFoto = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 112, 192));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Contraseña:");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(30, 380, 130, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Edite sus datos:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(30, 20, 390, 44);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(30, 140, 130, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cédula:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(30, 180, 130, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Correo electrónico:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(30, 220, 190, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Rol :");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(30, 300, 130, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Usuario:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(30, 340, 130, 30);

        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jTextField1);
        jTextField1.setBounds(250, 380, 310, 30);

        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jTextField2);
        jTextField2.setBounds(250, 140, 310, 30);

        jTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jTextField3);
        jTextField3.setBounds(250, 180, 310, 30);

        jTextField4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jTextField4);
        jTextField4.setBounds(250, 220, 310, 30);

        jTextField5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField5);
        jTextField5.setBounds(250, 300, 310, 30);

        jTextField6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jTextField6);
        jTextField6.setBounds(250, 340, 310, 30);

        lblFoto.setBackground(new java.awt.Color(255, 255, 255));
        lblFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.add(lblFoto);
        lblFoto.setBounds(640, 130, 230, 170);

        btnElegirFoto.setBackground(new java.awt.Color(0, 153, 0));
        btnElegirFoto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnElegirFoto.setForeground(new java.awt.Color(255, 255, 255));
        btnElegirFoto.setText("Elegir foto.");
        btnElegirFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElegirFotoActionPerformed(evt);
            }
        });
        jPanel2.add(btnElegirFoto);
        btnElegirFoto.setBounds(640, 320, 230, 33);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Teléfono:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(30, 260, 130, 30);

        jTextField7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jTextField7);
        jTextField7.setBounds(250, 260, 310, 30);

        jButton3.setText("Cambiar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(137, 300, 90, 32);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 930, 430);

        jPanel5.setBackground(new java.awt.Color(0, 112, 192));
        jPanel5.setLayout(null);

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Salir.");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1);
        jButton1.setBounds(30, 50, 70, 29);

        jButton2.setBackground(new java.awt.Color(0, 153, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton2);
        jButton2.setBounds(760, 50, 140, 30);

        jPanel1.add(jPanel5);
        jPanel5.setBounds(0, 430, 930, 110);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 930, 540);

        setSize(new java.awt.Dimension(944, 578));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnElegirFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElegirFotoActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Buscar foto o imagen");
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File archivo = new File(fc.getSelectedFile().toString());
            rsscalelabel.RSScaleLabel.setScaleLabel(lblFoto, fc.getSelectedFile().toString());
            controlador.getPersona().setPath_imagen(fc.getSelectedFile().toString());
        }
    }//GEN-LAST:event_btnElegirFotoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if (camposEnBlanco()) {
            controlador.getPersona().setCedula(jTextField3.getText());
            controlador.getPersona().setCorreo(jTextField4.getText());
            controlador.getPersona().setNombre(jTextField2.getText());
            controlador.getPersona().setTelefono(jTextField7.getText());
            controladorCuenta.obtenerCuentaPorId(controlador.getPersona().getId());
            controladorCuenta.getCuenta().setClave(jTextField1.getText());
            controladorCuenta.getCuenta().setUsuario(jTextField6.getText());
            //UtilidadesControlador.
            if (perSer.modificarPersona(controlador.getPersona(), "id", perSer.listarPersonas()) && cuentSer.modificarCuenta(controladorCuenta.getCuenta(),"id",cuentSer.listarCuentas())) {
                JOptionPane.showMessageDialog(null, "Se edito correctamente");
                dispose();
                AdministradorVista admin = new AdministradorVista();                
                admin.setLocationRelativeTo(null);
                admin.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo editar");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Tiene campos vacios");
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        GestionarEmpleadosVista ge = new GestionarEmpleadosVista();
        this.dispose();
        ge.setLocationRelativeTo(null);
        ge.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new Frm_CambioRol(this, true, controlador).setVisible(true);

    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditarEmpleadoVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarEmpleadoVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarEmpleadoVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarEmpleadoVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarEmpleadoVista().setVisible(true);
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(EditarEmpleadoVista.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnElegirFoto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JLabel lblFoto;
    // End of variables declaration//GEN-END:variables
}
