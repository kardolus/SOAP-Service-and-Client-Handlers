package us.kardol.soap.client;

import java.util.Date;
import java.util.Set;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import us.kardol.utility.Signature;
import us.kardol.utility.TimeStamp;

/**
 * @author Guillermo Kardolus
 */
public class ClientHashHandler implements SOAPHandler<SOAPMessageContext>{
    private String name = null, secret = null;
    public ClientHashHandler(String name, String secret){
        this.name = name;
        this.secret = secret;
    }
    
    @Override
    public Set<QName> getHeaders() {
        return null;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        Boolean outbound =
            (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if (outbound) {                                                         
            try {
                SOAPMessage soapMessage = context.getMessage();
                SOAPEnvelope envelope = soapMessage.getSOAPPart().getEnvelope();
                
                // Ensure there is a header and add a 'wrapper' element.
                if (envelope.getHeader() == null){
                    envelope.addHeader();
                }         
                SOAPHeader header = envelope.getHeader();
                QName qn = new QName("http://SOAPResource", "credentials");
                header.addHeaderElement(qn);              
                
                // Now insert credentials into the header.
                String timeStamp = new TimeStamp().getTimeStamp(new Date());
                String signature = new Signature().getSignature(secret, name + new TimeStamp().getTimeStamp(new Date()));
                Node firstChild = header.getFirstChild();
                append(firstChild, "Name",      this.name);                     
                append(firstChild, "Signature", signature);                     
                append(firstChild, "Timestamp", timeStamp);                     
                soapMessage.saveChanges();
            }
            catch(Exception e) {
                throw new RuntimeException("SOAPException thrown.", e);
            }
        }
        return true; // continue down the handler chain
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        return true;
    }

    @Override
    public void close(MessageContext context) {
        
    }

    private void append(Node node, String elementName, String elementText) {
        Element element = node.getOwnerDocument().createElement(elementName);
        element.setTextContent(elementText);
        node.appendChild(element);
    }
}
