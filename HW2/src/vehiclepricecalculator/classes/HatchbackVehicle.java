package vehiclepricecalculator.classes;

import java.time.LocalDate;
import java.util.Date;

public class HatchbackVehicle extends Automobile{
	private boolean cityMode;
	
	public HatchbackVehicle () {
		super();
		cityMode = false;
	}
	
	public HatchbackVehicle (HatchbackVehicle _hatchbackVehicle) {
		super(_hatchbackVehicle);
		this.setCityMode(_hatchbackVehicle.getCityMode());
	}
	
	public HatchbackVehicle(String _vehicleId, String _monthOfSale, String _cityOfSale, int _productionYear, int _valueAddedTax, boolean _cityMode, double _engineVolume) {
		super(_vehicleId, _monthOfSale, _cityOfSale, _productionYear, _valueAddedTax,_engineVolume);
		this.setCityMode(_cityMode);
	}
	
	/**
	 * Gets the Hatchback Object's <b>cityMode</b> variable as considering privacy leak.
	 * @return The boolean value of Hatchback's situation of having city mode or not.
	 */
	public boolean getCityMode() {
		return cityMode;
	}
	
	/**
	 * Sets the Hatchback Object's <b>cityMode</b> variable after input validation.
	 * @param The boolean city mode value which we want to set.
	 */
	public void setCityMode(boolean _cityMode) {
		this.cityMode = _cityMode;
	}
	
	public double calculateSCT() {
		return this.getEngineVolume()*0.3*this.getProductionYearSCTValue() + getCityModeSCTValue();
	}
	
	public String toString() {
		return "Vehicle: Hatchback " + super.toString();
	}
	
	public boolean equals(Object _object) {
		if(super.equals(_object)) {
			HatchbackVehicle hatchbackVehicle = (HatchbackVehicle) _object;
			return this.getCityMode() == hatchbackVehicle.getCityMode();
		}
		return false;
	}
	
	private double getCityModeSCTValue(){
		if (this.cityMode){
			return 0.15;
		}
		else {
			return 0.1;
		}
	}
}
