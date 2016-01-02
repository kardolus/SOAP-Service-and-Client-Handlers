
package us.kardol.soap.client.wsimport;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the us.kardol.soap.client.wsimport package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _HoverboardException_QNAME = new QName("http://service.soap.kardol.us/", "HoverboardException");
    private final static QName _GetOneResponse_QNAME = new QName("http://service.soap.kardol.us/", "getOneResponse");
    private final static QName _GetOne_QNAME = new QName("http://service.soap.kardol.us/", "getOne");
    private final static QName _Create_QNAME = new QName("http://service.soap.kardol.us/", "create");
    private final static QName _CreateResponse_QNAME = new QName("http://service.soap.kardol.us/", "createResponse");
    private final static QName _GetAllResponse_QNAME = new QName("http://service.soap.kardol.us/", "getAllResponse");
    private final static QName _GetAll_QNAME = new QName("http://service.soap.kardol.us/", "getAll");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: us.kardol.soap.client.wsimport
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAll }
     * 
     */
    public GetAll createGetAll() {
        return new GetAll();
    }

    /**
     * Create an instance of {@link GetAllResponse }
     * 
     */
    public GetAllResponse createGetAllResponse() {
        return new GetAllResponse();
    }

    /**
     * Create an instance of {@link GetOne }
     * 
     */
    public GetOne createGetOne() {
        return new GetOne();
    }

    /**
     * Create an instance of {@link Create }
     * 
     */
    public Create createCreate() {
        return new Create();
    }

    /**
     * Create an instance of {@link CreateResponse }
     * 
     */
    public CreateResponse createCreateResponse() {
        return new CreateResponse();
    }

    /**
     * Create an instance of {@link HoverboardException }
     * 
     */
    public HoverboardException createHoverboardException() {
        return new HoverboardException();
    }

    /**
     * Create an instance of {@link GetOneResponse }
     * 
     */
    public GetOneResponse createGetOneResponse() {
        return new GetOneResponse();
    }

    /**
     * Create an instance of {@link Invention }
     * 
     */
    public Invention createInvention() {
        return new Invention();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HoverboardException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soap.kardol.us/", name = "HoverboardException")
    public JAXBElement<HoverboardException> createHoverboardException(HoverboardException value) {
        return new JAXBElement<HoverboardException>(_HoverboardException_QNAME, HoverboardException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOneResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soap.kardol.us/", name = "getOneResponse")
    public JAXBElement<GetOneResponse> createGetOneResponse(GetOneResponse value) {
        return new JAXBElement<GetOneResponse>(_GetOneResponse_QNAME, GetOneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOne }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soap.kardol.us/", name = "getOne")
    public JAXBElement<GetOne> createGetOne(GetOne value) {
        return new JAXBElement<GetOne>(_GetOne_QNAME, GetOne.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Create }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soap.kardol.us/", name = "create")
    public JAXBElement<Create> createCreate(Create value) {
        return new JAXBElement<Create>(_Create_QNAME, Create.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soap.kardol.us/", name = "createResponse")
    public JAXBElement<CreateResponse> createCreateResponse(CreateResponse value) {
        return new JAXBElement<CreateResponse>(_CreateResponse_QNAME, CreateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soap.kardol.us/", name = "getAllResponse")
    public JAXBElement<GetAllResponse> createGetAllResponse(GetAllResponse value) {
        return new JAXBElement<GetAllResponse>(_GetAllResponse_QNAME, GetAllResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAll }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soap.kardol.us/", name = "getAll")
    public JAXBElement<GetAll> createGetAll(GetAll value) {
        return new JAXBElement<GetAll>(_GetAll_QNAME, GetAll.class, null, value);
    }

}
