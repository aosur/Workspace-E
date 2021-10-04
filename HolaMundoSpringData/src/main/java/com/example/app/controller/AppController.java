package com.example.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public String inicio(Model model, @ModelAttribute Persona persona) {

		log.info("Ejecutando controlador Spring MVC");
		List<Persona> personas = service.listarTodo();
		model.addAttribute("personas", personas);
		return "index";
	}
	
}
