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

import com.rentacar.car_service.dto.MarkaAutaDTO;
import com.rentacar.car_service.model.MarkaAuta;
import com.rentacar.car_service.repository.MarkaAutaRepository;
import com.rentacar.car_service.service.MarkaAutaService;

@RestController
@RequestMapping(value = "/markaAuta", produces = MediaType.APPLICATION_JSON_VALUE)
public class MarkaAutaController {

	@Autowired
	private MarkaAutaService mas;
	@Autowired
	private MarkaAutaRepository mar;
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping(value = "/all")
	public ResponseEntity<List<MarkaAutaDTO>> getAll() {
		try {
			List<MarkaAutaDTO> markaAutaDTO = mas.findAll().stream().map(this::convertToDto)
					.collect(Collectors.toList());
			return new ResponseEntity<>(markaAutaDTO, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/{id}")
	@ResponseBody
	public MarkaAutaDTO findById(@PathVariable("id") Long id) {
		return convertToDto(mas.findOneById(id));
	}

	@PostMapping
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public MarkaAutaDTO createMarkaAuta(@RequestBody MarkaAutaDTO markaAutaDto) throws ParseException {
		MarkaAuta auto = convertToEntity(markaAutaDto);
		MarkaAuta kreiran = mas.createMarkaAuta(auto);
		return convertToDto(kreiran);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<MarkaAutaDTO> updateMarkaAuta(@PathVariable Long id, @RequestBody MarkaAutaDTO markaDTO) {
		MarkaAuta marka = this.convertToEntity(markaDTO);
		marka.setId(id);

		mas.updateMarkaAuta(marka);

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(markaDTO);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteMarkaAuta(@PathVariable("id") Long id) {
		mar.deleteById(id);
	}

	private MarkaAutaDTO convertToDto(MarkaAuta markaAuta) {
		MarkaAutaDTO markaDTO = modelMapper.map(markaAuta, MarkaAutaDTO.class);
		return markaDTO;
	}

	private MarkaAuta convertToEntity(MarkaAutaDTO markaDTO) {
		MarkaAuta markaAuta = modelMapper.map(markaDTO, MarkaAuta.class);
		return markaAuta;
	}

}
