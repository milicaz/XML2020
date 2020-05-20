package xml_bsep.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xml_bsep.model.Automobil;

public interface AutomobilRepository extends JpaRepository<Automobil, Long> {
	
	public Automobil findOneById(Long id);
	

}
