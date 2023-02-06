package com.tecnico.tucompra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tecnico.tucompra.model.Historia_Clinica;

@Repository
public interface Historia_Clinica_Repository extends JpaRepository<Historia_Clinica, Long>{
}