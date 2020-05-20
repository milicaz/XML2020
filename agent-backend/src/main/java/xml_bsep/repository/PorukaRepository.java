package xml_bsep.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xml_bsep.model.Poruka;

public interface PorukaRepository extends JpaRepository<Poruka, Long> {

	public Poruka findOneById(Long id);

}
