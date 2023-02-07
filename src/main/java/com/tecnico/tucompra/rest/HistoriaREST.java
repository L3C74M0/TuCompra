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
import com.tecnico.tucompra.service.Historia_Clinica_Service;
import com.tecnico.tucompra.model.Historia_Clinica;

@RestController
@RequestMapping("/historiaR/")
public class HistoriaREST {

	@Autowired
	private Historia_Clinica_Service historia_Clinica_Service;

	@GetMapping("/historias")
	public List<Historia_Clinica> listarHistorias() {
		return historia_Clinica_Service.findAll();
	}

	@PostMapping(value = "/historias")
	public ResponseEntity<Historia_Clinica> saveHistoria(@RequestBody Historia_Clinica historia_Clinica) {
		try {
			Historia_Clinica hst = historia_Clinica_Service.save(historia_Clinica);
			return ResponseEntity.created(new URI("/historias/" + hst.getId())).body(hst);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@DeleteMapping(value = "/del/{id}")
	private ResponseEntity<Boolean> deleteHistoria(@PathVariable("id") int id) {
		historia_Clinica_Service.deleteById(id);
		return ResponseEntity.ok(!(historia_Clinica_Service.findById(id) != null));
	}
}
