package xml_bsep.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xml_bsep.model.Cenovnik;

public interface CenovnikRepository extends JpaRepository<Cenovnik, Long> {

	public Cenovnik findOneById(Long id);

}
