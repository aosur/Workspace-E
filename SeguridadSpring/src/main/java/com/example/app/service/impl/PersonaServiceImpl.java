package com.example.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.dao.PersonaDao;
import com.example.app.entity.Persona;
import com.example.app.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	private PersonaDao dao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Persona> listarTodo() {
		return dao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Persona buscarPorId(Long id) {
		return dao.findById(id)
				.orElseThrow(() -> new IllegalArgumentException(id + " no existe"));
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void guardar(Persona persona) {
		dao.save(persona);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void eliminar(Long id) {
		dao.deleteById(id);
	}

}
