package com.rentacar.car_service.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentacar.car_service.model.TipMenjaca;
import com.rentacar.car_service.repository.TipMenjacaRepository;
import com.rentacar.car_service.service.TipMenjacaService;

@Service
public class TipMenjacaServiceImpl implements TipMenjacaService {

	@Autowired
	TipMenjacaRepository tmr;

	@Override
	public TipMenjaca findOneById(Long id) {
		return tmr.findOneById(id);
	}

	@Override
	public List<TipMenjaca> findAll() {
		return tmr.findAll();
	}

	@Override
	public TipMenjaca createTipMenjaca(TipMenjaca tipMenjaca) {
		return tmr.save(tipMenjaca);
	}

	@Override
	public void updateTipMenjaca(TipMenjaca tipMenjaca) {
		tmr.save(tipMenjaca);
	}

}
