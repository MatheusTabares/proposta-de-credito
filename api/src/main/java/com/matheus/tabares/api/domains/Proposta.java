	package com.matheus.tabares.api.domains;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.matheus.tabares.api.domains.enums.EstadoCivil;

@Entity
public class Proposta implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Nome não pode estar em branco.")
	private String nome;
	
	@CPF(message = "CPF inválido")
	private String cpf;
	
	@NotNull(message = "Idade não pode estar em branco.")
	@Min(value = 16, message = "Idade mínima permitida apartir de 16 anos.")
	private Integer idade;
	
	private char sexo;
	private EstadoCivil estadoCivil;
	private String estado;
	
	@NotNull(message = "Dependentes não pode estar em branco.")
	private Integer dependentes;
	
	@NotNull(message = "Renda não pode estar em branco.")
	private Double renda;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "resultadoAnalise_id", referencedColumnName = "id")
	private ResultadoAnalise resultadoAnalise;
	
	public Proposta() {}

	public Proposta(Integer id, String nome, String cpf, Integer idade, char sexo, EstadoCivil estadoCivil, String estado,
			Integer dependentes, Double renda) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.sexo = sexo;
		this.estadoCivil = estadoCivil;
		this.estado = estado;
		this.dependentes = dependentes;
		this.renda = renda;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getDependentes() {
		return dependentes;
	}

	public void setDependentes(Integer dependentes) {
		this.dependentes = dependentes;
	}

	public Double getRenda() {
		return renda;
	}

	public void setRenda(Double renda) {
		this.renda = renda;
	}
	
	public ResultadoAnalise getResultadoAnalise() {
		return resultadoAnalise;
	}

	public void setResultadoAnalise(ResultadoAnalise resultadoAnalise) {
		this.resultadoAnalise = resultadoAnalise;
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
		Proposta other = (Proposta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
