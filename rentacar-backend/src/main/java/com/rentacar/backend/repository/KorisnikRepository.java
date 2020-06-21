package com.rentacar.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentacar.backend.model.Korisnik;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {

	Korisnik findOneById(Long id);

	Korisnik findOneByUsername(String username);

	Korisnik findOneByEmail(String email);

}
