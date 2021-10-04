package com.example.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dao.PersonaDao;
import com.example.app.entity.Persona;
import com.example.app.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	private PersonaDao dao;
	
	@Override
	public List<Persona> listarTodo() {
		return dao.findAll();
	}

	@Override
	public Persona buscarPorId(Long id) {
		return dao.findById(id)
				.orElseThrow(() -> new IllegalArgumentException(id + " no existe"));
	}

	@Override
	public void guardar(Persona persona) {
		dao.save(persona);
	}

	@Override
	public void eliminar(Long id) {
		dao.deleteById(id);
	}

}
