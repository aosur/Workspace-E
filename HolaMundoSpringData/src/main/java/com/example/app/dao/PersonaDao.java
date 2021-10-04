package com.example.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.app.entity.Persona;

@Repository // Spring Boot creará una implementacion por default, esta anotacion ya no es necesaria
public interface PersonaDao extends JpaRepository<Persona, Long> {

	
}
