/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Conexion.Conectar;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author alonso
 */
public class ConfiguracionDaoImpl implements ConfiguracionDao {

    private Connection con;
    private Statement st;

    @Override
    public boolean actualizarProdMin(int cantProd) {
        try {

            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "update configuracion set cant_prod_min=" + cantProd + " where configuracion.idconfiguracion=0";

            boolean resp = st.execute(sql);
            return resp;

        } catch (Exception e) {
            System.out.println("Error en el metodo actualizar cant min prod de config: " + e);
            return false;
        }
    }

    @Override
    public boolean actualizarDineroMin(int cantDin) {
        try {

            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "update configuracion set cant_din_min=" + cantDin + " where configuracion.idconfiguracion=0";

            boolean resp = st.execute(sql);
            return resp;

        } catch (Exception e) {
            System.out.println("Error en el metodo actualizar cant min din de config: " + e);
            return false;
        }
    }

    @Override
    public int CantProdMin() {
        try {

            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "select configuracion.cant_prod_min from configuracion where configuracion.idconfiguracion=0";

            ResultSet rs = st.executeQuery(sql);
            int res = 0;

            while (rs.next()) {
                res = rs.getInt(1);
            }

            return res;

        } catch (Exception e) {
            System.out.println("Error en el metodo devovler cant min prod de config: " + e);
            return -1;

        }
    }

    @Override
    public int CantDineroMin() {
        try {

            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "select configuracion.cant_din_min from configuracion where configuracion.idconfiguracion=0";

            ResultSet rs = st.executeQuery(sql);
            int res = 0;

            while (rs.next()) {
                res = rs.getInt(1);
            }

            return res;

        } catch (Exception e) {
            System.out.println("Error en el metodo devovler cant min prod de config: " + e);
            return -1;

        }
    }

    

    

}
