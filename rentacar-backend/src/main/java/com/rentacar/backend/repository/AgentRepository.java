package com.rentacar.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentacar.backend.model.Agent;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {
	Agent findOneById(Long id);

	Agent findOneByUsername(String username);

	Agent findOneByEmail(String email);

}
