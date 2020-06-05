package com.rentacar.advertisementservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rentacar.advertisementservice.model.Oglas;
import com.rentacar.advertisementservice.service.OglasService;

@RestController
public class OglasController {

	@Autowired
	private OglasService oglasService;
	
	@GetMapping("/oglasi")
	public List<Oglas> allOglasi() {
		return oglasService.findAll();
	}
	
	@GetMapping("/oglas/{id}")
	public Oglas find(@PathVariable Long id){
		return oglasService.findOne(id);
	}
}
