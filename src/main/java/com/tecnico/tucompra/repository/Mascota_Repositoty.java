package com.tecnico.tucompra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tecnico.tucompra.model.Mascota;

@Repository
public interface Mascota_Repositoty extends JpaRepository<Mascota, Long> {
}