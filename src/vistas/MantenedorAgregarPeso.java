/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static licanray.LicanRay.mantenedorMenuPrincipal;

/**
 *
 * @author alonso
 */
public class MantenedorAgregarPeso extends javax.swing.JFrame {

    private Object producto;

    /**
     * Creates new form MantenedorAgregarPeso
     */
    public MantenedorAgregarPeso() {
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblNombreProd = new javax.swing.JLabel();
        lblPesoTot = new javax.swing.JLabel();
        lblMarcaProd = new javax.swing.JLabel();
        txtPesoProd = new javax.swing.JTextField();
        btnOkPeso = new javax.swing.JButton();
        btnCancelarPeso = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lblPrecioKg = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar peso");

        jLabel1.setText("Nombre producto:");

        jLabel2.setText("Marca producto:");

        jLabel3.setText("Peso producto (Kg):");

        jLabel4.setText("Peso total producto (Kg):");

        txtPesoProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesoProdKeyReleased(evt);
            }
        });

        btnOkPeso.setText("OK");
        btnOkPeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkPesoActionPerformed(evt);
            }
        });

        btnCancelarPeso.setText("Cancelar");
        btnCancelarPeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarPesoActionPerformed(evt);
            }
        });

        jLabel5.setText("Precio por Kg:");

        jLabel6.setText("$");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(btnOkPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lblPesoTot, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblNombreProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblMarcaProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblPrecioKg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPesoProd, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCancelarPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNombreProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(lblMarcaProd, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPrecioKg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(lblPesoTot, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtPesoProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnOkPeso)
                            .addComponent(btnCancelarPeso))))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarPesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarPesoActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCancelarPesoActionPerformed

    private void txtPesoProdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesoProdKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_txtPesoProdKeyReleased

    private void btnOkPesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkPesoActionPerformed
        // TODO add your handling code here:
        String code = mantenedorMenuPrincipal.txtAgregarProducto.getText().trim();

        producto = mantenedorMenuPrincipal.productoDao.agregarProductoALaVenta(code);
        String nombre_prod = mantenedorMenuPrincipal.producto.getNombre();
        String marca_prod = mantenedorMenuPrincipal.producto.getMarca();
        String peso_total_prod = String.valueOf(mantenedorMenuPrincipal.producto.getPeso());

        double peso_ingresado = Double.parseDouble(txtPesoProd.getText().trim());
        double peso_total = Double.parseDouble(peso_total_prod);
        
        System.out.println("peso_ingresado: "+peso_ingresado);
        System.out.println("peso_total: "+peso_total);

        //Verificamos que el peso ingresado sea menor o igual que el peso total existente.
        if (peso_ingresado <= peso_total) {

            System.out.println("1..");
            producto = mantenedorMenuPrincipal.productoDao.agregarProductoALaVenta(mantenedorMenuPrincipal.txtAgregarProducto.getText().trim());
            DefaultTableModel modelo = (DefaultTableModel) mantenedorMenuPrincipal.tbVenta.getModel();

            Object[] columna = new Object[6];
            columna[0] = mantenedorMenuPrincipal.producto.getCodigo();
            columna[1] = mantenedorMenuPrincipal.producto.getNombre();
            columna[2] = mantenedorMenuPrincipal.producto.getMarca();

            int precioVenta = Integer.parseInt(String.valueOf(mantenedorMenuPrincipal.producto.getPrecioVenta()));
            DecimalFormat formateador = new DecimalFormat("###,###");
            String ff1 = formateador.format(precioVenta);
            columna[3] = ff1;
            
            System.out.println("precio venta: " +columna[3]);

            double pesoFinal = Double.parseDouble(String.valueOf(peso_ingresado));
            String ff2 = String.valueOf(pesoFinal);
            columna[4] = ff2;

            double precioFinal = pesoFinal * mantenedorMenuPrincipal.producto.getPrecioVenta();
            int precFinalAux = (int) precioFinal;
            String ff3 = String.valueOf(formateador.format(precFinalAux));
            columna[5] = ff3;
            
            double costoFinal = pesoFinal * mantenedorMenuPrincipal.producto.getPrecioCompra();
            int costoFinalReal = (int) costoFinal;
            
            System.out.println("precio final: " +columna[5]);
            
            //Como es de peso se agrega un 0 en la lista cant y se agrega el peso a la lista peso.
            mantenedorMenuPrincipal.listaCantidad.add(0);
            mantenedorMenuPrincipal.precio.add(Integer.parseInt(String.valueOf(precioVenta)));
            mantenedorMenuPrincipal.codigo.add(String.valueOf(columna[0]));
            mantenedorMenuPrincipal.lista.add(precFinalAux);
            mantenedorMenuPrincipal.listaPeso.add(pesoFinal);
            mantenedorMenuPrincipal.listaCostos.add(costoFinalReal);
            
            modelo.addRow(columna);
            mantenedorMenuPrincipal.tbVenta.setModel(modelo);
            int w = modelo.getRowCount();
            if (w > 0) {
                mantenedorMenuPrincipal.btnCobrar.setEnabled(true);
                mantenedorMenuPrincipal.btnEliminarProducto.setEnabled(true);
                mantenedorMenuPrincipal.btnCambiarCantidad.setEnabled(true);
            } else {
                mantenedorMenuPrincipal.btnCobrar.setEnabled(false);
                mantenedorMenuPrincipal.btnEliminarProducto.setEnabled(false);
                mantenedorMenuPrincipal.btnCambiarCantidad.setEnabled(false);
            }
            
            
            mantenedorMenuPrincipal.limpiar();
            mantenedorMenuPrincipal.total = mantenedorMenuPrincipal.getTotal() + precFinalAux;
            mantenedorMenuPrincipal.cantidadProductos = mantenedorMenuPrincipal.cantidadProductos + 1;
            mantenedorMenuPrincipal.pesoTotalProductos = mantenedorMenuPrincipal.pesoTotalProductos + pesoFinal;
            mantenedorMenuPrincipal.costosTotales = mantenedorMenuPrincipal.costosTotales + costoFinalReal;
             
            String texto = String.valueOf(mantenedorMenuPrincipal.total);
            String f1 = formateador.format(Double.parseDouble(texto));

            mantenedorMenuPrincipal.lblTotal.setText(String.valueOf("$" + f1));
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Tiene " + peso_total + " Kg totales almacenados, no puede vender mas", "Problema de cantidad", JOptionPane.ERROR_MESSAGE);
        }
    
    }//GEN-LAST:event_btnOkPesoActionPerformed

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
            java.util.logging.Logger.getLogger(MantenedorAgregarPeso.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 





catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MantenedorAgregarPeso.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 





catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MantenedorAgregarPeso.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 





catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MantenedorAgregarPeso.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MantenedorAgregarPeso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarPeso;
    private javax.swing.JButton btnOkPeso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    protected javax.swing.JLabel lblMarcaProd;
    protected javax.swing.JLabel lblNombreProd;
    protected javax.swing.JLabel lblPesoTot;
    protected javax.swing.JLabel lblPrecioKg;
    protected javax.swing.JTextField txtPesoProd;
    // End of variables declaration//GEN-END:variables
}
