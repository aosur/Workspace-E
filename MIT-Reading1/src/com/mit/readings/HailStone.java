package com.mit.readings;

import java.util.ArrayList;
import java.util.List;

public class HailStone {

	public static List<Integer> hailstoneSequence(int n) {
		
		List<Integer> hailstoneSequence = new ArrayList<>();
		hailstoneSequence.add(n);
		
		while(n != 1) {
			n = n % 2 == 0 ? n / 2 : 3 * n + 1;
			hailstoneSequence.add(n);
		}
		return hailstoneSequence;
	}
	
	public static void main(String[] args) {
		hailstoneSequence(1000000).forEach(System.out::println);
	}
}
