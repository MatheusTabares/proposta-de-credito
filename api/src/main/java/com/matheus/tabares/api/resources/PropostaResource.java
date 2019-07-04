package com.matheus.tabares.api.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheus.tabares.api.domains.Proposta;
import com.matheus.tabares.api.services.PropostaService;

@RestController
@RequestMapping(value = "/propostas")
public class PropostaResource {
	
	@Autowired
	private PropostaService service;
	
	@PostMapping
	private ResponseEntity<?> analisar(@RequestBody Proposta proposta) {
		return ResponseEntity.ok(service.analisar(proposta));
	}

}
