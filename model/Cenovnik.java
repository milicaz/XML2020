//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5.1 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.06.20 at 12:22:52 PM CEST 
//


package rentacar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element ref="{rentacar}Automobil"/>
 *         &lt;element name="datum_od" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="datum_do" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="cena_po_danu" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="cena_po_kilometru">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}double">
 *               &lt;minInclusive value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="cena_za_cdw">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}double">
 *               &lt;minInclusive value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
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
    "datumOd",
    "datumDo",
    "cenaPoDanu",
    "cenaPoKilometru",
    "cenaZaCdw"
})
@XmlRootElement(name = "Cenovnik")
public class Cenovnik {

    protected long id;
    @XmlElement(name = "Automobil", required = true)
    protected Automobil automobil;
    @XmlElement(name = "datum_od", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumOd;
    @XmlElement(name = "datum_do", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumDo;
    @XmlElement(name = "cena_po_danu")
    protected double cenaPoDanu;
    @XmlElement(name = "cena_po_kilometru")
    protected double cenaPoKilometru;
    @XmlElement(name = "cena_za_cdw")
    protected double cenaZaCdw;

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
     * Gets the value of the datumOd property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumOd() {
        return datumOd;
    }

    /**
     * Sets the value of the datumOd property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumOd(XMLGregorianCalendar value) {
        this.datumOd = value;
    }

    /**
     * Gets the value of the datumDo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumDo() {
        return datumDo;
    }

    /**
     * Sets the value of the datumDo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumDo(XMLGregorianCalendar value) {
        this.datumDo = value;
    }

    /**
     * Gets the value of the cenaPoDanu property.
     * 
     */
    public double getCenaPoDanu() {
        return cenaPoDanu;
    }

    /**
     * Sets the value of the cenaPoDanu property.
     * 
     */
    public void setCenaPoDanu(double value) {
        this.cenaPoDanu = value;
    }

    /**
     * Gets the value of the cenaPoKilometru property.
     * 
     */
    public double getCenaPoKilometru() {
        return cenaPoKilometru;
    }

    /**
     * Sets the value of the cenaPoKilometru property.
     * 
     */
    public void setCenaPoKilometru(double value) {
        this.cenaPoKilometru = value;
    }

    /**
     * Gets the value of the cenaZaCdw property.
     * 
     */
    public double getCenaZaCdw() {
        return cenaZaCdw;
    }

    /**
     * Sets the value of the cenaZaCdw property.
     * 
     */
    public void setCenaZaCdw(double value) {
        this.cenaZaCdw = value;
    }

}
