//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5.1 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.28 at 11:40:09 AM CEST 
//


package rentacar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for KrajnjiKorisnik complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="KrajnjiKorisnik">
 *   &lt;complexContent>
 *     &lt;extension base="{rentacar}Korisnik">
 *       &lt;attribute name="aktivan" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="broj_ograsa">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *             &lt;minInclusive value="0"/>
 *             &lt;maxInclusive value="3"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KrajnjiKorisnik")
public class KrajnjiKorisnik
    extends Korisnik
{

    @XmlAttribute(name = "aktivan")
    protected Boolean aktivan;
    @XmlAttribute(name = "broj_ograsa")
    protected Integer brojOgrasa;

    /**
     * Gets the value of the aktivan property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAktivan() {
        return aktivan;
    }

    /**
     * Sets the value of the aktivan property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAktivan(Boolean value) {
        this.aktivan = value;
    }

    /**
     * Gets the value of the brojOgrasa property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBrojOgrasa() {
        return brojOgrasa;
    }

    /**
     * Sets the value of the brojOgrasa property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBrojOgrasa(Integer value) {
        this.brojOgrasa = value;
    }

}