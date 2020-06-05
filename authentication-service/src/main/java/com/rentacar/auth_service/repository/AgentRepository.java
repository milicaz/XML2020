package com.rentacar.auth_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentacar.auth_service.model.Agent;

public interface AgentRepository extends JpaRepository<Agent, Long> {

}
