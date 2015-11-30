/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author cristian
 */
public class Conectar {
    
    private Connection con = null;
    private String baseDeDatos="licanRay";
        
    public Conectar(){

 }
    public Connection conexion() throws Exception{
        try {
              String user = "root";

              String pass = "admin"; 

              String url = "jdbc:mysql://localhost:3306/"+baseDeDatos;

              Class.forName("com.mysql.jdbc.Driver").newInstance();

              con = DriverManager.getConnection(url,user,pass);
            }
            catch (SQLException sqle)
                  {
                       System.out.println("Error SQL.....conexion" +sqle);
                  }

        if ( con != null )
            System.out.println("Se ha establecido una conexión a la base de datos ");

     return con;
    }

    public void cerrarConexion()
    {
        try
            {
                if(con != null)
                {
                    con.close();
                }

            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Problemas con la conexión", JOptionPane.ERROR_MESSAGE);
            }
        }
    
}
