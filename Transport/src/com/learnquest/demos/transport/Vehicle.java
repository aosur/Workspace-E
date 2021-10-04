package com.learnquest.demos.transport;

public interface Vehicle {

	String getName();
	void setName(String name);

	int getSpeed();
	void setSpeed(int newSpeed);
	
	default void stop() {
		setSpeed(0);
	}
	
	default void slow() {
		setSpeed(getSpeed() / 2); 
	}
	
    static void travelAtSpeedLimitCar(Vehicle vehicle) {
		vehicle.setSpeed(55);
	}
	
}
