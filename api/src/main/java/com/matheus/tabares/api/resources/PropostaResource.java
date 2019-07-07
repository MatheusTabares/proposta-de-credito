package com.matheus.tabares.api.resources;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@CrossOrigin
	@PostMapping
	private ResponseEntity<?> analisar(@Valid @RequestBody Proposta proposta) {
		return ResponseEntity.ok(service.analisar(proposta));
	}
	
	@CrossOrigin
	@GetMapping(value = "/{cpf}")
	public ResponseEntity<?> encontrarPorCpf(@PathVariable String cpf) {
		Optional<Proposta> proposta = service.encontrarPorCpf(cpf);
		if(proposta.isPresent()) {
			return ResponseEntity.ok(proposta);
		} 
		return ResponseEntity.notFound().build();
	}
	
}
