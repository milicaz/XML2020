package com.rentacar.backend.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rentacar.backend.model.Korisnik;
import com.rentacar.backend.security.TokenHelper;
import com.rentacar.backend.security.auth.JwtAuthenticationRequest;
import com.rentacar.backend.service.CustomUserDetailsService;

@RestController
@RequestMapping(value = "api/korisnikAuth")
@CrossOrigin(origins = { "http://localhost:4200, http://localhost:4201" })
public class KorisnikAuthenticationController {

	@Autowired
	private AuthenticationManager manager;
	@Autowired
	private TokenHelper tokenHelper;
	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@RequestMapping(value = "/setAuthentication", method = RequestMethod.POST)
	public ResponseEntity<?> setAuth(@RequestBody JwtAuthenticationRequest authRequest, HttpServletResponse response,
			HttpServletRequest request, Device device) {

		System.out.println("setAuthentication entered in SecurityController");
		final Authentication authentication = manager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext()
				.getAuthentication().getAuthorities();

		for (GrantedAuthority authority : authorities) {
			System.out.println("Authority: " + authority.getAuthority());
		}

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/userprofile", method = RequestMethod.POST)
	public ResponseEntity<?> getProfile(@RequestBody String token) {

		System.out.println("IMA TOKEN: " + token);
		String username = tokenHelper.getUsernameFromToken(token);

		System.out.println("USERNAME: " + username);
		Korisnik korisnik = (Korisnik) this.customUserDetailsService.loadUserByUsername(username);

		System.out.println("Korisnik: " + korisnik.getUsername());

		return new ResponseEntity<Korisnik>(korisnik, HttpStatus.OK);
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void logout() {

		System.out.println("Logout glavni back");
		SecurityContextHolder.clearContext();

	}

}
