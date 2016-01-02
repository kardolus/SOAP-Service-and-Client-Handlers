package us.kardol.utility;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Guillermo Kardolus
 * 
 * In production this should all go to a database. 
 */
public class Settings {
    public final static String DATABASE_PATH = "src/us/kardol/soap/service/inventions.db";
    public final static String HANDLER_XML = "/serviceHandler.xml";
    public final static String URL = "http://localhost:8888/testsoap";
    public final static Map<String, String> DATASTORE; // name and "secret" pairs
    
    static // note that secrets do no go over the wire. 
    {
        DATASTORE = new HashMap<String, String>();
        DATASTORE.put("Guillermo", "secret_b");
        DATASTORE.put("Casey", "secret_d");
    }
}
