package vehiclepricecalculator.classes;

import java.util.Locale;

	/**
	 * This Class is a sub class of Vehicle and more spesified than vehicle.
	 * Has concrete implementations for abstract class in the superclasses.
	 * <ul>
	 * <li><strong>ChainType {DERAILLEUR, ONECHAIN, DOUBLECHAIN}</strong> type: enum
	 * <li><strong>SeatPost {CARBONFIBER, STEEL, ALUMINUM, TITANIUM}</strong> type: enum
	 * <li><strong>chainType</strong> type: ChainType
	 * <li><strong>seatPost</strong> type: SeatPost
	 * </ul>
	 * @author  Mustafa Fatih Can 280201007
	 * @author  Deniz Kaya 280201033
	 * @author  Hakan Uskan 280201076
	 * @author  Burak Erinç 290201099
	 */

public class BicycleVehicle extends Vehicle {

	private enum ChainType {
		DERAILLEUR, ONECHAIN, DOUBLECHAIN
	}

	private enum SeatPost {
		CARBONFIBER, STEEL, ALUMINUM, TITANIUM
	}

	private ChainType chainType;
	private SeatPost seatPost;

	/**
	 * <strong>No Argument Constructor</strong><p>
	 */
	public BicycleVehicle() {
		this(null);
	}

	/**
	 * <strong>Copy Constructor</strong><p>
	 * Constructs a new Vehicle Object with another Vehicle Object
	 * @param _vehicle
	 */
	public BicycleVehicle(BicycleVehicle _vehicle) {
		super(_vehicle);
		this.setChainType(_vehicle.getChainType());
		this.setSeatPost(_vehicle.getSeatPost());
	}

	/**
	 * <strong>Parameterized Constructor</strong><p>
	 * Constructs Vehicle Object with required data.
	 * @param _vehicleId
	 * @param _monthOfSale
	 * @param _cityOfSale
	 * @param _productionYear
	 * @param _valueAddedTax
	 * @param _chainType
	 * @param _seatPost
	 */
	public BicycleVehicle(String _vehicleId, String _monthOfSale, String _cityOfSale, int _productionYear,
			int _valueAddedTax, String _chainType, String _seatPost) {
		super(_vehicleId, _monthOfSale, _cityOfSale, _productionYear, _valueAddedTax);
		this.setChainType(_chainType);
		this.setSeatPost(_seatPost);
	}

	public int getBASE_PRICE() {
		return 10000;
	}

	/**
	 * Gets the Bicycle Object's <b>chainType</b> variable as considering privacy
	 * leak.
	 * 
	 * @return the chainType
	 */
	public String getChainType() {
		return chainType.toString();
	}

	/**
	 * Sets the Bicycle Object's <b>chainType</b> variable after input validation.
	 * 
	 * @param chainType the chainType to set
	 */
	public void setChainType(String _chainType) {
		_chainType = _chainType.toUpperCase(Locale.ROOT);
		this.chainType = ChainType.valueOf(_chainType);
	}

	/**
	 * Gets the Bicycle Object's <b>seatPost</b> variable as considering privacy
	 * leak.
	 * 
	 * @return String the seatPost
	 */
	public String getSeatPost() {
		return seatPost.toString();
	}

	/**
	 * Sets the Bicycle Object's <b>seatPost</b> variable after input validation.
	 * 
	 * @param seatPost the seatPost to set
	 */
	public void setSeatPost(String _seatPost) {
		_seatPost = _seatPost.toUpperCase(Locale.ROOT);
		this.seatPost = SeatPost.valueOf(_seatPost);
	}

   /**
	* Gets the Bicycle Object's SCT value based on bicycle's chain type and seat post.
	*
	* @return double SCT value of bicycle. 
	*/
	public double calculateSCT() {
		double chainSCTValue = getChainSCTValue();
		double seatPostValue = getSeatPostSCTValue();
		if (chainSCTValue == -1.0 || seatPostValue == -1.0) { // check for error values
			System.out.println("Error calculating SCT value of bicycle");
			System.exit(0);
		}
		return (chainSCTValue * seatPostValue * 0.1) + getMonthOfSaleSCTValue();
	}

   /**
    * Gets the Bicycle Object's total price value
    * 
    * @return double Total price of bicycle.
	*/
	public double calculateTotalPrice() {
		return (this.BASE_PRICE * 0.9) * (1.0 + calculateSCT()) + (1.0 + getValueAddedTax() / 100.0);
	}

	@Override
	public String toString() {
		return "Vehicle: Bicycle " + super.toString();
	}

	@Override
	public boolean equals(Object _object) {
		if (super.equals(_object)) {
			BicycleVehicle bicycle = (BicycleVehicle) _object;
			return this.getChainType().equals(bicycle.getChainType())
					&& this.getSeatPost().equals(bicycle.getSeatPost());
		}
		return false;
	}

   /**
	* Gets the Bicycle Object's SCT value based on chain type.
	* 
	* @return double SCT value of bicycle's chain type. 
	*/
	private double getChainSCTValue() {
		double chainValue;
		switch (this.chainType) {
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
			chainValue = -1.0;// Error value
		}
		return chainValue;
	}

   /**
	* Gets the Bicycle Object's SCT value based on seat post.
	* 
	* @return double SCT value of bicycle's seat post. 
	*/
	private double getSeatPostSCTValue() {
		double seatPostSCTValue;
		switch (this.seatPost) {
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
			seatPostSCTValue = -1.0;// Error value
			break;
		}
		return seatPostSCTValue;
	}
}
