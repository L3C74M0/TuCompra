package com.tecnico.tucompra.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tecnico.tucompra.model.Mascota;
import com.tecnico.tucompra.model.Usuario;
import com.tecnico.tucompra.repository.Usuario_Repository;

@Service
public class Usuario_Service_Implementation implements Usuario_Service {

	@Autowired
	public Usuario_Repository usuario_repository;

	public Usuario_Service_Implementation(Usuario_Repository usuario_repository) {
		this.usuario_repository = usuario_repository;
	}

	@Override
	public Usuario edit(int id, String nombre, String apellido, char tipo_documento, int documento_identificacion,
			char estado, int sexo, List<Mascota> mascotas) throws Exception {
		
		Usuario usuarioDummy = new Usuario();
		
		if (nombre == " " || nombre == "") {
			throw new Exception("El nombre no debe ser nulo");
		} else if (apellido == " " || apellido == "") {
			throw new Exception("El apellido no debe ser nulo");
		} else if (tipo_documento == ' ') {
			throw new Exception("El tipo de documento no debe ser nulo");
		} else if (documento_identificacion < 1) {
			throw new Exception("El documento de identificacion debe ser mayor que 0");
		} else if (estado == ' ') {
			throw new Exception("El estado no debe ser nulo");
		} else if (sexo < 1) {
			throw new Exception("El valor de sexo debe ser mayor que 0");
		} else {
			usuarioDummy.setId(id);
			usuarioDummy.setNombre(nombre);
			usuarioDummy.setApellido(apellido);
			usuarioDummy.setTipo_documento(tipo_documento);
			usuarioDummy.setDocumento_identificacion(documento_identificacion);
			usuarioDummy.setEstado(estado);
			usuarioDummy.setSexo(sexo);
			usuarioDummy.setMascotas(mascotas);
		}

		return usuarioDummy;
	}

	@Override
	public Usuario add(int id, String nombre, String apellido, char tipo_documento, int documento_identificacion,
			char estado, int sexo, List<Mascota> mascotas) {
		
		Usuario usuarioDummy = new Usuario();
		usuarioDummy.setId(id);
		usuarioDummy.setNombre(nombre);
		usuarioDummy.setApellido(apellido);
		usuarioDummy.setTipo_documento(tipo_documento);
		usuarioDummy.setDocumento_identificacion(documento_identificacion);
		usuarioDummy.setEstado(estado);
		usuarioDummy.setSexo(sexo);
		usuarioDummy.setMascotas(mascotas);

		usuario_repository.save(usuarioDummy);
		return usuarioDummy;
	}

	@Override
	public Usuario save(Usuario usuario) {
		return usuario_repository.save(usuario);
	}

	@Override
	public void delete(Usuario usuario) {
		usuario_repository.delete(usuario);
	}

	@Override
	public Iterable<Usuario> findAll() {
		return usuario_repository.findAll();
	}

	@Override
	public Optional<Usuario> findById(int id) {
		return usuario_repository.findById((long) id);
	}
}
