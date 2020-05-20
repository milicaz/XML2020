package xml_bsep.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xml_bsep.model.AgentBooking;

public interface BookingRepository extends JpaRepository<AgentBooking, Long> {

	public AgentBooking findOneById(Long id);

}
