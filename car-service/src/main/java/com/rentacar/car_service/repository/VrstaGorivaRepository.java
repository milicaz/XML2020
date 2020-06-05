package com.rentacar.car_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentacar.car_service.model.VrstaGoriva;

@Repository
public interface VrstaGorivaRepository extends JpaRepository<VrstaGoriva, Long> {

	VrstaGoriva findOneById(Long id);

	List<VrstaGoriva> findAll();

}
