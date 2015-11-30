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
public class UsuarioDaoImpl implements UsuarioDao {

    private Connection con;
    private Statement st;

    @Override
    public boolean ingresar(Usuario usuario) {
        try {
            con = new Conectar().conexion();
            st = con.createStatement();
            Usuario usuario1 = new Usuario();
            usuario1 = usuario;
            String sql = "insert into usuario values(@idU,'@nombre','@clave','@cargo',@estado)";
            sql = sql.replaceAll("@idU", String.valueOf(usuario1.getIdUsuario()));
            sql = sql.replaceAll("@nombre", usuario1.getNombre());
            sql = sql.replaceAll("@clave", usuario1.getClave());
            sql = sql.replaceAll("@cargo", usuario1.getCargo());
            sql = sql.replaceAll("@estado", String.valueOf(usuario1.getEstado()));
            return st.execute(sql);
        } catch (Exception e) {

            System.err.println("Error al ingresar usuario: " + e);
            return false;
        }
    }

    @Override
    public boolean eliminar(Usuario usuario1) {
        try {
            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "delete from usuario where nombre='@usu'";
            sql = sql.replaceAll("@usu", usuario1.getNombre());

            return st.execute(sql);
        } catch (Exception e) {

            System.err.println("Error en el metodo eliminar usuario: " + e);
            return false;
        }
    }

    @Override
    public Usuario buscar(String nombre) {
        try {
            con = new Conectar().conexion();
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from usuario where nombre='" + nombre + "'");

            Usuario u = new Usuario();
            while (rs.next()) {
                u.setNombre(rs.getString("nombre"));
                u.setClave(rs.getString("clave"));
                u.setCargo(rs.getString("cargo"));
                u.setEstado(rs.getByte("estado"));
            }
            return u;
        } catch (Exception e) {
            System.err.print("Error al buscar el usuario: " + e);
            return null;
        }
    }

    public boolean actualizar(String nombre_viejo, String nombre, String clave, String cargo) {
        try {
            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "update usuario set nombre= '" + nombre + "',clave= '" + clave + "',cargo= '" + cargo + "' where nombre='" + nombre_viejo + "' ";
            return st.execute(sql);
        } catch (Exception e) {

            System.err.println("Error al actualizar el usuario " + e);
            return false;
        }
    }

    public boolean usuarioExiste(String nombre) {
        try {

            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "select usuario.nombre from usuario where nombre='" + nombre + "'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                return true;
            }
            return false;

        } catch (Exception e) {
            System.err.println("Error al veririfcar el nombre: " + e);
            return false;
        }
    }

    @Override
    public boolean activarUsuario(String nombre) {
        try {
            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "update usuario set estado=1 where nombre='" + nombre + "'";
            return st.execute(sql);
        } catch (Exception e) {
            System.out.println("Error en el metodo activar usuario: " + e);
            return false;
        }
    }

    @Override
    public boolean desactivarUsuario(String nombre) {
        try {
            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "update usuario set estado=0 where nombre='" + nombre + "'";
            return st.execute(sql);
        } catch (Exception e) {
            System.out.println("Error en el metodo activar usuario: " + e);
            return false;
        }
    }

    @Override
    public ResultSet todosUsuarios() {
        try {
            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "select usuario.nombre from usuario order by usuario.id_usuario asc;";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                return rs;
            } else {
                return null;
            }

        } catch (Exception e) {
            System.out.println("Error en el metodo traer nombre de todos los usuarios: " + e);
            return null;
        }
    }

    @Override
    public int idUsuario(String nombre) {
        try {
            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "select usuario.id_usuario from usuario where usuario.nombre='" + nombre + "'";
            ResultSet resultado = st.executeQuery(sql);
            if (resultado.next()) {
                int result = resultado.getInt("id_usuario");
                return result;
            } else {
                return -1;
            }

        } catch (Exception e) {
            System.out.println("Error en el metodo traer id del usuario: " + e);
            return -1;
        }
    }

    @Override
    public String nombreUsuario(int idUser) {
        try {
            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "select usuario.nombre from usuario where usuario.id_usuario = " + idUser + " ";
            ResultSet results;
            results = st.executeQuery(sql);
            if (results.next()) {
                String res = results.getString("nombre");
                return res;
            } else {
                return null;
            }

        } catch (Exception e) {
            System.out.println("Error en el metodo traer nombre de todos los usuarios: " + e);
            return null;
        }
    }

    @Override
    public byte estadoCaja(int idUser) {
        byte estado = 0;
        try {
            con = new Conectar().conexion();
            st = con.createStatement();
            String sql = "select estado from caja where id_usuario="+idUser+" and\n"
                    + "id_caja=(select max(id_caja) from caja);";
            ResultSet results;
            results = st.executeQuery(sql);
            if (results.next()) {
                estado = results.getByte("estado");
                System.out.println("Estado========>" + estado);
            }
            return estado;

        } catch (Exception e) {
            System.out.println("Error en el metodo obtener estado caja");
            return estado;
        }
    }

    @Override
    public ResultSet reportesVendedoresAsc(String fecha1, String fecha2) {
        try {
            con = new Conectar().conexion();
            st = con.createStatement();
            String sql = "select usuario.nombre as vendedor,count(ventas.id_venta) as ventasTotales,\n"
                    + "sum(((producto.precio_venta)-(producto.precio_compra))*(ventas_detalle.cant_producto)) as utilidadesTotales\n"
                    + "from usuario,ventas,ventas_detalle,producto,caja\n"
                    + "where ventas.id_venta = ventas_detalle.id_venta\n"
                    + "and ventas_detalle.id_producto = producto.id_producto\n"
                    + "and usuario.id_usuario = caja.id_usuario\n"
                    + "and caja.id_caja = ventas.id_caja\n"
                    + "and ventas.fecha between '" + fecha1 + "' and '" + fecha2 + "'\n"
                    + "group by vendedor order by ventasTotales asc;";
            ResultSet results;
            results = st.executeQuery(sql);
            if (results.next()) {
                return results;
            } else {
                System.out.println("Error en el metodo reportesVendedoresAsc");
                return null;
            }

        } catch (Exception e) {
            System.out.println("Error en el metodo reportesVendedoresAsc");
            return null;
        }
    }

    @Override
    public ResultSet reportesVendedoresDesc(String fecha1, String fecha2) {
        try {
            con = new Conectar().conexion();
            st = con.createStatement();
            String sql = "select usuario.nombre as vendedor,count(ventas.id_venta) as ventasTotales,\n"
                    + "sum(((producto.precio_venta)-(producto.precio_compra))*(ventas_detalle.cant_producto)) as utilidadesTotales\n"
                    + "from usuario,ventas,ventas_detalle,producto,caja\n"
                    + "where ventas.id_venta = ventas_detalle.id_venta\n"
                    + "and ventas_detalle.id_producto = producto.id_producto\n"
                    + "and usuario.id_usuario = caja.id_usuario\n"
                    + "and caja.id_caja = ventas.id_caja\n"
                    + "and ventas.fecha between '" + fecha1 + "' and '" + fecha2 + "'\n"
                    + "group by vendedor order by ventasTotales desc;";
            ResultSet results;
            results = st.executeQuery(sql);
            if (results.next()) {
                return results;
            } else {
                System.out.println("Error en el metodo reportesVendedoresDesc");
                return null;
            }

        } catch (Exception e) {
            System.out.println("Error en el metodo reportesVendedoresDesc");
            return null;
        }

    }

    @Override
    public ResultSet reportesVendedoresHorasAsc(String fecha1, String fecha2) {
        try {
            con = new Conectar().conexion();
            st = con.createStatement();
            String sql = "select usuario.nombre as vendedor,\n"
                    + "count(caja.id_caja) as diasTrabajados,\n"
                    + "sec_to_time(sum(time_to_sec(caja.hora_termino)-time_to_sec(caja.hora_inicio))) as horasTrabajadas\n"
                    + "from usuario,caja\n"
                    + "where usuario.id_usuario = caja.id_usuario\n"
                    + "and caja.fecha between '" + fecha1 + "' and '" + fecha2 + "'\n"
                    + "group by caja.id_usuario order by diasTrabajados asc;";
            ResultSet results;
            results = st.executeQuery(sql);
            if (results.next()) {
                return results;
            } else {
                System.out.println("Error en el metodo reportesVendedoresHorasAsc");
                return null;
            }

        } catch (Exception e) {
            System.out.println("Error en el metodo reportesVendedoresHorasAsc");
            return null;
        }
    }

    @Override
    public ResultSet reportesVendedoresHorasDesc(String fecha1, String fecha2) {
        try {
            con = new Conectar().conexion();
            st = con.createStatement();
            String sql = "select usuario.nombre as vendedor,\n"
                    + "count(caja.id_caja) as diasTrabajados,\n"
                    + "sec_to_time(sum(time_to_sec(caja.hora_termino)-time_to_sec(caja.hora_inicio))) as horasTrabajadas\n"
                    + "from usuario,caja\n"
                    + "where usuario.id_usuario = caja.id_usuario\n"
                    + "and caja.fecha between '" + fecha1 + "' and '" + fecha2 + "'\n"
                    + "group by caja.id_usuario order by diasTrabajados desc;";
            ResultSet results;
            results = st.executeQuery(sql);
            if (results.next()) {
                return results;
            } else {
                System.out.println("Error en el metodo reportesVendedoresHorasDesc");
                return null;
            }

        } catch (Exception e) {
            System.out.println("Error en el metodo reportesVendedoresHorasDesc");
            return null;
        }
    }
}
