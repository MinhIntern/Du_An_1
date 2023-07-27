/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package GUI;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lethi
 */
public class ChonBanFrameTest {
    
    public ChonBanFrameTest() {
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
     * Test of createJframe method, of class ChonBanFrame.
     */
    @Test
    public void testCreateJframe() {
        System.out.println("createJframe");
        ArrayList<String> listTableSelectedAll = null;
        ArrayList<String> listTableSelected = null;
        ChonBanFrame instance = new ChonBanFrame();
        instance.createJframe(listTableSelectedAll, listTableSelected);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of run method, of class ChonBanFrame.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        ChonBanFrame instance = new ChonBanFrame();
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
