package com.rentacar.car_service.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentacar.car_service.model.VrstaGoriva;
import com.rentacar.car_service.repository.VrstaGorivaRepository;
import com.rentacar.car_service.service.VrstaGorivaService;

@Service
public class VrstaGorivaServiceImpl implements VrstaGorivaService {

	@Autowired
	VrstaGorivaRepository vgr;

	@Override
	public VrstaGoriva findOneById(Long id) {
		return vgr.findOneById(id);
	}

	@Override
	public List<VrstaGoriva> findAll() {
		return vgr.findAll();
	}

	@Override
	public VrstaGoriva createVrstaGoriva(VrstaGoriva vrstaGoriva) {
		return vgr.save(vrstaGoriva);
	}

	@Override
	public void updateVrstaGoriva(VrstaGoriva vrstaGoriva) {
		vgr.save(vrstaGoriva);
	}

}
