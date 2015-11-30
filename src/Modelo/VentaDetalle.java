/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

/**
 *
 * @author cristian
 */
public class VentaDetalle {
 
    private int idVenta;
    private int idProducto;
    private int cantidadProductos;
    private int subTotal;
    private Double pesoTotal;

    public VentaDetalle() {
    }

    public VentaDetalle(int idVenta, int idProducto, int cantidadProductos, int subTotal, Double pesoTotal) {
        this.idVenta = idVenta;
        this.idProducto = idProducto;
        this.cantidadProductos = cantidadProductos;
        this.subTotal = subTotal;
        this.pesoTotal = pesoTotal;
    }
            
    public int getIdVenta() {
        return idVenta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public int getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(int subTotal) {
        this.subTotal = subTotal;
    }
    
    public Double getPesoTotal() {
        return pesoTotal;
    }

    public void setPesoTotal(Double pesoTotal) {
        this.pesoTotal = pesoTotal;
    }
    
}
