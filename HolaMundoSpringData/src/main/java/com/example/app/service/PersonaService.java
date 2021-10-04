package com.example.app.service;

import java.util.List;

import com.example.app.entity.Persona;

public interface PersonaService {

	List<Persona> listarTodo();
	Persona buscarPorId(Long id);
	void guardar(Persona persona);
	void eliminar(Long id);
}
