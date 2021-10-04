package hierarchies.app.model;

public class StationWagon extends Car{
     
	private Integer cargoCapacity;
	private Integer currentCargoLoad;
	
	public StationWagon(Integer speed, Integer gasoline, boolean engineState) {
		super(speed, gasoline, engineState);
	}

	public void setCurrentCargoLoad(Integer currentCargoLoad) {
		this.currentCargoLoad = currentCargoLoad;
	}
	
	
}
