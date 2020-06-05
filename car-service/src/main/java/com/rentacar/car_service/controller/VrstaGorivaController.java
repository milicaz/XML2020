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

import com.rentacar.car_service.dto.VrstaGorivaDTO;
import com.rentacar.car_service.model.VrstaGoriva;
import com.rentacar.car_service.repository.VrstaGorivaRepository;
import com.rentacar.car_service.service.VrstaGorivaService;

@RestController
@RequestMapping(value = "/vrstaGoriva", produces = MediaType.APPLICATION_JSON_VALUE)
public class VrstaGorivaController {

	@Autowired
	private VrstaGorivaService vgs;

	@Autowired
	private VrstaGorivaRepository vgr;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping(value = "/all")
	public ResponseEntity<List<VrstaGorivaDTO>> getAll() {
		try {
			List<VrstaGorivaDTO> vrstaGorivaDTO = vgs.findAll().stream().map(this::convertToDto)
					.collect(Collectors.toList());
			return new ResponseEntity<>(vrstaGorivaDTO, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/{id}")
	@ResponseBody
	public VrstaGorivaDTO findById(@PathVariable("id") Long id) {
		return convertToDto(vgs.findOneById(id));
	}

	@PostMapping
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public VrstaGorivaDTO createVrstaGoriva(@RequestBody VrstaGorivaDTO vrstaGorivaDto) throws ParseException {
		VrstaGoriva gorivo = convertToEntity(vrstaGorivaDto);
		VrstaGoriva kreiran = vgs.createVrstaGoriva(gorivo);
		return convertToDto(kreiran);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<VrstaGorivaDTO> updateVrstaGoriva(@PathVariable Long id,
			@RequestBody VrstaGorivaDTO vrstaDTO) {
		VrstaGoriva vrsta = this.convertToEntity(vrstaDTO);
		vrsta.setId(id);

		vgs.updateVrstaGoriva(vrsta);

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(vrstaDTO);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteVrstaGoriva(@PathVariable("id") Long id) {
		vgr.deleteById(id);
	}

	private VrstaGorivaDTO convertToDto(VrstaGoriva vrstaGoriva) {
		VrstaGorivaDTO vrstaDTO = modelMapper.map(vrstaGoriva, VrstaGorivaDTO.class);
		return vrstaDTO;
	}

	private VrstaGoriva convertToEntity(VrstaGorivaDTO vrstaDTO) {
		VrstaGoriva vrstaGoriva = modelMapper.map(vrstaDTO, VrstaGoriva.class);
		return vrstaGoriva;
	}

}
