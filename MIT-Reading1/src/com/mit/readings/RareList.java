package com.mit.readings;

import java.util.HashMap;
import java.util.Map;

public class RareList {

	public static void main(String[] args) {
		
		Map<String, Double> treasures = new HashMap<>();
		String x = "palm";
		treasures.put("beach", 25.);
		treasures.put("palm", 50.);
		treasures.put("cove", 75.);
		treasures.put("x", 100.);
		treasures.put("palm", treasures.get("palm") + treasures.size());
		treasures.remove("beach");
		System.out.println("size after remove item: " + treasures.size());
		double found = 0;
		for (double treasure : treasures.values()) {
		    found += treasure;
		}
		System.out.println("treasures.get(x): " + treasures.get(x));
		System.out.println("treasures.get('x'): " + treasures.get("x"));
		System.out.println("found: " + found);
	}
}
