package xml_bsep.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xml_bsep.model.Korisnik;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {
	
	public Korisnik findKorisnikByUsername(String username);

}
