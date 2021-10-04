package com.learnquest.generics.week1;

import java.util.Collection;

public class GenericMethods {

	public static <T> Collection<T> unmodifiable(Collection<T> c) {
		return c;
	}
	
	public <T> T getBean(Class<T> requiredType) {
		return null;
	}
}
