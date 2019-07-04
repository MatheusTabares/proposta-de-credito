package com.matheus.tabares.api.domains.enums;

public enum EstadoCivil {
	CASADO(60, "Casado(a)"),
	SOLTEIRO(60, "Solteiro(a)"), 
	DIVORCIADO(10, "Divorciado(a)"),
	VIUVO(10, "Viuvo(a)");
	
	private int pontuacao;
	private String descricao;
	
	private EstadoCivil(int pontuacao, String descricao) {
		this.pontuacao = pontuacao;
		this.descricao = descricao;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public String getDescricao() {
		return descricao;
	}

}
