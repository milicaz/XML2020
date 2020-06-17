package com.rentacar.auth_service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentacar.auth_service.model.Korisnik;
import com.rentacar.auth_service.repository.KorisnikRepository;
import com.rentacar.auth_service.service.KorisnikService;

@Service
public class KorisnikServiceImpl implements KorisnikService {

	@Autowired
	private KorisnikRepository kr;

	@Override
	public Korisnik findOneByUsername(String username) {
		return kr.findOneByUsername(username);
	}

	@Override
	public Korisnik findOneByEmail(String email) {
		return kr.findOneByEmail(email);
	}

}
