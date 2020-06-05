package com.rentacar.auth_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentacar.auth_service.model.Administrator;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
}
