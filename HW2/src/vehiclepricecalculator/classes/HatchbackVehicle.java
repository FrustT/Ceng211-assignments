package vehiclepricecalculator.classes;

import java.time.LocalDate;

public class HatchbackVehicle extends Vehicle{
	private boolean cityMode;
	private int engineVolume;
	
	public HatchbackVehicle () {
		this(null);
	}
	
	public HatchbackVehicle (Vehicle _vehicle) {
		super(_vehicle);
	}
	
	public HatchbackVehicle(String _vehicleId, LocalDate _monthOfSale, String _cityOfSale, LocalDate _productionYear, int _valueAddedTax, boolean _cityMode, int _engineVolume) {
		super(_vehicleId, _monthOfSale, _cityOfSale, _productionYear, _valueAddedTax);
		this.cityMode = _cityMode;
		this.engineVolume = _engineVolume;
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
	
	/**
	 * Gets the Hatchback Object's <b>engineVolume</b> variable as considering privacy leak.
	 * @return The integer value of Hatchback's engine volume.
	 */
	public int getEngineVolume() {
		return engineVolume;
	}
	
	/**
	 * Sets the Hatchback Object's <b>engineVolume</b> variable after input validation.
	 * @param The primitive integer value of engine volume.
	 */
	public void setEngineVolume(int _engineVolume) {
		if (_engineVolume >= 0)
		{
			this.engineVolume = _engineVolume;
		}
		
		else
		{
			System.out.println("The value of engine volume must be equal or greater than zero.");
			System.exit(0);
		}
	}
}
