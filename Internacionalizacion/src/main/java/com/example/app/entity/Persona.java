package com.example.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
@Table(name="persona")
public class Persona {

	@Id
	@Column(name="id_persona")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String nombre;
	
	@NotEmpty
	private String apellido;
	
	@NotEmpty
	@Email
	private String email;
	
	@NotEmpty
	private String telefono;
	
	public Persona() {		
	}
	
	public Persona(String nombre, String apellido, String email, String telefono) {
		setNombre(nombre);
		setApellido(apellido);
		setEmail(email);
		setTelefono(telefono);
	}
	
}
