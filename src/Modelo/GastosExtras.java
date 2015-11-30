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
public class GastosExtras {
    int id_gasto;
    int total;
    String fecha;
    String hora;
    String motivo;

    public GastosExtras() {
    }

    
    public GastosExtras(int id_gasto, int total, String fecha, String hora, String motivo) {
        this.id_gasto = id_gasto;
        this.total = total;
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
    }
    
    public GastosExtras(int id_gasto, int total, String motivo) {
        this.id_gasto = id_gasto;
        this.total = total;
        this.motivo = motivo;
    }
    

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    

    public int getId_gasto() {
        return id_gasto;
    }

    public void setId_gasto(int id_gasto) {
        this.id_gasto = id_gasto;
    }
    
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    
    
}
