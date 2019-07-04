package com.matheus.tabares.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matheus.tabares.api.domains.ResultadoAnalise;

@Repository
public interface ResultadoAnaliseRepository extends JpaRepository<ResultadoAnalise, Integer>{

}
