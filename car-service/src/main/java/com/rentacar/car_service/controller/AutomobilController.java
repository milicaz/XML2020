package com.rentacar.car_service.controller;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rentacar.car_service.dto.AutomobilDTO;
import com.rentacar.car_service.model.Automobil;
import com.rentacar.car_service.repository.AutomobilRepository;
import com.rentacar.car_service.service.AutomobilService;

@RestController
@RequestMapping(value = "/automobil", produces = MediaType.APPLICATION_JSON_VALUE)
public class AutomobilController {

	@Autowired
	private AutomobilService as;

	@Autowired
	private AutomobilRepository ar;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping(value = "/all")
	public ResponseEntity<List<AutomobilDTO>> getAll() {
		try {
			List<AutomobilDTO> autoDTO = as.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
			return new ResponseEntity<>(autoDTO, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/{id}")
	@ResponseBody
	public AutomobilDTO findById(@PathVariable("id") Long id) {
		return convertToDto(as.findOneById(id));
	}

	@PostMapping
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public AutomobilDTO createAutomobil(@RequestBody AutomobilDTO autoDto) throws ParseException {
		Automobil auto = convertToEntity(autoDto);
		Automobil kreiran = as.createAutomobil(auto);
		return convertToDto(kreiran);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<AutomobilDTO> updateAutomobil(@PathVariable Long id, @RequestBody AutomobilDTO autoDTO) {
		Automobil auto = this.convertToEntity(autoDTO);
		auto.setId(id);

		as.updateAutomobil(auto);

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(autoDTO);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteAutomobil(@PathVariable("id") Long id) {
		ar.deleteById(id);
	}

	private AutomobilDTO convertToDto(Automobil auto) {
		AutomobilDTO autoDTO = modelMapper.map(auto, AutomobilDTO.class);
		return autoDTO;
	}

	private Automobil convertToEntity(AutomobilDTO autoDTO) {
		Automobil auto = modelMapper.map(autoDTO, Automobil.class);
		return auto;
	}

}
