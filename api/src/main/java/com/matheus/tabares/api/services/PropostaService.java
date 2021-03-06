package com.matheus.tabares.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheus.tabares.api.domains.Proposta;
import com.matheus.tabares.api.domains.ResultadoAnalise;
import com.matheus.tabares.api.domains.enums.EstadoCivil;
import com.matheus.tabares.api.repositories.PropostaRepository;

@Service
public class PropostaService {
	
	private static final int PONTUACAO_NEGADO_POLITICA_DE_CREDITO = 20;

	private static final int PONTUACAO_NEGADO_RENDA_BAIXA = 60;

	private static final Integer CLIENTE_DA_PROPOSTA = 1;
	
	@Autowired
	private PropostaRepository propostaRepository;
	
	public Proposta analisar(Proposta proposta) {
		int pontuacao = analisarRendaPercapita(proposta);
		pontuacao += somarPontuacaoEstadoCivil(proposta);
		pontuacao = analisarRiscosCriticos(proposta, pontuacao);
		
		ResultadoAnalise resultadoAnalise = analisarPontuacao(pontuacao);
		proposta.setResultadoAnalise(resultadoAnalise);
		return salvarProposta(proposta);
	}
	
	private int somarPontuacaoEstadoCivil(Proposta proposta) {
		return proposta.getEstadoCivil().getPontuacao();
	}

	public Optional<Proposta> encontrarPorCpf(String cpf) { 
		return propostaRepository.findByCpf(cpf);
	}
	
	private int analisarRiscosCriticos(Proposta proposta, int pontuacao) {
		if(pontuacao >= 100 && proposta.getEstadoCivil().equals(EstadoCivil.SOLTEIRO) && proposta.getIdade() < 30 && proposta.getSexo() == 'M' && proposta.getDependentes() == 0) {
			pontuacao = 80;
		}
		return pontuacao;
	}
	
	private int analisarRendaPercapita(Proposta proposta) {
		int pontuacao = 0;
		double percapita = calcularRendaPercapita(proposta);
		
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

	private double calcularRendaPercapita(Proposta proposta) {
		return proposta.getRenda() / (proposta.getDependentes() + CLIENTE_DA_PROPOSTA);
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

	private Proposta salvarProposta(Proposta proposta) {
		proposta.setId(null);
		return propostaRepository.save(proposta);
	}
}
