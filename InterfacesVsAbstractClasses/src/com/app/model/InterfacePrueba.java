package com.app.model;

import java.time.LocalDate;

public interface InterfacePrueba {

	String nombre = "Alan";
	
	void getPhoneNumber();
	
	//int getAge();
	
	default int getYear() {
		return LocalDate.now().getYear();
	}
	
	static String getSaludo() {
		return "Hello World!!!";
	}
	
	/*default int getAgeInXYears(int x) {
		return getAge() + x;
	}*/
	
}
