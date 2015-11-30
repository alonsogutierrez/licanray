/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Conexion.Conectar;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author cristian
 */
public class LoginDaoImpl implements LoginDao {

    private Connection con;
    private Statement st;

    @Override
    public String ingresar(String nombre, String clave, String hora) {
        try {
            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "select * from usuario where nombre='" + nombre + "' and clave='" + clave + "'";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                licanray.LicanRay.usuario.setNombre(rs.getString("nombre"));
                licanray.LicanRay.usuario.setClave(rs.getString("clave"));
                licanray.LicanRay.usuario.setIdUsuario(rs.getInt("id_usuario"));
                licanray.LicanRay.usuario.setCargo(rs.getString("cargo"));
                licanray.LicanRay.caja.setHora(hora);

            }
            String cargo = licanray.LicanRay.usuario.getCargo();
            return cargo;

        } catch (Exception e) {
            System.out.println("Error en el metodo ingresar: " + e);
            return null;
        }
    }

    @Override
    public byte verificarEstado(String nombre) {
        try {
            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "select estado from usuario where nombre='" + nombre + "'";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                licanray.LicanRay.usuario.setEstado(rs.getByte("estado"));
            }
            return licanray.LicanRay.usuario.getEstado();

        } catch (Exception e) {
            System.out.println("Error en verificar estado: " + e);
            return 0;
        }
    }

}
