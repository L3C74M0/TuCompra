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
import com.tecnico.tucompra.model.Detalle_Historia_Clinica;
import com.tecnico.tucompra.service.Detalle_Historia_Clinica_Service;

@RestController
@RequestMapping("/detalleR/")
public class DetalleREST {

	@Autowired
	private Detalle_Historia_Clinica_Service detalleService;

	@GetMapping("/detalles")
	public List<Detalle_Historia_Clinica> listarDetalles() {
		return detalleService.findAll();
	}

	@PostMapping(value = "/detalles")
	public ResponseEntity<Detalle_Historia_Clinica> saveDetalles(
			@RequestBody Detalle_Historia_Clinica detalle_Historia_Clinica) {
		try {
			Detalle_Historia_Clinica detalle = detalleService.save(detalle_Historia_Clinica);
			return ResponseEntity.created(new URI("/detalles/" + detalle.getId())).body(detalle);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@DeleteMapping(value = "/del/{id}")
	private ResponseEntity<Boolean> deleteUsuario(@PathVariable("id") int id) {
		detalleService.deleteById(id);
		return ResponseEntity.ok(!(detalleService.findById(id) != null));
	}
}
