package com.matheus.tabares.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheus.tabares.api.domains.Proposta;
import com.matheus.tabares.api.domains.ResultadoAnalise;
import com.matheus.tabares.api.repositories.PropostaRepository;

@Service
public class PropostaService {
	
	private static final int PONTUACAO_NEGADO_POLITICA_DE_CREDITO = 20;

	private static final int PONTUACAO_NEGADO_RENDA_BAIXA = 60;
	
	@Autowired
	private PropostaRepository propostaRepository;
	
	@Autowired
	private ResultadoAnaliseService resultadoAnaliseService;
	
	public ResultadoAnalise analisar(Proposta proposta) {
		salvar(proposta);

		int pontuacao = analisarRendaPercapita(proposta);
		pontuacao += proposta.getEstadoCivil().getPontuacao();
		
		ResultadoAnalise resultadoAnalise = analisarPontuacao(pontuacao);
		resultadoAnalise.setProposta(proposta);
		resultadoAnaliseService.salvar(resultadoAnalise);
		
		return resultadoAnalise;
	}
	
	private int analisarRendaPercapita(Proposta proposta) {
		double percapita = proposta.getRenda() / (proposta.getDependentes() + 1);
		int pontuacao = 0;
		
		if(percapita > 800 && percapita <= 1000) {
			pontuacao = 10;
		} else if (percapita > 1000 && percapita < 1250) {
			pontuacao = 20;
		} else if (percapita >= 1250 && percapita < 2000) {
			pontuacao = 30;
		} else if (percapita >= 2000 && percapita < 2500) {
			pontuacao = 40;
		} else if (percapita >= 2500) {
			pontuacao = 100;
		}
		return pontuacao;
	}

	private ResultadoAnalise analisarPontuacao(int pontuacao) {
		ResultadoAnalise resultadoAnalise = new ResultadoAnalise();
		
		if(pontuacao <= PONTUACAO_NEGADO_POLITICA_DE_CREDITO) {
			resultadoAnalise.setAprovado(false);
			resultadoAnalise.setMotivoNegacao("reprovado pela política de crédito");
		} else if (pontuacao == PONTUACAO_NEGADO_RENDA_BAIXA) {
			resultadoAnalise.setAprovado(false);
			resultadoAnalise.setMotivoNegacao("renda baixa");
		} else if (pontuacao == 70) {
			resultadoAnalise.setAprovado(true);
			resultadoAnalise.setLimiteCredito("entre 100 - 500");
		} else if (pontuacao == 80) {
			resultadoAnalise.setAprovado(true);
			resultadoAnalise.setLimiteCredito("entre 500 - 1000");
		} else if (pontuacao == 90) {
			resultadoAnalise.setAprovado(true);
			resultadoAnalise.setLimiteCredito("entre 1000 - 1500");
		} else if (pontuacao == 100) {
			resultadoAnalise.setAprovado(true);
			resultadoAnalise.setLimiteCredito("entre 1500 - 2000");
		} else {
			resultadoAnalise.setAprovado(true);
			resultadoAnalise.setLimiteCredito("superior 2000");
		}
		return resultadoAnalise;
	}

	private void salvar(Proposta proposta) {
		proposta.setId(null);
		propostaRepository.save(proposta);
	}
}
