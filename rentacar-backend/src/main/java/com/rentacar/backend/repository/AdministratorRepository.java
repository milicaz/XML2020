package com.rentacar.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentacar.backend.model.Administrator;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long> {

}
