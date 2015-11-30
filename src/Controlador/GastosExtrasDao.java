/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.GastosExtras;
import Modelo.Usuario;
import java.sql.ResultSet;

/**
 *
 * @author cristian
 */
public interface GastosExtrasDao {
    public void ingresarGasto(GastosExtras gastos, int idCaja);
    public ResultSet gastosPorFecha(String fecha1, String fecha2);
    public ResultSet gastosPorUsuario(int idUsuario);
    public ResultSet gastosUsuarioYFecha(String fecha1, String fecha2, int idUsuario);
    public int gastosCaja (int idCaja);
}
