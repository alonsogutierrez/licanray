/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import Controlador.LoginDao;
import Controlador.LoginDaoImpl;
import Controlador.UsuarioDao;
import Controlador.UsuarioDaoImpl;
import Modelo.Caja;
import Modelo.Usuario;
import com.mchange.v2.lang.Coerce;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import static licanray.LicanRay.caja;

/**
 *
 * @author cristian
 */
public class MantenedorLogin extends javax.swing.JFrame {

    LoginDao loginDao = new LoginDaoImpl();
    private Object frame;

    //Usuario usuario = new Usuario();
    /**
     * Creates new form MantenedorLogin
     */
    public MantenedorLogin() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtClave = new javax.swing.JPasswordField();
        btnIngresar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Inicio de Sesión");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Usuario:");

        jLabel2.setText("Contraseña:");

        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });

        txtClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtClaveKeyTyped(evt);
            }
        });

        btnIngresar.setText("Ingresar");
        btnIngresar.setEnabled(false);
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                            .addComponent(txtClave)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnIngresar)
                        .addGap(48, 48, 48)
                        .addComponent(btnCancelar)))
                .addContainerGap(134, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresar)
                    .addComponent(btnCancelar))
                .addGap(76, 76, 76))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        // TODO add your handling code here:
        String user = txtUsuario.getText().trim();
        String pass = txtClave.getText().trim();
        String estado;
        Calendar c1 = GregorianCalendar.getInstance();
        int mes = c1.get(Calendar.MONTH) + 1;
        String fecha = c1.get(Calendar.DAY_OF_MONTH) + "/" + mes + "/" + c1.get(Calendar.YEAR);
        String hora = String.valueOf(c1.get(Calendar.HOUR_OF_DAY) + ":" + c1.get(Calendar.MINUTE) + ":" + c1.get(Calendar.SECOND));
        /*caja.setHora(hora);
         byte bit=1;
         caja.setEstado(bit);*/

        if (!user.equals("") && !pass.equals("")) {
            byte est = loginDao.verificarEstado(user);
            System.out.println("estado user(1 activo y 0 no permitido): " + est);
            
            estado = loginDao.ingresar(user, pass, hora);
            System.out.println("estado cargo(adm o vendedor): " + estado);

            if ("Administrador".equals(estado) || "Vendedor".equals(estado)) {
                if (est == 1) {
                    UsuarioDao usuarioDao = new UsuarioDaoImpl();
                    int id = usuarioDao.idUsuario(user);
                    byte estadoCaja = usuarioDao.estadoCaja(id);
                    System.out.println("Estado Caja==>" + estadoCaja);
                    
                    //Si la caja esta abierta.
                    if (estadoCaja == 1) {
                        txtUsuario.setText("");
                        txtClave.setText("");
                        licanray.LicanRay.mantenedorMenuPrincipal.setVisible(true);
                        licanray.LicanRay.mantenedorMenuPrincipal.lblNombreVendedor.setText(user);
                        licanray.LicanRay.mantenedorMenuPrincipal.lblCargoUsuario.setText(estado);
                        licanray.LicanRay.mantenedorMenuPrincipal.lblFechaReal.setText(fecha);
                        if (licanray.LicanRay.mantenedorMenuPrincipal.lblCargoUsuario.getText().equals("Administrador")) {
                            licanray.LicanRay.mantenedorMenuPrincipal.btnAdminUsuarios.setEnabled(true);
                            licanray.LicanRay.mantenedorMenuPrincipal.btnConfiguraciones.setEnabled(true);
                            licanray.LicanRay.mantenedorMenuPrincipal.btnAdminVentas.setEnabled(true);
                            licanray.LicanRay.mantenedorMenuPrincipal.cmbProductos.setEnabled(true);
                            licanray.LicanRay.mantenedorMenuPrincipal.btnReportes.setEnabled(true);
                        } else {
                            licanray.LicanRay.mantenedorMenuPrincipal.btnAdminUsuarios.setEnabled(false);
                            licanray.LicanRay.mantenedorMenuPrincipal.btnConfiguraciones.setEnabled(false);
                            licanray.LicanRay.mantenedorMenuPrincipal.btnAdminVentas.setEnabled(false);
                            licanray.LicanRay.mantenedorMenuPrincipal.cmbProductos.setEnabled(false);
                            licanray.LicanRay.mantenedorMenuPrincipal.btnReportes.setEnabled(false);
                        }
                    } else {
                        txtUsuario.setText("");
                        txtClave.setText("");
                        licanray.LicanRay.mantenedorMenuPrincipal.setVisible(true);
                        licanray.LicanRay.mantenedorDineroCaja.setVisible(true);
                        licanray.LicanRay.mantenedorMenuPrincipal.lblNombreVendedor.setText(user);
                        licanray.LicanRay.mantenedorMenuPrincipal.lblCargoUsuario.setText(estado);
                        licanray.LicanRay.mantenedorMenuPrincipal.lblFechaReal.setText(fecha);
                        if (licanray.LicanRay.mantenedorMenuPrincipal.lblCargoUsuario.getText().equals("Administrador")) {
                            licanray.LicanRay.mantenedorMenuPrincipal.btnAdminUsuarios.setEnabled(true);
                            licanray.LicanRay.mantenedorMenuPrincipal.btnConfiguraciones.setEnabled(true);
                            licanray.LicanRay.mantenedorMenuPrincipal.btnAdminVentas.setEnabled(true);
                            licanray.LicanRay.mantenedorMenuPrincipal.cmbProductos.setEnabled(true);
                            licanray.LicanRay.mantenedorMenuPrincipal.btnReportes.setEnabled(true);
                        } else {
                            licanray.LicanRay.mantenedorMenuPrincipal.btnAdminUsuarios.setEnabled(false);
                            licanray.LicanRay.mantenedorMenuPrincipal.btnConfiguraciones.setEnabled(false);
                            licanray.LicanRay.mantenedorMenuPrincipal.btnAdminVentas.setEnabled(false);
                            licanray.LicanRay.mantenedorMenuPrincipal.cmbProductos.setEnabled(false);
                            licanray.LicanRay.mantenedorMenuPrincipal.btnReportes.setEnabled(false);
                        }

                    }
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Usuario sin permisos para ingresar, contactese con el adminstrador", "Ingreso No Permitido", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña invalido, intentelo de nuevo", "Usuario o Contraseña invalida", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese los datos solicitados, por favor.", "Datos Vacios", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        int ax = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea salir del programa?", "Confirmar ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (ax == JOptionPane.YES_OPTION) {
            System.exit(0);
        }

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
        // TODO add your handling code here:
        btnIngresar.setEnabled(true);
    }//GEN-LAST:event_txtUsuarioKeyTyped

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        cerrar();
    }//GEN-LAST:event_formWindowClosing

    private void txtClaveKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClaveKeyTyped
        // TODO add your handling code here:
        char cTeclaPresionada = evt.getKeyChar();
        if (cTeclaPresionada == KeyEvent.VK_ENTER) {
            btnIngresar.doClick();
        }
    }//GEN-LAST:event_txtClaveKeyTyped

    public void cerrar() {
        Object[] opciones = {"Aceptar", "Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(rootPane, "Desea cerrar por completo la aplicación", "Mensaje de Confirmacion",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
        if (eleccion == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
        }
    }

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
            java.util.logging.Logger.getLogger(MantenedorLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MantenedorLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MantenedorLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MantenedorLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MantenedorLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField txtClave;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
