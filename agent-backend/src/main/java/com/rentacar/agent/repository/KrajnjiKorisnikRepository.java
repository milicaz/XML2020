package com.rentacar.agent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentacar.agent.model.KrajnjiKorisnik;

@Repository
public interface KrajnjiKorisnikRepository extends JpaRepository<KrajnjiKorisnik, Long> {

	KrajnjiKorisnik findOneByUsername(String username);

	KrajnjiKorisnik findOneByEmail(String email);

}
