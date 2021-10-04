package com.app.main;

import com.app.model.AbstractImpl;
import com.app.model.InterfacePrueba;
import com.app.model.InterfacePruebaImpl;

public class MainInterfacePrueba {

	public static void main(String[] args) {
		String miNombre = InterfacePrueba.nombre;
		InterfacePrueba prueba = new InterfacePruebaImpl();
		AbstractImpl absImpl = new AbstractImpl();
		
		System.out.println(miNombre);
		System.out.println("Year: " + prueba.getYear());
		System.out.println("Saludo: " + InterfacePrueba.getSaludo());
		System.out.println("Year" + absImpl.getYear());
		absImpl.getPhoneNumber();		
		
	}
}
