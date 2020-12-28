/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Fatih
 */
public class AdresBilgileriTest {
    
    public AdresBilgileriTest() {
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
     * Test of setEposta method, of class AdresBilgileri.
     */
    @Test
    public void testSetEposta() {
        System.out.println("setEposta");
        String email = "";
        AdresBilgileri instance = new AdresBilgileri();
        instance.setEposta(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class AdresBilgileri.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        AdresBilgileri.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
