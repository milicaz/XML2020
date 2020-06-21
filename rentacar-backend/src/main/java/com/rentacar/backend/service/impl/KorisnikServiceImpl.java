package com.rentacar.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentacar.backend.model.Agent;
import com.rentacar.backend.model.Korisnik;
import com.rentacar.backend.model.KrajnjiKorisnik;
import com.rentacar.backend.repository.AgentRepository;
import com.rentacar.backend.repository.KorisnikRepository;
import com.rentacar.backend.repository.KrajnjiKorisnikRepository;
import com.rentacar.backend.service.KorisnikService;

@Service
public class KorisnikServiceImpl implements KorisnikService {

	@Autowired
	private KorisnikRepository korisnikRepository;
	@Autowired
	private KrajnjiKorisnikRepository krajnjiKorisnikRepository;
	@Autowired
	private AgentRepository agentRepository;

	@Override
	public KrajnjiKorisnik findOneById(Long id) {
		return krajnjiKorisnikRepository.findOneById(id);
	}

	@Override
	public KrajnjiKorisnik findOneByUsername(String username) {
		return krajnjiKorisnikRepository.findOneByUsername(username);
	}

	@Override
	public KrajnjiKorisnik findOneByEmail(String email) {
		return krajnjiKorisnikRepository.findOneByEmail(email);
	}

	@Override
	public List<KrajnjiKorisnik> getAllKrajnjiKorisnici() {
		return krajnjiKorisnikRepository.findAll();
	}

	@Override
	public KrajnjiKorisnik saveKrajnjiKorisnik(KrajnjiKorisnik korisnik) {
		return krajnjiKorisnikRepository.save(korisnik);
	}

	@Override
	public Agent findAgentById(Long id) {
		return agentRepository.findOneById(id);
	}

	@Override
	public Agent findAgentByUsername(String username) {
		return agentRepository.findOneByUsername(username);
	}

	@Override
	public Agent findAgentByEmail(String email) {
		return agentRepository.findOneByEmail(email);
	}

	@Override
	public List<Agent> getAllAgenti() {
		return agentRepository.findAll();
	}

	@Override
	public Agent saveAgent(Agent agent) {
		return agentRepository.save(agent);
	}

	@Override
	public Korisnik findKorisnikById(Long id) {
		return korisnikRepository.findOneById(id);
	}

	@Override
	public Korisnik findKorisnkByEmail(String email) {
		return korisnikRepository.findOneByEmail(email);
	}

}
