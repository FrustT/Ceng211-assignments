package vehiclepricecalculator.classes;

import java.time.LocalDate;

public class SedanVehicle extends Automobile {
	private enum RoofType {REGULAR, MOONROOF, SUNROOF};
	
	private RoofType roofType;
	
	public SedanVehicle() {
		super();
		this.roofType = null;
	}

	public SedanVehicle(SedanVehicle _SedanVehicle) {
		super(_SedanVehicle);
		this.setRoofTypeOfSedan(_SedanVehicle.getRoofTypeOfSedan());
	}

	public SedanVehicle(String _vehicleId, LocalDate _monthOfSale, String _cityOfSale, LocalDate _productionYear, int _valueAddedTax, String _roofType, double _engineVolume) {
		super(_vehicleId, _monthOfSale, _cityOfSale, _productionYear, _valueAddedTax,_engineVolume);
		this.setRoofTypeOfSedan(_roofType);
	}

	/**
	 * Gets the Sedan Object's <b>roofType</b> variable as considering privacy leak.
	 * @return the roofType
	 */
	public String getRoofTypeOfSedan() {
		return this.roofType.toString();
	}

	/**
	 * Sets the Sedan Object's <b>roofType</b>  variable after input validation.
	 * @param roofType the roofType to set
	 */
	public void setRoofTypeOfSedan(String _roofType) {
		this.roofType = RoofType.valueOf(_roofType);
	}
	public String toString() {//TODO
		return "";
	}
	public boolean equals() {//TODO
		return false;
	}

}
