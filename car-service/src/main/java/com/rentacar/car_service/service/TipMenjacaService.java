package com.rentacar.car_service.service;

import java.util.List;

import com.rentacar.car_service.model.TipMenjaca;

public interface TipMenjacaService {

	TipMenjaca findOneById(Long id);

	List<TipMenjaca> findAll();

	TipMenjaca createTipMenjaca(TipMenjaca tipMenjaca);

	void updateTipMenjaca(TipMenjaca tipMenjaca);

}
