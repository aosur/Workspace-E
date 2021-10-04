package com.learnquest.demos.transport;

public class Train extends com.devtech.training.transportation.Train implements 
	Vehicle {
	
	public Train(String name) {
		super(name);
	}
	
	//the name property can be inherited; implement speed
	@Override
	public int getSpeed() {
		return (int)(2 * Math.PI * (getWheelSize() / 2) 
				/ 12 * getRPM() * 60 / 5280);
	}

	@Override
	public void setSpeed(int mph) {
		setRPM((int) (mph * 5280 * 12 /
				(2 * Math.PI * (getWheelSize() / 2) * 60)));
		
	}
	
	@Override
	public String toString() {
		return String.format("%s is traveling at %d", getName(), getSpeed());
	}
}
