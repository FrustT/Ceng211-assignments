package vehiclepricecalculator.classes;

import java.time.LocalDate;

public class SedanVehicle extends Vehicle {
	private enum RoofType {REGULAR, MOONROOF, SUNROOF};
	
	private int engineVolume;
	private RoofType roofTypeOfSedan;
	public SedanVehicle() {
		this(null);
	}

	public SedanVehicle(Vehicle _vehicle) {
		super(_vehicle);
		// TODO Auto-generated constructor stub
	}

	public SedanVehicle(String _vehicleId, String _cityOfSale, LocalDate _monthOfSale, LocalDate _productionYear, RoofType _roofTypeOfSedan, int _engineVolume) {
		super(_vehicleId, _cityOfSale, _monthOfSale, _productionYear);
		this.roofTypeOfSedan = _roofTypeOfSedan;
		this.engineVolume = _engineVolume;
	}

	/**
	 * Gets the Sedan Object's <b>engineVolume</b> variable as considering privacy leak.
	 * @return the engineVolume
	 */
	public int getEngineVolume() {
		return engineVolume;
	}

	/**
	 * Sets the Sedan Object's <b>engineVolume</b> variable after input validation.
	 * @param engineVolume the engineVolume to set
	 */
	public void setEngineVolume(int engineVolume) {
		this.engineVolume = engineVolume;
	}

	/**
	 * Gets the Sedan Object's <b>roofTypeOfSedan</b> variable as considering privacy leak.
	 * @return the roofTypeOfSedan
	 */
	public RoofType getRoofTypeOfSedan() {
		return roofTypeOfSedan;
	}

	/**
	 * Sets the Sedan Object's <b>roofTypeOfSedan</b>  variable after input validation.
	 * @param roofTypeOfSedan the roofTypeOfSedan to set
	 */
	public void setRoofTypeOfSedan(RoofType roofTypeOfSedan) {
		this.roofTypeOfSedan = roofTypeOfSedan;
	}

}
