package com.rentacar.agent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentacar.agent.model.Agent;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {

	Agent findOneByUsername(String username);

	Agent findOneByEmail(String email);

}
