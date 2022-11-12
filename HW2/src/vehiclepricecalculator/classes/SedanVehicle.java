package vehiclepricecalculator.classes;

import java.util.Locale;

public class SedanVehicle extends Automobile {
	private enum RoofType {
		REGULAR, MOONROOF, SUNROOF
	};

	private RoofType roofType;

	public SedanVehicle() {
		super();
		this.roofType = null;
	}

	public SedanVehicle(SedanVehicle _SedanVehicle) {
		super(_SedanVehicle);
		this.setRoofTypeOfSedan(_SedanVehicle.getRoofTypeOfSedan());
	}

	public SedanVehicle(String _vehicleId, String _monthOfSale, String _cityOfSale, int _productionYear,
			int _valueAddedTax, String _roofType, double _engineVolume) {
		super(_vehicleId, _monthOfSale, _cityOfSale, _productionYear, _valueAddedTax, _engineVolume);
		this.setRoofTypeOfSedan(_roofType);
	}

	/**
	 * Gets the Sedan Object's <b>roofType</b> variable as considering privacy leak.
	 * 
	 * @return the roofType
	 */
	public String getRoofTypeOfSedan() {
		return this.roofType.toString();
	}

	/**
	 * Sets the Sedan Object's <b>roofType</b> variable after input validation.
	 * 
	 * @param roofType the roofType to set
	 */
	public void setRoofTypeOfSedan(String _roofType) {
		_roofType = _roofType.toUpperCase(Locale.ROOT);
		this.roofType = RoofType.valueOf(_roofType);
	}

	public double calculateSCT() {
		double roofTypeSCTValue = getRoofTypeSCTValue();
		double engineVolumeSCTValue = this.getEngineVolume();

		if (roofTypeSCTValue == -1.0 || engineVolumeSCTValue == -1.0) { // check for error values
			System.out.println("Error calculating SCT value of Sedan(Bad input)");
			System.exit(0);
		}

		return ((engineVolumeSCTValue * 0.2 * roofTypeSCTValue) / getProductionYearSCTValue());
	}

	public String toString() {
		return "Vehicle: Sedan " + super.toString();
	}

	public boolean equals(Object _object) {
		if (super.equals(_object)) {
			SedanVehicle sedanVehicle = (SedanVehicle) _object;
			return this.getRoofTypeOfSedan().equals(sedanVehicle.getRoofTypeOfSedan());
		}
		return false;
	}

	protected double getRoofTypeSCTValue() {
		switch (this.roofType) {
		case MOONROOF:
			return 0.6;
		case REGULAR:
			return 0.5;
		case SUNROOF:
			return 0.8;
		default:
			return -1.0;
		}
	}
}
