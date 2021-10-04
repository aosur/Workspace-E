package com.learnquest.demos.transport;

public class Cargo extends Car{

	private int currentCargoLoad;
	
	public Cargo() {
		
	}
	
	public Cargo(String name) {
		super(name);
	}

	public Cargo(int currentCargoLoad) {
		setCurrentCargoLoad(currentCargoLoad);
	}

	public int getCurrentCargoLoad() {
		return currentCargoLoad;
	}

	public void setCurrentCargoLoad(int currentCargoLoad) {
		this.currentCargoLoad = currentCargoLoad;
	}
}
