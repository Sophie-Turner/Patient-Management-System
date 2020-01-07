/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Administrator;
import View.AdminHome;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pipin
 */
public class AdminControllerTest {
    
    public AdminControllerTest() {
        
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
     * Test of setHomeView method, of class AdminController.
     */
    @Test
    public void testSetHomeView() {
        System.out.println("testing setHomeView");
        AdminHome homeView = null;
        AdminController instance = new AdminController();
        instance.setHomeView(homeView);
        System.out.println("setHomeView method in AdminController was called.");
    }

    /**
     * Test of setModel method, of class AdminController.
     */
    @Test
    public void testSetModel() {
        System.out.println("setModel");
        Administrator model = null;
        AdminController instance = new AdminController();
        instance.setModel(model);
        System.out.println("setModel method in AdminController was called.");
    }
    
}
