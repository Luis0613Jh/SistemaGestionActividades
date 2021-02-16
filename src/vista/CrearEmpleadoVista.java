/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorPersona;
import controlador.servicio.RolServicio;
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

/**
 *
 * @author juana
 */
public class CrearEmpleadoVista extends javax.swing.JFrame {

    /**
     * Creates new form CrearAdministrador
     */
    private ControladorPersona controladorEmp = new ControladorPersona();
    private RolServicio serRol = new RolServicio();
    private ControladorPersona temp ;
    public CrearEmpleadoVista() {
        initComponents();
        this.setLocationRelativeTo(this);
        ImageIcon imagenLoginUsuario = new ImageIcon(getClass().getResource("/imagenes/insertarFoto.png"));
        Icon fondoImagen = new ImageIcon(imagenLoginUsuario.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT));
        lblFoto.setIcon(fondoImagen);
        //UtilidadesControlador.cargarComboBoxDias(jComboBox1, controladorEmp.ObtenerRoles());
    }
    public CrearEmpleadoVista(ControladorPersona temp) {
        initComponents();
        this.setLocationRelativeTo(this);
        ImageIcon imagenLoginUsuario = new ImageIcon(getClass().getResource("/imagenes/insertarFoto.png"));
        Icon fondoImagen = new ImageIcon(imagenLoginUsuario.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT));
        lblFoto.setIcon(fondoImagen);
        
    }


    /**
     * Metodo para saber si hay campos vacios
     *
     * @return Un boolean correspondiente a si esta vacia
     */
    public boolean vacios() {
        if (txtCedulaPersonal.getText().length() > 0 && txtContraseniaPersonal.getText().length() > 0 && txtCorreoElectronicoPersonal.getText().length() > 0 && txtNombrePersonal.getText().length() > 0 && txtTelefonoPersonal.getText().length() > 0 && txtUsuarioPersonal.getText().length() > 0) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Tiene campos vacios");
            return false;
        }
    }

    public void limpiar() {
        txtCedulaPersonal.setText(null);
        txtContraseniaPersonal.setText(null);
        txtCorreoElectronicoPersonal.setText(null);
        txtNombrePersonal.setText(null);
        txtTelefonoPersonal.setText(null);
        txtUsuarioPersonal.setText(null);
        lblFoto.setDisabledIcon(null);
        ImageIcon imagenLoginUsuario = new ImageIcon(getClass().getResource("/imagenes/insertarFoto.png"));
        Icon fondoImagen = new ImageIcon(imagenLoginUsuario.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT));
        lblFoto.setIcon(fondoImagen);
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
        txtNombrePersonal = new javax.swing.JTextField();
        txtCedulaPersonal = new javax.swing.JTextField();
        txtCorreoElectronicoPersonal = new javax.swing.JTextField();
        txtUsuarioPersonal = new javax.swing.JTextField();
        lblFoto = new javax.swing.JLabel();
        btnElegirFoto = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtTelefonoPersonal = new javax.swing.JTextField();
        txtContraseniaPersonal = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();

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
        jLabel2.setText("Ingrese sus datos:");
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
        jLabel6.setText("Rol");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(30, 300, 130, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Usuario:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(30, 340, 130, 30);

        txtNombrePersonal.setBorder(null);
        jPanel2.add(txtNombrePersonal);
        txtNombrePersonal.setBounds(250, 140, 310, 30);

        txtCedulaPersonal.setBorder(null);
        jPanel2.add(txtCedulaPersonal);
        txtCedulaPersonal.setBounds(250, 180, 310, 30);

        txtCorreoElectronicoPersonal.setBorder(null);
        jPanel2.add(txtCorreoElectronicoPersonal);
        txtCorreoElectronicoPersonal.setBounds(250, 220, 310, 30);

        txtUsuarioPersonal.setBorder(null);
        jPanel2.add(txtUsuarioPersonal);
        txtUsuarioPersonal.setBounds(250, 340, 310, 30);

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
        btnElegirFoto.setBounds(640, 320, 230, 23);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Teléfono:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(30, 260, 130, 30);

        txtTelefonoPersonal.setBorder(null);
        jPanel2.add(txtTelefonoPersonal);
        txtTelefonoPersonal.setBounds(250, 260, 310, 30);
        jPanel2.add(txtContraseniaPersonal);
        txtContraseniaPersonal.setBounds(250, 380, 310, 30);

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setText("Personal");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(250, 310, 100, 24);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 930, 460);

        jPanel5.setBackground(new java.awt.Color(0, 112, 192));
        jPanel5.setLayout(null);

        btnSalir.setBackground(new java.awt.Color(255, 0, 0));
        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Salir.");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel5.add(btnSalir);
        btnSalir.setBounds(30, 50, 70, 29);

        btnRegistrar.setBackground(new java.awt.Color(0, 153, 0));
        btnRegistrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Registrar.");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel5.add(btnRegistrar);
        btnRegistrar.setBounds(760, 50, 140, 30);

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
            controladorEmp.getPersona().setPath_imagen(fc.getSelectedFile().toString());
        }
    }//GEN-LAST:event_btnElegirFotoActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (vacios()) {
            controladorEmp.getPersona().setCedula(txtCedulaPersonal.getText());
            controladorEmp.getPersona().setNombre(txtNombrePersonal.getText());
            controladorEmp.getPersona().setId(controladorEmp.numeroEmpleados()+1);
            controladorEmp.getPersona().setId_cuenta(controladorEmp.numeroEmpleados()+1);
            controladorEmp.getPersona().setCorreo(txtCorreoElectronicoPersonal.getText());
            controladorEmp.getPersona().setTelefono(txtTelefonoPersonal.getText());
            controladorEmp.getPersona().setId_rol(serRol.obtenerIdRol(serRol.listarRoles(),"Personal", "tipo"));
            controladorEmp.getPersona().setEstado("activo");
            controladorEmp.getPersona().setId_departamento(-3);                        
            controladorEmp.getCuenta().setUsuario(txtUsuarioPersonal.getText());
            controladorEmp.getCuenta().setClave(txtContraseniaPersonal.getText());
            controladorEmp.getCuenta().setEstado("activo");
            controladorEmp.getCuenta().setExternal_id(0);
            controladorEmp.getCuenta().setId(controladorEmp.getPersona().getId_cuenta());
            if (controladorEmp.guardarEmpleado()) {
                JOptionPane.showMessageDialog(null, "Se guardo correctamente");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "NO SE PUDO GUARDAR");
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        GestionarEmpleadosVista ge = new GestionarEmpleadosVista(temp);
        this.dispose();
        ge.setLocationRelativeTo(null);
        ge.setVisible(true);
    }//GEN-LAST:event_btnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(CrearEmpleadoVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearEmpleadoVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearEmpleadoVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearEmpleadoVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new CrearEmpleadoVista().setVisible(true);
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(CrearEmpleadoVista.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnElegirFoto;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JTextField txtCedulaPersonal;
    private javax.swing.JPasswordField txtContraseniaPersonal;
    private javax.swing.JTextField txtCorreoElectronicoPersonal;
    private javax.swing.JTextField txtNombrePersonal;
    private javax.swing.JTextField txtTelefonoPersonal;
    private javax.swing.JTextField txtUsuarioPersonal;
    // End of variables declaration//GEN-END:variables
}
