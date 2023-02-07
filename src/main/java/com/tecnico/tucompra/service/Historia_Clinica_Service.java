package com.tecnico.tucompra.service;

import java.util.List;
import java.util.Optional;
import com.tecnico.tucompra.model.Detalle_Historia_Clinica;
import com.tecnico.tucompra.model.Historia_Clinica;
import com.tecnico.tucompra.model.Mascota;

public interface Historia_Clinica_Service {

	public Historia_Clinica edit(int id, Mascota mascota, int fecha_creacion, List<Detalle_Historia_Clinica> detalles)
			throws Exception;

	public Historia_Clinica add(int id, Mascota mascota, int fecha_creacion, List<Detalle_Historia_Clinica> detalles);

	public Historia_Clinica save(Historia_Clinica historia_clinica);

	public void delete(Historia_Clinica historia_clinica);

	public List<Historia_Clinica> findAll();

	public Optional<Historia_Clinica> findById(int id);
	
	public void deleteById(int id);
}
