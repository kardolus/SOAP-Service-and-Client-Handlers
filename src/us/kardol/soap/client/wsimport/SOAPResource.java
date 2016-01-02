
package us.kardol.soap.client.wsimport;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "SOAPResource", targetNamespace = "http://service.soap.kardol.us/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SOAPResource {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     * @throws HoverboardException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "create", targetNamespace = "http://service.soap.kardol.us/", className = "us.kardol.soap.client.wsimport.Create")
    @ResponseWrapper(localName = "createResponse", targetNamespace = "http://service.soap.kardol.us/", className = "us.kardol.soap.client.wsimport.CreateResponse")
    @Action(input = "http://service.soap.kardol.us/SOAPResource/createRequest", output = "http://service.soap.kardol.us/SOAPResource/createResponse", fault = {
        @FaultAction(className = HoverboardException_Exception.class, value = "http://service.soap.kardol.us/SOAPResource/create/Fault/HoverboardException")
    })
    public String create(
        @WebParam(name = "arg0", targetNamespace = "")
        Invention arg0)
        throws HoverboardException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns us.kardol.soap.client.wsimport.Invention
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getOne", targetNamespace = "http://service.soap.kardol.us/", className = "us.kardol.soap.client.wsimport.GetOne")
    @ResponseWrapper(localName = "getOneResponse", targetNamespace = "http://service.soap.kardol.us/", className = "us.kardol.soap.client.wsimport.GetOneResponse")
    @Action(input = "http://service.soap.kardol.us/SOAPResource/getOneRequest", output = "http://service.soap.kardol.us/SOAPResource/getOneResponse")
    public Invention getOne(
        @WebParam(name = "arg0", targetNamespace = "")
        Integer arg0);

    /**
     * 
     * @return
     *     returns java.util.List<us.kardol.soap.client.wsimport.Invention>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAll", targetNamespace = "http://service.soap.kardol.us/", className = "us.kardol.soap.client.wsimport.GetAll")
    @ResponseWrapper(localName = "getAllResponse", targetNamespace = "http://service.soap.kardol.us/", className = "us.kardol.soap.client.wsimport.GetAllResponse")
    @Action(input = "http://service.soap.kardol.us/SOAPResource/getAllRequest", output = "http://service.soap.kardol.us/SOAPResource/getAllResponse")
    public List<Invention> getAll();

}
