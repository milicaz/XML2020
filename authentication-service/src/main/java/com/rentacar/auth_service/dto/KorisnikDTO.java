package com.rentacar.auth_service.dto;

public class KorisnikDTO {

	private long id;
	private String username;
	private String password;
	private String email;
	private String ime;
	private String prezime;
	private String ulica;
	private String mesto;
	private String drzava;

	public KorisnikDTO() {
	}

	public KorisnikDTO(long id, String username, String password, String email, String ime, String prezime,
			String ulica, String mesto, String drzava) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.ime = ime;
		this.prezime = prezime;
		this.ulica = ulica;
		this.mesto = mesto;
		this.drzava = drzava;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public String getMesto() {
		return mesto;
	}

	public void setMesto(String mesto) {
		this.mesto = mesto;
	}

	public String getDrzava() {
		return drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

}
