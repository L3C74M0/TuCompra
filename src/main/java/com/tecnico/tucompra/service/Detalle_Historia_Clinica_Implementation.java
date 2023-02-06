package com.tecnico.tucompra.service;

import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tecnico.tucompra.model.Colaborador;
import com.tecnico.tucompra.model.Detalle_Historia_Clinica;
import com.tecnico.tucompra.model.Historia_Clinica;
import com.tecnico.tucompra.repository.Detalle_Historia_Clinica_Repository;

@Service
public class Detalle_Historia_Clinica_Implementation implements Detalle_Historia_Clinica_Service {

	@Autowired
	public Detalle_Historia_Clinica_Repository detalle_Historia_Clinica_Repository;

	public Detalle_Historia_Clinica_Implementation(
			Detalle_Historia_Clinica_Repository detalle_Historia_Clinica_Repository) {
		this.detalle_Historia_Clinica_Repository = detalle_Historia_Clinica_Repository;
	}

	@Override
	public Detalle_Historia_Clinica edit(int id, String temperatura, double peso, double frecuencia_cardiaca,
			double frecuencia_respiratoria, Date fecha_hora, String alimetacion, String habitad, String observacion,
			Colaborador colaborador, Historia_Clinica historia_clinica) throws Exception {

		Detalle_Historia_Clinica detalle_Historia_Clinica_Dummmy = new Detalle_Historia_Clinica();

		if (temperatura == " " || temperatura == "") {
			throw new Exception("La temperatura no debe ser nula");
		} else if (peso < 0) {
			throw new Exception("El peso debe ser mayor que 0");
		} else if (frecuencia_cardiaca < 0) {
			throw new Exception("La frecuencia cardiaca debe ser mayor que 0");
		} else if (frecuencia_respiratoria < 0) {
			throw new Exception("La frecuencia respiratoria debe ser mayor que 0");
		} else if (fecha_hora == null) {
			throw new Exception("La fecha no debe ser nula");
		} else if (alimetacion == " " || alimetacion == "") {
			throw new Exception("La alimetacion no debe ser nula");
		} else if (habitad == " " || habitad == "") {
			throw new Exception("El habitad no debe ser nulo");
		} else if (observacion == " " || observacion == "") {
			throw new Exception("La observacion no debe ser nula");
		} else if (historia_clinica == null) {
			throw new Exception("La historia clinica no debe ser nula");
		} else {
			detalle_Historia_Clinica_Dummmy.setId(id);
			detalle_Historia_Clinica_Dummmy.setTemperatura(temperatura);
			detalle_Historia_Clinica_Dummmy.setPeso(peso);
			detalle_Historia_Clinica_Dummmy.setFrecuencia_cardiaca(frecuencia_cardiaca);
			detalle_Historia_Clinica_Dummmy.setFrecuencia_respiratoria(frecuencia_respiratoria);
			detalle_Historia_Clinica_Dummmy.setFecha_hora(fecha_hora);
			detalle_Historia_Clinica_Dummmy.setAlimentacion(alimetacion);
			detalle_Historia_Clinica_Dummmy.setHabitad(habitad);
			detalle_Historia_Clinica_Dummmy.setObservacion(observacion);
			detalle_Historia_Clinica_Dummmy.setColaborador(colaborador);
			detalle_Historia_Clinica_Dummmy.setHistoria_clinica(historia_clinica);
		}

		return detalle_Historia_Clinica_Dummmy;
	}

	@Override
	public Detalle_Historia_Clinica add(int id, String temperatura, double peso, double frecuencia_cardiaca,
			double frecuencia_respiratoria, Date fecha_hora, String alimetacion, String habitad, String observacion,
			Colaborador colaborador, Historia_Clinica historia_clinica) {

		Detalle_Historia_Clinica detalle_Historia_Clinica_Dummmy = new Detalle_Historia_Clinica();
		detalle_Historia_Clinica_Dummmy.setId(id);
		detalle_Historia_Clinica_Dummmy.setTemperatura(temperatura);
		detalle_Historia_Clinica_Dummmy.setPeso(peso);
		detalle_Historia_Clinica_Dummmy.setFrecuencia_cardiaca(frecuencia_cardiaca);
		detalle_Historia_Clinica_Dummmy.setFrecuencia_respiratoria(frecuencia_respiratoria);
		detalle_Historia_Clinica_Dummmy.setFecha_hora(fecha_hora);
		detalle_Historia_Clinica_Dummmy.setAlimentacion(alimetacion);
		detalle_Historia_Clinica_Dummmy.setHabitad(habitad);
		detalle_Historia_Clinica_Dummmy.setObservacion(observacion);
		detalle_Historia_Clinica_Dummmy.setColaborador(colaborador);
		detalle_Historia_Clinica_Dummmy.setHistoria_clinica(historia_clinica);

		detalle_Historia_Clinica_Repository.save(detalle_Historia_Clinica_Dummmy);
		return detalle_Historia_Clinica_Dummmy;

	}

	@Override
	public Detalle_Historia_Clinica save(Detalle_Historia_Clinica detalle_historia_clinica) {
		return detalle_Historia_Clinica_Repository.save(detalle_historia_clinica);
	}

	@Override
	public void delete(Detalle_Historia_Clinica detalle_historia_clinica) {
		detalle_Historia_Clinica_Repository.delete(detalle_historia_clinica);
	}

	@Override
	public Iterable<Detalle_Historia_Clinica> findAll() {
		return detalle_Historia_Clinica_Repository.findAll();
	}

	@Override
	public Optional<Detalle_Historia_Clinica> findById(int id) {
		return detalle_Historia_Clinica_Repository.findById((long) id);
	}

}
