package com.rentacar.car_service.service;

import java.util.List;

import com.rentacar.car_service.model.VrstaGoriva;

public interface VrstaGorivaService {

	VrstaGoriva findOneById(Long id);

	List<VrstaGoriva> findAll();

	VrstaGoriva createVrstaGoriva(VrstaGoriva vrstaGoriva);

	void updateVrstaGoriva(VrstaGoriva vrstaGoriva);

}
