package vista;

import controlador.ControladorPersona;
import controlador.ControladorProyecto;
import controlador.servicio.PersonaServicio;
import controlador.servicio.RolServicio;
import controlador.utilidades.UtilidadesControlador;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class CrearProyectosVista extends javax.swing.JFrame {

    /**
     * Creates new form CrearAdministrador
     */
    ControladorPersona controladorPersona = new ControladorPersona();
    ControladorProyecto controladorProyecto = new ControladorProyecto();
    PersonaServicio serPer = new PersonaServicio();
    RolServicio rolSer = new RolServicio();
    public CrearProyectosVista() {
        initComponents();
        this.setLocationRelativeTo(this);
        llenarJefesProyecto();
        cbxJefeProyecto.setSelectedItem(null);
    }

    public void llenarJefesProyecto() {
        UtilidadesControlador.cargarComboBoxDias(cbxJefeProyecto, controladorPersona.ObtenerPersonas());
    }

    public boolean camposVacios() {
        if (cbxJefeProyecto.getSelectedItem().equals(null) && dateChooserFechaInicio.getDate().equals(null) && dateChooserFechaEntrega.getDate().equals(null)) {
            return false;
        } else {
            return true;
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbxJefeProyecto = new javax.swing.JComboBox<>();
        dateChooserFechaEntrega = new com.toedter.calendar.JDateChooser();
        dateChooserFechaInicio = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        btnGuardarProyecto = new javax.swing.JButton();

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

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Crear proyecto.");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(30, 20, 390, 44);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(30, 100, 130, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Fecha inicio:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(30, 180, 130, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Fecha entrega:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(30, 220, 190, 30);

        cbxJefeProyecto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxJefeProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel2.add(cbxJefeProyecto);
        cbxJefeProyecto.setBounds(250, 140, 310, 30);
        jPanel2.add(dateChooserFechaEntrega);
        dateChooserFechaEntrega.setBounds(250, 220, 310, 30);
        jPanel2.add(dateChooserFechaInicio);
        dateChooserFechaInicio.setBounds(250, 180, 310, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Jefe proyecto:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(30, 140, 130, 30);
        jPanel2.add(jTextField1);
        jTextField1.setBounds(250, 100, 310, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 640, 280);

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

        btnGuardarProyecto.setBackground(new java.awt.Color(0, 153, 0));
        btnGuardarProyecto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGuardarProyecto.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarProyecto.setText("Guardar proyecto.");
        btnGuardarProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarProyectoActionPerformed(evt);
            }
        });
        jPanel5.add(btnGuardarProyecto);
        btnGuardarProyecto.setBounds(410, 50, 190, 30);

        jPanel1.add(jPanel5);
        jPanel5.setBounds(0, 280, 640, 110);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 640, 390);

        setSize(new java.awt.Dimension(658, 428));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarProyectoActionPerformed
        if (camposVacios()) {
            controladorProyecto.getProyecto().setEstado("activo");
            controladorProyecto.getProyecto().setExternal_id(UtilidadesControlador.generarId());
            controladorProyecto.getProyecto().setFechaFinal(dateChooserFechaEntrega.getDate());
            controladorProyecto.getProyecto().setFechaInicio(dateChooserFechaInicio.getDate());
            controladorProyecto.getProyecto().setId(UtilidadesControlador.generarId());
            controladorProyecto.getProyecto().setId_jefeProyecto(serPer.obtenerIdPersona(serPer.listarPersonas(), (String) cbxJefeProyecto.getSelectedItem(), "nombre"));
            controladorProyecto.getProyecto().setNombreProyecto(jTextField1.getText());
            controladorPersona.setPersona(serPer.buscarPersona(controladorProyecto.getProyecto().getId_jefeProyecto(),"id"));
            controladorPersona.getPersona().setId_rol(rolSer.obtenerIdRol(rolSer.listarRoles(),"Jefe de Proyecto","tipo"));
            boolean guardar = serPer.modificarPersona(controladorPersona.getPersona(),"id",serPer.listarPersonas());
            if (controladorProyecto.guardarProyecto() && guardar) {
                JOptionPane.showMessageDialog(null, "Se guardo el proyecto");
                AdministradorVista admin = new AdministradorVista();
                this.dispose();
                admin.setLocationRelativeTo(null);
                admin.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardo el proyecto");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Tienes campos vacios");
        }
    }//GEN-LAST:event_btnGuardarProyectoActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        GestionarProyectosVista gps = new GestionarProyectosVista();
        this.dispose();
        gps.setLocationRelativeTo(null);
        gps.setVisible(true);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(CrearProyectosVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearProyectosVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearProyectosVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearProyectosVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new CrearProyectosVista().setVisible(true);
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(CrearProyectosVista.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarProyecto;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbxJefeProyecto;
    private com.toedter.calendar.JDateChooser dateChooserFechaEntrega;
    private com.toedter.calendar.JDateChooser dateChooserFechaInicio;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
