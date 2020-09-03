//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5.1 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.28 at 11:40:09 AM CEST 
//

package com.rentacar.backend.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for Agent complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="Agent">
 *   &lt;complexContent>
 *     &lt;extension base="{rentacar}Korisnik">
 *       &lt;attribute name="poslovni_broj">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value=""/>
 *             &lt;minLength value="10"/>
 *             &lt;maxLength value="10"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="naziv_firme" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Agent")
@Entity
@DiscriminatorValue("AGENT")
public class Agent extends Korisnik {

	@XmlAttribute(name = "poslovni_broj")
	@Column(nullable = true)
	protected String poslovniBroj;
	@XmlAttribute(name = "naziv_firme")
	@Column(nullable = true)
	protected String nazivFirme;

	/**
	 * Gets the value of the poslovniBroj property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPoslovniBroj() {
		return poslovniBroj;
	}

	/**
	 * Sets the value of the poslovniBroj property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setPoslovniBroj(String value) {
		this.poslovniBroj = value;
	}

	/**
	 * Gets the value of the nazivFirme property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNazivFirme() {
		return nazivFirme;
	}

	/**
	 * Sets the value of the nazivFirme property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setNazivFirme(String value) {
		this.nazivFirme = value;
	}

}
