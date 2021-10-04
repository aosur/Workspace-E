package com.app.model;

import java.io.IOException;

public class PrincipalInterfaceGeneric {

	public static void main(String[] args) throws IOException {
//		
//		InterfaceGeneric<String> prueba = new InterfaceGenericImpl<String>();
//		prueba.getAll();
//		prueba.getName("something");
		InterfaceGenericImpl<String> a = new InterfaceGenericImpl<>();
		a.print();
	}
}
