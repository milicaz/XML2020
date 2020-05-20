package xml_bsep.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xml_bsep.model.Komentar;

public interface KomentarRepository extends JpaRepository<Komentar, Long> {

	public Komentar findOneById(Long id);

}
