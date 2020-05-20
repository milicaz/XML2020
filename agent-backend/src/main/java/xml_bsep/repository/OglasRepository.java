package xml_bsep.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xml_bsep.model.Oglas;

public interface OglasRepository extends JpaRepository<Oglas, Long> {

	public Oglas findOneById(Long id);

}
