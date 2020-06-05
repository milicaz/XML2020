//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5.1 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.28 at 11:40:09 AM CEST 
//


package com.rentacar.advertisementservice.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
 *         &lt;element name="korisnik" type="{rentacar}Korisnik"/>
 *         &lt;element ref="{rentacar}Cenovnik"/>
 *         &lt;element name="slika" type="{http://www.w3.org/2001/XMLSchema}anyType" maxOccurs="unbounded"/>
 *         &lt;element name="slobodan_od" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="slobodan_do" type="{http://www.w3.org/2001/XMLSchema}date"/>
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
    "korisnik",
    "cenovnik",
    "slika",
    "slobodanOd",
    "slobodanDo"
})
@XmlRootElement(name = "Oglas")
@Entity
@Table(name = "oglasi")
public class Oglas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    @XmlElement(name = "Automobil", required = true)
    @ManyToOne
    @JoinColumn(name = "auto_id", nullable = false)
    protected Automobil automobil;
    @XmlElement(required = true)
    @OneToOne
    @JoinColumn(name = "korisnik_id", nullable = false)
    protected Korisnik korisnik;
    @XmlElement(name = "Cenovnik", required = true)
    @OneToOne
    @JoinColumn(name = "cenovnik_id", nullable = false)
    protected Cenovnik cenovnik;
    @XmlElement(required = true)
    protected byte[] slika;
    @XmlElement(name = "slobodan_od", required = true)
    @XmlSchemaType(name = "date")
    protected Date slobodanOd;
    @XmlElement(name = "slobodan_do", required = true)
    @XmlSchemaType(name = "date")
    protected Date slobodanDo;

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
     * Gets the value of the korisnik property.
     * 
     * @return
     *     possible object is
     *     {@link Korisnik }
     *     
     */
    public Korisnik getKorisnik() {
        return korisnik;
    }

    /**
     * Sets the value of the korisnik property.
     * 
     * @param value
     *     allowed object is
     *     {@link Korisnik }
     *     
     */
    public void setKorisnik(Korisnik value) {
        this.korisnik = value;
    }

    /**
     * Gets the value of the cenovnik property.
     * 
     * @return
     *     possible object is
     *     {@link Cenovnik }
     *     
     */
    public Cenovnik getCenovnik() {
        return cenovnik;
    }

    /**
     * Sets the value of the cenovnik property.
     * 
     * @param value
     *     allowed object is
     *     {@link Cenovnik }
     *     
     */
    public void setCenovnik(Cenovnik value) {
        this.cenovnik = value;
    }

    /**
     * Gets the value of the slika property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the slika property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSlika().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    
    public byte[] getSlika() {
		return slika;
	}

	public void setSlika(byte[] slika) {
		this.slika = slika;
	}

    /**
     * Gets the value of the slobodanOd property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    
    
    public Date getSlobodanOd() {
        return slobodanOd;
    }

	/**
     * Sets the value of the slobodanOd property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSlobodanOd(Date value) {
        this.slobodanOd = value;
    }

    /**
     * Gets the value of the slobodanDo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public Date getSlobodanDo() {
        return slobodanDo;
    }

    /**
     * Sets the value of the slobodanDo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSlobodanDo(Date value) {
        this.slobodanDo = value;
    }

}
