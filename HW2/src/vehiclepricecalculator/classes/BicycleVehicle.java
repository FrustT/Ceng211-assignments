package vehiclepricecalculator.classes;

import java.util.Locale;

public class BicycleVehicle extends Vehicle{
	public final int BASEPRICE = 10000;
	
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
	
	public BicycleVehicle(String _vehicleId, String _monthOfSale, String _cityOfSale, int _productionYear, int _valueAddedTax, String _chainType, String _seatPost) {
		super(_vehicleId, _monthOfSale, _cityOfSale, _productionYear, _valueAddedTax);
		this.setChainType(_chainType);
		this.setSeatPost(_seatPost);
	}

	/**
	 * Gets the Bicycle Object's <b>chainType</b> variable as considering privacy leak.
	 * @return the chainType
	 */
	public String getChainType() {
		return chainType.toString();
	}

	/**
	 * Sets the Bicycle Object's <b>chainType</b>  variable after input validation.
	 * @param chainType the chainType to set
	 */
	public void setChainType(String _chainType) {
		_chainType = _chainType.toUpperCase(Locale.ROOT);
		this.chainType = ChainType.valueOf(_chainType);
	}

	/**
	 * Gets the Bicycle Object's <b>seatPost</b> variable as considering privacy leak.
	 * @return the seatPost
	 */
	public String getSeatPost() {
		return seatPost.toString();
	}

	/**
	 * Sets the Bicycle Object's <b>seatPost</b>  variable after input validation.
	 * @param seatPost the seatPost to set
	 */
	public void setSeatPost(String _seatPost) {
		_seatPost = _seatPost.toUpperCase(Locale.ROOT);
		this.seatPost = SeatPost.valueOf(_seatPost);
	}
	public double calculateSCT() {
		double chainSCTValue = getChainSCTValue();
		double seatPostValue = getSeatPostSCTValue();
		if(chainSCTValue == -1.0 || seatPostValue == -1.0) { //check for error values 
			System.out.println("Error calculating SCT value of bicycle");
			System.exit(0);
		}
		return (chainSCTValue*seatPostValue*0.1) + getMonthOfSaleSCTValue();
	}
	
	public double calculateTotalPrice() {
		return (this.BASEPRICE * 0.9) * (1.0+calculateSCT()) + (1.0+getValueAddedTax()/100.0);
	}
	
	public String toString() {
		return "Vehicle: Bicycle " + super.toString();
	}
	
	public boolean equals(Object _object) {
		if(super.equals(_object)) {
			BicycleVehicle bicycle = (BicycleVehicle) _object;
			return this.getChainType().equals(bicycle.getChainType()) &&
				   this.getSeatPost().equals(bicycle.getSeatPost());
		}
		return false;
	}
	
	private double getChainSCTValue() {
		double chainValue;
		switch(this.chainType) {
			case DERAILLEUR:
				chainValue = 1.1;
				break;
			case ONECHAIN:
				chainValue = 1.2;
				break;
			case DOUBLECHAIN:
				chainValue = 1.3;
				break;
			default:
				chainValue = -1.0;//Error value
		}
		return chainValue;
	}
	
	private double getSeatPostSCTValue() {
		double seatPostSCTValue;
		switch(this.seatPost) {
		case ALUMINUM:
			seatPostSCTValue = 0.9;
			break;
		case CARBONFIBER:
			seatPostSCTValue = 0.8;
			break;
		case STEEL:
			seatPostSCTValue = 0.7;
			break;
		case TITANIUM:
			seatPostSCTValue = 0.6;
			break;
		default:
			seatPostSCTValue = -1.0;//Error value
			break;
		}
		return seatPostSCTValue;
	}
}
