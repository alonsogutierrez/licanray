/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.Usuario;
import java.sql.ResultSet;

/**
 *
 * @author cristian
 */
public interface UsuarioDao {
    public boolean actualizar(String nombre_viejo,String nombre, String clave, String cargo);
    public boolean ingresar(Usuario usuario);
    public boolean eliminar(Usuario usuario);
    public Usuario buscar(String nombre);
    public boolean usuarioExiste(String nombre);
    public boolean activarUsuario(String nombre);
    public boolean desactivarUsuario(String nombre);
    public ResultSet todosUsuarios();
    public int idUsuario(String nombre);
    public String nombreUsuario(int idUser);
    public byte estadoCaja(int idUser);
    public ResultSet reportesVendedoresAsc(String fecha1, String fecha2);
    public ResultSet reportesVendedoresDesc(String fecha1, String fecha2);
    public ResultSet reportesVendedoresHorasAsc(String fecha1, String fecha2);
    public ResultSet reportesVendedoresHorasDesc(String fecha1, String fecha2);
}
