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
public class AsignarPersonalDepartamentoVista extends javax.swing.JFrame {

    /**
     * Creates new form AsignarPersonalDepartamentoVista
     */
    public AsignarPersonalDepartamentoVista() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPersonalDisponible = new rojerusan.RSTableMetro();
        btnDelegarPersonal = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbtPersonalEnDepartamento = new rojerusan.RSTableMetro();
        btnSalir = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnRevocarPersonal = new javax.swing.JButton();

        jPanel5.setBackground(new java.awt.Color(0, 112, 192));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 860, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jButton4.setBackground(new java.awt.Color(255, 0, 0));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Revocar");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        tblPersonalDisponible.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPersonalDisponible.setColorBackgoundHead(new java.awt.Color(0, 153, 0));
        jScrollPane1.setViewportView(tblPersonalDisponible);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(30, 70, 650, 210);

        btnDelegarPersonal.setBackground(new java.awt.Color(0, 153, 0));
        btnDelegarPersonal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelegarPersonal.setForeground(new java.awt.Color(255, 255, 255));
        btnDelegarPersonal.setText("Delegar");
        jPanel2.add(btnDelegarPersonal);
        btnDelegarPersonal.setBounds(690, 240, 153, 40);

        jPanel4.setBackground(new java.awt.Color(0, 112, 192));
        jPanel4.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Personal disponible.");
        jPanel4.add(jLabel2);
        jLabel2.setBounds(300, 10, 200, 22);

        jPanel2.add(jPanel4);
        jPanel4.setBounds(0, 0, 860, 50);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 860, 300);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(null);

        tbtPersonalEnDepartamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbtPersonalEnDepartamento.setColorBackgoundHead(new java.awt.Color(255, 0, 0));
        jScrollPane2.setViewportView(tbtPersonalEnDepartamento);

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(30, 70, 650, 210);

        btnSalir.setBackground(new java.awt.Color(255, 0, 0));
        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Salir.");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel3.add(btnSalir);
        btnSalir.setBounds(30, 300, 153, 40);

        jPanel6.setBackground(new java.awt.Color(0, 112, 192));
        jPanel6.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Personal en \"nombre departamento\".");
        jPanel6.add(jLabel1);
        jLabel1.setBounds(230, 10, 370, 30);

        jPanel3.add(jPanel6);
        jPanel6.setBounds(0, 0, 860, 60);

        btnRevocarPersonal.setBackground(new java.awt.Color(255, 0, 0));
        btnRevocarPersonal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRevocarPersonal.setForeground(new java.awt.Color(255, 255, 255));
        btnRevocarPersonal.setText("Revocar");
        jPanel3.add(btnRevocarPersonal);
        btnRevocarPersonal.setBounds(690, 240, 153, 40);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 300, 860, 350);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 860, 650);

        setBounds(0, 0, 877, 692);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        AdministradorVista admin = new AdministradorVista();
        this.dispose();
        admin.setLocationRelativeTo(null);
        admin.setVisible(true);
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
            java.util.logging.Logger.getLogger(AsignarPersonalDepartamentoVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AsignarPersonalDepartamentoVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AsignarPersonalDepartamentoVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AsignarPersonalDepartamentoVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AsignarPersonalDepartamentoVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelegarPersonal;
    private javax.swing.JButton btnRevocarPersonal;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private rojerusan.RSTableMetro tblPersonalDisponible;
    private rojerusan.RSTableMetro tbtPersonalEnDepartamento;
    // End of variables declaration//GEN-END:variables
}