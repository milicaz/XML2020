//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5.1 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.28 at 11:40:09 AM CEST 
//


package com.rentacar.car_service.model;

import java.math.BigInteger;
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
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="marka_automobila" type="{rentacar}MarkaAuta"/>
 *         &lt;element name="model_automobila" type="{rentacar}ModelAuta"/>
 *         &lt;element name="klasa_automobila" type="{rentacar}KlasaAuta"/>
 *         &lt;element name="vrsta_goriva" type="{rentacar}VrstaGoriva"/>
 *         &lt;element name="tip_menjaca" type="{rentacar}TipMenjaca"/>
 *         &lt;element name="kilometraza" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="dozvoljena_kilometraza" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="cdw" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="decija_sedista" type="{http://www.w3.org/2001/XMLSchema}integer"/>
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
    "markaAutomobila",
    "modelAutomobila",
    "klasaAutomobila",
    "vrstaGoriva",
    "tipMenjaca",
    "kilometraza",
    "dozvoljenaKilometraza",
    "cdw",
    "decijaSedista"
})
@XmlRootElement(name = "Automobil")
public class Automobil {

    protected long id;
    @XmlElement(name = "marka_automobila", required = true)
    protected MarkaAuta markaAutomobila;
    @XmlElement(name = "model_automobila", required = true)
    protected ModelAuta modelAutomobila;
    @XmlElement(name = "klasa_automobila", required = true)
    protected KlasaAuta klasaAutomobila;
    @XmlElement(name = "vrsta_goriva", required = true)
    protected VrstaGoriva vrstaGoriva;
    @XmlElement(name = "tip_menjaca", required = true)
    protected TipMenjaca tipMenjaca;
    protected double kilometraza;
    @XmlElement(name = "dozvoljena_kilometraza")
    protected double dozvoljenaKilometraza;
    protected boolean cdw;
    @XmlElement(name = "decija_sedista", required = true)
    protected BigInteger decijaSedista;

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
     * Gets the value of the markaAutomobila property.
     * 
     * @return
     *     possible object is
     *     {@link MarkaAuta }
     *     
     */
    public MarkaAuta getMarkaAutomobila() {
        return markaAutomobila;
    }

    /**
     * Sets the value of the markaAutomobila property.
     * 
     * @param value
     *     allowed object is
     *     {@link MarkaAuta }
     *     
     */
    public void setMarkaAutomobila(MarkaAuta value) {
        this.markaAutomobila = value;
    }

    /**
     * Gets the value of the modelAutomobila property.
     * 
     * @return
     *     possible object is
     *     {@link ModelAuta }
     *     
     */
    public ModelAuta getModelAutomobila() {
        return modelAutomobila;
    }

    /**
     * Sets the value of the modelAutomobila property.
     * 
     * @param value
     *     allowed object is
     *     {@link ModelAuta }
     *     
     */
    public void setModelAutomobila(ModelAuta value) {
        this.modelAutomobila = value;
    }

    /**
     * Gets the value of the klasaAutomobila property.
     * 
     * @return
     *     possible object is
     *     {@link KlasaAuta }
     *     
     */
    public KlasaAuta getKlasaAutomobila() {
        return klasaAutomobila;
    }

    /**
     * Sets the value of the klasaAutomobila property.
     * 
     * @param value
     *     allowed object is
     *     {@link KlasaAuta }
     *     
     */
    public void setKlasaAutomobila(KlasaAuta value) {
        this.klasaAutomobila = value;
    }

    /**
     * Gets the value of the vrstaGoriva property.
     * 
     * @return
     *     possible object is
     *     {@link VrstaGoriva }
     *     
     */
    public VrstaGoriva getVrstaGoriva() {
        return vrstaGoriva;
    }

    /**
     * Sets the value of the vrstaGoriva property.
     * 
     * @param value
     *     allowed object is
     *     {@link VrstaGoriva }
     *     
     */
    public void setVrstaGoriva(VrstaGoriva value) {
        this.vrstaGoriva = value;
    }

    /**
     * Gets the value of the tipMenjaca property.
     * 
     * @return
     *     possible object is
     *     {@link TipMenjaca }
     *     
     */
    public TipMenjaca getTipMenjaca() {
        return tipMenjaca;
    }

    /**
     * Sets the value of the tipMenjaca property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipMenjaca }
     *     
     */
    public void setTipMenjaca(TipMenjaca value) {
        this.tipMenjaca = value;
    }

    /**
     * Gets the value of the kilometraza property.
     * 
     */
    public double getKilometraza() {
        return kilometraza;
    }

    /**
     * Sets the value of the kilometraza property.
     * 
     */
    public void setKilometraza(double value) {
        this.kilometraza = value;
    }

    /**
     * Gets the value of the dozvoljenaKilometraza property.
     * 
     */
    public double getDozvoljenaKilometraza() {
        return dozvoljenaKilometraza;
    }

    /**
     * Sets the value of the dozvoljenaKilometraza property.
     * 
     */
    public void setDozvoljenaKilometraza(double value) {
        this.dozvoljenaKilometraza = value;
    }

    /**
     * Gets the value of the cdw property.
     * 
     */
    public boolean isCdw() {
        return cdw;
    }

    /**
     * Sets the value of the cdw property.
     * 
     */
    public void setCdw(boolean value) {
        this.cdw = value;
    }

    /**
     * Gets the value of the decijaSedista property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDecijaSedista() {
        return decijaSedista;
    }

    /**
     * Sets the value of the decijaSedista property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDecijaSedista(BigInteger value) {
        this.decijaSedista = value;
    }

}
