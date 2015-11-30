/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.RetiroDinero;
import java.util.Date;

/**
 *
 * @author cristian
 */
public interface RetiroDineroDao {
    public boolean retiroDinero(int idUser,int retiroDinero);
    public int dineroActual(int id_user);
}
