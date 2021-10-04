package com.mit.readings;

public class Reading1_Hailstone {

	private static void hailstoneSequence(int initialNumber) {
		
		System.out.println(initialNumber);
		
		while(initialNumber != 1) {
			initialNumber = initialNumber % 2 == 0 ? initialNumber / 2 : 3 * initialNumber + 1;
			System.out.println(initialNumber);
		}
	}
	
	public static void main(String[] args) {
		
		hailstoneSequence(7);
	}
}
