/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

/**
 *
 * @author cristian
 */
public interface LoginDao {
    public String ingresar(String nombre, String clave, String hora);
    public byte verificarEstado(String nombre);
}
