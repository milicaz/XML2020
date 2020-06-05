package com.rentacar.car_service.service;

import java.util.List;

import com.rentacar.car_service.model.Automobil;

public interface AutomobilService {

	Automobil findOneById(Long id);

	List<Automobil> findAll();

	Automobil createAutomobil(Automobil automobil);

	void updateAutomobil(Automobil automobil);

}
