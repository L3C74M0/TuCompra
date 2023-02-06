package com.tecnico.tucompra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tecnico.tucompra.model.Detalle_Historia_Clinica;

@Repository
public interface Detalle_Historia_Clinica_Repository extends JpaRepository<Detalle_Historia_Clinica, Long> {
}