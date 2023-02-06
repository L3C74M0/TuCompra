package com.tecnico.tucompra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tecnico.tucompra.model.Usuario;

@Repository
public interface Usuario_Repository extends JpaRepository<Usuario, Long> {
}