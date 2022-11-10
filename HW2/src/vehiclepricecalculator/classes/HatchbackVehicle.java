package vehiclepricecalculator.classes;

import java.time.LocalDate;

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
	
	public HatchbackVehicle(String _vehicleId, LocalDate _monthOfSale, String _cityOfSale, LocalDate _productionYear, int _valueAddedTax, boolean _cityMode, double _engineVolume) {
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
	public String toString() {//TODO
		return "";
	}
	public boolean equals() {//TODO
		return false;
	}
}
