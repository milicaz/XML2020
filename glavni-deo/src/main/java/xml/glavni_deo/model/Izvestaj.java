//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5.1 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.15 at 05:39:20 PM CEST 
//


package xml.glavni_deo.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element ref="{korisnik}Automobil"/>
 *         &lt;element name="Predjena_kilometraza" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="Dodatni_info" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id",
    "automobil",
    "predjenaKilometraza",
    "dodatniInfo"
})
@XmlRootElement(name = "Izvestaj")
public class Izvestaj {

    @XmlElement(name = "Id")
    protected long id;
    @XmlElement(name = "Automobil", required = true)
    protected Automobil automobil;
    @XmlElement(name = "Predjena_kilometraza")
    protected float predjenaKilometraza;
    @XmlElement(name = "Dodatni_info", required = true)
    protected String dodatniInfo;

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
     * Gets the value of the automobil property.
     * 
     * @return
     *     possible object is
     *     {@link Automobil }
     *     
     */
    public Automobil getAutomobil() {
        return automobil;
    }

    /**
     * Sets the value of the automobil property.
     * 
     * @param value
     *     allowed object is
     *     {@link Automobil }
     *     
     */
    public void setAutomobil(Automobil value) {
        this.automobil = value;
    }

    /**
     * Gets the value of the predjenaKilometraza property.
     * 
     */
    public float getPredjenaKilometraza() {
        return predjenaKilometraza;
    }

    /**
     * Sets the value of the predjenaKilometraza property.
     * 
     */
    public void setPredjenaKilometraza(float value) {
        this.predjenaKilometraza = value;
    }

    /**
     * Gets the value of the dodatniInfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDodatniInfo() {
        return dodatniInfo;
    }

    /**
     * Sets the value of the dodatniInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDodatniInfo(String value) {
        this.dodatniInfo = value;
    }

}
