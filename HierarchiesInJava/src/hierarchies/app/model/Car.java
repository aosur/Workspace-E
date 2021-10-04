package hierarchies.app.model;

public class Car {

	protected Integer speed;
	protected Integer gasoline;
	protected boolean engineState;
	
	public Car(Integer speed, Integer gasoline, boolean engineState) {
		this.speed = speed;
		this.gasoline = gasoline;
		this.engineState = engineState;
	}

	public Car() {
		super();
	}



	public Integer getSpeed() {
		return speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
	}
	
	
	
}
