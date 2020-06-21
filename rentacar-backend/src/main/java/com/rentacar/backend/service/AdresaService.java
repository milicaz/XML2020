package com.rentacar.backend.service;

import com.rentacar.backend.model.Adresa;

public interface AdresaService {
	
	Adresa findOneByUlicaBrojMestoDrzava(String ulica, String broj, String mesto, String drzava);
	
	Adresa save(Adresa adresa);
	
	Adresa findOneById(Long id);

}
