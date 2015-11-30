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
public class Producto {
    
    private int idProducto;
    private String codigo;
    private String marca;
    private String nombre;
    private int cantidad;
    private double peso ;
    private int precioCompra;
    private int precioVenta;
    private int cant_o_peso;

    public Producto() {
        cantidad = 0 ;
        peso = 0.0;
    }
    
    public Producto(String nombre){
    this.nombre = nombre;
    }

    public Producto(int idProducto, String codigo, String marca, String nombre, int cantidad, double peso, int precioCompra, int precioVenta, int cant_o_peso) {
        this.idProducto = idProducto;
        this.codigo = codigo;
        this.marca = marca;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.peso = peso;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.cant_o_peso = cant_o_peso;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
        
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
   
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(int precioCompra) {
        this.precioCompra = precioCompra;
    }

    public int getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }
    
    public int getCant_o_Peso() {
        return cant_o_peso;
    }

    public void setCant_o_Peso(int cant_o_peso) {
        this.cant_o_peso = cant_o_peso;
    }
    
}
