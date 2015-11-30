/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package licanray;

import Modelo.Caja;
import Modelo.Usuario;
import vistas.MantenedorDineroCaja;
import vistas.MantenedorLogin;
import vistas.MantenedorMenuPrincipal;

/**
 *
 * @author cristian
 */
public class LicanRay {

    /**
     * @param args the command line arguments
     */
    public static MantenedorMenuPrincipal mantenedorMenuPrincipal = new MantenedorMenuPrincipal();
    public static MantenedorLogin mantenedorLogin = new MantenedorLogin();
    public static Usuario usuario = new Usuario();
    public static Caja caja = new Caja();
    public static MantenedorDineroCaja mantenedorDineroCaja = new MantenedorDineroCaja();
    public static void main(String[] args) {
        // Metodo que llama al mantenedor de menu principal.
       mantenedorLogin.setVisible(true);
    }
    
}
