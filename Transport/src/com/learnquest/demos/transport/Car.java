package com.learnquest.demos.transport;

import java.time.LocalDate;
import java.time.Period;

public abstract class Car implements Vehicle{

	private String name;
	private int speed;
	private int fuel;
	private boolean running;
	private LocalDate manufactured;
	private int gasoline;
	
	public Car() {
	}
	
	public Car(String name) {
		this(name, 0, 0, true);
	}

	public Car(String name, int speed, int fuel, boolean running) {
		setName(name);
		setSpeed(speed);
		setFuel(fuel);
		setRunning(running);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getFuel() {
		return fuel;
	}

	public void setFuel(int fuel) {
		this.fuel = fuel;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public LocalDate getManufactured() {
		return manufactured;
	}

	public void setManufactured(LocalDate manufactured) {
		this.manufactured = manufactured;
	}

	public int getGasoline() {
		return gasoline;
	}

	public void setGasoline(int gasoline) {
		this.gasoline = gasoline;
	}
	
	public String toString() {
		return String.format("%s is %d years old and is traveling at %d", 
				getName(), Period.between(getManufactured(), LocalDate.now()).getYears(), 
					getSpeed());
	}
	
}
