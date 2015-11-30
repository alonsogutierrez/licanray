/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Conexion.Conectar;
import Modelo.GastosExtras;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author cristian
 */
public class GastosExtrasDaoImpl implements GastosExtrasDao {
    
    private Connection con ;
    private Statement st ;
    
    @Override
    public void ingresarGasto(GastosExtras gastos, int idCaja)
    {
         try {
                con = new Conectar().conexion();
                st = con.createStatement();
                
                String sql = "insert into gastos_extras values (@idG, @total, curdate(),CURTIME(), '@motivo', @idC)";
                sql = sql.replaceAll("@idG", String.valueOf(gastos.getId_gasto()));
                sql = sql.replaceAll("@total", String.valueOf(gastos.getTotal()));
                sql = sql.replaceAll("@motivo", gastos.getMotivo());
                sql = sql.replaceAll("@idC", String.valueOf(idCaja));
                
                st.executeUpdate(sql);
                
            
        } catch (Exception e) {
            System.out.println("Error en el metodo ingresar gastos: " +e);
            
        }
    }
    
    @Override
    public ResultSet gastosPorFecha(String fecha1, String fecha2) {
        try {
            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "select usuario.nombre, DATE_FORMAT(gastos_extras.fecha,'%d/%m/%Y') as fecha, gastos_extras.motivo, gastos_extras.total\n"
                    + " from gastos_extras, usuario, caja where gastos_extras.id_caja = caja.id_caja\n"
                    + "and caja.id_usuario = usuario.id_usuario and\n"
                    + "gastos_extras.fecha between '" + fecha1 + "' and '" + fecha2 + "' \n"
                    + "order by gastos_extras.fecha asc;";
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                return rs;
            } else {
                return null;
            }

        } catch (Exception e) {
            System.out.println("Error en el metodo gastos por fecha: " + e);
            return null;
        }

    }

    @Override
    public ResultSet gastosPorUsuario(int idUsuario) {
        try {
            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "select usuario.nombre, DATE_FORMAT(gastos_extras.fecha,'%d/%m/%Y') as fecha, gastos_extras.motivo, gastos_extras.total\n"
                    + " from gastos_extras, usuario, caja where gastos_extras.id_caja = caja.id_caja\n"
                    + "and caja.id_usuario = usuario.id_usuario and\n"
                    + "usuario.id_usuario = "+idUsuario+" \n"
                    + "order by gastos_extras.fecha asc;";
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                return rs;
            } else {
                return null;
            }

        } catch (Exception e) {
            System.out.println("Error en el gastos por usuario: " + e);
            return null;
        }
    }

    @Override
    public ResultSet gastosUsuarioYFecha(String fecha1, String fecha2, int idUsuario) {
        try {

            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "select usuario.nombre, DATE_FORMAT(gastos_extras.fecha,'%d/%m/%Y') as fecha, gastos_extras.motivo, gastos_extras.total\n"
                    + "from usuario, gastos_extras, caja\n"
                    + "where usuario.id_usuario = caja.id_usuario and caja.id_caja = gastos_extras.id_caja\n"
                    + "and usuario.id_usuario = "+idUsuario+" and\n"
                    + "gastos_extras.fecha between '"+fecha1+"' and '"+fecha2+"'\n"
                    + "order by gastos_extras.fecha asc;";

            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                return rs;
            } else {
                return null;
            }

        } catch (Exception e) {
            System.out.println("Error en el metodo gastos por usuario y fecha: " + e);
            return null;
        }
    }

    @Override
    public int gastosCaja(int idCaja) {
        int total = 0;
        try {
            
            con = new Conectar().conexion();
            st = con.createStatement();
            
                String sql = "call `licanRay`.`gastosExtrasCaja` ("+idCaja+")";
                
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                    total = rs.getInt("total");
                }  
                con.close();
                return total;            
        } catch (Exception e) {
            System.err.println("Error metodo gastosCaja: " + e);
            return total;
        }
    }
}
