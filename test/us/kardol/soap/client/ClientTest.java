package us.kardol.soap.client;

import java.util.List;
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
import static us.kardol.data.Inventions.DATA;
import us.kardol.soap.client.wsimport.HoverboardException_Exception;
import us.kardol.utility.FileParser;

/**
 * @author Guillermo Kardolus
 */
public class ClientTest {
    private SOAPResourceService service = null;
    private SOAPResource port = null;
    private String name = null;
    
    public ClientTest() {
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
        new FileParser().parse(Settings.DATABASE_PATH);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void getAllTest() {
        System.out.println("Testing " + service.getClass().getName() + ".getAll()");
        List<Invention> inventions = port.getAll();
        for(Invention i : inventions){
            assertEquals(DATA.get(i.getId()).getYear(), i.getYear());
            assertEquals(DATA.get(i.getId()).getInvention(), i.getInvention());
            assertEquals(DATA.get(i.getId()).getInventor(), i.getInventor());
        }
    }
    
    @Test
    public void getOneTest() {
        System.out.println("Testing " + service.getClass().getName() + ".getOne(id)");
        Invention invention = port.getOne(port.getAll().size() - 1);
        assert(invention != null);
    }
 
    @Test
    public void createTest() throws HoverboardException_Exception {
        System.out.println("Testing " + service.getClass().getName() + ".create(inv)");
        Invention i = new Invention();
        i.setYear(2016);
        i.setInvention("The thing");
        i.setInventor("The dude");
        Integer theId = port.create(i);
        assertEquals(port.getOne(theId).getYear(), i.getYear());
    }
}
