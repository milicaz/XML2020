package com.rentacar.auth_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentacar.auth_service.repository.KrajnjiKorisnikRepository;
import com.rentacar.auth_service.service.KrajnjiKorisnikService;

@RestController
@RequestMapping("")
public class KrajnjiKorisnikController {

	@Autowired
	KrajnjiKorisnikService kks;

	@Autowired
	KrajnjiKorisnikRepository kkr;

	@PutMapping("/admin/activateKorisnik/{id}")
	public void activateKorisnik(@PathVariable Long id) {
		kks.activateKorisnik(id);
	}

	@PutMapping("/admin/deactivateKorisnik/{id}")
	public void deactivateKorisnik(@PathVariable Long id) {
		kks.deactivateKorisnik(id);
	}

	@PutMapping("/admin/blockKorisnik/{id}")
	public void blockKorisnik(@PathVariable Long id) {
		kks.blockKorsnik(id);
	}

	@PutMapping("/admin/unblockKorisnik/{id}")
	public void unblockKorisnik(@PathVariable Long id) {
		kks.unblockKorinsik(id);
	}

	@DeleteMapping("/admin/deleteKorisnik/{id}")
	public void deleteKorisnik(@PathVariable Long id) {
		kkr.deleteById(id);
	}

}
