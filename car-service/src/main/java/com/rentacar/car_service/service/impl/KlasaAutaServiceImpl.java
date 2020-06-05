package com.rentacar.car_service.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentacar.car_service.model.KlasaAuta;
import com.rentacar.car_service.repository.KlasaAutaRepository;
import com.rentacar.car_service.service.KlasaAutaService;

@Service
public class KlasaAutaServiceImpl implements KlasaAutaService {

	@Autowired
	KlasaAutaRepository kar;

	@Override
	public KlasaAuta findOneById(Long id) {
		return kar.findOneById(id);
	}

	@Override
	public List<KlasaAuta> findAll() {
		return kar.findAll();
	}

	@Override
	public KlasaAuta createKlasaAuta(KlasaAuta klasaAuta) {
		return kar.save(klasaAuta);
	}

	@Override
	public void updateKlasaAuta(KlasaAuta klasaAuta) {
		kar.save(klasaAuta);
	}

}
