package us.kardol.data;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import us.kardol.soap.service.HoverboardException;

/**
 * @author Guillermo Kardolus
 */
public class InventionsTest {
    Inventions inv;
    
    public InventionsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        inv = new Inventions();
        try {
            inv.addInvention(new Invention("FirstName LastName", "Invention 1", 100));
            inv.addInvention(new Invention("FirstName LastName", "Invention 2", 10));
            inv.addInvention(new Invention("FirstName LastName", "Invention 3", 200));
            inv.addInvention(new Invention("FirstName LastName", "Invention 4", 300));
            inv.addInvention(new Invention("FirstName LastName", "Invention 5", 400));
        } catch (HoverboardException ex) {
            Logger.getLogger(InventionsTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addInvention method, of class Inventions.
     * @throws us.kardol.soap.service.HoverboardException
     */
    @Test(expected = HoverboardException.class)
    public void testAddInvention() throws HoverboardException{
        System.out.println("Testing " + inv.getClass().getName() + ".addInvention()");
        inv.addInvention(new Invention("Tarzan", "Hoverboard", 1980));
    }

    /**
     * Test of getInvention method, of class Inventions.
     */
    @Test
    public void testGetInvention() {
        System.out.println("Testing " + inv.getClass().getName() + ".getInvention(key)");
        assertEquals(inv.getInvention(2).getYear().intValue(), 10);
    }

    /**
     * Test of getInventions method, of class Inventions.
     */
    @Test
    public void testGetInventions() {
        System.out.println("Testing " + inv.getClass().getName() + ".getInventions()");
        assertEquals(inv.getInventions().get(0).getYear().intValue(), 10); // sorted
    }
    
}
