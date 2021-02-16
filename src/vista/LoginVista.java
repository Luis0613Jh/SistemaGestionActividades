package vista;

import controlador.ControladorActividadPersonal;
import controlador.ControladorPersona;
import controlador.DAO.ConexionDAO;
import controlador.cola.Cola;
import controlador.listaSimple.ListaSimple;
import controlador.servicio.ActividadPersonalServicio;
import javax.swing.JOptionPane;

import controlador.servicio.CuentaServicio;
import controlador.servicio.PersonaServicio;
import controlador.utilidades.Sesion;
import controlador.utilidades.UtilidadesControlador;
import ds.desktop.notify.DesktopNotify;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import modelo.ActividadPersonalModelo;

public class LoginVista extends javax.swing.JFrame {

    private ControladorPersona controlador = new ControladorPersona();
    private Sesion sesion = new Sesion();
    private CuentaServicio cuentaServicio = new CuentaServicio();
    private ControladorActividadPersonal cap = new ControladorActividadPersonal();
    private ActividadPersonalServicio aps = new ActividadPersonalServicio();
    private Timer timer;
    private int segundos;
    private Cola colaActividadesPersonales = new Cola();

    private ActionListener accion = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
//            ListaSimple actividadesPersonalesActivas = aps.listarActividadesPersonalesActivas(aps.listarActividadesPersonales());
//            ListaSimple actividadesPersonales = aps.listarActividadesPersonalesCoincidencias(actividadesPersonalesActivas, controlador.getPersona().getId(), new ActividadPersonalServicio().ID_PERSONA);
            ListaSimple actividadesPersonales = aps.listarActividadesPersonalesActivas(aps.listarActividadesPersonalesCoincidencias(aps.listarActividadesPersonales(), controlador.getPersona().getId(), "persona_id"));
            if (colaActividadesPersonales.tamanio() == actividadesPersonales.tamanio()) {
                segundos--;
                System.out.println("Segundos: " + segundos);
                if (segundos == 0) {
                    System.out.println("Se terminó el tiempo");
                    cap.setActividadPersonal((ActividadPersonalModelo) colaActividadesPersonales.buscarPorPosicion(0));
                    DesktopNotify.showDesktopMessage("La tarea " + cap.getActividadPersonal().getNombre() + " ha finalizado a las: " + cap.getActividadPersonal().getHora(), "Tarea Finalizada", DesktopNotify.INFORMATION);
                    aps.darDeBajaActividadPersonal(cap.getActividadPersonal().getId(), ActividadPersonalServicio.IDENTIFICADOR, aps.listarActividadesPersonalesActivas(aps.listarActividadesPersonales()));
                    cap.setActividadPersonal(null);
                    timer.stop();
                    colaActividadesPersonales.dequeue();
                    if (colaActividadesPersonales.tamanio() > 0) {
                        segundos = cap.determinarSegundosTotales(cap.determinarHora(colaActividadesPersonales));
                        timer.start();
                    } else {
                        DesktopNotify.showDesktopMessage("Sin actividades pendientes", "Aviso", DesktopNotify.TIP, 1400L);
                    }
                }
            } else {
                iniciarReloj();
            }

        }
    };

    /**
     * Creates new form pms
     */
    public LoginVista() {
        initComponents();
        this.setLocationRelativeTo(this);
    }

    public void iniciarSesion() {

        sesion.setCuenta(cuentaServicio.inicarSesion(txtUsuario.getText(), txtClave.getText()));
        if (sesion.getCuenta() != null) {
            PersonaServicio serPer = new PersonaServicio();
            controlador.setPersona(serPer.buscarPersona(sesion.getCuenta().getId(), "id"));
            sesion.obtenerDatos();
            autorizarVista(sesion.getRol().getTipo(), controlador);
        } else {
            JOptionPane.showMessageDialog(this, "Credenciales inválidas", "Error en inicio de sesión", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void autorizarVista(String rolNombre, ControladorPersona controlador) {
        System.out.println("---------ROL: " + rolNombre);

        File archivo = new File(new ConexionDAO().getCARPETA_CONTENEDORA() + File.separatorChar + new ConexionDAO().getCARPETA_ACTIVIDADES_PERSONALES() + File.separatorChar + ActividadPersonalModelo.class.getSimpleName() + ".json");
        if (archivo.exists()) {
            iniciarReloj();
        } else {
            System.out.println("No existe el archivo actividades personales");
        }

        switch (rolNombre) {
            case "Administrador":
                System.out.println("Es un Administrador");
                this.dispose();
                AdministradorVista av = new AdministradorVista(controlador);
                av.setVisible(true);
                break;
            case "Jefe de Proyecto":
                System.out.println("Es un Jefe de Proyecto");
                this.dispose();
                JefeProyectoVista jpv = new JefeProyectoVista(controlador);
                jpv.setVisible(true);
                break;
            case "Encargado":
                System.out.println("Es un Encargado");
                this.dispose();
                EncargadoDepartamentoVista edv = new EncargadoDepartamentoVista(controlador);
                edv.setVisible(true);
                break;
            case "Personal":
                System.out.println("Es un Personal");
                this.dispose();
                PersonalVista pv = new PersonalVista(controlador);
                pv.setVisible(true);
                break;
        }
    }

    public void iniciarReloj() {

        ListaSimple lista = cap.obtenerListaActividadesPersonales(controlador.getPersona());
        if (lista != null) {
            System.out.println("En reloj no soy null");
        } else {
            System.out.println("En reloj soy null");
        }
        colaActividadesPersonales = UtilidadesControlador.obtenerNotificacionesActividadesPersonal(lista);
        if (colaActividadesPersonales != null) {
            timer = new Timer(1000, accion);
            segundos = cap.determinarSegundosTotales(cap.determinarHora(colaActividadesPersonales));
            timer.start();
        } else {
            System.out.println("Persona sin actividades personales");
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

        rSPanelsSlider1 = new rojerusan.RSPanelsSlider();
        btnIniciarSesion1 = new rojeru_san.RSButtonRiple();
        jPanel2 = new javax.swing.JPanel();
        rSPanelsSlider2 = new rojeru_san.RSPanelsSlider();
        panelSesion = new javax.swing.JPanel();
        rSLabelImage2 = new rojerusan.RSLabelImage();
        txtUsuario = new rojeru_san.RSMTextFull();
        txtClave = new rojeru_san.rsfield.RSPassView();
        rSLabelImage1 = new rojeru_san.rslabel.RSLabelImage();
        rSLabelImage3 = new rojeru_san.rslabel.RSLabelImage();
        lblIngreseUsuarioClave = new javax.swing.JLabel();
        btnIniciarSesion = new rojeru_san.RSButtonRiple();
        btnSalir = new rojeru_san.RSButtonRiple();

        btnIniciarSesion1.setText("Iniciar Sesión");
        btnIniciarSesion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesion1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        panelSesion.setBackground(new java.awt.Color(255, 255, 255));

        rSLabelImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/user_customer_person_13976.png"))); // NOI18N

        txtUsuario.setPlaceholder("Ingrese su usuario");

        txtClave.setPlaceholder("Ingrese su contraseña");

        rSLabelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/user_customer_person_13976.png"))); // NOI18N

        rSLabelImage3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/password_userpassword_9564.png"))); // NOI18N

        lblIngreseUsuarioClave.setFont(new java.awt.Font("Tw Cen MT", 3, 24)); // NOI18N
        lblIngreseUsuarioClave.setForeground(new java.awt.Color(204, 0, 0));
        lblIngreseUsuarioClave.setText("Ingrese el usuario y contraseña.");

        btnIniciarSesion.setText("Iniciar Sesión");
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(255, 0, 0));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSesionLayout = new javax.swing.GroupLayout(panelSesion);
        panelSesion.setLayout(panelSesionLayout);
        panelSesionLayout.setHorizontalGroup(
            panelSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSesionLayout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(rSLabelImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelSesionLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(panelSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSesionLayout.createSequentialGroup()
                        .addGroup(panelSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelSesionLayout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(lblIngreseUsuarioClave, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 76, Short.MAX_VALUE))
                            .addGroup(panelSesionLayout.createSequentialGroup()
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(panelSesionLayout.createSequentialGroup()
                        .addGroup(panelSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rSLabelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                            .addComponent(rSLabelImage3, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(63, 63, 63))))
        );
        panelSesionLayout.setVerticalGroup(
            panelSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSesionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSLabelImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(panelSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rSLabelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addGroup(panelSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rSLabelImage3, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                    .addGroup(panelSesionLayout.createSequentialGroup()
                        .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)))
                .addGap(18, 18, 18)
                .addComponent(lblIngreseUsuarioClave, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(panelSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(panelSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rSPanelsSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(rSPanelsSlider2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(panelSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarSesion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesion1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIniciarSesion1ActionPerformed

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
        iniciarSesion();
    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
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
            java.util.logging.Logger.getLogger(LoginVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButtonRiple btnIniciarSesion;
    private rojeru_san.RSButtonRiple btnIniciarSesion1;
    private rojeru_san.RSButtonRiple btnSalir;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblIngreseUsuarioClave;
    private javax.swing.JPanel panelSesion;
    private rojeru_san.rslabel.RSLabelImage rSLabelImage1;
    private rojerusan.RSLabelImage rSLabelImage2;
    private rojeru_san.rslabel.RSLabelImage rSLabelImage3;
    private rojerusan.RSPanelsSlider rSPanelsSlider1;
    private rojeru_san.RSPanelsSlider rSPanelsSlider2;
    private rojeru_san.rsfield.RSPassView txtClave;
    private rojeru_san.RSMTextFull txtUsuario;
    // End of variables declaration//GEN-END:variables
}
