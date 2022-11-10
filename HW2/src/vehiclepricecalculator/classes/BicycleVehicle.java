package vehiclepricecalculator.classes;

import java.time.LocalDate;

public class BicycleVehicle extends Vehicle{
	private enum ChainType {DERAILLEUR, ONECHAIN, DOUBLECHAIN}
	private enum SeatPost {CARBONFIBER, STEEL, ALUMINUM, TITANIUM}
	
	private ChainType chainType;
	private SeatPost seatPost;
	
	public BicycleVehicle() {
		this(null);
	}
	
	public BicycleVehicle(Vehicle _vehicle) {
		super(_vehicle);
	}
	
	public BicycleVehicle(String _vehicleId, LocalDate _monthOfSale, String _cityOfSale, LocalDate _productionYear, int _valueAddedTax, ChainType _chainType, SeatPost _seatPost) {
		super(_vehicleId, _monthOfSale, _cityOfSale, _productionYear, _valueAddedTax);
		this.setChainType(_chainType);
		this.setSeatPost(_seatPost);
	}

	/**
	 * Gets the Bicycle Object's <b>chainType</b> variable as considering privacy leak.
	 * @return the chainType
	 */
	public ChainType getChainType() {
		return chainType;
	}

	/**
	 * Sets the Bicycle Object's <b>chainType</b>  variable after input validation.
	 * @param chainType the chainType to set
	 */
	public void setChainType(ChainType _chainType) {
		this.chainType = _chainType;
	}

	/**
	 * Gets the Bicycle Object's <b>seatPost</b> variable as considering privacy leak.
	 * @return the seatPost
	 */
	public SeatPost getSeatPost() {
		return seatPost;
	}

	/**
	 * Sets the Bicycle Object's <b>seatPost</b>  variable after input validation.
	 * @param seatPost the seatPost to set
	 */
	public void setSeatPost(SeatPost _seatPost) {
		this.seatPost = _seatPost;
	}
	public String toString() {//TODO
		return "";
	}
	public boolean equals() {//TODO
		return false;
	}
	
}
