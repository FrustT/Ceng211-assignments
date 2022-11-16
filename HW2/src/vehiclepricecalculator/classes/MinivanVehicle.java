package vehiclepricecalculator.classes;

	/**
	 * This Class is a sub class of Automobile and it is more spesified than Automobile.
	 * Has concrete implementations for abstract methods in the superclasses.
	 * <ul>
	 * <li><strong>NumberOfSeats {FOUR, FIVE, SIX, SEVEN}</strong> type: enum
	 * <li><strong>numberOfSeats</strong> type: NumberOfSeats
	 * </ul>
	 * @author  Mustafa Fatih Can 280201007
	 * @author  Deniz Kaya 280201033
	 * @author  Hakan Uskan 280201076
	 * @author  Burak Erinç 290201099
	 */
public class MinivanVehicle extends Automobile{
	private enum NumberOfSeats {FOUR, FIVE, SIX, SEVEN}
	
	private NumberOfSeats numberOfSeats;
	
	/**
	 * <strong>No Argument Constructor</strong><p>
	 */
	public MinivanVehicle()
	{
		this(null);
	}
	
	/**
	 * <strong>Copy Constructor</strong><p>
	 * Constructs a new MinivanVehicle Object with another MinivanVehicle Object
	 * @param _vehicle
	 */
	
	public MinivanVehicle(MinivanVehicle _vehicle) {
		super(_vehicle);
		this.setNumberOfSeats(_vehicle.getNumberOfSeats());
	}
	
	/**
	 * <strong>Parameterized Constructor</strong><p>
	 * Constructs MinivanVehicle Object with required data.
	 * @param _vehicleId
	 * @param _monthOfSale
	 * @param _cityOfSale
	 * @param _productionYear
	 * @param _valueAddedTax
	 * @param _numberOfSeats
	 * @param _engineVolume
	 */
	
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
	
       /**
	* Gets the SCT value of minivan vehicle.
	* @return double value of SCT
	*/
	public double calculateSCT() {
		return (0.6 * getProductionYearSCTValue())/(getEngineVolume() + getNumberOfSeatsSCTValue());
	}
	
	@Override
	public String toString() {
		return "Vehicle: Minivan " + super.toString();
	}
	
	@Override
	public boolean equals(Object _object) {
		if(super.equals(_object)) {
			MinivanVehicle minivanVehicle = (MinivanVehicle) _object;
			return this.getNumberOfSeats() == minivanVehicle.getNumberOfSeats();
		}
		return false;
	}
	
       /**
	* Gets the SCT value of minivan based on its number of seats. 
	* @return double value of SCT.
	*/
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
