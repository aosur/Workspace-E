package com.example.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="persona")
public class Persona {

	@Id
	@Column(name="id_persona")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	
	public Persona() {
		this("Paco", "Yunque", "pacoy@gmail.com", "896563256");
	}
	
	public Persona(String nombre, String apellido, String email, String telefono) {
		setNombre(nombre);
		setApellido(apellido);
		setEmail(email);
		setTelefono(telefono);
	}
	
}
