package com.matheus.tabares.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheus.tabares.api.domains.Proposta;
import com.matheus.tabares.api.repositories.PropostaRepository;

@Service
public class PropostaService {
	
	@Autowired
	private PropostaRepository repo;
	
	public Proposta salvar(Proposta proposta) {
		proposta.setId(null);
		return repo.save(proposta);
	}
}
