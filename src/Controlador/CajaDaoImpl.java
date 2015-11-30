/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Conexion.Conectar;
import Modelo.Caja;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

/**
 *
 * @author cristian
 */
public class CajaDaoImpl implements CajaDao {

    private Connection con;
    private Statement st;

    @Override
    public void actualizarCaja(int dinero, int idCaja) {
        try {
            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "update caja set dinero= " + dinero + " where id_caja=" + idCaja + ";";

            st.executeUpdate(sql);
        } catch (Exception e) {

            System.err.println("Error al actualizar la cantidad del producto: " + e);

        }
    }

    @Override
    public int dineroActualCaja(int id_user) {
        try {
            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "select caja.dinero from caja where id_usuario=" + id_user + " and estado=1";

            ResultSet rs = st.executeQuery(sql);
            Caja caja = new Caja();
            while (rs.next()) {
                caja.setDinero(rs.getInt("dinero"));
            }

            return caja.getDinero();

        } catch (Exception e) {

            System.err.println("Error al obtener el dinero de la caja: " + e);
            return 0;

        }
    }

    @Override
    public void inicioCaja(Caja caja, int idU) {
        try {
            con = new Conectar().conexion();
            st = con.createStatement();
            String sql = "insert into caja values(@idC,@idU,@din,curdate(),'@hor',@a, 0, 0,@e)";
            sql = sql.replaceAll("@idC", String.valueOf(caja.getId_caja()));
            sql = sql.replaceAll("@idU", String.valueOf(idU));
            sql = sql.replaceAll("@din", String.valueOf(caja.getDinero()));
            //sql = sql.replaceAll("@fech",caja.getFecha().toString());
            sql = sql.replaceAll("@hor", caja.getHora());
            sql = sql.replaceAll("@a", String.valueOf(caja.getDinero_inicial()));
            sql = sql.replaceAll("@e", String.valueOf(caja.getEstado()));

            st.execute(sql);
            System.err.println("dinero inicia: " + caja.getDinero_inicial());

        } catch (Exception e) {
            System.err.println("Error al ingresar el dinero: " + e);
        }

    }

    @Override
    public int idCaja(int idUsuario) {
        try {
            con = new Conectar().conexion();
            st = con.createStatement();
            String sql = "select id_caja from caja where id_usuario = "+idUsuario+" and estado= 1 and\n"
                    + "id_caja = (select max(id_caja) from caja)";

            ResultSet rs = st.executeQuery(sql);
            int idCaja = 0;
            while (rs.next()) {
                idCaja = rs.getInt("id_caja");
            }

            return idCaja;

        } catch (Exception e) {

            System.err.println("Error al obtener el dinero de la caja: " + e);
            return 0;

        }
    }

    @Override
    public int dineroInicio(int idCaja) {
        try {
            con = new Conectar().conexion();
            st = con.createStatement();
            String sql = "SELECT dinero_inicio FROM licanRay.caja where id_caja=" + idCaja + " and estado= 1;";

            ResultSet rs = st.executeQuery(sql);
            int dineroInicio = 0;
            while (rs.next()) {
                dineroInicio = rs.getInt("dinero_inicio");
            }

            return dineroInicio;

        } catch (Exception e) {

            System.err.println("Error al obtener el dinero de la caja: " + e);
            return 0;

        }
    }

    @Override
    public int totalVentas(int idCaja) {
        int totalVentas = 0;
        try {
            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "select sum(total) as total from ventas where id_caja = " + idCaja + "";

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                totalVentas = rs.getInt("total");
            }
            return totalVentas;

        } catch (Exception e) {

            System.err.println("Error metodo totalVentas: " + e);
            return totalVentas;

        }
    }

    @Override
    public Date obtenerFecha(int idUsuario, byte estado) {
        Date fecha = null;
        try {
            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "select fecha from caja where id_usuario = " + idUsuario + " and estado= " + estado + ";";

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                fecha = rs.getDate("fecha");
            }
            return fecha;
        } catch (Exception e) {
            System.out.println("Error al obtener la fecha: " + e);
            return fecha;
        }
    }

    @Override
    public String obtenerHora(int idUsuario, byte estado) {
        String fecha = null;
        try {
            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "select fecha from caja where id_usuario = " + idUsuario + " and estado= " + estado + ";";

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                fecha = rs.getString("fecha");
            }
            return fecha;
        } catch (Exception e) {
            System.out.println("Error al obtener la fecha: " + e);
            return fecha;
        }
    }

    @Override
    public int totalRetiros(int idCaja) {
        int dinero = 0;
        try {
            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "select sum(dinero_retiro) as dinero from retiro_dinero where id_caja=" + idCaja + ";";

            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                dinero = rs.getInt("dinero");
            }

            con.close();
            st.close();
            return dinero;
        } catch (Exception e) {
            System.out.println("Error en el metodo totalRetiros: " + e);
            return dinero;
        }
    }

    @Override
    public int utilidadCaja(int idCaja) {
        int utilidad = 0;
        try {

            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "call `licanRay`.`sp_utilidadCaja` (" + idCaja + ")";

            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                utilidad = rs.getInt("utilidad");
            }
            con.close();
            return utilidad;
        } catch (Exception e) {
            System.err.println("Error metodo retiroDinero: " + e);
            return utilidad;
        }
    }

    @Override
    public void cerrarCaja(int totalVentas, int totalGastos, int idCaja) {
        try {

            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "call `licanRay`.`sp_cerrarCaja` (" + totalVentas + "," + totalGastos + "," + idCaja + ")";
            st.execute(sql);
            con.close();

        } catch (Exception e) {
            System.err.println("Error metodo cerrarCaja: " + e);

        }
    }

    @Override
    public ResultSet obtenerVenta(int idVenta) {
        try {
            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "call `licanRay`.`sp_obtenerVenta` (" + idVenta + ")";
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                return rs;
            } else {
                return null;
            }

        } catch (Exception e) {
            System.out.println("Error en el metodo Obtener Venta: " + e);
            return null;
        }
    }

    @Override
    public int obtenerTotalVenta(int idVenta) {
        int total = 0;
        try {
            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "call `licanRay`.`sp_obtenerTotalVenta` (" + idVenta + ")";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt("total");
            }
            return total;
        } catch (Exception e) {
            System.out.println("Error en el metodo Obtener Total Venta: " + e);
            return total;
        }
    }

    @Override
    public String obtenerFechaVenta(int idVenta) {
        String dia = "";
        String mes = "";
        byte numero = 0;
        short anio = 0;

        try {
            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "call `licanRay`.`obtenerFechaVenta` (" + idVenta + ")";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                dia = rs.getString("nombre_dia");
                mes = rs.getString("mes");
                numero = rs.getByte("dia");
                anio = rs.getShort("anio");
            }
            return dia + "-" + mes + "-" + numero + "-" + anio;
        } catch (Exception e) {
            System.out.println("Error en el metodo Obtener Fecha Venta: " + e);
            return dia + mes + numero + anio;
        }
    }

    @Override
    public String obtenerVendedorVenta(int idVenta) {
        String vendedor = "";
        try {
            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "call `licanRay`.`obtenerVendedorVenta`(" + idVenta + ")";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                vendedor = rs.getString("vendedor");
            }
            return vendedor;
        } catch (Exception e) {
            System.out.println("Error en el metodo Obtener Vendedor Venta: " + e);
            return vendedor;
        }
    }

    @Override
    public int obtenerTotalGastosExtras(int idCaja) {
        try {
            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "select caja.Total_gastos_extras as gastosTotales\n"
                    + "from caja\n"
                    + "where caja.id_caja = " + idCaja + ";";
            ResultSet rs = st.executeQuery(sql);
            int res = 0;
            while (rs.next()) {
                res = rs.getInt("gastosTotales");
            }

            return res;
        } catch (Exception e) {
            System.out.println("Error en el metodo Obtener totalGastosExtras: " + e);
            return -1;
        }
    }
}
