
package us.kardol.soap.client.wsimport;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for invention complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="invention">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="invention" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inventor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="year" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "invention", propOrder = {
    "id",
    "invention",
    "inventor",
    "year"
})
public class Invention {

    protected Integer id;
    protected String invention;
    protected String inventor;
    protected Integer year;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

    /**
     * Gets the value of the invention property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvention() {
        return invention;
    }

    /**
     * Sets the value of the invention property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvention(String value) {
        this.invention = value;
    }

    /**
     * Gets the value of the inventor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInventor() {
        return inventor;
    }

    /**
     * Sets the value of the inventor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInventor(String value) {
        this.inventor = value;
    }

    /**
     * Gets the value of the year property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getYear() {
        return year;
    }

    /**
     * Sets the value of the year property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setYear(Integer value) {
        this.year = value;
    }

}
