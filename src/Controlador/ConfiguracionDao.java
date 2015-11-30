/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author alonso
 */
public interface ConfiguracionDao {
    public boolean actualizarProdMin(int cantProd);
    public boolean actualizarDineroMin(int cantDin);
    public int CantProdMin();
    public int CantDineroMin();

}
