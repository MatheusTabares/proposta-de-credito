package com.matheus.tabares.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheus.tabares.api.domains.ResultadoAnalise;
import com.matheus.tabares.api.repositories.ResultadoAnaliseRepository;

@Service
public class ResultadoAnaliseService {
	
	@Autowired
	private ResultadoAnaliseRepository repo;
	
	public ResultadoAnalise salvar(ResultadoAnalise resultado) {
		return repo.save(resultado);
	}
}
