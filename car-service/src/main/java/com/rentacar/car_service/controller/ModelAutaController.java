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

import com.rentacar.car_service.dto.ModelAutaDTO;
import com.rentacar.car_service.model.ModelAuta;
import com.rentacar.car_service.repository.ModelAutaRepository;
import com.rentacar.car_service.service.ModelAutaService;

@RestController
@RequestMapping(value = "/modelAuta", produces = MediaType.APPLICATION_JSON_VALUE)
public class ModelAutaController {

	@Autowired
	private ModelAutaService mas;

	@Autowired
	private ModelAutaRepository mar;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping(value = "/all")
	public ResponseEntity<List<ModelAutaDTO>> getAll() {
		try {
			List<ModelAutaDTO> modelAutaDTO = mas.findAll().stream().map(this::convertToDto)
					.collect(Collectors.toList());
			return new ResponseEntity<>(modelAutaDTO, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/{id}")
	@ResponseBody
	public ModelAutaDTO findById(@PathVariable("id") Long id) {
		return convertToDto(mas.findOneById(id));

	}

	@PostMapping
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public ModelAutaDTO createModelAuta(@RequestBody ModelAutaDTO modelAutaDto) throws ParseException {
		ModelAuta model = convertToEntity(modelAutaDto);
		ModelAuta kreiran = mas.createModelAuta(model);
		return convertToDto(kreiran);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ModelAutaDTO> updateModelAuta(@PathVariable Long id, @RequestBody ModelAutaDTO modelDTO) {
		ModelAuta model = this.convertToEntity(modelDTO);
		model.setId(id);

		mas.updateModelAuta(model);

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(modelDTO);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteModelAuta(@PathVariable("id") Long id) {
		mar.deleteById(id);
	}

	private ModelAutaDTO convertToDto(ModelAuta modelAuta) {
		ModelAutaDTO modelAutaDTO = modelMapper.map(modelAuta, ModelAutaDTO.class);
		return modelAutaDTO;
	}

	private ModelAuta convertToEntity(ModelAutaDTO modelDTO) {
		ModelAuta modelAuta = modelMapper.map(modelDTO, ModelAuta.class);
		return modelAuta;
	}

}
