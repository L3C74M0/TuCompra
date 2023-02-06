package com.tecnico.tucompra.service;

import java.util.Optional;
import com.tecnico.tucompra.model.Colaborador;
import com.tecnico.tucompra.model.Detalle_Historia_Clinica;

public interface Colaborador_Service {

	public Colaborador edit(int id, String nombre, String apellido, String cargo, String especialidad,
			String tipo_documento, int documento_identificacion, Detalle_Historia_Clinica detalle_Historia_Clinica)
			throws Exception;

	public Colaborador add(int id, String nombre, String apellido, String cargo, String especialidad,
			String tipo_documento, int documento_identificacion, Detalle_Historia_Clinica detalle_Historia_Clinica);

	public Colaborador save(Colaborador colaborador);

	public void delete(Colaborador colaborador);

	public Iterable<Colaborador> findAll();

	public Optional<Colaborador> findById(int id);
}
