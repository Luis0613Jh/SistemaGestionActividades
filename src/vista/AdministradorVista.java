/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author juana
 */
public class AdministradorVista extends javax.swing.JFrame {

    /**
     * Creates new form Administrador
     */
    public AdministradorVista() {
        initComponents();
        this.setLocationRelativeTo(this);
        this.btnGestionarEmpleados.setSelected(true);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSMenuBar1 = new rojerusan.RSMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        rSCalendar1 = new necesario.RSCalendar();
        roboto1 = new rojeru_san.efectos.Roboto();
        scheduledExecutorTimingSource1 = new org.jdesktop.core.animation.timing.sources.ScheduledExecutorTimingSource();
        rSButtonRiple2 = new rojeru_san.RSButtonRiple();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnMenu = new rojeru_san.rsbutton.RSButtonMetro();
        rSLabelHora1 = new rojeru_san.rsdate.RSLabelHora();
        panelBotones = new javax.swing.JPanel();
        btnGestionarEmpleados = new rojerusan.RSButtonMetro();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnGestionarProyectos = new rojeru_san.rsbutton.RSButtonMetro();
        btnSalir = new rojeru_san.rsbutton.RSButtonMetro();
        btnGestionarDepartamentos1 = new rojeru_san.rsbutton.RSButtonMetro();
        rSCalendar2 = new rojerusan.RSCalendar();

        jMenu1.setText("File");
        rSMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        rSMenuBar1.add(jMenu2);

        rSButtonRiple2.setBackground(new java.awt.Color(0, 153, 51));
        rSButtonRiple2.setText("Gestionar empleados.");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 112, 192));
        jPanel2.setLayout(null);

        btnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/menu.png"))); // NOI18N
        btnMenu.setGrosorLinea(10);
        btnMenu.setIconTextGap(10);
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });
        jPanel2.add(btnMenu);
        btnMenu.setBounds(30, 10, 60, 50);

        rSLabelHora1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        rSLabelHora1.setForeground(new java.awt.Color(255, 255, 255));
        rSLabelHora1.setFont(new java.awt.Font("Roboto Bold", 1, 18)); // NOI18N
        jPanel2.add(rSLabelHora1);
        rSLabelHora1.setBounds(750, 20, 200, 40);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 80));

        panelBotones.setBackground(new java.awt.Color(204, 204, 204));
        panelBotones.setLayout(null);

        btnGestionarEmpleados.setText("Gestionar empleados.");
        btnGestionarEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionarEmpleadosActionPerformed(evt);
            }
        });
        panelBotones.add(btnGestionarEmpleados);
        btnGestionarEmpleados.setBounds(0, 100, 230, 50);

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Administrador + nombre del admin");
        jPanel4.add(jLabel1);
        jLabel1.setBounds(0, 30, 230, 21);

        panelBotones.add(jPanel4);
        jPanel4.setBounds(0, 0, 230, 70);

        btnGestionarProyectos.setText("Gestionar proyectos.");
        btnGestionarProyectos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGestionarProyectos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionarProyectosActionPerformed(evt);
            }
        });
        panelBotones.add(btnGestionarProyectos);
        btnGestionarProyectos.setBounds(0, 170, 230, 50);

        btnSalir.setBackground(new java.awt.Color(255, 0, 0));
        btnSalir.setText("Salir.");
        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        panelBotones.add(btnSalir);
        btnSalir.setBounds(0, 360, 230, 50);

        btnGestionarDepartamentos1.setText("Gestionar departamentos.");
        btnGestionarDepartamentos1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGestionarDepartamentos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionarDepartamentos1ActionPerformed(evt);
            }
        });
        panelBotones.add(btnGestionarDepartamentos1);
        btnGestionarDepartamentos1.setBounds(0, 240, 230, 50);

        jPanel1.add(panelBotones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 230, 430));

        rSCalendar2.setColorBackground(new java.awt.Color(0, 153, 0));
        jPanel1.add(rSCalendar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 103, 680, 380));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 510));

        setSize(new java.awt.Dimension(992, 547));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        int posicion = this.panelBotones.getX();
        if (posicion > -1) {
            Animacion.Animacion.mover_izquierda(0, -250, 2, 2, panelBotones);
        } else {
            Animacion.Animacion.mover_derecha(-250, 0, 2, 2, panelBotones);
        }
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnGestionarEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionarEmpleadosActionPerformed
        GestionarEmpleadosVista ge = new GestionarEmpleadosVista();
        this.dispose();
        ge.setLocationRelativeTo(null);
        ge.setVisible(true);
    }//GEN-LAST:event_btnGestionarEmpleadosActionPerformed

    private void btnGestionarProyectosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionarProyectosActionPerformed
        GestionarProyectosVista gps = new GestionarProyectosVista();
        this.dispose();
        gps.setLocationRelativeTo(null);
        gps.setVisible(true);
    }//GEN-LAST:event_btnGestionarProyectosActionPerformed

    private void btnGestionarDepartamentos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionarDepartamentos1ActionPerformed
        GestionarDepartamentosVista gp = new GestionarDepartamentosVista();
        this.dispose();
        gp.setLocationRelativeTo(null);
        gp.setVisible(true);
    }//GEN-LAST:event_btnGestionarDepartamentos1ActionPerformed

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
            java.util.logging.Logger.getLogger(AdministradorVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdministradorVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdministradorVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdministradorVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdministradorVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.rsbutton.RSButtonMetro btnGestionarDepartamentos1;
    private rojerusan.RSButtonMetro btnGestionarEmpleados;
    private rojeru_san.rsbutton.RSButtonMetro btnGestionarProyectos;
    private rojeru_san.rsbutton.RSButtonMetro btnMenu;
    private rojeru_san.rsbutton.RSButtonMetro btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel panelBotones;
    private rojeru_san.RSButtonRiple rSButtonRiple2;
    private necesario.RSCalendar rSCalendar1;
    private rojerusan.RSCalendar rSCalendar2;
    private rojeru_san.rsdate.RSLabelHora rSLabelHora1;
    private rojerusan.RSMenuBar rSMenuBar1;
    private rojeru_san.efectos.Roboto roboto1;
    private org.jdesktop.core.animation.timing.sources.ScheduledExecutorTimingSource scheduledExecutorTimingSource1;
    // End of variables declaration//GEN-END:variables
}
