package com.rentacar.backend.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rentacar.backend.model.Adresa;
import com.rentacar.backend.model.Agent;
import com.rentacar.backend.model.Korisnik;
import com.rentacar.backend.model.KorisnikTokenState;
import com.rentacar.backend.model.KrajnjiKorisnik;
import com.rentacar.backend.service.AdresaService;
import com.rentacar.backend.service.KorisnikService;
import com.rentacar.backend.service.RoleService;

@RestController
@RequestMapping(value = "api/users")
@CrossOrigin(origins = "http://localhost:4201")
public class KorisnikController {

	@Autowired
	private KorisnikService korisnikService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private AdresaService adresaService;

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/registration", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> registerUser(@Valid @RequestBody Korisnik korisnik, BindingResult result) {
		System.out.println("Dosao u registrujKorisnika");
		System.out.println("Korisnik " + korisnik.getEmail() + korisnik.getPassword());

		KrajnjiKorisnik klijent = korisnikService.findOneByUsername(korisnik.getUsername());

		if (result.hasErrors()) {
			// 404

			return new ResponseEntity<>(new KorisnikTokenState("error", 0), HttpStatus.NOT_FOUND);
		}
		if (!checkMail(korisnik.getEmail())) {
			return new ResponseEntity<>(new KorisnikTokenState("error", 0), HttpStatus.NOT_FOUND);
		}
		if (!checkCharacters(korisnik.getIme())) {

			return new ResponseEntity<>(new KorisnikTokenState("error", 0), HttpStatus.NOT_FOUND);
		}
		if (!checkCharacters(korisnik.getPrezime())) {

			return new ResponseEntity<>(new KorisnikTokenState("error", 0), HttpStatus.NOT_FOUND);
		}
		if (klijent == null) {
			KrajnjiKorisnik noviKlijent = new KrajnjiKorisnik();

			String newPassword = korisnik.getPassword();
			if (newPassword.equals("") || newPassword == null) {
				return null;
			}
			String salt = org.springframework.security.crypto.bcrypt.BCrypt.gensalt();

			System.out.println("===== Hesiranje lozinke =====");
			// byte[] hashedPassword = hashPassword(newPassword, salt);
			// BASE64Encoder encoder = new BASE64Encoder();
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String hashedPass = org.springframework.security.crypto.bcrypt.BCrypt.hashpw(newPassword, salt);
			System.out.println("hashed " + hashedPass);
			noviKlijent.setEmail(korisnik.getEmail());
			noviKlijent.setIme(korisnik.getIme());
			noviKlijent.setPrezime(korisnik.getPrezime());
			noviKlijent.setPassword(hashedPass);
			noviKlijent.setRoles(Arrays.asList(roleService.findOneByName("ROLE_CLIENT")));
			noviKlijent.setRole("ROLE_CLIENT");
			Adresa adresa = adresaService.findOneByUlicaBrojMestoDrzava(korisnik.getAdresa().getUlica(),
					korisnik.getAdresa().getBroj(), korisnik.getAdresa().getMesto(), korisnik.getAdresa().getDrzava());
			if (adresa == null) {
				System.out.println("Adresa je null");
				Adresa novaAdresa = new Adresa();
				novaAdresa.setUlica(korisnik.getAdresa().getUlica());
				novaAdresa.setBroj(korisnik.getAdresa().getBroj());
				novaAdresa.setMesto(korisnik.getAdresa().getMesto());
				novaAdresa.setDrzava(korisnik.getAdresa().getDrzava());
				Adresa saved = adresaService.save(novaAdresa);
				noviKlijent.setAdresa(saved);
			} else {
				noviKlijent.setAdresa(adresa);
			}

			noviKlijent.setEnabled(false);
			System.out.println("Cuvanje u bazu");
			korisnikService.saveKrajnjiKorisnik(noviKlijent);

			return new ResponseEntity<>(noviKlijent, HttpStatus.OK);
		} else {
			korisnik.setEmail("error");

			return new ResponseEntity<>(korisnik, HttpStatus.OK);
		}

	}

	public boolean checkCharacters(String data) {
		if (data.isEmpty()) {
			return false;
		}
		for (Character c : data.toCharArray()) {
			if (Character.isWhitespace(c) == false && Character.isLetterOrDigit(c) == false) {
				return false;
			}
		}

		return true;
	}

	public boolean checkId(String id) {
		if (id.isEmpty()) {
			return false;
		}
		for (Character c : id.toCharArray()) {
			if (!Character.isDigit(c)) {
				return false;
			}
		}
		return true;
	}

	public boolean checkMail(String mail) {
		if (mail.isEmpty()) {
			return false;
		}
		if (mail.contains(";")) {
			return false;
		}

		if (mail.contains(",")) {
			return false;
		}
		for (Character c : mail.toCharArray()) {
			if (Character.isWhitespace(c)) {
				return false;

			}

		}
		return true;
	}

	@RequestMapping(value = "/getUsers", method = RequestMethod.GET)
	public ResponseEntity<?> getUsers() {
		System.out.println("getUsers entered");

		List<KrajnjiKorisnik> korisnici = this.korisnikService.getAllKrajnjiKorisnici();

		return new ResponseEntity<List<KrajnjiKorisnik>>(korisnici, HttpStatus.OK);
	}

	@RequestMapping(value = "/addAgent", method = RequestMethod.POST)
	public ResponseEntity<?> addAgent(@RequestBody Agent agent) {

		System.out.println("add new agent entered");
		Agent kor = korisnikService.findAgentByUsername(agent.getUsername());
		if (kor == null) {
			Adresa adresa = adresaService.findOneByUlicaBrojMestoDrzava(agent.getAdresa().getUlica(),
					agent.getAdresa().getBroj(), agent.getAdresa().getMesto(), agent.getAdresa().getDrzava());
			if (adresa == null) {
				System.out.println("null ?>");
				Adresa novaAdresa = new Adresa();
				novaAdresa.setUlica(agent.getAdresa().getUlica());
				novaAdresa.setBroj(agent.getAdresa().getBroj());
				novaAdresa.setMesto(agent.getAdresa().getMesto());
				novaAdresa.setDrzava(agent.getAdresa().getDrzava());
				adresaService.save(novaAdresa);

				agent.setAdresa(novaAdresa);
			} else {
				agent.setAdresa(adresa);
			}
			agent.setRoles(Arrays.asList(roleService.findOneByName("ROLE_AGENT")));
			agent.setRole("ROLE_AGENT");
			agent.setEnabled(true);

			String newPassword = agent.getPassword();
			if (newPassword.equals("") || newPassword == null) {
				return null;
			}
			String salt = org.springframework.security.crypto.bcrypt.BCrypt.gensalt();

			System.out.println("===== Hesiranje lozinke =====");
			// byte[] hashedPassword = hashPassword(newPassword, salt);
			// BASE64Encoder encoder = new BASE64Encoder();
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String hashedPass = org.springframework.security.crypto.bcrypt.BCrypt.hashpw(newPassword, salt);
			System.out.println("hashed " + hashedPass);
			agent.setPassword(hashedPass);
			Agent saved = korisnikService.saveAgent(agent);
			return new ResponseEntity<Agent>(saved, HttpStatus.OK);
		} else {
			agent.setEmail("error");
			agent.setRoles(Arrays.asList(roleService.findOneByName("ROLE_AGENT")));
			agent.setRole("ROLE_AGENT");
			return new ResponseEntity<>(agent, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/activateUser", method = RequestMethod.PUT)
	public ResponseEntity<?> activateUser(@RequestBody Long id) {
		System.out.println("activiteUser entered");
		KrajnjiKorisnik klijent = korisnikService.findOneById(id);
		klijent.setEnabled(true);
		klijent = korisnikService.saveKrajnjiKorisnik(klijent);
		return new ResponseEntity<KrajnjiKorisnik>(klijent, HttpStatus.OK);
	}

	@RequestMapping(value = "/blockUser", method = RequestMethod.PUT)
	public ResponseEntity<?> blockUser(@RequestBody Long id) {
		System.out.println("blockUser entered");
		KrajnjiKorisnik klijent = korisnikService.findOneById(id);
		klijent.setBlocked(true);
		klijent = korisnikService.saveKrajnjiKorisnik(klijent);
		return new ResponseEntity<KrajnjiKorisnik>(klijent, HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.PUT)
	public ResponseEntity<?> deleteUser(@RequestBody Long id) {
		System.out.println("deleteUser entered");
		KrajnjiKorisnik klijent = korisnikService.findOneById(id);
		klijent.setDeleted(true);
		klijent = korisnikService.saveKrajnjiKorisnik(klijent);
		return new ResponseEntity<KrajnjiKorisnik>(klijent, HttpStatus.OK);
	}

}
