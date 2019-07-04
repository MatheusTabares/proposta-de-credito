package com.matheus.tabares.api.services;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
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
		Proposta proposta = new Proposta("João", "74397923000", 56, 'M', EstadoCivil.DIVORCIADO, "RJ", 2, 2000.00);
		ResultadoAnalise resultadoAnalise = service.analisar(proposta);
		proposta.setId(1);
		ResultadoAnalise resultadoAnaliseEsperado = new ResultadoAnalise(1, false, null, "reprovado pela política de crédito");
		resultadoAnaliseEsperado.setProposta(proposta);
		assertEquals(resultadoAnalise, resultadoAnaliseEsperado);
	}
	
	@Test
	public void testa02AnalisePropostaNegadaMotivoRendaBaixa() {
		Proposta proposta = new Proposta("Marcos", "66616108082", 19, 'M', EstadoCivil.SOLTEIRO, "SC", 1, 400.00);
		ResultadoAnalise resultadoAnalise = service.analisar(proposta);
		proposta.setId(2);
		ResultadoAnalise resultadoAnaliseEsperado = new ResultadoAnalise(2, false, null, "renda baixa");
		resultadoAnaliseEsperado.setProposta(proposta);
		assertEquals(resultadoAnalise, resultadoAnaliseEsperado);
	}
	
	@Test
	public void testa03AnalisePropostaAprovadaLimiteSuperior2000() {
		Proposta proposta = new Proposta("Jose", "42964057052", 30, 'M', EstadoCivil.CASADO, "MA", 2, 8000.00);
		ResultadoAnalise resultadoAnalise = service.analisar(proposta);
		proposta.setId(3);
		ResultadoAnalise resultadoAnaliseEsperado = new ResultadoAnalise(3, true, "superior 2000", null);
		resultadoAnaliseEsperado.setProposta(proposta);
		assertEquals(resultadoAnalise, resultadoAnaliseEsperado);
	}
}
