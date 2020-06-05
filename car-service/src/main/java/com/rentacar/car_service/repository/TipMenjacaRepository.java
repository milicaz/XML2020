package com.rentacar.car_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentacar.car_service.model.TipMenjaca;

@Repository
public interface TipMenjacaRepository extends JpaRepository<TipMenjaca, Long> {

	TipMenjaca findOneById(Long id);

	List<TipMenjaca> findAll();

}
