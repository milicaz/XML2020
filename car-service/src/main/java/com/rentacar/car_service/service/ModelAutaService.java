package com.rentacar.car_service.service;

import java.util.List;

import com.rentacar.car_service.model.ModelAuta;

public interface ModelAutaService {

	ModelAuta findOneById(Long id);

	List<ModelAuta> findAllByMarkaAuta(Long markaId);

	List<ModelAuta> findAll();

	ModelAuta createModelAuta(ModelAuta modelAuta);

	void updateModelAuta(ModelAuta modelAuta);

}
