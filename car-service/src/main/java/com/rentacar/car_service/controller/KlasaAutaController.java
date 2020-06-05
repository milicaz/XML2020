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

import com.rentacar.car_service.dto.KlasaAutaDTO;
import com.rentacar.car_service.model.KlasaAuta;
import com.rentacar.car_service.repository.KlasaAutaRepository;
import com.rentacar.car_service.service.KlasaAutaService;

@RestController
@RequestMapping(value = "/klasaAuta", produces = MediaType.APPLICATION_JSON_VALUE)
public class KlasaAutaController {

	@Autowired
	private KlasaAutaService kas;

	@Autowired
	private KlasaAutaRepository kar;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping(value = "/all")
	public ResponseEntity<List<KlasaAutaDTO>> getAll() {
		try {
			List<KlasaAutaDTO> klasaAutaDTO = kas.findAll().stream().map(this::convertToDto)
					.collect(Collectors.toList());
			return new ResponseEntity<>(klasaAutaDTO, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/{id}")
	@ResponseBody
	public KlasaAutaDTO findById(@PathVariable("id") Long id) {
		return convertToDto(kas.findOneById(id));
	}

	@PostMapping
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public KlasaAutaDTO createKlasaAuta(@RequestBody KlasaAutaDTO klasaAutaDto) throws ParseException {
		KlasaAuta auto = convertToEntity(klasaAutaDto);
		KlasaAuta kreiran = kas.createKlasaAuta(auto);
		return convertToDto(kreiran);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<KlasaAutaDTO> updateKlasaAuta(@PathVariable Long id, @RequestBody KlasaAutaDTO klasaDTO) {
		KlasaAuta klasa = this.convertToEntity(klasaDTO);
		klasa.setId(id);

		kas.updateKlasaAuta(klasa);

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(klasaDTO);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteKlasaAuta(@PathVariable("id") Long id) {
		kar.deleteById(id);
	}

	private KlasaAutaDTO convertToDto(KlasaAuta klasaAuta) {
		KlasaAutaDTO klasaDTO = modelMapper.map(klasaAuta, KlasaAutaDTO.class);
		return klasaDTO;
	}

	private KlasaAuta convertToEntity(KlasaAutaDTO klasaDTO) {
		KlasaAuta klasaAuta = modelMapper.map(klasaDTO, KlasaAuta.class);
		return klasaAuta;
	}

}
