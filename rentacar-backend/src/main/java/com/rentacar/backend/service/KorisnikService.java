package com.rentacar.backend.service;

import java.util.List;

import com.rentacar.backend.model.Agent;
import com.rentacar.backend.model.Korisnik;
import com.rentacar.backend.model.KrajnjiKorisnik;

public interface KorisnikService {

	public KrajnjiKorisnik findOneById(Long id);

	public KrajnjiKorisnik findOneByUsername(String username);

	public KrajnjiKorisnik findOneByEmail(String email);

	public List<KrajnjiKorisnik> getAllKrajnjiKorisnici();

	public KrajnjiKorisnik saveKrajnjiKorisnik(KrajnjiKorisnik korisnik);

	public Agent findAgentById(Long id);

	public Agent findAgentByUsername(String username);

	public Agent findAgentByEmail(String email);

	public List<Agent> getAllAgenti();

	public Agent saveAgent(Agent agent);

	public Korisnik findKorisnikById(Long id);

	public Korisnik findKorisnkByEmail(String email);

}
