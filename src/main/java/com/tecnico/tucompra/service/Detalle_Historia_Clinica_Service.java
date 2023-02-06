package com.tecnico.tucompra.service;

import java.util.Date;
import java.util.Optional;
import com.tecnico.tucompra.model.Colaborador;
import com.tecnico.tucompra.model.Detalle_Historia_Clinica;
import com.tecnico.tucompra.model.Historia_Clinica;

public interface Detalle_Historia_Clinica_Service {

	public Detalle_Historia_Clinica edit(int id, String temperatura, double peso, double frecuencia_cardiaca,
			double frecuencia_respiratoria, Date fecha_hora, String alimetacion, String habitad, String observacion,
			Colaborador colaborador, Historia_Clinica historia_clinica) throws Exception;

	public Detalle_Historia_Clinica add(int id, String temperatura, double peso, double frecuencia_cardiaca,
			double frecuencia_respiratoria, Date fecha_hora, String alimetacion, String habitad, String observacion,
			Colaborador colaborador, Historia_Clinica historia_clinica);

	public Detalle_Historia_Clinica save(Detalle_Historia_Clinica detalle_historia_clinica);

	public void delete(Detalle_Historia_Clinica detalle_historia_clinica);

	public Iterable<Detalle_Historia_Clinica> findAll();

	public Optional<Detalle_Historia_Clinica> findById(int id);
}
