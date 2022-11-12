package vehiclepricecalculator.classes;

import java.util.Locale;


public class PickupTruckVehicle extends Vehicle{
	public final int BASEPRICE = 250000;
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
	
	public PickupTruckVehicle(String _vehicleId, String _monthOfSale, String _cityOfSale, int _productionYear, int _valueAddedTax, String _cabType, String _truckBedType) {
		super(_vehicleId, _monthOfSale, _cityOfSale, _productionYear, _valueAddedTax);
		this.setCabType(_cabType);
		this.setTruckBedType(_truckBedType);
	}

	/**
	 * Gets the PickupTruck Object's <b>CabType</b> variable as considering privacy leak.
	 * @return the cabType
	 */
	public String getCabType() {
		return cabType.toString();
	}

	/**
	 * Sets the PickupTruck Object's <b>CabType</b>  variable after input validation.
	 * @param cabType the cabType to set
	 */
	public void setCabType(String _cabType) {
		_cabType = _cabType.toUpperCase(Locale.ROOT);
		this.cabType = CabType.valueOf(_cabType);
	}

	/**
	 * Gets the PickupTruck Object's <b>TruckBedType</b> variable as considering privacy leak.
	 * @return the truckBedType
	 */
	public String getTruckBedType() {
		return truckBedType.toString();
	}

	/**
	 * Sets the PickupTruck Object's <b>TruckBedType</b>  variable after input validation.
	 * @param truckBedType the truckBedType to set
	 */
	public void setTruckBedType(String _truckBedType) {
		_truckBedType = _truckBedType.toUpperCase(Locale.ROOT);
		this.truckBedType = TruckBedType.valueOf(_truckBedType);
	}
	
	public double calculateSCT() {
		double cabTypeSCTValue = getCabTypeSCTValue();
		double truckBedTypeValue = getTruckBedTypeSCTValue();
		
		if(cabTypeSCTValue == -1.0 || truckBedTypeValue == -1.0) { //check for error values  
			System.out.println("Error calculating SCT value of Pickup Truck(Bad input)");
			System.exit(0);
		}
		
		return ((truckBedTypeValue*getProductionYearSCTValue()) / cabTypeSCTValue);
	}
	
	public double calculateTotalPrice() {
		return this.BASEPRICE*(1.0 + calculateSCT()*0.6) + (1.0 + getValueAddedTax()/100.0);
	}
	
	public String toString() {
		return "Vehicle: Pickup Truck " + super.toString();
	}
	
	public boolean equals(Object _object) {
		if(super.equals(_object)) {
			PickupTruckVehicle pickupTruckVehicle = (PickupTruckVehicle) _object;
			return this.getCabType().equals(pickupTruckVehicle.getCabType())&&
				   this.getTruckBedType().equals(pickupTruckVehicle.getTruckBedType());
		}
		return false;
	}
	
	private double getCabTypeSCTValue(){
		double cabTypeValue;
		
		switch(this.cabType){
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
				cabTypeValue = -1.0;//Error value
				break;
		}
		
		return cabTypeValue;
	}
	
	private double getTruckBedTypeSCTValue(){
		double truckBedTypeValue;
		
		switch(this.truckBedType){
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
				truckBedTypeValue = -1.0;//Error value
				break;
		}
		
		return truckBedTypeValue;
	}
	
}
