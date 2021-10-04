package com.example.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.entity.Persona;
import com.example.app.service.PersonaService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/")
@Slf4j
public class AppController {
	
	@Autowired
	private PersonaService service;

	@GetMapping(value = { "inicio" })
	public String inicio(Model model) {
		log.info("Ejecutando controlador Spring MVC");
		List<Persona> personas = service.listarTodo();
		model.addAttribute("personas", personas);
		return "index";
	}
	
	@GetMapping(value = { "agregar" })
	public String mostrarFormulario(@ModelAttribute Persona persona, Model model) {
		log.info("Ejecutando controlador agregar Spring MVC");
		String titulo = "Nueva Persona";
		model.addAttribute("titulo", titulo);
		return "agregarpersona";
	}
	
	@PostMapping(value = { "guardar" })
	public String guardar(@Valid @ModelAttribute Persona persona, 
			BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			
			log.info("Se encontraron errores en el formulario!");
			String titulo = "Nueva Persona";

			if (persona.getId() != null)
				titulo = "Editar Persona (" + persona.getId() + ")";
						
			model.addAttribute("titulo", titulo);
			return "agregarpersona";
			
		}
		log.info("Ejecutando controlador guardar Spring MVC");
		service.guardar(persona);
		return "redirect:/inicio";
	}
	
	@GetMapping(value = { "editar/{id}" })
	public String editar(Model model, @PathVariable Long id) {
		log.info("Ejecutando controlador editar Spring MVC");
		String titulo = "Editar Persona (" + id + ")";
		Persona persona = service.buscarPorId(id);
		model.addAttribute("persona", persona);
		model.addAttribute("titulo", titulo);
		return "agregarpersona";
	}
	
	@PostMapping(value = { "eliminar/{id}" })
	public String eliminar(@PathVariable Long id) {
		log.info("Ejecutando controlador eliminar Spring MVC");
		service.eliminar(id);;
		return "redirect:/inicio";
	}
	
	
	
}
