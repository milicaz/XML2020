package com.rentacar.advertisementservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentacar.advertisementservice.model.Oglas;
import com.rentacar.advertisementservice.repository.OglasRepository;
import com.rentacar.advertisementservice.service.OglasService;

@Service
public class OglasServiceImpl implements OglasService{
	
	@Autowired
	private OglasRepository oglasRepo;
	
	@Override
	public Oglas findOne(Long id) {
		return oglasRepo.findOne(id);
	}
	
	@Override
	public List<Oglas> findAll() {
		return oglasRepo.findAll();
	}


}
