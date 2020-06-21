package com.rentacar.agent.controller;

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

import com.rentacar.agent.model.Korisnik;
import com.rentacar.agent.security.TokenHelper;
import com.rentacar.agent.security.auth.JwtAuthenticationRequest;
import com.rentacar.agent.service.CustomUserDetailsService;
import com.rentacar.agent.service.KorisnikService;

@RestController
@RequestMapping(value = "agentAuth")
@CrossOrigin(origins = "http://localhost:4202")
public class AgentAuthenticationController {

	@Autowired
	private AuthenticationManager manager;
	@Autowired
	private KorisnikService korisnikService;
	@Autowired
	private CustomUserDetailsService userDetailsService;
	@Autowired
	private TokenHelper tokenHelper;

	@RequestMapping(value = "/setAuthentication", method = RequestMethod.POST)
	public ResponseEntity<?> setAuthentication(@RequestBody JwtAuthenticationRequest authRequest,
			HttpServletResponse response, HttpServletRequest request, Device device) {

		System.out.println("setAuthentication u AgentAuthenticationController-u");

		final Authentication authentication = manager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		Collection<GrantedAuthority> authorites = (Collection<GrantedAuthority>) SecurityContextHolder.getContext()
				.getAuthentication().getAuthorities();

		for (GrantedAuthority authority : authorites) {
			System.out.println("Authority: " + authority.getAuthority());
		}

		Korisnik korisnik = korisnikService.findOneByUsername(authRequest.getUsername());
		System.out.println("Agent id: " + korisnik.getId());
		Long agentId = korisnik.getId();

		/*
		 * getPrivilege(agentId); getRole(agentId); getMessages(agentId);
		 */
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void logOut() {
		System.out.println("Logout agent backend");
		SecurityContextHolder.clearContext();
	}

	@RequestMapping(value = "/userProfile", method = RequestMethod.POST)
	public ResponseEntity<?> getProfile(@RequestBody String token) throws InterruptedException{
		System.out.println("Ima token: " + token);
		String username = tokenHelper.getUsernameFromToken(token);
		System.out.println("Username: " + username);
		Korisnik korisnik = (Korisnik) userDetailsService.loadUserByUsername(username);
		return new ResponseEntity<Korisnik>(korisnik, HttpStatus.OK);
	}

}
