package com.rentacar.auth_service.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rentacar.auth_service.model.Korisnik;
import com.rentacar.auth_service.model.KorisnikTokenState;
import com.rentacar.auth_service.security.TokenHelper;
import com.rentacar.auth_service.security.auth.JwtAuthenticationRequest;
import com.rentacar.auth_service.service.KorisnikService;

@RestController
@RequestMapping(value = "/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

	@Autowired
	private AuthenticationManager manager;

	@Autowired
	private TokenHelper tokenHelper;

	@Autowired
	private KorisnikService ks;

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> loginKorisnik(@RequestBody JwtAuthenticationRequest authRequest,
			HttpServletRequest request, HttpServletResponse response, Device device) {
		System.out.println("Usao je u login u AuthController");
		if (!checkUsername(authRequest.getUsername())) {
			System.out.println("Username sadrzi karaktere koje ne moze da sadrzi");
			return new ResponseEntity<>(new KorisnikTokenState("error", 0), HttpStatus.NOT_FOUND);
		}
		System.out.println(authRequest.getUsername());

		Korisnik korisnik = ks.findOneByUsername(authRequest.getUsername());

		if (korisnik != null) {
			if (BCrypt.checkpw(authRequest.getPassword(), korisnik.getPassword())) {
				System.out.println("Uspesna prijava: username: " + korisnik.getUsername());
			} else {
				return new ResponseEntity<>(new KorisnikTokenState("error", 0), HttpStatus.OK);
			}

			if (!korisnik.isEnabled()) {
				return new ResponseEntity<>(new KorisnikTokenState("Not activated", 0), HttpStatus.OK);
			}
			MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
			headers.add("Content-Type", "application/json");
			HttpEntity<JwtAuthenticationRequest> httpRequest = new HttpEntity<>(authRequest, headers);
			if (korisnik.getRole().equals("ROLE_AGENT")) {
				System.out.println("Agent se loguje");
				ResponseEntity<?> agentResponse = restTemplate.postForEntity("http://agent-backend/", httpRequest,
						JwtAuthenticationRequest.class);
			} else {
				System.out.println("Admin ili klijent se loguju");
				ResponseEntity<?> akResponse = restTemplate.postForEntity("http://", httpRequest,
						JwtAuthenticationRequest.class);
			}

			final Authentication authentication = manager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);

			Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext()
					.getAuthentication().getAuthorities();

			for (GrantedAuthority authority : authorities) {
				System.out.println("Authority: " + authority.getAuthority());
			}

			Korisnik kor = (Korisnik) authentication.getPrincipal();
			String jwt = tokenHelper.generateToken(kor.getUsername(), device);
			int expiresIn = tokenHelper.getExpiredIn(device);

			return ResponseEntity.ok(new KorisnikTokenState(jwt, expiresIn));
		} else {
			System.out.println("User je null");
			return new ResponseEntity<>(new KorisnikTokenState("error", 0), HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void logOutKorisnik(@Context HttpServletRequest request) {
		System.out.println("Logout iz auth-service");
		String token = tokenHelper.getToken(request);
		String username = tokenHelper.getUsernameFromToken(token);
		Korisnik korisnik = (Korisnik) this.ks.findOneByUsername(username);

		if (korisnik.getRole().equals("ROLE_AGENT")) {
			System.out.println("Agent je ulogovan");
			restTemplate.getForEntity("http://agent-backend/", void.class);
		} else {
			System.out.println("Admin ili klijent je ulogovan");
			restTemplate.getForEntity("http://", void.class);
		}
		SecurityContextHolder.clearContext();

	}

	public boolean checkUsername(String username) {
		if (username.isEmpty()) {
			return false;
		}
		if (username.contains(";")) {
			return false;
		}
		if (username.contains(",")) {
			return false;
		}
		for (Character c : username.toCharArray()) {
			if (Character.isWhitespace(c)) {
				return false;
			}
		}
		return true;
	}

}
