package xml_bsep.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xml_bsep.model.Izvestaj;

public interface IzvestajRepository extends JpaRepository<Izvestaj, Long> {

	public Izvestaj findOneById(Long id);

}
