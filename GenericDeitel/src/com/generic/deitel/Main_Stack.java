package com.generic.deitel;

import java.util.stream.IntStream;

public class Main_Stack {

	public static void main(String[] args) {
		
		Stack<Integer> StackInteger = new Stack<>();
		
		IntStream.rangeClosed(0, 10)
			.forEach(StackInteger::push);
		
		System.out.println(StackInteger.size());
		
		System.out.println("Eliminated: " + StackInteger.pop());
		
		System.out.println(StackInteger.size());
	}
} 
