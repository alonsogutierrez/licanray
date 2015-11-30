/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author cristian
 */
public class RetiroDinero {
    
    private int idRetiroDinero;
    private int dineroRetiro;
    private Date fechaHora;
    private Caja caja ;

    public RetiroDinero() {
    }

    public RetiroDinero(int idRetiroDinero, int dineroRetiro, Date fechaHora, Caja caja) {
        this.idRetiroDinero = idRetiroDinero;
        this.dineroRetiro = dineroRetiro;
        this.fechaHora = fechaHora;
        this.caja = caja;
    }

    public int getIdRetiroDinero() {
        return idRetiroDinero;
    }

    public void setIdRetiroDinero(int idRetiroDinero) {
        this.idRetiroDinero = idRetiroDinero;
    }

    public int getDineroRetiro() {
        return dineroRetiro;
    }

    public void setDineroRetiro(int dineroRetiro) {
        this.dineroRetiro = dineroRetiro;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Caja getCaja() {
        return caja;
    }

    public void setCaja(Caja caja) {
        this.caja = caja;
    }   
}
