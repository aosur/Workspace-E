package com.app.model;

import java.io.IOException;
import java.util.List;

public class InterfaceGenericImpl<E> implements InterfaceGeneric<E>{

	@Override
	public void getName(E e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<E> getAll() {
		// TODO Auto-generated method stub
		return null;
	}	
	
	public void print() throws IOException{
		throw new IOException();
	}
}
