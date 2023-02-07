package com.tecnico.tucompra.rest;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tecnico.tucompra.model.Colaborador;
import com.tecnico.tucompra.service.Colaborador_Service;

@RestController
@RequestMapping("/colaboradorR/")
public class ColaboradorREST {

	@Autowired
	private Colaborador_Service colaborador_Service;

	@GetMapping("/colaboradores")
	public List<Colaborador> listColaboradores() {
		return colaborador_Service.findAll();
	}

	@PostMapping(value = "/colaboradores")
	public ResponseEntity<Colaborador> saveColaborador(@RequestBody Colaborador colaborador) {
		try {
			Colaborador clb = colaborador_Service.save(colaborador);
			return ResponseEntity.created(new URI("/colaboradores/" + clb.getId())).body(clb);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@DeleteMapping(value = "/del/{id}")
	private ResponseEntity<Boolean> deleteColaborador(@PathVariable("id") int id) {
		colaborador_Service.deleteById(id);
		return ResponseEntity.ok(!(colaborador_Service.findById(id) != null));
	}
}
