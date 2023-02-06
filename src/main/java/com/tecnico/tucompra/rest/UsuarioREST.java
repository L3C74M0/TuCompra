package com.tecnico.tucompra.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import com.tecnico.tucompra.model.Usuario;
import com.tecnico.tucompra.service.Usuario_Service;

@RestController
public class UsuarioREST {

	@Autowired
	private Usuario_Service usuario_Service;
	
	@GetMapping("/usuario")
	public String indexUsuario(Model model) {
		model.addAttribute("usuarios", usuario_Service.findAll());
		return "usuario/index";
	}
	
	@GetMapping("/usuario/add-usuario")
	public String addUsuario(Model model, @ModelAttribute("usuario") Usuario usuario) {
		model.addAttribute("usuario", new Usuario());
		return "/usuario/add-usuario";
	}
}
