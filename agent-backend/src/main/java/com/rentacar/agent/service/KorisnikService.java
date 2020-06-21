package com.rentacar.agent.service;

import java.util.List;

import com.rentacar.agent.model.Agent;
import com.rentacar.agent.model.Korisnik;

public interface KorisnikService {

	public Korisnik findOneById(Long id);

	public Korisnik findOneByUsername(String username);

	public Korisnik findOneByEmail(String email);

	public Agent saveAgent(Agent agent);

	public Agent findAgentByEmail(String email);

	public List<Agent> findAllAgents();

	public void deleteAgent(String agent);

}
