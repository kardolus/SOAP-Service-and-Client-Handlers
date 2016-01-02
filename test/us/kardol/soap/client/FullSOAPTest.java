package us.kardol.soap.client;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import us.kardol.soap.client.wsimport.Invention;
import us.kardol.soap.client.wsimport.SOAPResource;
import us.kardol.soap.client.wsimport.SOAPResourceService;
import us.kardol.utility.Settings;

/**
 * @author Guillermo Kardolus
 *  
 * TODO
 * 1. Expand this test method -- look at best practices as well 
 * 2. create Git repository
 */
public class FullSOAPTest {
    private SOAPResourceService service = null;
    private SOAPResource port = null;
    private String name = null;
    
    public FullSOAPTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        name = "Guillermo";
        service = new SOAPResourceService();
        service.setHandlerResolver(new ClientHandlerResolver(name, Settings.DATASTORE.get(name)));
        port = service.getSOAPResourcePort();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAll method, of class Client.
     */
    @Test
    public void fullSOAPTest() {
        for(Invention i : port.getAll()){
            System.out.println(i.getYear() + " " + i.getInvention() + " " + i.getInventor());
        }
    }
    
}
