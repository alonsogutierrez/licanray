/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.Producto;
import Modelo.VentaDetalle;
import Modelo.Ventas;
import java.awt.List;
import java.sql.ResultSet;

/**
 *
 * @author cristian
 */
public interface ProductoDao {
    public int guardar1(Producto producto);
    public int actualizar(String marca, String nombre, int cantidad, double peso, int precioCompra, int precioVenta, String codigo);
    public boolean verificarProducto(String codigo);
    public byte eliminar(int id);
    public Producto buscarNombre(String codigo);
    public Producto agregarProductoALaVenta(String codigo);
    public int verificarCantidad(String codigo);
    public Double verificarPeso(String codigo);
    public int ventaProducto(Ventas ventas, int idCaja);
    public int detalleVenta(VentaDetalle ventaDetalle);
    public int idUltimaVenta();
    public int idProducto(String codigo);
    public void actualizaCantidad(int cantidad, String codigo);
    public void actualizaPeso(Double peso, String codigo);
    public String devuelveNombre(String codigo);
    public ResultSet productosMasVendidosUnidadFechas(String fecha1, String fecha2, String fecha3, String fecha4);
    public ResultSet productosMenosVendidosUnidadFechas(String fecha1, String fecha2, String fecha3, String fecha4);
    public ResultSet productosMasVendidosPesoFechas(String fecha1, String fecha2, String fecha3, String fecha4);
    public ResultSet productosMenosVendidosPesoFechas(String fecha1, String fecha2, String fecha3, String fecha4);
    public ResultSet filtrarProductoNombreUnidadMayorAMenor(String fecha1, String fecha2, String fecha3, String fecha4, String nom);
    public ResultSet filtrarProductoNombreUnidadMenorAMayor(String fecha1, String fecha2, String fecha3, String fecha4, String nom);
    public ResultSet filtrarProductoNombrePesoMayorAMenor(String fecha1, String fecha2, String fecha3, String fecha4, String nom);
    public ResultSet filtrarProductoNombrePesoMenorAMayor(String fecha1, String fecha2, String fecha3, String fecha4, String nom);
    public ResultSet productosStockMayorAMenor();
    public ResultSet productosStockMenorAMayor();
    public ResultSet FiltroNombreproductosStockMayorAMenor(String caracter);
    public ResultSet FiltroNombreproductosStockMenorAMayor(String caracter);
    public ResultSet FiltroNombreBuscador(String caracter);
    public ResultSet FiltroMarcaBuscador(String caracter);
    public int tipoProducto(int idProd);
}
