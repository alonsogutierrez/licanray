/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.Caja;
import java.sql.ResultSet;
import java.util.Date;

/**
 *
 * @author cristian
 */
public interface CajaDao {
    public void actualizarCaja(int dinero, int idCaja);
    public int dineroActualCaja(int idUsuario);
    public void inicioCaja(Caja caja, int idU);
    public int idCaja(int idUsuario);
    public int dineroInicio(int idCaja);
    public int totalVentas(int idCaja);
    public Date obtenerFecha(int idUsuario, byte estado);
    public String obtenerHora(int idUsuario, byte estado);
    public int totalRetiros(int idCaja);
    public int utilidadCaja(int idCaja);
    public void cerrarCaja(int totalVentas, int totalGastos, int idCaja);
    public ResultSet obtenerVenta(int idVenta);
    public int obtenerTotalVenta(int idVenta);
    public String obtenerFechaVenta(int idVenta);
    public String obtenerVendedorVenta(int idVenta);
    public int obtenerTotalGastosExtras(int idCaja);
    
}
