package us.kardol.utility;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import us.kardol.data.Inventions;

/**
 * @author Guillermo Kardolus
 */
public class FileParserTest {
    Inventions inv = null;
    FileParser fp = null;
    
    public FileParserTest() {
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
        fp = new FileParser();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testParse() {
        System.out.println("Testing " + fp.getClass().getName() + ".parse(filename)");
        fp.parse(Settings.DATABASE_PATH);
        assertEquals(Inventions.DATA.get(1).getYear().intValue(), 1769);
    }
    
}
