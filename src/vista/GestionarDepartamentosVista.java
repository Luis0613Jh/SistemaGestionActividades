package vista;

import controlador.ControladorDepartamento;
import controlador.ControladorPersona;
import controlador.servicio.DepartamentoServicio;
import javax.swing.JOptionPane;
import modelo.DepartamentoModelo;
import vista.tabla.tabla_Departamento;

public class GestionarDepartamentosVista extends javax.swing.JFrame {

    /**
     * Creates new form PruebaModificado
     */
    private tabla_Departamento tabla = new tabla_Departamento();
    private DepartamentoServicio seDep = new DepartamentoServicio();
    private ControladorPersona controlador;
    public GestionarDepartamentosVista() {
        initComponents();
        this.setLocationRelativeTo(this);
        this.btnCrearDepartamento.setSelected(true);
        tabla.setLista(seDep.listarDepartamentosActivos(seDep.listarDepartamentos()));
        if (tabla.getLista().tamanio() < 1) {
            JOptionPane.showMessageDialog(null, "No tiene departamentos creados");
            dispose();
            GestionarDepartamentosVista gp = new GestionarDepartamentosVista();
            this.dispose();
            gp.setLocationRelativeTo(null);
            gp.setVisible(true);
        } else {
            tbtGestionarDepartamentos.setModel(tabla);
            tbtGestionarDepartamentos.updateUI();
        }
    }
    public GestionarDepartamentosVista(ControladorPersona controlador) {
        initComponents();
        this.setLocationRelativeTo(this);
        this.controlador = controlador;
        this.btnCrearDepartamento.setSelected(true);
        tabla.setLista(seDep.listarDepartamentosActivos(seDep.listarDepartamentos()));
        if (tabla.getLista().tamanio() < 1) {
            JOptionPane.showMessageDialog(null, "No tiene departamentos creados");
            dispose();
            GestionarDepartamentosVista gp = new GestionarDepartamentosVista();
            this.dispose();
            gp.setLocationRelativeTo(null);
            gp.setVisible(true);
        } else {
            tbtGestionarDepartamentos.setModel(tabla);
            tbtGestionarDepartamentos.updateUI();
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
        java.awt.GridBagConstraints gridBagConstraints;

        rSLabelSombra1 = new rojeru_san.rslabel.RSLabelSombra();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnInstructivo = new javax.swing.JButton();
        pnlMenu = new javax.swing.JPanel();
        btnEliminarDepartamento = new rojeru_san.rsbutton.RSButtonMetro();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnCrearDepartamento = new rojeru_san.rsbutton.RSButtonMetro();
        btnSalir = new rojeru_san.rsbutton.RSButtonMetro();
        btnVerDetalladamente = new rojerusan.RSButtonMetro();
        btnVerDetalladamente1 = new rojerusan.RSButtonMetro();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbtGestionarDepartamentos = new rojerusan.RSTableMetro();
        btnGuardarCambios = new javax.swing.JButton();

        rSLabelSombra1.setText("rSLabelSombra1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel2.setBackground(new java.awt.Color(0, 112, 192));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/menu.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnInstructivo.setBackground(new java.awt.Color(255, 0, 0));
        btnInstructivo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnInstructivo.setForeground(new java.awt.Color(255, 255, 255));
        btnInstructivo.setText("Instructivo.");
        btnInstructivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInstructivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(btnInstructivo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(btnInstructivo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 937;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(jPanel2, gridBagConstraints);

        pnlMenu.setBackground(new java.awt.Color(204, 204, 204));

        btnEliminarDepartamento.setText("Eliminar departamento.");
        btnEliminarDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarDepartamentoActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel1.setText("Administrador.");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 57, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        btnCrearDepartamento.setText("Crear departamento.");
        btnCrearDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearDepartamentoActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(255, 0, 0));
        btnSalir.setText("Salir.");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnVerDetalladamente.setText("Ver detalladamente.");
        btnVerDetalladamente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerDetalladamenteActionPerformed(evt);
            }
        });

        btnVerDetalladamente1.setText("Gestionar Personal");
        btnVerDetalladamente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerDetalladamente1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnVerDetalladamente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                                .addComponent(btnEliminarDepartamento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCrearDepartamento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnVerDetalladamente1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSalir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(btnCrearDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnEliminarDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnVerDetalladamente, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVerDetalladamente1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = -10;
        gridBagConstraints.ipady = 40;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(pnlMenu, gridBagConstraints);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        tbtGestionarDepartamentos.setModel(new javax.swing.table.DefaultTableModel(
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
        tbtGestionarDepartamentos.setColorBackgoundHead(new java.awt.Color(0, 153, 0));
        jScrollPane1.setViewportView(tbtGestionarDepartamentos);

        btnGuardarCambios.setBackground(new java.awt.Color(0, 153, 0));
        btnGuardarCambios.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGuardarCambios.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarCambios.setText("Guardar cambios.");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGuardarCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGuardarCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 649;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(31, 0, 0, 0);
        jPanel1.add(jPanel6, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1055, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int posicion = this.pnlMenu.getX();
        if (posicion > -1) {
            Animacion.Animacion.mover_izquierda(0, -250, 2, 2, pnlMenu);
        } else {
            Animacion.Animacion.mover_derecha(-250, 0, 2, 2, pnlMenu);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnCrearDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearDepartamentoActionPerformed
        CrearDepartamentoVista cd = new CrearDepartamentoVista(controlador);
        this.dispose();
        cd.setLocationRelativeTo(null);
        cd.setVisible(true);
    }//GEN-LAST:event_btnCrearDepartamentoActionPerformed

    private void btnVerDetalladamenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerDetalladamenteActionPerformed
        int seleccion = -1;
        seleccion = tbtGestionarDepartamentos.getSelectedRow();
        if (seleccion == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un departamento de la tabla");
        } else {
            ControladorDepartamento aux = new ControladorDepartamento();
            VerDetalladamenteDepartamentosVista vdd = new VerDetalladamenteDepartamentosVista(aux,controlador);
            this.dispose();
            vdd.setLocationRelativeTo(null);
            vdd.setVisible(true);
        }

    }//GEN-LAST:event_btnVerDetalladamenteActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        AdministradorVista admin = new AdministradorVista(controlador);
        this.dispose();
        admin.setLocationRelativeTo(null);
        admin.setVisible(true);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnEliminarDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarDepartamentoActionPerformed
        int seleccion = -1;
        seleccion = tbtGestionarDepartamentos.getSelectedRow();
        if (seleccion == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un departamento de la tabla");
        } else {
            boolean eliminar = seDep.darDeBajaDepartamento(((DepartamentoModelo) tabla.getLista().buscarPorPosicion(seleccion)).getId(), "id", seDep.listarDepartamentos());
            if (eliminar) {
                JOptionPane.showMessageDialog(null, "Se dio de baja departamento correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo dar de baja");
            }
        }
    }//GEN-LAST:event_btnEliminarDepartamentoActionPerformed

    private void btnInstructivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInstructivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInstructivoActionPerformed

    private void btnVerDetalladamente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerDetalladamente1ActionPerformed
        int seleccion = -1;
        seleccion = tbtGestionarDepartamentos.getSelectedRow();
        if (seleccion == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un departamento de la tabla");
        } else {
            ControladorDepartamento aux = new ControladorDepartamento();
            aux.setDepatamento((DepartamentoModelo) tabla.getLista().buscarPorPosicion(seleccion));
            AsignarPersonalDepartamentoVista apd = new AsignarPersonalDepartamentoVista(aux,controlador);
            apd.setLocationRelativeTo(null);
            this.dispose();
            apd.setVisible(true);
        }

    }//GEN-LAST:event_btnVerDetalladamente1ActionPerformed

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
            java.util.logging.Logger.getLogger(GestionarDepartamentosVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionarDepartamentosVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionarDepartamentosVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionarDepartamentosVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionarDepartamentosVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.rsbutton.RSButtonMetro btnCrearDepartamento;
    private rojeru_san.rsbutton.RSButtonMetro btnEliminarDepartamento;
    private javax.swing.JButton btnGuardarCambios;
    private javax.swing.JButton btnInstructivo;
    private rojeru_san.rsbutton.RSButtonMetro btnSalir;
    private rojerusan.RSButtonMetro btnVerDetalladamente;
    private rojerusan.RSButtonMetro btnVerDetalladamente1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlMenu;
    private rojeru_san.rslabel.RSLabelSombra rSLabelSombra1;
    private rojerusan.RSTableMetro tbtGestionarDepartamentos;
    // End of variables declaration//GEN-END:variables
}
