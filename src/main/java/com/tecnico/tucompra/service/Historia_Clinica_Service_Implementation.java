package com.tecnico.tucompra.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tecnico.tucompra.model.Detalle_Historia_Clinica;
import com.tecnico.tucompra.model.Historia_Clinica;
import com.tecnico.tucompra.model.Mascota;
import com.tecnico.tucompra.repository.Historia_Clinica_Repository;

@Service
public class Historia_Clinica_Service_Implementation implements Historia_Clinica_Service {

	@Autowired
	public Historia_Clinica_Repository historia_clinica_repository;

	public Historia_Clinica_Service_Implementation(Historia_Clinica_Repository historia_clinica_repository) {
		this.historia_clinica_repository = historia_clinica_repository;
	}

	@Override
	public Historia_Clinica edit(int id, Mascota mascota, int fecha_creacion, List<Detalle_Historia_Clinica> detalles)
			throws Exception {

		Historia_Clinica historiaClinicaDummy = new Historia_Clinica();

		if (mascota == null) {
			throw new Exception("La mascota no debe ser nula");
		} else if (fecha_creacion == 0) {
			throw new Exception("La fecha de creacion no debe ser 0");
		} else {
			historiaClinicaDummy.setId(id);
			historiaClinicaDummy.setMascota(mascota);
			historiaClinicaDummy.setFecha_creacion(fecha_creacion);
			historiaClinicaDummy.setDetalles(detalles);
		}

		return historiaClinicaDummy;
	}

	@Override
	public Historia_Clinica add(int id, Mascota mascota, int fecha_creacion, List<Detalle_Historia_Clinica> detalles) {

		Historia_Clinica historiaClinicaDummy = new Historia_Clinica();
		historiaClinicaDummy.setId(id);
		historiaClinicaDummy.setMascota(mascota);
		historiaClinicaDummy.setFecha_creacion(fecha_creacion);
		historiaClinicaDummy.setDetalles(detalles);

		historia_clinica_repository.save(historiaClinicaDummy);
		return historiaClinicaDummy;
	}

	@Override
	public Historia_Clinica save(Historia_Clinica historia_clinica) {
		return historia_clinica_repository.save(historia_clinica);
	}

	@Override
	public void delete(Historia_Clinica historia_clinica) {
		historia_clinica_repository.delete(historia_clinica);
	}

	@Override
	public List<Historia_Clinica> findAll() {
		return historia_clinica_repository.findAll();
	}

	@Override
	public Optional<Historia_Clinica> findById(int id) {
		return historia_clinica_repository.findById((long) id);
	}

	@Override
	public void deleteById(int id) {
		historia_clinica_repository.deleteById((long) id);
	}

}
