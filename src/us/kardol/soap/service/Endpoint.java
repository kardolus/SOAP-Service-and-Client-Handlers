package us.kardol.soap.service;

import us.kardol.utility.Settings;

/**
 * @author Guillermo Kardolus
 */
public class Endpoint {
    public static void main(String... args){
        final String url = Settings.URL;                    
        System.out.println("Publishing SOAPResource at endpoint " + url);
        System.out.println("Working directory: " + System.getProperty("user.dir"));
        javax.xml.ws.Endpoint.publish(url, new SOAPResource());
    }
}
