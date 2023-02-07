package com.tecnico.tucompra.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.tecnico.tucompra.model.Mascota;
import com.tecnico.tucompra.service.Mascota_Service;

@RestController
public class MascotaREST {
	
	@Autowired
	private Mascota_Service mascota_Service;
	
	@GetMapping("/mascota/")
	public String indexMascota(Model model) {
		model.addAttribute("mascotas", mascota_Service.findAll());
		return "mascota/index";
	}
	
	@GetMapping("/mascota/add-mascota")
	public String addMascota (Model model,  @ModelAttribute("mascota") Mascota mascota) {
		model.addAttribute("mascota", new Mascota());
		return "/mascota/add-mascota";
	}
	
	@GetMapping("/mascota/edit/{id}")
	public String editUsuario(@PathVariable("id") int id,
			@RequestParam(value = "action", required = true) String action, Mascota mascota,
			BindingResult bindingResult, Model model) {
		if (action != null && !action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				model.addAttribute("mascota", mascota);
				return "mascota/edit-mascota";
			}
		}
		return "redirect:/mascota/";
	}

	@GetMapping("/mascota/del/{id}")
	public String deleteUsuario(@PathVariable("id") int id, Model model) {
		Mascota mascota = mascota_Service.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Id de mascota invalido:" + id));
		mascota_Service.delete(mascota);
		return "redirect:/mascota/";
	}
}
