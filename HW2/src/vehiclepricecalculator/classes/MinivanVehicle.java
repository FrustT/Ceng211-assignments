package vehiclepricecalculator.classes;

import java.time.LocalDate;

public class MinivanVehicle extends Automobile{
	private enum NumberOfSeats {FOUR, FIVE, SIX, SEVEN}
	
	private NumberOfSeats numberOfSeats;
	
	public MinivanVehicle()
	{
		this(null);
	}
	
	public MinivanVehicle(MinivanVehicle _vehicle) {
		super(_vehicle);
	}
	
	public MinivanVehicle(String _vehicleId, String _monthOfSale, String _cityOfSale, int _productionYear, int _valueAddedTax, int _numberOfSeats, double _engineVolume) {
		super(_vehicleId, _monthOfSale, _cityOfSale, _productionYear, _valueAddedTax, _engineVolume);
		setNumberOfSeats(_numberOfSeats);
	}

	/**
	 * Gets the Minivan Object's <b>numberOfSeats</b> number of seats of minivan with type of NumberOfSeats.
	 * @return the numberOfSeats.
	 */
	public int getNumberOfSeats() {
		switch(this.numberOfSeats) {
		case FIVE:
			return 5;
		case FOUR:
			return 4;
		case SEVEN:
			return 7;
		case SIX:
			return 6;
		default:
			System.out.println("Error while parsing enum to int in number of seats");
			System.exit(0);
		}
		return 0;
	}

	/**
	 * Sets the Minivan Object's <b>numberOfSeats</b>  variable after input validation.
	 * @param numberOfSeats the numberOfSeats set.
	 */
	public void setNumberOfSeats(int _numberOfSeats) {
		switch(_numberOfSeats) {
		case 4:
			this.numberOfSeats = NumberOfSeats.FOUR;
			break;
		case 5:
			this.numberOfSeats = NumberOfSeats.FIVE;
			break;
		case 6:
			this.numberOfSeats = NumberOfSeats.SIX;
			break;
		case 7:
			this.numberOfSeats = NumberOfSeats.SEVEN;
			break;
		default:
			System.out.println("Error while parsing int to enum in MinivanVehicle.setNumberOfSeats");
			System.exit(0);
		}
	}
	
	public double calculateSCT() {
		return (0.6 * getProductionYearSCTValue())/(getEngineVolume() + getNumberOfSeatsSCTValue());
	}
	
	public String toString() {
		return "Vehicle: Minivan " + super.toString();
	}
	
	public boolean equals(Object _object) {
		if(super.equals(_object)) {
			MinivanVehicle minivanVehicle = (MinivanVehicle) _object;
			return this.getNumberOfSeats() == minivanVehicle.getNumberOfSeats();
		}
		return false;
	}
	
	private double getNumberOfSeatsSCTValue() {
		switch(this.numberOfSeats) {
		case FIVE:
			return 0.4;
		case FOUR:
			return 0.1;
		case SEVEN:
			return 0.8;
		case SIX:
			return 0.6;
		default:
			System.out.println("Error finding the SCT Value according to number of seats");
			System.exit(0);
		}
		return -1.0;
	}
}
