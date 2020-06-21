package com.rentacar.agent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rentacar.agent.model.Korisnik;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {

	Korisnik findOneByUsername(String username);

	Korisnik findOneByEmail(String email);
	
	@Query(value = "DELETE FROM Korisnik WHERE tip_korisnika = ?1", nativeQuery = true)
	void deleteAgent(String agent);

}
