package vehiclepricecalculator.classes;

import java.time.LocalDate;

public class Automobile extends Vehicle{
	private double engineVolume;
	
	public Automobile() {
		super();
		this.engineVolume = 0.0;
	}
	
	public Automobile(
			String _vehicleId, LocalDate _monthOfSale, 
    	    String _cityOfSale, LocalDate _productionYear,
	        int _valueAddedTax, double _engineVolume) {
		super(_vehicleId,_monthOfSale,_cityOfSale,_productionYear,_valueAddedTax);
		this.engineVolume = _engineVolume;
	}
	
	public Automobile(Automobile _automobile) {
		super(_automobile);
		this.engineVolume = _automobile.engineVolume;
	}
	
	public double getEngineVolume() {
		return this.engineVolume;
	}
	public void setEngineVolume(double _engineVolume) {
		if(_engineVolume < 1 || _engineVolume > 2) {
			System.out.println("Invalid engine volume");
			System.exit(0);
		}
		this.engineVolume=_engineVolume;
	}
	public String toString() {//TODO
		return "";
	}
	public boolean equals() {//TODO
		return false;
	}
}
