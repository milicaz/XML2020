package com.rentacar.advertisementservice.service;

import java.util.List;

import com.google.common.base.Optional;
import com.rentacar.advertisementservice.model.Oglas;

public interface OglasService {

	Oglas findOne(Long id);
	
	List<Oglas> findAll();
	
	void delete(Long id);
	

}
