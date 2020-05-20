//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5.1 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.15 at 05:39:20 PM CEST 
//


package xml_bsep.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CTMarkaAuta complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CTMarkaAuta">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element ref="{korisnik}Automobili"/>
 *         &lt;element ref="{korisnik}Modeli"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CTMarkaAuta", propOrder = {
    "id",
    "name",
    "automobili",
    "modeli"
})
public class CTMarkaAuta {

    @XmlElement(name = "Id")
    protected long id;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "Automobili", required = true)
    protected Automobili automobili;
    @XmlElement(name = "Modeli", required = true)
    protected Modeli modeli;

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
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
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

    /**
     * Gets the value of the modeli property.
     * 
     * @return
     *     possible object is
     *     {@link Modeli }
     *     
     */
    public Modeli getModeli() {
        return modeli;
    }

    /**
     * Sets the value of the modeli property.
     * 
     * @param value
     *     allowed object is
     *     {@link Modeli }
     *     
     */
    public void setModeli(Modeli value) {
        this.modeli = value;
    }

}