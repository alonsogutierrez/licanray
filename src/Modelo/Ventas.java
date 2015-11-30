/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;

/**
 *
 * @author cristian
 */
public class Ventas {

    int idVenta;
    int total;
    int cant_productos;
    int id_caja;
    String fecha;
    String hora;
    Double peso_total_prod;
    int costo_total;

    public Ventas() {

    }

    public Ventas(int idVenta, int id_caja, int total, int cant_productos, String fecha,String hora,Double peso_total_prod, int costo_total) {
        this.idVenta = idVenta;
        this.id_caja = id_caja;
        this.total = total;
        this.cant_productos = cant_productos;
        this.fecha = fecha;
        this.hora = hora;
        this.peso_total_prod = peso_total_prod;
        this.costo_total = costo_total;

    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCant_productos() {
        return cant_productos;
    }

    public void setCant_productos(int cant_productos) {
        this.cant_productos = cant_productos;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId_caja() {
        return id_caja;
    }

    public void setId_caja(int id_caja) {
        this.id_caja = id_caja;
    }
    
    public Double getPesoTotalProds() {
        return peso_total_prod;
    }

    public void setPesoTotalProds(Double peso_total_prods) {
        this.peso_total_prod = peso_total_prods;
    }
    
    public int getCostoTotal() {
        return costo_total;
    }

    public void setCostoTotal(int costo_total) {
        this.costo_total = costo_total;
    }
    

}
