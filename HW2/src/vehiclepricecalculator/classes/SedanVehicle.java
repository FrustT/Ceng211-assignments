package vehiclepricecalculator.classes;

import java.util.Locale;

	/**
	 * This Class is a sub class of Automobile and more spesified than vehicle.
	 * Has concrete implementations for abstract class in the superclasses.
	 * <ul>
	 * <li><strong>RoofType {REGULAR, MOONROOF, SUNROOF}</strong> type: enum
	 * <li><strong>roofType</strong> type: RoofType
	 * </ul>
	 * @author  Mustafa Fatih Can 280201007
	 * @author  Deniz Kaya 280201033
	 * @author  Hakan Uskan 280201076
	 * @author  Burak Erinç 290201099
	 */

public class SedanVehicle extends Automobile {
	private enum RoofType {
		REGULAR, MOONROOF, SUNROOF
	};

	private RoofType roofType;
	
	/**
	 * <strong>No Argument Constructor</strong><p>
	 */
	
	public SedanVehicle() {
		super();
		this.roofType = null;
	}
	
	/**
	 * <strong>Copy Constructor</strong><p>
	 * Constructs a new SedanVehicle Object with another SedanVehicle Object
	 * @param _SedanVehicle
	 */
	
	public SedanVehicle(SedanVehicle _SedanVehicle) {
		super(_SedanVehicle);
		this.setRoofTypeOfSedan(_SedanVehicle.getRoofTypeOfSedan());
	}
	
	/**
	 * <strong>Parameterized Constructor</strong><p>
	 * Constructs SedanVehicle Object with required data.
	 * @param _vehicleId
	 * @param _monthOfSale
	 * @param _cityOfSale
	 * @param _productionYear
	 * @param _valueAddedTax
	 * @param _roofType
	 * @param _engineVolume
	 */
	
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
	
   /**
	* Gets the Sedan Object's SCT value based on sedan's roof type.
	*
	* @return double SCT value of sedan. 
	*/
	public double calculateSCT() {
		double roofTypeSCTValue = getRoofTypeSCTValue();
		double engineVolumeSCTValue = this.getEngineVolume();

		if (roofTypeSCTValue == -1.0 || engineVolumeSCTValue == -1.0) { // check for error values
			System.out.println("Error calculating SCT value of Sedan(Bad input)");
			System.exit(0);
		}

		return ((engineVolumeSCTValue * 0.2 * roofTypeSCTValue) / getProductionYearSCTValue());
	}

	@Override
	public String toString() {
		return "Vehicle: Sedan " + super.toString();
	}

	@Override
	public boolean equals(Object _object) {
		if (super.equals(_object)) {
			SedanVehicle sedanVehicle = (SedanVehicle) _object;
			return this.getRoofTypeOfSedan().equals(sedanVehicle.getRoofTypeOfSedan());
		}
		return false;
	}

   /**
	* Gets the Sedan Object's SCT value based on roof type.
	* 
	* @return double SCT value of sedan's roof type. 
	*/
	public double getRoofTypeSCTValue() {
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
