package com.rentacar.car_service.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentacar.car_service.model.ModelAuta;
import com.rentacar.car_service.repository.ModelAutaRepository;
import com.rentacar.car_service.service.ModelAutaService;

@Service
public class ModelAutaServiceImpl implements ModelAutaService {

	@Autowired
	ModelAutaRepository mar;

	@Override
	public ModelAuta findOneById(Long id) {
		return mar.findOneById(id);
	}

	@Override
	public List<ModelAuta> findAllByMarkaAuta(Long markaId) {
		return mar.findAllByMarkaAuta(markaId);
	}

	@Override
	public List<ModelAuta> findAll() {
		return mar.findAll();
	}

	@Override
	public ModelAuta createModelAuta(ModelAuta modelAuta) {
		return mar.save(modelAuta);
	}

	@Override
	public void updateModelAuta(ModelAuta modelAuta) {
		mar.save(modelAuta);
	}
	
	

}
