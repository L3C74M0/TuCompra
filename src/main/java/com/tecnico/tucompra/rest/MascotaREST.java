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
import com.tecnico.tucompra.model.Mascota;
import com.tecnico.tucompra.service.Mascota_Service;

@RestController
@RequestMapping("/mascotaR/")
public class MascotaREST {

	@Autowired
	private Mascota_Service mascota_Service;

	@GetMapping("/mascotas")
	public List<Mascota> listarMascotas() {
		return mascota_Service.findAll();
	}

	@PostMapping(value = "/mascotas")
	public ResponseEntity<Mascota> saveUsuario(@RequestBody Mascota mascota) {
		try {
			Mascota mst = mascota_Service.save(mascota);
			return ResponseEntity.created(new URI("/mascotas/" + mst.getId())).body(mst);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@DeleteMapping(value = "/del/{id}")
	private ResponseEntity<Boolean> deleteMascota(@PathVariable("id") int id) {
		mascota_Service.deleteById(id);
		return ResponseEntity.ok(!(mascota_Service.findById(id) != null));
	}
}
