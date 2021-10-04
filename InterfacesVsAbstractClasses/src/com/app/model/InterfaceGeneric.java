package com.app.model;

import java.util.List;

public interface InterfaceGeneric<E> {

	void getName(E e);
	List<E> getAll();
}
