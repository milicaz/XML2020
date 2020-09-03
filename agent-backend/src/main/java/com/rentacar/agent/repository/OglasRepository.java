package com.rentacar.agent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentacar.agent.model.Oglas;

@Repository
public interface OglasRepository extends JpaRepository<Oglas, Long> {

}
