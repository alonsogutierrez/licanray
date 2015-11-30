/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import Controlador.CajaDao;
import Controlador.CajaDaoImpl;
import Controlador.GastosExtrasDao;
import Controlador.GastosExtrasDaoImpl;
import Controlador.UsuarioDao;
import Controlador.UsuarioDaoImpl;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import static licanray.LicanRay.usuario;

/**
 *
 * @author cristian
 */
public class MantenedorCerraCaja extends javax.swing.JFrame {

    /**
     * Creates new form MantenedorCerraCaja
     */
    public MantenedorCerraCaja() {
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
        txtAperturaCaja = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTotalVentas = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTotalDia = new javax.swing.JTextField();
        btnCerrarCaja = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtDiferenciaCaja = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtUtilidadCaja = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtTotalRetiros = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtTotalVentas1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtCostosTotales = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtGastosExtras = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cerrar Caja");

        jLabel1.setText("Apertura Caja:");

        txtAperturaCaja.setEditable(false);

        jLabel2.setText("Total Ventas:");

        txtTotalVentas.setEditable(false);

        jLabel3.setText("Total Día:");

        txtTotalDia.setEditable(false);

        btnCerrarCaja.setText("Cerrar Caja");
        btnCerrarCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarCajaActionPerformed(evt);
            }
        });

        btnVolver.setText("Cancelar");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jLabel4.setText("$");

        jLabel5.setText("$");

        jLabel6.setText("$");

        jLabel7.setText("Diferencia Caja:");

        jLabel8.setText("$");

        txtDiferenciaCaja.setEditable(false);

        jLabel9.setText("Utilidad Marginal:");

        jLabel10.setText("$");
        jLabel10.setAlignmentX(321321.0F);

        txtUtilidadCaja.setEditable(false);

        jLabel11.setText("Total Retiros:");

        txtTotalRetiros.setEditable(false);
        txtTotalRetiros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalRetirosActionPerformed(evt);
            }
        });

        jLabel12.setText("$");

        jLabel13.setText("Contabilidad:");

        jLabel14.setText("-------------------------------------------------------------------");

        jLabel15.setText("Ventas Totales:");

        txtTotalVentas1.setEditable(false);

        jLabel16.setText("$");

        jLabel17.setText("Costos Totales:");

        jLabel18.setText("$");

        txtCostosTotales.setEditable(false);

        jLabel19.setText("-------------------------------------------------------------------");

        jLabel20.setText("------------------------------------------------------------------");

        jLabel21.setText("Gastos Extras Totales:");

        jLabel22.setText("$");

        txtGastosExtras.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(jLabel20)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel19)
                        .addComponent(jLabel13)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(7, 7, 7)))
                                .addComponent(jLabel3)
                                .addComponent(jLabel7))
                            .addGap(96, 96, 96)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtDiferenciaCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtTotalDia, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTotalVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtAperturaCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTotalRetiros, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addComponent(jLabel14)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnCerrarCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(27, 27, 27)
                            .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel15)
                                .addComponent(jLabel17))
                            .addGap(97, 97, 97)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel18)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtCostosTotales))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel16)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtTotalVentas1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel22)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtGastosExtras))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addGap(85, 85, 85)
                            .addComponent(jLabel10)
                            .addGap(18, 18, 18)
                            .addComponent(txtUtilidadCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37))))
                .addGap(111, 111, 111))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtAperturaCaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(txtTotalVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalRetiros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(1, 1, 1)
                .addComponent(jLabel20)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTotalDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDiferenciaCaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(txtTotalVentas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(txtCostosTotales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel22)
                        .addComponent(txtGastosExtras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(txtUtilidadCaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVolver)
                    .addComponent(btnCerrarCaja))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarCajaActionPerformed
        // TODO add your handling code here:
        try {

            int ax = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea cerrar su caja?", "Cierre Caja", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (ax == JOptionPane.YES_NO_OPTION) {
                CajaDao cajaDao = new CajaDaoImpl();
                GastosExtrasDao gastosExtrasDao = new GastosExtrasDaoImpl();
                UsuarioDao usuarioDao = new UsuarioDaoImpl();
                int idUsuario = usuarioDao.idUsuario(usuario.getNombre());
                int idCaja = cajaDao.idCaja(idUsuario);
                String real, noreal = txtTotalVentas.getText().trim();
                real = noreal.replace(".", "");
                int totalVentas = Integer.parseInt(real);
                int totalGastosExtras = gastosExtrasDao.gastosCaja(idCaja);
                cajaDao.cerrarCaja(totalVentas, totalGastosExtras, idCaja);
                //Cerrar la sesión, guardar la hora del cierre de la caja en la caja.
                licanray.LicanRay.usuario.setCargo("");
                licanray.LicanRay.usuario.setClave("");
                licanray.LicanRay.usuario.setEstado(Byte.parseByte("0"));
                licanray.LicanRay.usuario.setIdUsuario(0);
                licanray.LicanRay.usuario.setNombre("");
                licanray.LicanRay.mantenedorMenuPrincipal.costosTotales = 0;
                licanray.LicanRay.mantenedorMenuPrincipal.pesoTotalProductos = 0.0;
                licanray.LicanRay.mantenedorMenuPrincipal.cantidadProductos = 0;
                licanray.LicanRay.mantenedorMenuPrincipal.s = -1;
                
                dispose();
                JOptionPane.showMessageDialog(null, "Caja Cerrada ", "Caja Cerrada", JOptionPane.INFORMATION_MESSAGE);
                licanray.LicanRay.mantenedorMenuPrincipal.dispose();
                licanray.LicanRay.mantenedorLogin.setVisible(true);

            }

        } catch (Exception e) {
            System.err.println("Error cuando se estaba cerrando la Caja: " + e);
            JOptionPane.showMessageDialog(null, "Error al realizar el cierre de caja, por favor intentelo de nuevo o contáctese con su administrador de sistemas", "Error Cierre de Caja", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnCerrarCajaActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void txtTotalRetirosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalRetirosActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtTotalRetirosActionPerformed

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
            java.util.logging.Logger.getLogger(MantenedorCerraCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MantenedorCerraCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MantenedorCerraCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MantenedorCerraCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MantenedorCerraCaja().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton btnCerrarCaja;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    protected javax.swing.JTextField txtAperturaCaja;
    protected javax.swing.JTextField txtCostosTotales;
    protected javax.swing.JTextField txtDiferenciaCaja;
    protected javax.swing.JTextField txtGastosExtras;
    protected javax.swing.JTextField txtTotalDia;
    protected javax.swing.JTextField txtTotalRetiros;
    protected javax.swing.JTextField txtTotalVentas;
    protected javax.swing.JTextField txtTotalVentas1;
    protected javax.swing.JTextField txtUtilidadCaja;
    // End of variables declaration//GEN-END:variables
}