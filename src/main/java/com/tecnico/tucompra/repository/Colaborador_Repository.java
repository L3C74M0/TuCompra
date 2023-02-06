package com.tecnico.tucompra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tecnico.tucompra.model.Colaborador;

@Repository
public interface Colaborador_Repository extends JpaRepository<Colaborador, Long> {
}