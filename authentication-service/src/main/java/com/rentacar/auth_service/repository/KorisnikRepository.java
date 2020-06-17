package com.rentacar.auth_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentacar.auth_service.model.Korisnik;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {

	Korisnik findOneByUsername(String username);

	Korisnik findOneByEmail(String email);

}
