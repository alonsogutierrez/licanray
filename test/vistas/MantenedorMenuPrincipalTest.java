/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alonso
 */
public class MantenedorMenuPrincipalTest {
    
    public MantenedorMenuPrincipalTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of cerrar method, of class MantenedorMenuPrincipal.
     */
    @Test
    public void testCerrar() {
        System.out.println("cerrar");
        MantenedorMenuPrincipal instance = new MantenedorMenuPrincipal();
        instance.cerrar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of limpiar method, of class MantenedorMenuPrincipal.
     */
    @Test
    public void testLimpiar() {
        System.out.println("limpiar");
        MantenedorMenuPrincipal instance = new MantenedorMenuPrincipal();
        instance.limpiar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of limpiarTodo method, of class MantenedorMenuPrincipal.
     */
    @Test
    public void testLimpiarTodo() {
        System.out.println("limpiarTodo");
        MantenedorMenuPrincipal instance = new MantenedorMenuPrincipal();
        instance.limpiarTodo();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotal method, of class MantenedorMenuPrincipal.
     */
    @Test
    public void testGetTotal() {
        System.out.println("getTotal");
        MantenedorMenuPrincipal instance = new MantenedorMenuPrincipal();
        int expResult = 0;
        int result = instance.getTotal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTotal method, of class MantenedorMenuPrincipal.
     */
    @Test
    public void testSetTotal() {
        System.out.println("setTotal");
        int total = 0;
        MantenedorMenuPrincipal instance = new MantenedorMenuPrincipal();
        instance.setTotal(total);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class MantenedorMenuPrincipal.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        MantenedorMenuPrincipal instance = new MantenedorMenuPrincipal();
        instance.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
