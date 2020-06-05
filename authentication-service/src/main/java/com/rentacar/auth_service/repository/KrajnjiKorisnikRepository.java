package com.rentacar.auth_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentacar.auth_service.model.KrajnjiKorisnik;

public interface KrajnjiKorisnikRepository extends JpaRepository<KrajnjiKorisnik, Long> {
	KrajnjiKorisnik findOneById(Long id);

	KrajnjiKorisnik findByUsername(String username);

	KrajnjiKorisnik findByEmail(String email);

}
