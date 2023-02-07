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
import com.tecnico.tucompra.model.Usuario;
import com.tecnico.tucompra.service.Usuario_Service;

@RestController
@RequestMapping("/usuarioR/")
public class UsuarioREST {

	@Autowired
	private Usuario_Service usuario_Service;

	@GetMapping("/usuarios")
	public List<Usuario> listarUsuarios() {
		return usuario_Service.findAll();
	}

	@PostMapping(value = "/usuarios")
	public ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario usuario) {
		try {
			Usuario usr = usuario_Service.save(usuario);
			return ResponseEntity.created(new URI("/usuarios/" + usr.getId())).body(usr);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@DeleteMapping(value = "/del/{id}")
	private ResponseEntity<Boolean> deleteUsuario(@PathVariable("id") int id) {
		usuario_Service.deleteById(id);
		return ResponseEntity.ok(!(usuario_Service.findById(id) != null));
	}

	
	/**
	@GetMapping("/usuario/add-usuario")
	public String addUsuario(Model model, @ModelAttribute("usuario") Usuario usuario) {
		model.addAttribute("usuario", new Usuario());
		return "/usuario/add-usuario";
	}

	@GetMapping("/usuario/edit/{id}")
	public String editUsuario(@PathVariable("id") int id,
			@RequestParam(value = "action", required = true) String action, Usuario usuario,
			BindingResult bindingResult, Model model) {
		if (action != null && !action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				model.addAttribute("usuario", usuario);
				return "usuario/edit-usuario";
			}
		}
		return "redirect:/usuario/";
	}*/
}
