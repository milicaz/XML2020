//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5.1 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.28 at 11:40:09 AM CEST 
//

package com.rentacar.backend.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * <p>
 * Java class for Korisnik complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="Korisnik">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="email">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="prezime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="adresa" type="{rentacar}Adresa"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Korisnik", propOrder = { "id", "username", "password", "email", "ime", "prezime", "adresa" })
@XmlSeeAlso({ Agent.class, Administrator.class, KrajnjiKorisnik.class })
@Entity
@Table(name = "korisnici")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tip_korisnika", discriminatorType = DiscriminatorType.STRING)
public class Korisnik implements UserDetails, Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long id;
	@XmlElement(required = true)
	protected String username;
	@XmlElement(required = true)
	protected String password;
	@XmlElement(required = true)
	protected String email;
	@XmlElement(required = true)
	protected String ime;
	@XmlElement(required = true)
	protected String prezime;
	@XmlElement(required = true)
	@OneToOne(cascade = { CascadeType.ALL })
	protected Adresa adresa;
	@XmlElement(required = true)
	protected String role;
	@XmlElement(required = true)
	protected boolean enabled;
	@XmlElement(required = true)
	protected boolean blocked;
	@XmlElement(required = true)
	protected boolean deleted;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "uloga_korisnika", joinColumns = @JoinColumn(name = "korisnik_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "uloga_id", referencedColumnName = "id"))
	protected List<Role> roles;

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
	 * Gets the value of the username property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the value of the username property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setUsername(String value) {
		this.username = value;
	}

	/**
	 * Gets the value of the password property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the value of the password property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setPassword(String value) {
		this.password = value;
	}

	/**
	 * Gets the value of the email property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the value of the email property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setEmail(String value) {
		this.email = value;
	}

	/**
	 * Gets the value of the ime property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getIme() {
		return ime;
	}

	/**
	 * Sets the value of the ime property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setIme(String value) {
		this.ime = value;
	}

	/**
	 * Gets the value of the prezime property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPrezime() {
		return prezime;
	}

	/**
	 * Sets the value of the prezime property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setPrezime(String value) {
		this.prezime = value;
	}

	/**
	 * Gets the value of the adresa property.
	 * 
	 * @return possible object is {@link Adresa }
	 * 
	 */
	public Adresa getAdresa() {
		return adresa;
	}

	/**
	 * Sets the value of the adresa property.
	 * 
	 * @param value allowed object is {@link Adresa }
	 * 
	 */
	public void setAdresa(Adresa value) {
		this.adresa = value;
	}

	/**
	 * Gets the value of the role property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRole() {
		return role;
	}

	/**
	 * Sets the value of the role property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setRole(String role) {
		this.role = role;
	}

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	@Transient
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (!this.roles.isEmpty()) {
			Role r = roles.iterator().next();
			List<Privilege> privilegije = new ArrayList<>();
			for (Privilege p : r.getPrivilegije()) {
				privilegije.add(p);
			}
			return privilegije;
		}
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
