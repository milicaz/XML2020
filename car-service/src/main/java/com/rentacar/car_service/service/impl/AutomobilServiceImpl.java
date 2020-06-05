package com.rentacar.car_service.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentacar.car_service.model.Automobil;
import com.rentacar.car_service.repository.AutomobilRepository;
import com.rentacar.car_service.service.AutomobilService;

@Service
public class AutomobilServiceImpl implements AutomobilService {

	@Autowired
	AutomobilRepository ar;

	@Override
	public Automobil findOneById(Long id) {
		return ar.findOneById(id);
	}

	@Override
	public List<Automobil> findAll() {
		return ar.findAll();
	}

	@Override
	public Automobil createAutomobil(Automobil automobil) {
		return ar.save(automobil);
	}

	@Override
	public void updateAutomobil(Automobil automobil) {
		ar.save(automobil);
	}

}
