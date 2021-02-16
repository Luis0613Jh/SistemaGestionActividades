package vista;

import controlador.ControladorActividad;
import controlador.ControladorDepartamento;
import controlador.ControladorPersona;
import controlador.ControladorProyecto;
import controlador.servicio.DepartamentoServicio;
import controlador.utilidades.UtilidadesControlador;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class CrearActividadVista extends javax.swing.JFrame {

    /**
     * Creates new form CrearAdministrador
     */
    ControladorActividad controladorActividad = new ControladorActividad();
    ControladorDepartamento controladorDeapartamento = new ControladorDepartamento();
    DepartamentoServicio serDepa = new DepartamentoServicio();
    private ControladorProyecto controladorProyecto;
    ControladorPersona controlador;

    public CrearActividadVista() {
        initComponents();
        this.setLocationRelativeTo(this);
        llenarDepartamentos();
    }

    public CrearActividadVista(ControladorPersona controlador) {
        initComponents();
        this.controlador = controlador;
        this.setLocationRelativeTo(this);
        llenarDepartamentos();
    }

    public CrearActividadVista(ControladorPersona controlador, ControladorProyecto controladorProyecto) {
        initComponents();
        this.controlador = controlador;
        this.controladorProyecto = controladorProyecto;
        this.setLocationRelativeTo(this);
        llenarDepartamentos();
    }

    public void llenarDepartamentos() {
        UtilidadesControlador.cargarComboBoxDias(cbxDepartamento, controladorDeapartamento.departamentos());
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
        cbxPrioridad = new javax.swing.JComboBox<>();
        txtDescripcion = new javax.swing.JTextField();
        txtNombreActividad = new javax.swing.JTextField();
        dateChooserFechaInicio = new com.toedter.calendar.JDateChooser();
        dateChooserFechaEntrega = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbxDepartamento = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
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
        jLabel2.setText("Crear actividad.");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(30, 20, 400, 50);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre de la actividad:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(30, 100, 210, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Prioridad:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(30, 300, 130, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Descripción:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(30, 350, 190, 30);

        cbxPrioridad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Baja", "Media", "Alta" }));
        jPanel2.add(cbxPrioridad);
        cbxPrioridad.setBounds(250, 300, 310, 30);
        jPanel2.add(txtDescripcion);
        txtDescripcion.setBounds(250, 350, 310, 70);
        jPanel2.add(txtNombreActividad);
        txtNombreActividad.setBounds(250, 100, 310, 30);
        jPanel2.add(dateChooserFechaInicio);
        dateChooserFechaInicio.setBounds(250, 150, 310, 30);
        jPanel2.add(dateChooserFechaEntrega);
        dateChooserFechaEntrega.setBounds(250, 200, 310, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Fecha inicio:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(30, 150, 130, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Fecha entrega:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(30, 200, 190, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Departamento:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(30, 250, 130, 30);

        cbxDepartamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cbxDepartamento);
        cbxDepartamento.setBounds(250, 250, 310, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 640, 430);

        jPanel5.setBackground(new java.awt.Color(0, 112, 192));
        jPanel5.setLayout(null);

        btnRegresar.setBackground(new java.awt.Color(255, 0, 0));
        btnRegresar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("Regresar.");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel5.add(btnRegresar);
        btnRegresar.setBounds(20, 40, 130, 29);

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
        btnGuardarProyecto.setBounds(410, 40, 190, 30);

        jPanel1.add(jPanel5);
        jPanel5.setBounds(0, 430, 640, 100);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 640, 530);

        setSize(new java.awt.Dimension(658, 573));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        controladorActividad.getActividad().setDescripcion(txtDescripcion.getText());
        controladorActividad.getActividad().setEstado("activo");
        controladorActividad.getActividad().setExternal_id(UtilidadesControlador.generarId());
        controladorActividad.getActividad().setFechaEntrega(dateChooserFechaEntrega.getDate());
        controladorActividad.getActividad().setFechaInicio(dateChooserFechaInicio.getDate());
        controladorActividad.getActividad().setId(controladorActividad.numeroActividades()+1);
        controladorActividad.getActividad().setNombre(txtNombreActividad.getText());
        controladorActividad.getActividad().setPrioridad((String) cbxPrioridad.getSelectedItem());
        controladorActividad.getActividad().setProyecto_id(controladorProyecto.getProyecto().getId());
        controladorDeapartamento.setDepatamento(serDepa.buscarDepartamento((String) cbxDepartamento.getSelectedItem(), "nombreDepartamento"));
        controladorActividad.getActividad().setDepartamento_id(serDepa.obtenerIdDepartamento(serDepa.listarDepartamentos(), controladorDeapartamento.getDepatamento(), "id"));
        if (controladorActividad.guardarActividad()) {
            JOptionPane.showMessageDialog(null, "Se guardo correctamente");
            GestionarActividadesVista gac = new GestionarActividadesVista(controlador, controladorProyecto);
            this.dispose();
            gac.setLocationRelativeTo(null);
            gac.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "No se logro guardar");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        GestionarActividadesVista gac = new GestionarActividadesVista(controlador, controladorProyecto);
        this.dispose();
        gac.setLocationRelativeTo(null);
        gac.setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed

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
            java.util.logging.Logger.getLogger(CrearActividadVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearActividadVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearActividadVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearActividadVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new CrearActividadVista().setVisible(true);
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(CrearActividadVista.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarProyecto;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbxDepartamento;
    private javax.swing.JComboBox<String> cbxPrioridad;
    private com.toedter.calendar.JDateChooser dateChooserFechaEntrega;
    private com.toedter.calendar.JDateChooser dateChooserFechaInicio;
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
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNombreActividad;
    // End of variables declaration//GEN-END:variables
}
