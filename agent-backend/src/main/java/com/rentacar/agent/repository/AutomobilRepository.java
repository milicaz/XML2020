package com.rentacar.agent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentacar.agent.model.Automobil;

@Repository
public interface AutomobilRepository extends JpaRepository<Automobil, Long> {
	

}
