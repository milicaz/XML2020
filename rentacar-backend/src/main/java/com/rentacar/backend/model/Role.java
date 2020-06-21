package com.rentacar.backend.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "uloge")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	@Column
	private String name;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "privilegije_uloga", joinColumns = @JoinColumn(name = "uloga_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_privilegije", referencedColumnName = "id"))
	private List<Privilege> privilegije;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Privilege> getPrivilegije() {
		return privilegije;
	}

	public void setPrivilegije(List<Privilege> privilegije) {
		this.privilegije = privilegije;
	}

}
