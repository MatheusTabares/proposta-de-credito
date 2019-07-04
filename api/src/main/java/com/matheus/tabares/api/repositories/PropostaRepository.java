package com.matheus.tabares.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.matheus.tabares.api.domains.Proposta;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta, Integer>{
	
	@Transactional(readOnly=true)
	Optional<Proposta> findByCpf(String cpf);

}
