package com.tecnico.tucompra.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tecnico.tucompra.model.Colaborador;
import com.tecnico.tucompra.model.Detalle_Historia_Clinica;
import com.tecnico.tucompra.repository.Colaborador_Repository;

@Service
public class Colaborador_Service_Implementation implements Colaborador_Service {

	@Autowired
	public Colaborador_Repository colaborador_Repository;

	public Colaborador_Service_Implementation(Colaborador_Repository colaborador_Repository) {
		this.colaborador_Repository = colaborador_Repository;
	}

	@Override
	public Colaborador edit(int id, String nombre, String apellido, String cargo, String especialidad,
			String tipo_documento, int documento_identificacion, Detalle_Historia_Clinica detalle_Historia_Clinica)
			throws Exception {

		Colaborador colaboradorDummy = new Colaborador();

		if (nombre == " " || nombre == "") {
			throw new Exception("El nombre no debe ser nulo");
		} else if (apellido == " " || apellido == "") {
			throw new Exception("El apellido no debe ser nulo");
		} else if (cargo == " " || cargo == "") {
			throw new Exception("El cargo no debe ser nulo");
		} else if (especialidad == " " || especialidad == "") {
			throw new Exception("La especialidad no debe ser nula");
		} else if (tipo_documento == " " || tipo_documento == "") {
			throw new Exception("El tipo documento no debe ser nulo");
		} else if (documento_identificacion < 1) {
			throw new Exception("El documento identificacion debe ser mayor que 0");
		} else {
			colaboradorDummy.setId(id);
			colaboradorDummy.setNombre(nombre);
			colaboradorDummy.setApellido(apellido);
			colaboradorDummy.setCargo(cargo);
			colaboradorDummy.setEspecialidad(especialidad);
			colaboradorDummy.setTipo_documento(tipo_documento);
			colaboradorDummy.setDocumento_identificacion(documento_identificacion);
			colaboradorDummy.setDetalle_Historia_Clinica(detalle_Historia_Clinica);
		}

		return colaboradorDummy;

	}

	@Override
	public Colaborador add(int id, String nombre, String apellido, String cargo, String especialidad,
			String tipo_documento, int documento_identificacion, Detalle_Historia_Clinica detalle_Historia_Clinica) {

		Colaborador colaboradorDummy = new Colaborador();
		colaboradorDummy.setId(id);
		colaboradorDummy.setNombre(nombre);
		colaboradorDummy.setApellido(apellido);
		colaboradorDummy.setCargo(cargo);
		colaboradorDummy.setEspecialidad(especialidad);
		colaboradorDummy.setTipo_documento(tipo_documento);
		colaboradorDummy.setDocumento_identificacion(documento_identificacion);
		colaboradorDummy.setDetalle_Historia_Clinica(detalle_Historia_Clinica);

		colaborador_Repository.save(colaboradorDummy);
		return colaboradorDummy;
	}

	@Override
	public Colaborador save(Colaborador colaborador) {
		return colaborador_Repository.save(colaborador);
	}

	@Override
	public void delete(Colaborador colaborador) {
		colaborador_Repository.delete(colaborador);
	}

	@Override
	public List<Colaborador> findAll() {
		return colaborador_Repository.findAll();
	}

	@Override
	public Optional<Colaborador> findById(int id) {
		return colaborador_Repository.findById((long) id);
	}

	@Override
	public void deleteById(int id) {
		colaborador_Repository.deleteById((long) id);
	}

}
