package com.rentacar.car_service.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentacar.car_service.model.MarkaAuta;
import com.rentacar.car_service.repository.MarkaAutaRepository;
import com.rentacar.car_service.service.MarkaAutaService;

@Service
public class MarkaAutaServiceImpl implements MarkaAutaService {

	@Autowired
	MarkaAutaRepository mar;

	@Override
	public MarkaAuta findOneById(Long id) {
		return mar.findOneById(id);
	}

	@Override
	public List<MarkaAuta> findAll() {
		return mar.findAll();
	}

	@Override
	public MarkaAuta createMarkaAuta(MarkaAuta markaAuta) {
		return mar.save(markaAuta);
	}

	@Override
	public void updateMarkaAuta(MarkaAuta markaAuta) {
		mar.save(markaAuta);
	}

}
