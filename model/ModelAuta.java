//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5.1 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.28 at 11:40:09 AM CEST 
//


package rentacar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ModelAuta complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ModelAuta">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="marka_auta" type="{rentacar}MarkaAuta"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ModelAuta", propOrder = {
    "id",
    "ime",
    "markaAuta"
})
public class ModelAuta {

    protected long id;
    @XmlElement(required = true)
    protected String ime;
    @XmlElement(name = "marka_auta", required = true)
    protected MarkaAuta markaAuta;

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
     * Gets the value of the ime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIme() {
        return ime;
    }

    /**
     * Sets the value of the ime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIme(String value) {
        this.ime = value;
    }

    /**
     * Gets the value of the markaAuta property.
     * 
     * @return
     *     possible object is
     *     {@link MarkaAuta }
     *     
     */
    public MarkaAuta getMarkaAuta() {
        return markaAuta;
    }

    /**
     * Sets the value of the markaAuta property.
     * 
     * @param value
     *     allowed object is
     *     {@link MarkaAuta }
     *     
     */
    public void setMarkaAuta(MarkaAuta value) {
        this.markaAuta = value;
    }

}