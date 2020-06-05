package com.rentacar.car_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentacar.car_service.model.MarkaAuta;

@Repository
public interface MarkaAutaRepository extends JpaRepository<MarkaAuta, Long> {

	MarkaAuta findOneById(Long id);

	List<MarkaAuta> findAll();

}
