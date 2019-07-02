package com.matheus.tabares.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matheus.tabares.api.domains.Proposta;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta, Integer>{

}
