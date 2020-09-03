package com.rentacar.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rentacar.backend.model.Adresa;

@Repository
public interface AdresaRepository extends JpaRepository<Adresa, Long> {
	
	@Query(value = "SELECT * FROM Adresa adresa WHERE adresa.ulica = ?1 and adresa.broj = ?2 and adresa.mesto = ?3 and adresa.drzava= ?4", nativeQuery = true)
	Adresa findOneByUlicaBrojMestoDrzava(String ulica, String broj, String mesto, String drzava);

}
