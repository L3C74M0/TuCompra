package com.tecnico.tucompra.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tecnico.tucompra.model.Historia_Clinica;
import com.tecnico.tucompra.model.Mascota;
import com.tecnico.tucompra.model.Usuario;
import com.tecnico.tucompra.repository.Mascota_Repositoty;

@Service
public class Mascota_Service_Implementation implements Mascota_Service {

	@Autowired
	public Mascota_Repositoty mascota_repository;

	public Mascota_Service_Implementation(Mascota_Repositoty mascota_repositorio) {
		this.mascota_repository = mascota_repositorio;
	}

	@Override
	public Mascota edit(int id, String nombre, String raza, Usuario usuario, char sexo,
			Historia_Clinica historia_clinica) throws Exception {

		Mascota mascotaDummy = new Mascota();

		if (nombre == " " || nombre == "") {
			throw new Exception("El nombre no debe ser nulo");
		} else if (raza == " " || raza == "") {
			throw new Exception("La raza no debe ser nula");
		} else if (usuario == null) {
			throw new Exception("El usuario no debe ser nulo");
		} else if (sexo == ' ') {
			throw new Exception("El sexo no debe ser nulo");
		} else {
			mascotaDummy.setId(id);
			mascotaDummy.setNombre(nombre);
			mascotaDummy.setRaza(raza);
			mascotaDummy.setSexo(sexo);
			mascotaDummy.setUsuario(usuario);
			mascotaDummy.setHistoria_clinica(historia_clinica);
		}

		return mascotaDummy;
	}

	@Override
	public Mascota add(int id, String nombre, String raza, Usuario usuario, char sexo,
			Historia_Clinica historia_clinica) {

		Mascota mascotaDummy = new Mascota();
		mascotaDummy.setId(id);
		mascotaDummy.setNombre(nombre);
		mascotaDummy.setRaza(raza);
		mascotaDummy.setSexo(sexo);
		mascotaDummy.setUsuario(usuario);
		mascotaDummy.setHistoria_clinica(historia_clinica);

		mascota_repository.save(mascotaDummy);
		return mascotaDummy;
	}

	@Override
	public Mascota save(Mascota mascota) {
		return mascota_repository.save(mascota);
	}

	@Override
	public void delete(Mascota mascota) {
		mascota_repository.delete(mascota);
	}

	@Override
	public List<Mascota> findAll() {
		return mascota_repository.findAll();
	}

	@Override
	public Optional<Mascota> findById(int id) {
		return mascota_repository.findById((long) id);
	}

	@Override
	public void deleteById(int id) {
		mascota_repository.deleteById((long) id);
	}
}
