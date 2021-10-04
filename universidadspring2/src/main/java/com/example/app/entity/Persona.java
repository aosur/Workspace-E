package com.example.app.entity;

import lombok.Data;

@Data
public class Persona {

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
