package com.rentacar.car_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentacar.car_service.model.Automobil;

@Repository
public interface AutomobilRepository extends JpaRepository<Automobil, Long> {

	Automobil findOneById(Long id);

	List<Automobil> findAll();

}
