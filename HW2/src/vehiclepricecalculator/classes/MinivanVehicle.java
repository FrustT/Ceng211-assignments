package vehiclepricecalculator.classes;

import java.time.LocalDate;

public class MinivanVehicle extends Automobile{
	private enum NumberOfSeats {FOUR, FIVE, SIX, SEVEN}
	
	private NumberOfSeats numberOfSeats;
	private double engineVolume;
	
	public MinivanVehicle()
	{
		this(null);
	}
	
	public MinivanVehicle(Vehicle _vehicle) {
		super(_vehicle);
	}
	
	public MinivanVehicle(String _vehicleId, LocalDate _monthOfSale, String _cityOfSale, LocalDate _productionYear, int _valueAddedTax, NumberOfSeats _numberOfSeats, double _engineVolume) {
		super(_vehicleId, _monthOfSale, _cityOfSale, _productionYear, _valueAddedTax);
		this.numberOfSeats = _numberOfSeats;
		this.engineVolume= _engineVolume;
	}

	/**
	 * Gets the Minivan Object's <b>numberOfSeats</b> number of seats of minivan with type of NumberOfSeats.
	 * @return the numberOfSeats.
	 */
	public NumberOfSeats getNumberOfSeats() {
		return numberOfSeats;
	}

	/**
	 * Sets the Minivan Object's <b>numberOfSeats</b>  variable after input validation.
	 * @param numberOfSeats the numberOfSeats set.
	 */
	public void setNumberOfSeats(NumberOfSeats _numberOfSeats) {
		this.numberOfSeats = _numberOfSeats;
	}

	/**
	 * Gets the Minivan Object's <b>engineVolume</b> variable as considering privacy leak.
	 * @return The integer value of Minivan's engine volume.
	 */
	public double getEngineVolume() {
		return engineVolume;
	}

	/**
	 * Sets the Minivan Object's <b>engineVolume</b> variable after input validation.
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
	public String toString() {//TODO
		return "";
	}
	public boolean equals() {//TODO
		return false;
	}
}
