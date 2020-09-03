package com.rentacar.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentacar.backend.model.KrajnjiKorisnik;

@Repository
public interface KrajnjiKorisnikRepository extends JpaRepository<KrajnjiKorisnik, Long> {

	KrajnjiKorisnik findOneById(Long id);

	KrajnjiKorisnik findOneByUsername(String username);

	KrajnjiKorisnik findOneByEmail(String email);

}
