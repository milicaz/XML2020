//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5.1 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.15 at 05:39:20 PM CEST 
//


package korisnik;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CTTipMenjaca complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CTTipMenjaca">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Ime_menjaca" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element ref="{korisnik}Automobili"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CTTipMenjaca", propOrder = {
    "id",
    "imeMenjaca",
    "automobili"
})
public class CTTipMenjaca {

    @XmlElement(name = "Id")
    protected long id;
    @XmlElement(name = "Ime_menjaca", required = true)
    protected String imeMenjaca;
    @XmlElement(name = "Automobili", required = true)
    protected Automobili automobili;

    /**
     * Gets the value of the id property.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Gets the value of the imeMenjaca property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImeMenjaca() {
        return imeMenjaca;
    }

    /**
     * Sets the value of the imeMenjaca property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImeMenjaca(String value) {
        this.imeMenjaca = value;
    }

    /**
     * Gets the value of the automobili property.
     * 
     * @return
     *     possible object is
     *     {@link Automobili }
     *     
     */
    public Automobili getAutomobili() {
        return automobili;
    }

    /**
     * Sets the value of the automobili property.
     * 
     * @param value
     *     allowed object is
     *     {@link Automobili }
     *     
     */
    public void setAutomobili(Automobili value) {
        this.automobili = value;
    }

}
