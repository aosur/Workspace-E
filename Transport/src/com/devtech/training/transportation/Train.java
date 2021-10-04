package com.devtech.training.transportation;

public class Train {

	private String name;
	private int RPM;
	private int wheelSize;
	
	public Train(String name) {
		setName(name);
		setWheelSize(60);// assume 5' diameter of the wheel
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRPM() {
		return RPM;
	}

	public void setRPM(int rPM) {
		RPM = rPM;
	}

	public int getWheelSize() {
		return wheelSize;
	}

	public void setWheelSize(int wheelSize) {
		this.wheelSize = wheelSize;
	}
	
	
	
	
	
	
}
