package com.rentacar.car_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentacar.car_service.model.KlasaAuta;

@Repository
public interface KlasaAutaRepository extends JpaRepository<KlasaAuta, Long> {

	KlasaAuta findOneById(Long id);

	List<KlasaAuta> findAll();

}
