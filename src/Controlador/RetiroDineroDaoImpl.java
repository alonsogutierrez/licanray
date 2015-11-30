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
public class RetiroDineroDaoImpl implements RetiroDineroDao {

    private Connection con;
    private Statement st;

    @Override
    public boolean retiroDinero(int iduser, int retiroDinero) {
        try {

            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "call `licanRay`.`sp_retiro_dinero` ("+iduser+","+retiroDinero+")";
            st.execute(sql);
            con.close();
            return true;
        } catch (Exception e) {
            System.err.println("Error metodo retiroDinero: " + e);
            return false;
        }
    }

    @Override
    public int dineroActual(int id_user) {

        try {
            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "select dinero from caja where id_usuario = " + id_user + " and estado= 1;";

            ResultSet rs = st.executeQuery(sql);
            Caja caja = new Caja();
            while (rs.next()) {
                caja.setDinero(rs.getInt("dinero"));
            }

            con.close();
            st.close();
            return caja.getDinero();

        } catch (Exception e) {

            System.err.println("Error metodo dineroActual: " + e);
            return -1;

        }
    }
}
