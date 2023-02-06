package com.tecnico.tucompra.service;

import java.util.List;
import java.util.Optional;
import com.tecnico.tucompra.model.Mascota;
import com.tecnico.tucompra.model.Usuario;

public interface Usuario_Service {

	public Usuario edit(int id, String nombre, String apellido, char tipo_documento, int documento_identificacion,
			char estado, int sexo, List<Mascota> mascotas) throws Exception;

	public Usuario add(int id, String nombre, String apellido, char tipo_documento, int documento_identificacion,
			char estado, int sexo, List<Mascota> mascotas);

	public Usuario save(Usuario usuario);

	public void delete(Usuario usuario);

	public Iterable<Usuario> findAll();

	public Optional<Usuario> findById(int id);
}
