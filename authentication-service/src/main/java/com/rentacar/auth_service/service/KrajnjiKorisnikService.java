package com.rentacar.auth_service.service;

public interface KrajnjiKorisnikService {

	void blockKorsnik(Long id);

	void unblockKorinsik(Long id);

	void activateKorisnik(Long id);

	void deactivateKorisnik(Long id);

}
