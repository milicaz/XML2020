package com.rentacar.advertisementservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentacar.advertisementservice.model.Oglas;

@Repository
public interface OglasRepository extends JpaRepository<Oglas, Long> {

	List<Oglas> findAll();
	
	Oglas findOneById(Long id);
}
