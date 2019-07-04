package com.matheus.tabares.api.services;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.matheus.tabares.api.domains.Proposta;
import com.matheus.tabares.api.domains.ResultadoAnalise;
import com.matheus.tabares.api.domains.enums.EstadoCivil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PropostaServiceTest {
	
	@Autowired
	private PropostaService service;
	
	@Test
	public void testaAnalisePropostaNegadaMotivoPoliticaDeCredito() {
		Proposta proposta = new Proposta("João", "743.979.230-00", 56, 'M', EstadoCivil.DIVORCIADO, "RS", 2, 2000.00);
		ResultadoAnalise resultadoAnalise = service.analisar(proposta);
		proposta.setId(1);
		ResultadoAnalise resultadoAnaliseEsperado = new ResultadoAnalise(1, false, null, "reprovado pela política de crédito");
		resultadoAnaliseEsperado.setProposta(proposta);
		assertEquals(resultadoAnalise, resultadoAnaliseEsperado);
	}
}
