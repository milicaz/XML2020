package com.rentacar.auth_service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentacar.auth_service.model.KrajnjiKorisnik;
import com.rentacar.auth_service.repository.KrajnjiKorisnikRepository;
import com.rentacar.auth_service.service.KrajnjiKorisnikService;

@Service
public class KrajnjiKorisnikServiceImpl implements KrajnjiKorisnikService {

	@Autowired
	private KrajnjiKorisnikRepository kkr;

	@Override
	public void blockKorsnik(Long id) {
		KrajnjiKorisnik korisnik = kkr.findOneById(id);
		korisnik.setBlokiran(true);
		kkr.save(korisnik);

	}

	@Override
	public void unblockKorinsik(Long id) {
		KrajnjiKorisnik korisnik = kkr.findOneById(id);
		korisnik.setBlokiran(false);
		kkr.save(korisnik);

	}

	@Override
	public void activateKorisnik(Long id) {
		KrajnjiKorisnik korisnik = kkr.findOneById(id);
		korisnik.setAktivan(false);
		kkr.save(korisnik);

	}

	@Override
	public void deactivateKorisnik(Long id) {
		KrajnjiKorisnik korisnik = kkr.findOneById(id);
		korisnik.setAktivan(true);
		kkr.save(korisnik);

	}

}
