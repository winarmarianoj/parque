/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import logica.Empleado;
import logica.Usuarios;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mariano
 */
public class EmpleadoTest {
    
    public EmpleadoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getEmpleado_id method, of class Empleado.
     */
    @Test
    public void testGetEmpleado_id() {
        System.out.println("getEmpleado_id");
        Empleado instance = new Empleado();
        int expResult = 0;
        int result = instance.getEmpleado_id();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmpleado_id method, of class Empleado.
     */
    @Test
    public void testSetEmpleado_id() {
        System.out.println("setEmpleado_id");
        int empleado_id = 0;
        Empleado instance = new Empleado();
        instance.setEmpleado_id(empleado_id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsuario method, of class Empleado.
     */
    @Test
    public void testGetUsuario() {
        System.out.println("getUsuario");
        Empleado instance = new Empleado();
        Usuarios expResult = null;
        Usuarios result = instance.getUsuario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsuario method, of class Empleado.
     */
    @Test
    public void testSetUsuario() {
        System.out.println("setUsuario");
        Usuarios usuario = null;
        Empleado instance = new Empleado();
        instance.setUsuario(usuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombre method, of class Empleado.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Empleado instance = new Empleado();
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombre method, of class Empleado.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "";
        Empleado instance = new Empleado();
        instance.setNombre(nombre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getApellido method, of class Empleado.
     */
    @Test
    public void testGetApellido() {
        System.out.println("getApellido");
        Empleado instance = new Empleado();
        String expResult = "";
        String result = instance.getApellido();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setApellido method, of class Empleado.
     */
    @Test
    public void testSetApellido() {
        System.out.println("setApellido");
        String apellido = "";
        Empleado instance = new Empleado();
        instance.setApellido(apellido);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of logueoEmpleado method, of class Empleado.
     */
    @Test
    public void testLogueoEmpleado() {
        System.out.println("logueoEmpleado");
        Empleado instance = new Empleado();
        boolean expResult = false;
        boolean result = instance.logueoEmpleado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of entradaCliente method, of class Empleado.
     */
    @Test
    public void testEntradaCliente() {
        System.out.println("entradaCliente");
        Empleado instance = new Empleado();
        boolean expResult = false;
        boolean result = instance.entradaCliente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
