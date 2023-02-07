package com.tecnico.tucompra.service;

import java.util.List;
import java.util.Optional;
import com.tecnico.tucompra.model.Historia_Clinica;
import com.tecnico.tucompra.model.Mascota;
import com.tecnico.tucompra.model.Usuario;

public interface Mascota_Service {

	public Mascota edit(int id, String nombre, String raza, Usuario usuario, char sexo,
			Historia_Clinica historia_clinica) throws Exception;

	public Mascota add(int id, String nombre, String raza, Usuario usuario, char sexo,
			Historia_Clinica historia_clinica);

	public Mascota save(Mascota mascota);

	public void delete(Mascota mascota);

	public List<Mascota> findAll();

	public Optional<Mascota> findById(int id);
	
	public void deleteById(int id);
}
