package com.rentacar.auth_service.service;

import com.rentacar.auth_service.model.Korisnik;

public interface KorisnikService {

	Korisnik findOneByUsername(String username);

	Korisnik findOneByEmail(String email);
}
