package vehiclepricecalculator.classes;

import java.util.Locale;

	/**
	 * This Class is a sub class of Automobile and more spesified than vehicle.
	 * Has concrete implementations for abstract class in the superclasses.
	 * <ul>
	 * <li><strong>CabType {REGULAR, EXTENDED, CREW}</strong> type: enum
	 * <li><strong>TruckBedType {REGULAR, TANKER, TRAILER}</strong> type: enum
	 * <li><strong>cabType</strong> type: CabType
	 * <li><strong>truckBedType</strong> type: TruckBedType
	 * </ul>
	 * @author  Mustafa Fatih Can 280201007
	 * @author  Deniz Kaya 280201033
	 * @author  Hakan Uskan 280201076
	 * @author  Burak Erinç 290201099
	 */

public class PickupTruckVehicle extends Vehicle {
	private enum CabType {
		REGULAR, EXTENDED, CREW
	}

	private enum TruckBedType {
		REGULAR, TANKER, TRAILER
	}

	private CabType cabType;
	private TruckBedType truckBedType;
	
	/**
	 * <strong>No Argument Constructor</strong><p>
	 */
	
	public PickupTruckVehicle() {
		this(null);
	}
	
	/**
	 * <strong>Copy Constructor</strong><p>
	 * Constructs a new PickupTruckVehicle Object with another PickupTruckVehicle Object
	 * @param _vehicle
	 */
	
	public PickupTruckVehicle(PickupTruckVehicle _vehicle) {
		super(_vehicle);
		this.setCabType(_vehicle.getCabType());
		this.setTruckBedType(_vehicle.getTruckBedType());
	}
	
	/**
	 * <strong>Parameterized Constructor</strong><p>
	 * Constructs PickupTruckVehicle Object with required data.
	 * @param _vehicleId
	 * @param _monthOfSale
	 * @param _cityOfSale
	 * @param _productionYear
	 * @param _valueAddedTax
	 * @param _cabType
	 * @param _truckBedType
	 */
	
	public PickupTruckVehicle(String _vehicleId, String _monthOfSale, String _cityOfSale, int _productionYear,
			int _valueAddedTax, String _cabType, String _truckBedType) {
		super(_vehicleId, _monthOfSale, _cityOfSale, _productionYear, _valueAddedTax);
		this.setCabType(_cabType);
		this.setTruckBedType(_truckBedType);
	}

	public int getBASE_PRICE() {
		return 250000;
	}

	/**
	 * Gets the PickupTruck Object's <b>CabType</b> variable as considering privacy
	 * leak.
	 * 
	 * @return the cabType
	 */
	public String getCabType() {
		return cabType.toString();
	}

	/**
	 * Sets the PickupTruck Object's <b>CabType</b> variable after input validation.
	 * 
	 * @param cabType the cabType to set
	 */
	public void setCabType(String _cabType) {
		_cabType = _cabType.toUpperCase(Locale.ROOT);
		this.cabType = CabType.valueOf(_cabType);
	}

	/**
	 * Gets the PickupTruck Object's <b>TruckBedType</b> variable as considering
	 * privacy leak.
	 * 
	 * @return the truckBedType
	 */
	public String getTruckBedType() {
		return truckBedType.toString();
	}

	/**
	 * Sets the PickupTruck Object's <b>TruckBedType</b> variable after input
	 * validation.
	 * 
	 * @param truckBedType the truckBedType to set
	 */
	public void setTruckBedType(String _truckBedType) {
		_truckBedType = _truckBedType.toUpperCase(Locale.ROOT);
		this.truckBedType = TruckBedType.valueOf(_truckBedType);
	}

	public double calculateSCT() {
		double cabTypeSCTValue = getCabTypeSCTValue();
		double truckBedTypeValue = getTruckBedTypeSCTValue();

		if (cabTypeSCTValue == -1.0 || truckBedTypeValue == -1.0) { // check for error values
			System.out.println("Error calculating SCT value of Pickup Truck(Bad input)");
			System.exit(0);
		}

		return ((truckBedTypeValue * getProductionYearSCTValue()) / cabTypeSCTValue);
	}

   /**
    * Gets the Pickup Truck Object's total price value
    * 
    * @return double Total price of Pickup Truck.
	*/
	public double calculateTotalPrice() {
		return this.BASE_PRICE * (1.0 + calculateSCT() * 0.6) + (1.0 + getValueAddedTax() / 100.0);
	}

	@Override
	public String toString() {
		return "Vehicle: Pickup Truck " + super.toString();
	}
	
	@Override
	public boolean equals(Object _object) {
		if (super.equals(_object)) {
			PickupTruckVehicle pickupTruckVehicle = (PickupTruckVehicle) _object;
			return this.getCabType().equals(pickupTruckVehicle.getCabType())
					&& this.getTruckBedType().equals(pickupTruckVehicle.getTruckBedType());
		}
		return false;
	}

   /**
	* Gets the Pickup Truck Object's SCT value based on cab type.
	* 
	* @return double SCT value of Pickup Truck's cab type. 
	*/
	private double getCabTypeSCTValue() {
		double cabTypeValue;

		switch (this.cabType) {
		case REGULAR:
			cabTypeValue = 2.5;
			break;
		case EXTENDED:
			cabTypeValue = 2.8;
			break;
		case CREW:
			cabTypeValue = 3.0;
			break;
		default:
			cabTypeValue = -1.0;// Error value
			break;
		}

		return cabTypeValue;
	}
	
   /**
	* Gets the Pickup Truck Object's SCT value based on bed type.
	* 
	* @return double SCT value of Pickup Truck's bed type. 
	*/
	private double getTruckBedTypeSCTValue() {
		double truckBedTypeValue;

		switch (this.truckBedType) {
		case REGULAR:
			truckBedTypeValue = 0.5;
			break;
		case TANKER:
			truckBedTypeValue = 0.8;
			break;
		case TRAILER:
			truckBedTypeValue = 1.0;
			break;
		default:
			truckBedTypeValue = -1.0;// Error value
			break;
		}

		return truckBedTypeValue;
	}

}
