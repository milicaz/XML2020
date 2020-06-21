package com.rentacar.agent.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentacar.agent.model.Agent;
import com.rentacar.agent.model.Korisnik;
import com.rentacar.agent.repository.AgentRepository;
import com.rentacar.agent.repository.KorisnikRepository;
import com.rentacar.agent.service.KorisnikService;

@Service
public class KorisnikServiceImpl implements KorisnikService {

	@Autowired
	private AgentRepository agentRepository;

	@Autowired
	private KorisnikRepository korisnikRepository;

	@Override
	public Korisnik findOneById(Long id) {
		return korisnikRepository.findById(id).get();
	}

	@Override
	public Korisnik findOneByUsername(String username) {
		return korisnikRepository.findOneByUsername(username);
	}

	@Override
	public Korisnik findOneByEmail(String email) {
		return korisnikRepository.findOneByEmail(email);
	}

	@Override
	public Agent saveAgent(Agent agent) {
		return agentRepository.save(agent);
	}

	@Override
	public Agent findAgentByEmail(String email) {
		return agentRepository.findOneByEmail(email);
	}

	@Override
	public List<Agent> findAllAgents() {
		return agentRepository.findAll();
	}

	@Override
	public void deleteAgent(String agent) {
		korisnikRepository.deleteAgent(agent);
	}

}
