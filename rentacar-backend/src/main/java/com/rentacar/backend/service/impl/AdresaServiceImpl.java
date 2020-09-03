package com.rentacar.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentacar.backend.model.Adresa;
import com.rentacar.backend.repository.AdresaRepository;
import com.rentacar.backend.service.AdresaService;

@Service
public class AdresaServiceImpl implements AdresaService {

	@Autowired
	private AdresaRepository adresaRepository;

	@Override
	public Adresa findOneByUlicaBrojMestoDrzava(String ulica, String broj, String mesto, String drzava) {
		return adresaRepository.findOneByUlicaBrojMestoDrzava(ulica, broj, mesto, drzava);
	}

	@Override
	public Adresa save(Adresa adresa) {
		return adresaRepository.save(adresa);
	}

	@Override
	public Adresa findOneById(Long id) {
		return adresaRepository.findById(id).get();
	}

}
