package com.matheus.tabares.api.services;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.matheus.tabares.api.domains.Proposta;
import com.matheus.tabares.api.domains.ResultadoAnalise;
import com.matheus.tabares.api.domains.enums.EstadoCivil;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PropostaServiceTest {
	
	@Autowired
	private PropostaService service;
	
	@Test
	public void testa01AnalisePropostaNegadaMotivoPoliticaDeCredito() {
		Proposta propostaEsperada = new Proposta(null, "João", "74397923000", 56, 'M', EstadoCivil.DIVORCIADO, "RJ", 2, 2000.00);
		Proposta resultadoProposta = service.analisar(propostaEsperada);
		propostaEsperada.setId(1);
		ResultadoAnalise resultadoAnaliseEsperado = new ResultadoAnalise(1, false, null, "reprovado pela política de crédito");
		propostaEsperada.setResultadoAnalise(resultadoAnaliseEsperado);
		assertEquals(resultadoProposta, propostaEsperada);
	}
	
	@Test
	@Ignore
	public void testa02AnalisePropostaNegadaMotivoRendaBaixa() {
		Proposta propostaEsperada = new Proposta(null, "Marcos", "66616108082", 19, 'M', EstadoCivil.SOLTEIRO, "SC", 1, 400.00);
		Proposta resultadoProposta = service.analisar(propostaEsperada);
		propostaEsperada.setId(2);
		ResultadoAnalise resultadoAnaliseEsperado = new ResultadoAnalise(2, false, null, "renda baixa");
		propostaEsperada.setResultadoAnalise(resultadoAnaliseEsperado);
		assertEquals(resultadoProposta, propostaEsperada);
	}
	
	@Test
	@Ignore
	public void testa03AnalisePropostaAprovadaLimiteSuperior2000() {
		Proposta propostaEsperada = new Proposta(null, "Jose", "42964057052", 30, 'M', EstadoCivil.CASADO, "MA", 2, 8000.00);
		Proposta resultadoProposta = service.analisar(propostaEsperada);
		propostaEsperada.setId(3);
		ResultadoAnalise resultadoAnaliseEsperado = new ResultadoAnalise(3, true, "superior 2000", null);
		propostaEsperada.setResultadoAnalise(resultadoAnaliseEsperado);
		assertEquals(resultadoProposta, propostaEsperada);
	}
}
