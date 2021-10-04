package com.learnquest.generics.week1;

public class GenericsApp {

	private interface Stack<E> {
		
		void push(E element);
		E pop();
		
	}
	
	private static class StackArray<E> implements Stack<E>{
		
		int tos;
		E[] stack;
		
		public StackArray() {
			this(10);
		}

		@SuppressWarnings("unchecked")
		public StackArray(int maxdepth) {
			tos = 0;
			stack = (E[]) new Object[maxdepth];
		}
		
		@Override
		public void push(E element) {
			stack[tos ++] = element;
		}

		@Override
		public E pop() {
			// Empty  stack return null, since we have not covered Exceptions yet
			return tos > 0 ? stack[--tos] : null;
		}
		
	}
	
	public static void main(String[] args) {
		
		Stack<Integer> ints = new StackArray<>();
		Stack<String> strings = new StackArray<>(5);
		
		if(ints.getClass() == strings.getClass())
			System.out.printf("Stack<Integer> and Stack<String> are both %s!%n", 
					ints.getClass());
		
		strings.push("World");
		strings.push("Hello");
		//strings.push(5);
		
		ints.push(5);
		ints.push(3);
		ints.push(2);
		ints.push(1);
		ints.push(1);
		//ints.push("Hello World");
	}
}
