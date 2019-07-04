package com.matheus.tabares.api.domains;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ResultadoAnalise implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Boolean aprovado;
	
	private String limiteCredito;
	
	private String motivoNegacao;
	
	@OneToOne(mappedBy = "resultadoAnalise")
	private Proposta proposta;
	
	public ResultadoAnalise() {}
	
	public ResultadoAnalise(Integer id, Boolean aprovado, String limiteCredito, String motivoNegacao) {
		super();
		this.id = id;
		this.aprovado = aprovado;
		this.limiteCredito = limiteCredito;
		this.motivoNegacao = motivoNegacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getAprovado() {
		return aprovado;
	}

	public void setAprovado(Boolean aprovado) {
		this.aprovado = aprovado;
	}

	public String getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(String limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	public String getMotivoNegacao() {
		return motivoNegacao;
	}

	public void setMotivoNegacao(String motivoNegacao) {
		this.motivoNegacao = motivoNegacao;
	}
	
	public Proposta getProposta() {
		return proposta;
	}

	public void setProposta(Proposta proposta) {
		this.proposta = proposta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResultadoAnalise other = (ResultadoAnalise) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
