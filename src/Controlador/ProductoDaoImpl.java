/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Conexion.Conectar;
import Modelo.Caja;
import Modelo.Producto;
import Modelo.VentaDetalle;
import Modelo.Ventas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static licanray.LicanRay.usuario;

/**
 *
 * @author cristian
 */
public class ProductoDaoImpl implements ProductoDao {

    private Connection con;
    private Statement st;

    @Override
    public int guardar1(Producto producto) {
        //Metodo para guardar los productos en la base de datos 
        try {
            con = new Conectar().conexion();
            st = con.createStatement();
            String sql = "insert into producto values(@idp,'@cod','@marc','@nom',@cant,@pe,@preC,@preV,@tipoProd)";
            sql = sql.replaceAll("@idp", String.valueOf(producto.getIdProducto()));
            sql = sql.replaceAll("@cod", producto.getCodigo());
            sql = sql.replaceAll("@marc", producto.getMarca());
            sql = sql.replaceAll("@nom", producto.getNombre());
            sql = sql.replaceAll("@cant", String.valueOf(producto.getCantidad()));
            sql = sql.replaceAll("@pe", String.valueOf(producto.getPeso()));
            sql = sql.replaceAll("@preC", String.valueOf(producto.getPrecioCompra()));
            sql = sql.replaceAll("@preV", String.valueOf(producto.getPrecioVenta()));
            sql = sql.replaceAll("@tipoProd", String.valueOf(producto.getCant_o_Peso()));
            return st.executeUpdate(sql);
        } catch (Exception e) {

            System.err.println("Error al guardar producto " + e);
            return 0;
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public boolean verificarProducto(String codigo) {
        //Metodo que verifica si existen productos en la base de datos 
        try {

            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "select producto.codigo from producto where codigo='" + codigo + "'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                return true;
            }
            return false;

        } catch (Exception e) {
            System.err.println("Error en el metodo verificar: " + e);
            return false;
        }
    }

    @Override
    public int actualizar(String marca, String nombre, int cantidad, double peso, int precioCompra, int precioVenta, String codigo) {
        //Metodo para actualizar los atributos de un producto (update).
        try {
            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "update producto set marca= '" + marca + "',nombre= '" + nombre + "',cantidad= " + cantidad + ", peso= " + peso + ","
                    + "precio_compra=" + precioCompra + ", precio_venta=" + precioVenta + " where codigo='" + codigo + "' ";

            return st.executeUpdate(sql);
        } catch (Exception e) {

            System.err.println("Error al actualizar producto " + e);
            return 0;
        }
    }

    @Override
    public byte eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Producto buscarNombre(String codigo) {
        //Metodo para buscar un producto por su codigo.
        try {
            con = new Conectar().conexion();
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from producto where codigo='" + codigo + "'");

            Producto producto = new Producto();
            while (rs.next()) {
                producto.setMarca(rs.getString("marca"));
                producto.setNombre(rs.getString("nombre"));
                producto.setCantidad(rs.getInt("cantidad"));
                producto.setPeso(rs.getDouble("peso"));
                producto.setPrecioCompra(rs.getInt("precio_compra"));
                producto.setPrecioVenta(rs.getInt("precio_venta"));
                producto.setCant_o_Peso(rs.getInt("cant_o_peso"));
            }

            if (producto.getPrecioCompra() == 0) {
                JOptionPane.showMessageDialog(null, "Producto no existe", "Codigo no existe", JOptionPane.ERROR_MESSAGE);
            }

            return producto;
        } catch (Exception e) {
            System.err.print("Error al buscar " + e);
            return null;
        }
    }

    @Override
    public Producto agregarProductoALaVenta(String codigo) {
        //Metodo para agregar un producto a la venta.
        try {
            con = new Conectar().conexion();
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from producto where codigo='" + codigo + "'");
            Producto producto = new Producto();
            while (rs.next()) {
                producto.setCodigo(rs.getString("codigo"));
                producto.setNombre(rs.getString("nombre"));
                producto.setMarca(rs.getString("marca"));
                producto.setPeso(rs.getDouble("peso"));
                producto.setPrecioVenta(rs.getInt("precio_venta"));
                producto.setPrecioCompra(rs.getInt("precio_compra"));
                producto.setCant_o_Peso(rs.getInt("cant_o_peso"));
            }
            return producto;
        } catch (Exception e) {
            System.err.print("Error al buscar " + e);
            return null;
        }
    }

    @Override
    public int verificarCantidad(String codigo) {
        //Metodo que verifica si existen productos en la base de datos 
        try {

            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "select producto.cantidad from producto where codigo='" + codigo + "'";
            ResultSet rs = st.executeQuery(sql);
            Producto producto = new Producto();
            while (rs.next()) {
                producto.setCantidad(rs.getInt("cantidad"));
            }

            return producto.getCantidad();

        } catch (Exception e) {
            System.err.println("Error en el metodo verificar cantidad: " + e);
            return 0;
        }
    }

    @Override
    public int ventaProducto(Ventas ventas, int idCaja) {

        try {

            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "insert into ventas values (@idV,"+ idCaja +",@total,@cantP,'@fech','@hora', @pesoTotal, @costoTotal)";
            sql = sql.replaceAll("@idV", String.valueOf(ventas.getIdVenta()));
            sql = sql.replaceAll("@total", String.valueOf(ventas.getTotal()));
            sql = sql.replaceAll("@cantP", String.valueOf(ventas.getCant_productos()));
            sql = sql.replaceAll("@fech", String.valueOf(ventas.getFecha()));
            sql = sql.replaceAll("@hora", String.valueOf(ventas.getHora()));
            sql = sql.replaceAll("@pesoTotal", String.valueOf(ventas.getPesoTotalProds()));
            sql = sql.replaceAll("@costoTotal", String.valueOf(ventas.getCostoTotal()));

            return st.executeUpdate(sql);

        } catch (Exception e) {
            System.err.println("Error al insertar la venta del producto: " + e);
            return 0;
        }

    }

    @Override
    public int detalleVenta(VentaDetalle ventaDetalle) {
        try {

            con = new Conectar().conexion();
            st = con.createStatement();
            String sql = "insert into ventas_detalle values(@idV, @CodProd, @cant, @subT, @pesoProd)";
            sql = sql.replaceAll("@idV", String.valueOf(ventaDetalle.getIdVenta()));
            sql = sql.replaceAll("@CodProd", String.valueOf(ventaDetalle.getIdProducto()));
            sql = sql.replaceAll("@cant", String.valueOf(ventaDetalle.getCantidadProductos()));
            sql = sql.replaceAll("@subT", String.valueOf(ventaDetalle.getSubTotal()));
            sql = sql.replaceAll("@pesoProd", String.valueOf(ventaDetalle.getPesoTotal()));

            return st.executeUpdate(sql);
        } catch (Exception e) {
            System.err.println("Error al insertar el detalle Venta: " + e);
            return 0;
        }
    }

    @Override
    public int idUltimaVenta() {
        try {
            con = new Conectar().conexion();
            st = con.createStatement();
            String sql = "select ventas.id_venta from ventas where id_venta= (select MAX(id_venta)from ventas)";
            ResultSet rs = st.executeQuery(sql);
            Ventas ventas = new Ventas();
            while (rs.next()) {
                ventas.setIdVenta(rs.getInt("id_venta"));
            }

            return ventas.getIdVenta();

        } catch (Exception e) {
            System.err.println("Error al obtener el ultimo id: " + e);
            return 0;
        }
    }

    @Override
    public Double verificarPeso(String codigo) {
        try {
            con = new Conectar().conexion();
            st = con.createStatement();
            String sql = "select producto.peso from producto where producto.codigo = '" + codigo + "'";
            ResultSet rs = st.executeQuery(sql);
            Double peso = 0.0;
            while (rs.next()) {
                peso = rs.getDouble("peso");

            }
            return peso;

        } catch (Exception e) {
            System.err.println("Error al obtener el ultimo id: " + e);
            return -1.1;
        }
    }

    @Override
    public int idProducto(String codigo) {
        try {
            con = new Conectar().conexion();
            st = con.createStatement();
            String sql = "select producto.id_producto from producto where codigo='" + codigo + "' ";
            ResultSet rs = st.executeQuery(sql);
            Producto producto = new Producto();
            while (rs.next()) {
                producto.setIdProducto(rs.getInt("id_producto"));
            }

            return producto.getIdProducto();

        } catch (Exception e) {
            System.err.println("Error al obtener el id del producto: " + e);
            return 0;
        }
    }

    @Override
    public void actualizaCantidad(int cantidad, String codigo) {
        try {
            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "update producto set cantidad= " + cantidad + " where codigo='" + codigo + "' ";

            st.executeUpdate(sql);
        } catch (Exception e) {

            System.err.println("Error al actualizar la cantidad del producto: " + e);

        }
    }

    @Override
    public void actualizaPeso(Double peso, String codigo) {
        try {
            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "update producto set peso= " + peso + " where codigo='" + codigo + "' ";

            st.executeUpdate(sql);
        } catch (Exception e) {

            System.err.println("Error al actualizar el peso del producto: " + e);

        }
    }

    @Override
    public String devuelveNombre(String codigo) {
        try {
            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "select producto.nombre from producto where codigo='" + codigo + "' ";
            ResultSet rs = st.executeQuery(sql);
            Producto p = new Producto();
            while (rs.next()) {
                p.setNombre(rs.getString("nombre"));
            }

            return p.getNombre();

        } catch (Exception e) {

            System.err.println("Error al retornar el nombre del producto: " + e);
            return null;
        }
    }

    @Override
    public ResultSet productosMasVendidosUnidadFechas(String fecha1, String fecha2, String fecha3, String fecha4) {
        try {
            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "select producto.codigo, producto.nombre, producto.marca, producto.precio_compra,\n"
                    + "producto.precio_venta, ((producto.precio_venta)-(producto.precio_compra)) as utilidadUnitaria,\n"
                    + "sum(ventas_detalle.cant_producto) as cantVendida, \n"
                    + "sum(ventas_detalle.peso_producto) as pesoVendido,\n"
                    + "(((producto.precio_venta)-(producto.precio_compra)) * sum(ventas_detalle.cant_producto)) as utilidadFinal,\n"
                    + "(select sum(ventas_detalle.cant_producto) from producto, ventas, ventas_detalle\n"
                    + "where producto.id_producto = ventas_detalle.id_producto and\n"
                    + "ventas.id_venta = ventas_detalle.id_venta and \n"
                    + "ventas.fecha between '" + fecha3 + "' and '" + fecha4 + "')  as cantPAnt\n"
                    + "from producto, ventas, ventas_detalle\n"
                    + "where producto.id_producto = ventas_detalle.id_producto \n"
                    + "and ventas.id_venta = ventas_detalle.id_venta\n"
                    + "and producto.cant_o_peso = 1\n"
                    + "and ventas.fecha between '" + fecha1 + "' and '" + fecha2 + "'\n"
                    + "group by producto.codigo order by sum(ventas_detalle.cant_producto) desc;";

            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                return rs;
            } else {
                return null;
            }

        } catch (Exception e) {

            System.err.println("Error al retornar la consulta de productos por fecha: " + e);
            return null;
        }
    }

    @Override
    public ResultSet productosMenosVendidosUnidadFechas(String fecha1, String fecha2, String fecha3, String fecha4) {
        try {
            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "select producto.codigo, producto.nombre, producto.marca, producto.precio_compra,\n"
                    + "producto.precio_venta, ((producto.precio_venta)-(producto.precio_compra)) as utilidadUnitaria,\n"
                    + "sum(ventas_detalle.cant_producto) as cantVendida, \n"
                    + "sum(ventas_detalle.peso_producto) as pesoVendido,\n"
                    + "(((producto.precio_venta)-(producto.precio_compra)) * sum(ventas_detalle.cant_producto)) as utilidadFinal,\n"
                    + "(select sum(ventas_detalle.cant_producto) from producto, ventas, ventas_detalle\n"
                    + "where producto.id_producto = ventas_detalle.id_producto and\n"
                    + "ventas.id_venta = ventas_detalle.id_venta and \n"
                    + "ventas.fecha between '" + fecha3 + "' and '" + fecha4 + "')  as cantPAnt\n"
                    + "from producto, ventas, ventas_detalle\n"
                    + "where producto.id_producto = ventas_detalle.id_producto \n"
                    + "and ventas.id_venta = ventas_detalle.id_venta\n"
                    + "and producto.cant_o_peso = 1\n"
                    + "and ventas.fecha between '" + fecha1 + "' and '" + fecha2 + "'\n"
                    + "group by producto.codigo order by sum(ventas_detalle.cant_producto) asc;";
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                return rs;
            } else {
                return null;
            }

        } catch (Exception e) {

            System.err.println("Error al retornar la consulta de productos por fecha: " + e);
            return null;
        }
    }

    @Override
    public ResultSet productosMasVendidosPesoFechas(String fecha1, String fecha2, String fecha3, String fecha4) {
        try {
            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "select producto.codigo, producto.nombre, producto.marca, producto.precio_compra,\n"
                    + "producto.precio_venta, ((producto.precio_venta)-(producto.precio_compra)) as utilidadUnitaria,\n"
                    + "sum(ventas_detalle.cant_producto) as cantVendida, \n"
                    + "sum(ventas_detalle.peso_producto) as pesoVendido,\n"
                    + "(((producto.precio_venta)-(producto.precio_compra)) * sum(ventas_detalle.peso_producto)) as utilidadFinal,\n"
                    + "(select sum(ventas_detalle.cant_producto) from producto, ventas, ventas_detalle\n"
                    + "where producto.id_producto = ventas_detalle.id_producto and\n"
                    + "ventas.id_venta = ventas_detalle.id_venta and \n"
                    + "ventas.fecha between '" + fecha3 + "' and '" + fecha4 + "')  as cantPAnt\n"
                    + "from producto, ventas, ventas_detalle\n"
                    + "where producto.id_producto = ventas_detalle.id_producto \n"
                    + "and ventas.id_venta = ventas_detalle.id_venta\n"
                    + "and producto.cant_o_peso = 0\n"
                    + "and ventas.fecha between '" + fecha1 + "' and '" + fecha2 + "'\n"
                    + "group by producto.codigo order by pesoVendido desc;";
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                return rs;
            } else {
                return null;
            }

        } catch (Exception e) {

            System.err.println("Error al retornar la consulta de productos por fecha: " + e);
            return null;
        }
    }

    @Override
    public ResultSet productosMenosVendidosPesoFechas(String fecha1, String fecha2, String fecha3, String fecha4) {
        try {
            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "select producto.codigo, producto.nombre, producto.marca, producto.precio_compra,\n"
                    + "producto.precio_venta, ((producto.precio_venta)-(producto.precio_compra)) as utilidadUnitaria,\n"
                    + "sum(ventas_detalle.cant_producto) as cantVendida, \n"
                    + "sum(ventas_detalle.peso_producto) as pesoVendido,\n"
                    + "(((producto.precio_venta)-(producto.precio_compra)) * sum(ventas_detalle.peso_producto)) as utilidadFinal,\n"
                    + "(select sum(ventas_detalle.cant_producto) from producto, ventas, ventas_detalle\n"
                    + "where producto.id_producto = ventas_detalle.id_producto and\n"
                    + "ventas.id_venta = ventas_detalle.id_venta and \n"
                    + "ventas.fecha between '" + fecha3 + "' and '" + fecha4 + "')  as cantPAnt\n"
                    + "from producto, ventas, ventas_detalle\n"
                    + "where producto.id_producto = ventas_detalle.id_producto \n"
                    + "and ventas.id_venta = ventas_detalle.id_venta\n"
                    + "and producto.cant_o_peso = 0\n"
                    + "and ventas.fecha between '" + fecha1 + "' and '" + fecha2 + "'\n"
                    + "group by producto.codigo order by pesoVendido asc;";
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                return rs;
            } else {
                return null;
            }

        } catch (Exception e) {

            System.err.println("Error al retornar la consulta de productos por fecha: " + e);
            return null;
        }
    }

    @Override
    public ResultSet filtrarProductoNombreUnidadMayorAMenor(String fecha1, String fecha2, String fecha3, String fecha4, String nom) {
        try {
            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "select producto.codigo, producto.nombre, producto.marca, producto.precio_compra,\n"
                    + "producto.precio_venta, ((producto.precio_venta)-(producto.precio_compra)) as utilidadUnitaria,\n"
                    + "sum(ventas_detalle.cant_producto) as cantVendida, \n"
                    + "sum(ventas_detalle.peso_producto) as pesoVendido,\n"
                    + "(((producto.precio_venta)-(producto.precio_compra)) * sum(ventas_detalle.cant_producto)) as utilidadFinal,\n"
                    + "(select sum(ventas_detalle.cant_producto) from producto, ventas, ventas_detalle\n"
                    + "where producto.id_producto = ventas_detalle.id_producto and\n"
                    + "ventas.id_venta = ventas_detalle.id_venta and \n"
                    + "ventas.fecha between '" + fecha3 + "' and '" + fecha4 + "')  as cantPAnt\n"
                    + "from producto, ventas, ventas_detalle\n"
                    + "where producto.nombre like '" + nom + "%' and\n"
                    + "producto.id_producto = ventas_detalle.id_producto \n"
                    + "and ventas.id_venta = ventas_detalle.id_venta\n"
                    + "and producto.cant_o_peso = 1\n"
                    + "and ventas.fecha between '" + fecha1 + "' and '" + fecha2 + "'\n"
                    + "group by producto.codigo order by cantVendida desc;";
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                return rs;
            } else {
                return null;
            }

        } catch (Exception e) {

            System.err.println("Error al retornar la consulta de filtrar productos por nombre en desc: " + e);
            return null;
        }
    }

    @Override
    public ResultSet filtrarProductoNombreUnidadMenorAMayor(String fecha1, String fecha2, String fecha3, String fecha4, String nom) {
        try {
            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "select producto.codigo, producto.nombre, producto.marca, producto.precio_compra,\n"
                    + "producto.precio_venta, ((producto.precio_venta)-(producto.precio_compra)) as utilidadUnitaria,\n"
                    + "sum(ventas_detalle.cant_producto) as cantVendida, \n"
                    + "sum(ventas_detalle.peso_producto) as pesoVendido,\n"
                    + "(((producto.precio_venta)-(producto.precio_compra)) * sum(ventas_detalle.cant_producto)) as utilidadFinal,\n"
                    + "(select sum(ventas_detalle.cant_producto) from producto, ventas, ventas_detalle\n"
                    + "where producto.id_producto = ventas_detalle.id_producto and\n"
                    + "ventas.id_venta = ventas_detalle.id_venta and \n"
                    + "ventas.fecha between '" + fecha3 + "' and '" + fecha4 + "')  as cantPAnt\n"
                    + "from producto, ventas, ventas_detalle\n"
                    + "where producto.nombre like '" + nom + "%' and\n"
                    + "producto.id_producto = ventas_detalle.id_producto \n"
                    + "and ventas.id_venta = ventas_detalle.id_venta\n"
                    + "and producto.cant_o_peso = 1\n"
                    + "and ventas.fecha between '" + fecha1 + "' and '" + fecha2 + "'\n"
                    + "group by producto.codigo order by cantVendida asc;";
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                return rs;
            } else {
                return null;
            }

        } catch (Exception e) {

            System.err.println("Error al retornar la consulta de filtrar productos por nombre en asc: " + e);
            return null;
        }
    }
    
    @Override
    public ResultSet filtrarProductoNombrePesoMayorAMenor(String fecha1, String fecha2, String fecha3, String fecha4, String nom) {
        try {
            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "select producto.codigo, producto.nombre, producto.marca, producto.precio_compra,\n"
                    + "producto.precio_venta, ((producto.precio_venta)-(producto.precio_compra)) as utilidadUnitaria,\n"
                    + "sum(ventas_detalle.cant_producto) as cantVendida, \n"
                    + "sum(ventas_detalle.peso_producto) as pesoVendido,\n"
                    + "(((producto.precio_venta)-(producto.precio_compra)) * sum(ventas_detalle.peso_producto)) as utilidadFinal,\n"
                    + "(select sum(ventas_detalle.cant_producto) from producto, ventas, ventas_detalle\n"
                    + "where producto.id_producto = ventas_detalle.id_producto and\n"
                    + "ventas.id_venta = ventas_detalle.id_venta and \n"
                    + "ventas.fecha between '" + fecha3 + "' and '" + fecha4 + "')  as cantPAnt\n"
                    + "from producto, ventas, ventas_detalle\n"
                    + "where producto.nombre like '" + nom + "%' and\n"
                    + "producto.id_producto = ventas_detalle.id_producto \n"
                    + "and ventas.id_venta = ventas_detalle.id_venta\n"
                    + "and producto.cant_o_peso = 0\n"
                    + "and ventas.fecha between '" + fecha1 + "' and '" + fecha2 + "'\n"
                    + "group by producto.codigo order by pesoVendido desc;";
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                return rs;
            } else {
                return null;
            }

        } catch (Exception e) {

            System.err.println("Error al retornar la consulta de filtrar productos por nombre en asc: " + e);
            return null;
        }
    }
    
    @Override
    public ResultSet filtrarProductoNombrePesoMenorAMayor(String fecha1, String fecha2, String fecha3, String fecha4, String nom) {
        try {
            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "select producto.codigo, producto.nombre, producto.marca, producto.precio_compra,\n"
                    + "producto.precio_venta, ((producto.precio_venta)-(producto.precio_compra)) as utilidadUnitaria,\n"
                    + "sum(ventas_detalle.cant_producto) as cantVendida, \n"
                    + "sum(ventas_detalle.peso_producto) as pesoVendido,\n"
                    + "(((producto.precio_venta)-(producto.precio_compra)) * sum(ventas_detalle.peso_producto)) as utilidadFinal,\n"
                    + "(select sum(ventas_detalle.cant_producto) from producto, ventas, ventas_detalle\n"
                    + "where producto.id_producto = ventas_detalle.id_producto and\n"
                    + "ventas.id_venta = ventas_detalle.id_venta and \n"
                    + "ventas.fecha between '" + fecha3 + "' and '" + fecha4 + "')  as cantPAnt\n"
                    + "from producto, ventas, ventas_detalle\n"
                    + "where producto.nombre like '" + nom + "%' and\n"
                    + "producto.id_producto = ventas_detalle.id_producto \n"
                    + "and ventas.id_venta = ventas_detalle.id_venta\n"
                    + "and producto.cant_o_peso = 0\n"
                    + "and ventas.fecha between '" + fecha1 + "' and '" + fecha2 + "'\n"
                    + "group by producto.codigo order by pesoVendido asc;";
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                return rs;
            } else {
                return null;
            }

        } catch (Exception e) {

            System.err.println("Error al retornar la consulta de filtrar productos por nombre en asc: " + e);
            return null;
        }
    }

    @Override
    public ResultSet productosStockMayorAMenor() {
        try {
            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "select producto.codigo, producto.nombre, producto.marca,\n"
                    + "producto.cantidad\n"
                    + "from producto\n"
                    + "order by producto.cantidad desc;";
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                return rs;
            } else {
                return null;
            }

        } catch (Exception e) {

            System.err.println("Error al retornar la consulta de productos en stock en forma desc: " + e);
            return null;
        }
    }

    @Override
    public ResultSet productosStockMenorAMayor() {
        try {
            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "select producto.codigo, producto.nombre, producto.marca,\n"
                    + "producto.cantidad\n"
                    + "from producto\n"
                    + "order by producto.cantidad asc;";
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                return rs;
            } else {
                return null;
            }

        } catch (Exception e) {

            System.err.println("Error al retornar la consulta de productos en stock en forma asc: " + e);
            return null;
        }
    }

    @Override
    public ResultSet FiltroNombreproductosStockMayorAMenor(String caracter) {
        try {
            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "select producto.codigo, producto.nombre, producto.marca,\n"
                    + "producto.cantidad\n"
                    + "from producto\n"
                    + "where producto.nombre like '" + caracter + "%'\n"
                    + "order by producto.cantidad desc;";
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                return rs;
            } else {
                return null;
            }

        } catch (Exception e) {

            System.err.println("Error al retornar la consulta de filtrar productos por nombre en desc: " + e);
            return null;
        }
    }

    @Override
    public ResultSet FiltroNombreproductosStockMenorAMayor(String caracter) {
        try {
            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "select producto.codigo, producto.nombre, producto.marca,\n"
                    + "producto.cantidad\n"
                    + "from producto\n"
                    + "where producto.nombre like '" + caracter + "%'\n"
                    + "order by producto.cantidad asc;";
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                return rs;
            } else {
                return null;
            }

        } catch (Exception e) {

            System.err.println("Error al retornar la consulta de filtrar productos por nombre en asc: " + e);
            return null;
        }
    }

    @Override
    public ResultSet FiltroNombreBuscador(String caracter) {
        try {
            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "select producto.codigo, producto.nombre, producto.marca, producto.cantidad, producto.precio_venta\n"
                    + "from producto\n"
                    + "where producto.nombre like '" + caracter + "%'\n"
                    + "order by producto.cantidad desc;";
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                return rs;
            } else {
                return null;
            }

        } catch (Exception e) {

            System.err.println("Error al retornar la consulta de filtrar productos por nombre en buscador: " + e);
            return null;
        }
    }

    @Override
    public ResultSet FiltroMarcaBuscador(String caracter) {
        try {
            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "select producto.codigo, producto.nombre, producto.marca, producto.cantidad, producto.precio_venta\n"
                    + "from producto\n"
                    + "where producto.marca like '" + caracter + "%'\n"
                    + "order by producto.cantidad desc;";
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                return rs;
            } else {
                return null;
            }

        } catch (Exception e) {

            System.err.println("Error al retornar la consulta de filtrar productos por marca en buscador: " + e);
            return null;
        }
    }

    @Override
    public int tipoProducto(int idProd) {
        try {
            con = new Conectar().conexion();
            st = con.createStatement();

            String sql = "select producto.cant_o_peso from producto where producto.id_producto=" + idProd + ";";
            ResultSet resp = st.executeQuery(sql);

            //Si resp toma el valor 1, quiere decir que es producto de cantidad unitaria.
            //Por el contrario, si es 0 qiere decir que es de peso.
            int aux;
            if (resp.next()) {
                aux = resp.getInt(1);
                return aux;
            } else {
                return -1;
            }

        } catch (Exception e) {

            System.err.println("Error al retornar la consulta del tipo de producto cant o peso: " + e);
            return -1;
        }
    }

}
