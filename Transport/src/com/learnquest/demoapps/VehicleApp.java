package com.learnquest.demoapps;

import java.time.LocalDate;

import com.learnquest.demos.transport.Car;
import com.learnquest.demos.transport.SUV;
import com.learnquest.demos.transport.SportCar;
import com.learnquest.demos.transport.StationWagon;
import com.learnquest.demos.transport.Train;
import com.learnquest.demos.transport.Vehicle;

public class VehicleApp {
	
	public static void main(String[] args) {
		
		Car car54 = new SportCar();
		car54.setName("Car 54");
		car54.setSpeed(20);
		car54.setGasoline(20);
		car54.setManufactured(LocalDate.of(1961, 9, 17));

		Car match5 = new SportCar("Match V", 250, 21, true);
		match5.setManufactured(LocalDate.of(1967, 4, 12));
		
		StationWagon wagon = new StationWagon("Wagon Queen Family Truckster");
		wagon.setManufactured(LocalDate.of(1970, 7, 29));
		wagon.setCurrentCargoLoad(500);
		wagon.setSpeed(75);
		
		SUV suv = new SUV("Jurassic Explorer");
		suv.setManufactured(LocalDate.of(1993, 6, 11));
		suv.setCurrentCargoLoad(500);
		suv.setSpeed(25);
		
		Train train = new Train("City of New Orleans");
		
		for(Vehicle vehicle: new Vehicle[] {car54, match5, wagon, suv, train}) {
			if(vehicle instanceof SportCar) 
				((SportCar)vehicle).race();
			else
				Vehicle.travelAtSpeedLimitCar(vehicle);
			
			System.out.println(vehicle);
		}		
	}
}
