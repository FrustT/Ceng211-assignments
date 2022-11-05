package vehiclepricecalculator.classes;

import java.time.LocalDate;

public class PickupTruckVehicle extends Vehicle{
	private enum CabType {REGULAR, EXTENDED, CREW}
	private enum TruckBedType {REGULAR, TANKER, TRAILER}
	
	private CabType cabType;
	private TruckBedType truckBedType;

	public PickupTruckVehicle() {
		this(null);
	}
	
	public PickupTruckVehicle(Vehicle _vehicle) {
		super(_vehicle);
	}
	
	public PickupTruckVehicle(String _vehicleId, LocalDate _monthOfSale, String _cityOfSale, LocalDate _productionYear, int _valueAddedTax, CabType _cabType, TruckBedType _truckBedType) {
		super(_vehicleId, _monthOfSale, _cityOfSale, _productionYear, _valueAddedTax);
		this.setCabType(_cabType);
		this.setTruckBedType(_truckBedType);
	}

	/**
	 * Gets the PickupTruck Object's <b>CabType</b> variable as considering privacy leak.
	 * @return the cabType
	 */
	public CabType getCabType() {
		return cabType;
	}

	/**
	 * Sets the PickupTruck Object's <b>CabType</b>  variable after input validation.
	 * @param cabType the cabType to set
	 */
	public void setCabType(CabType _cabType) {
		this.cabType = _cabType;
	}

	/**
	 * Gets the PickupTruck Object's <b>TruckBedType</b> variable as considering privacy leak.
	 * @return the truckBedType
	 */
	public TruckBedType getTruckBedType() {
		return truckBedType;
	}

	/**
	 * Sets the PickupTruck Object's <b>TruckBedType</b>  variable after input validation.
	 * @param truckBedType the truckBedType to set
	 */
	public void setTruckBedType(TruckBedType _truckBedType) {
		this.truckBedType = _truckBedType;
	}
	
	
}
