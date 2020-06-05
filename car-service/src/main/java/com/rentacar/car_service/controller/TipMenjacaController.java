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

import com.rentacar.car_service.dto.TipMenjacaDTO;
import com.rentacar.car_service.model.TipMenjaca;
import com.rentacar.car_service.repository.TipMenjacaRepository;
import com.rentacar.car_service.service.TipMenjacaService;

@RestController
@RequestMapping(value = "/tipMenjaca", produces = MediaType.APPLICATION_JSON_VALUE)
public class TipMenjacaController {

	@Autowired
	private TipMenjacaService tms;

	@Autowired
	private TipMenjacaRepository tmr;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping(value = "/all")
	public ResponseEntity<List<TipMenjacaDTO>> getAll() {
		try {
			List<TipMenjacaDTO> tipMenjacaDTO = tms.findAll().stream().map(this::convertToDto)
					.collect(Collectors.toList());
			return new ResponseEntity<>(tipMenjacaDTO, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/{id}")
	@ResponseBody
	public TipMenjacaDTO findById(@PathVariable("id") Long id) {
		return convertToDto(tms.findOneById(id));
	}

	@PostMapping
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public TipMenjacaDTO createTipMenjaca(@RequestBody TipMenjacaDTO tipMenjacaDto) throws ParseException {
		TipMenjaca tip = convertToEntity(tipMenjacaDto);
		TipMenjaca kreiran = tms.createTipMenjaca(tip);
		return convertToDto(kreiran);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<TipMenjacaDTO> updateTipMenjaca(@PathVariable Long id, @RequestBody TipMenjacaDTO tipDTO) {
		TipMenjaca tip = this.convertToEntity(tipDTO);
		tip.setId(id);

		tms.updateTipMenjaca(tip);

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(tipDTO);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteTipMenjaca(@PathVariable("id") Long id) {
		tmr.deleteById(id);
	}

	private TipMenjacaDTO convertToDto(TipMenjaca tipMenjaca) {
		TipMenjacaDTO tipDTO = modelMapper.map(tipMenjaca, TipMenjacaDTO.class);
		return tipDTO;
	}

	private TipMenjaca convertToEntity(TipMenjacaDTO tipMenjacaDTO) {
		TipMenjaca tipMenjaca = modelMapper.map(tipMenjacaDTO, TipMenjaca.class);
		return tipMenjaca;
	}

}
