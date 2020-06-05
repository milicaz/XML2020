package com.rentacar.car_service.service;

import java.util.List;

import com.rentacar.car_service.model.MarkaAuta;

public interface MarkaAutaService {

	MarkaAuta findOneById(Long id);

	List<MarkaAuta> findAll();
	
	MarkaAuta createMarkaAuta(MarkaAuta markaAuta);
	
	void updateMarkaAuta(MarkaAuta markaAuta);

}
