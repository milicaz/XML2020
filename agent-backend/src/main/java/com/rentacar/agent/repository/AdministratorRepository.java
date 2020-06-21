package com.rentacar.agent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentacar.agent.model.Administrator;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long> {

}
