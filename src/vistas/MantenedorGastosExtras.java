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
import Modelo.GastosExtras;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import static licanray.LicanRay.caja;
import static licanray.LicanRay.usuario;

/**
 *
 * @author cristian
 */
public class MantenedorGastosExtras extends javax.swing.JFrame {

    /**
     * Creates new form MantenedorGastosExtras
     */
    public MantenedorGastosExtras() {
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
        btnOK = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        txtMonto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMotivo = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Motivo/Descripción");

        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        txtMonto.setToolTipText("Ingrese el Dinero");
        txtMonto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMontoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMontoKeyTyped(evt);
            }
        });

        jLabel2.setText("Monto en pesos: $");

        txtMotivo.setColumns(20);
        txtMotivo.setLineWrap(true);
        txtMotivo.setRows(5);
        txtMotivo.setToolTipText("Ingrese la Descripción");
        txtMotivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMotivoKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txtMotivo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnOK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(87, 87, 87)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnOK)
                            .addComponent(btnVolver)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(60, 60, 60))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
        int resp = JOptionPane.showConfirmDialog(this, "¿Esta seguro que desea volver?", "Confirmación de volver", JOptionPane.YES_OPTION);
        if (resp == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        // TODO add your handling code here:
        int usuarioActual = usuario.getIdUsuario();
        String horaIngreso = caja.getHora();
        Date fechaHoy = caja.getFecha();
        CajaDao cajaDao = new CajaDaoImpl();
        int idCaja = cajaDao.idCaja(usuarioActual);
        String montoSinPuntos, monto2 = txtMonto.getText().trim();
        montoSinPuntos = monto2.replace(".", "");
        GastosExtras gastoReal = new GastosExtras();
        GastosExtrasDao gasto = new GastosExtrasDaoImpl();

        Calendar cal = new GregorianCalendar().getInstance();

        String hora = String.valueOf(cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND));

        if (!montoSinPuntos.equals("") && !txtMotivo.getText().trim().equals("")) {
            int monto = Integer.parseInt(montoSinPuntos);
          
                if (monto > 0) {
                    gastoReal.setId_gasto(0);
                    gastoReal.setTotal(monto);
                    gastoReal.setMotivo(txtMotivo.getText().trim());
                    
                    
                    int dinActual1 = cajaDao.dineroActualCaja(usuarioActual);
                    if (monto < dinActual1) {
                        gasto.ingresarGasto(gastoReal, idCaja);
                        int dinActual = cajaDao.dineroActualCaja(usuarioActual);
                        int resultado = dinActual - monto;
                        cajaDao.actualizarCaja(resultado, idCaja);
                        limpiar();
                        JOptionPane.showMessageDialog(this, "Gasto ingresado correctamente");
                    } else {
                        JOptionPane.showMessageDialog(this, "Su gasto sobrepasa lo que hay en caja, porfavor ingrese bien.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Ingrese correctamente el dinero", "Datos no validos", JOptionPane.ERROR_MESSAGE);
                }

            

        } else {
            JOptionPane.showMessageDialog(this, "Ingrese la descripción y el monto del dinero", "Datos vacios", JOptionPane.ERROR_MESSAGE);

        }


    }//GEN-LAST:event_btnOKActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        int resp = JOptionPane.showConfirmDialog(this, "¿Esta seguro que desea volver?", "Confirmación de volver", JOptionPane.YES_OPTION);
        if (resp == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_formWindowClosing

    private void txtMontoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoKeyReleased
        // TODO add your handling code here:
        DecimalFormat formateador = new DecimalFormat("###,###");
        String textoNuevo, texto = txtMonto.getText().trim();
        if (!texto.equals("")) {
            textoNuevo = texto.replace(".", "");

            String ff = formateador.format(Double.parseDouble(textoNuevo));

            txtMonto.setText(ff);
        }
    }//GEN-LAST:event_txtMontoKeyReleased

    private void txtMontoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoKeyTyped
        // TODO add your handling code here:
         int k = (int) evt.getKeyChar();
        if (k >= 97 && k <= 122 || k >= 65 && k <= 90) {

            evt.consume();
            JOptionPane.showMessageDialog(null, "No puede ingresar Letras!!!", "Error Datos", JOptionPane.ERROR_MESSAGE);
        }
        int largo = txtMonto.getText().trim().length();

        if (largo > 9) {
            evt.consume();
        }
    }//GEN-LAST:event_txtMontoKeyTyped

    private void txtMotivoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMotivoKeyTyped
        // TODO add your handling code here:
        int largo = txtMotivo.getText().trim().length();

        if (largo > 199) {
            evt.consume();
        }
    }//GEN-LAST:event_txtMotivoKeyTyped

    public void limpiar() {
        txtMonto.setText("");
        txtMotivo.setText("");
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
            java.util.logging.Logger.getLogger(MantenedorGastosExtras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MantenedorGastosExtras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MantenedorGastosExtras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MantenedorGastosExtras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MantenedorGastosExtras().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextArea txtMotivo;
    // End of variables declaration//GEN-END:variables
}
