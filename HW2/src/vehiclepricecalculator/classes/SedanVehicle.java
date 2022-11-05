package vehiclepricecalculator.classes;

import java.time.LocalDate;

public class SedanVehicle extends Vehicle {
	private enum RoofType {REGULAR, MOONROOF, SUNROOF};
	
	private double engineVolume;
	private RoofType roofType;
	
	public SedanVehicle() {
		this(null);
	}

	public SedanVehicle(Vehicle _vehicle) {
		super(_vehicle);
	}

	public SedanVehicle(String _vehicleId, LocalDate _monthOfSale, String _cityOfSale, LocalDate _productionYear, int _valueAddedTax, RoofType _roofType, double _engineVolume) {
		super(_vehicleId, _monthOfSale, _cityOfSale, _productionYear, _valueAddedTax);
		this.roofType = _roofType;
		this.engineVolume = _engineVolume;
	}

	/**
	 * Gets the Sedan Object's <b>roofType</b> variable as considering privacy leak.
	 * @return the roofType
	 */
	public RoofType getRoofTypeOfSedan() {
		return roofType;
	}

	/**
	 * Sets the Sedan Object's <b>roofType</b>  variable after input validation.
	 * @param roofType the roofType to set
	 */
	public void setRoofTypeOfSedan(RoofType _roofType) {
		this.roofType = _roofType;
	}

	/**
	 * Gets the Sedan Object's <b>engineVolume</b> variable as considering privacy leak.
	 * @return The integer value of Sedan's engine volume.
	 */
	public double getEngineVolume() {
		return engineVolume;
	}
	
	/**
	 * Sets the Sedan Object's <b>engineVolume</b> variable after input validation.
	 * @param engineVolume the engineVolume to set
	 */
	public void setEngineVolume(double _engineVolume) {
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
