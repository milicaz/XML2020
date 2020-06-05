package com.rentacar.car_service.service;

import java.util.List;

import com.rentacar.car_service.model.KlasaAuta;

public interface KlasaAutaService {

	KlasaAuta findOneById(Long id);

	List<KlasaAuta> findAll();

	KlasaAuta createKlasaAuta(KlasaAuta klasaAuta);

	void updateKlasaAuta(KlasaAuta klasaAuta);

}
