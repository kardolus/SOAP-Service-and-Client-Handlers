package us.kardol.soap.service;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.ws.soap.SOAPFaultException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import us.kardol.utility.Settings;
import us.kardol.utility.Signature;
import us.kardol.utility.TimeStamp;

/**
 * @author Guillermo Kardolus
 */
public class ServiceHashHandler implements SOAPHandler<SOAPMessageContext>{

    @Override
    public Set<QName> getHeaders() {
        return null;
    }
    @Override
    public boolean handleFault(SOAPMessageContext context) {
        return true; // continue down the chain
    }
    @Override
    public void close(MessageContext context) {
        
    }
    
    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        Boolean isInbound = !(Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if (isInbound) {
            SOAPMessage message = context.getMessage();
            try {
                SOAPHeader header = message.getSOAPHeader();
                if(header == null){
                    this.generateFault(message, "No header");
                }
                
                Node node = header.getFirstChild(); // credentials
                NodeList list = node.getChildNodes();
                if(list.getLength() < 3){
                    this.generateFault(message, "Not enough header nodes");
                }
                
                // Extract the required attributes.
                String name = list.item(0).getFirstChild().getNodeValue();
                String signature = list.item(1).getFirstChild().getNodeValue();
                String timestamp = list.item(2).getFirstChild().getNodeValue();
                if (name == null || timestamp == null || signature == null){
                    this.generateFault(message, "missing header key/value pairs");
                }
                
                // Check against locally generated signature
                String secret = Settings.DATASTORE.get(name); 
                String localSignature = new Signature().getSignature(secret, name + timestamp);
                if(!verify(localSignature, signature)){
                    this.generateFault(message, "Wrong signature");
                }
            } catch (SOAPException ex) {
                Logger.getLogger(ServiceHashHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
    }
    
    private Boolean verify(String sig1, String sig2) {
        try {
            return Arrays.equals(sig1.getBytes("UTF-8"), sig2.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ServiceHashHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Arrays.equals(sig1.getBytes(), sig2.getBytes()); // if UTF-8 not supported
    }
    
    private void generateFault(SOAPMessage msg, String reason) {
        try {
            SOAPBody body = msg.getSOAPBody();
            SOAPFault fault = body.addFault();
            fault.setFaultString(reason);
            throw new SOAPFaultException(fault);
        }
        catch (SOAPException ex) {
            Logger.getLogger(ServiceHashHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
