package com.example.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.entity.Persona;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/")
@Slf4j
public class AppController {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final List<Persona> PERSONAS = Arrays.asList
			(
			new Persona("Guillermo", "Osorio", "gmonosorio@gmail.com", "98652356"),
			new Persona("Ian", "Osorio", "iansorio@gmail.com", "14525852"),
			new Persona("Claudio", "Osorio", "clauosorio@gmail.com", "96856326"),
			new Persona("Bianca", "Osorio", "bosorio@gmail.com", "963652354"),
			new Persona("Nicolle", "Osorio", "nicoosorio@gmail.com", "96856456"),
			new Persona("Luquitas", "Osorio", "luquitasosorio@gmail.com", "985685674")
			);
	
	//private List<Persona> lista = new ArrayList<Persona>();

	@Value("${welcome.msg.header}")
	private String header;

	@Value("${welcome.msg.par}")
	private String par;

	@GetMapping(value = { "inicio" })
	public String inicio(Model model, @ModelAttribute Persona persona) {

		log.info("Ejecutando controlador Spring MVC");

		model.addAttribute("class", persona.getClass());
		model.addAttribute("header", header);
		model.addAttribute("par", par);
		model.addAttribute("personas", PERSONAS);
		model.addAttribute("nombre", getNombre(1));

		return "index";
	}
	
	private String getNombre(int id) {
		String nombre = jdbcTemplate.queryForObject("select nombre from persona where id_persona=?", String.class, id);
		return nombre;
	}

}
