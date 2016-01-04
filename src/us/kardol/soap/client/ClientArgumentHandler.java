package us.kardol.soap.client;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.ws.LogicalMessage;
import javax.xml.ws.handler.LogicalHandler;
import javax.xml.ws.handler.LogicalMessageContext;
import javax.xml.ws.handler.MessageContext;
import us.kardol.soap.client.wsimport.GetOne;

/**
 * @author Guillermo Kardolus
 * 
 * This handler validates the id argument used in the GetOne method
 */
public class ClientArgumentHandler implements LogicalHandler<LogicalMessageContext> {

    @Override
    public boolean handleMessage(LogicalMessageContext context) {
        Boolean outbound =
           (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if (outbound) { // request?
            LogicalMessage msg = context.getMessage();
            JAXBContext jaxbCtx;      
            try {
                // package that includes the wsimport ObjectFactory
                jaxbCtx = JAXBContext.newInstance("us.kardol.soap.client.wsimport"); 
                Object payload = msg.getPayload(jaxbCtx);                         
                // Check payload to be sure it's what we want.
                if(payload instanceof JAXBElement) {
                    Object value = ((JAXBElement) payload).getValue();
                    if(value.toString().contains("GetOne") &&
                            ((GetOne) value).getArg0() <= 0){
                        throw new IllegalArgumentException("ID cannot be zero or less");
                    }
                }
            } catch (JAXBException ex) {
                Logger.getLogger(ClientArgumentHandler.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
        return true;
    }

    @Override
    public boolean handleFault(LogicalMessageContext context) {
        return true;
    }

    @Override
    public void close(MessageContext context) { }
    
}
