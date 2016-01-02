package us.kardol.soap.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

/**
 * @author Guillermo Kardolus
 */
public class ClientHandlerResolver implements HandlerResolver{
    private String name = null;
    private String secret = null;

    public ClientHandlerResolver(String name, String key) {
        this.name = name;
        this.secret = key;
    }
    
    @Override
    public List<Handler> getHandlerChain(PortInfo portInfo) {
        List<Handler> handlerChain = new ArrayList<>();
        handlerChain.add(new ClientHashHandler(this.name, this.secret));
        return handlerChain;
    }
}
