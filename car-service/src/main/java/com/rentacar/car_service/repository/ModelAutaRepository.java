package com.rentacar.car_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentacar.car_service.model.ModelAuta;

@Repository
public interface ModelAutaRepository extends JpaRepository<ModelAuta, Long> {
	
	ModelAuta findOneById(Long id);
	
	List<ModelAuta> findAllByMarkaAuta(Long markaId);

	List<ModelAuta> findAll();

}
