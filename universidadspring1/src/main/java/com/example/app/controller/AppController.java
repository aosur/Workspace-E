package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/")
@Slf4j
public class AppController {

	@ResponseBody
	@GetMapping(value = {"inicio"})
	public String inicio() {
		log.info("Ejecutando controlador");
		return "Hola mundo con Spring Boot";
	}
}
