package vehiclepricecalculator.classes;

/**
 * This class is a subclass of vehicle class and super class of sedan class, minivan class and hatchback class.
 * This class is not a concrete implementation and has more general description than sedan, minivan and hatchback about implementations.
 * We will spesify them later in creation of the classes
 * <ul>
 * <li><strong>engineVolume</strong> type: double
 * </ul>
 * @author  Mustafa Fatih Can 280201007
 * @author  Deniz Kaya 280201033
 * @author  Hakan Uskan 280201076
 * @author  Burak Erinç 290201099
 */
public abstract class Automobile extends Vehicle {
	private double engineVolume;

	/**
	 * <strong>No Argument Constructor</strong><p>
	 */
	public Automobile() {
		super();
		this.engineVolume = 0.0;
	}

	/**
	 * <strong>Parameterized Constructor</strong><p>
	 * Constructs Automobile Object with required data.
	 * @param _vehicleId
	 * @param _monthOfSale
	 * @param _cityOfSale
	 * @param _productionYear
	 * @param _valueAddedTax
	 * @param _engineVolume
	 */
	public Automobile(String _vehicleId, String _monthOfSale, String _cityOfSale, int _productionYear,
			int _valueAddedTax, double _engineVolume) {
		super(_vehicleId, _monthOfSale, _cityOfSale, _productionYear, _valueAddedTax);
		this.engineVolume = _engineVolume;
	}
	
	/**
	 * <strong>Copy Constructor</strong><p>
	 * Constructs a new Automobile Object with another Automobile Object
	 * @param _automobile
	 */
	public Automobile(Automobile _automobile) {
		super(_automobile);
		this.engineVolume = _automobile.engineVolume;
	}
	
	/**
	* Gets the base price of atutomobile type vehicles
	* @return int 200000
	*/
	public int getBASE_PRICE() {
		return 200000;
	}
	
	/**
	* Gets the engine volume of automobil.
	* @return double engine volume value
	*/
	public double getEngineVolume() {
		return this.engineVolume;
	}
	/**
	 * Sets the engine volume's value after validating input
	 * @param _engineVolume
	 */
	public void setEngineVolume(double _engineVolume) {
		if (_engineVolume < 1 || _engineVolume > 2) {
			System.out.println("Invalid engine volume");
			System.exit(0);
		}
		this.engineVolume = _engineVolume;
	}

	//This is just a decleration,Not a concrete implementation
	public abstract double calculateSCT();

	/**
	 * Gets the total price of automobile
	 * @return double value of total price of automobile.
	 */
	public double calculateTotalPrice() {
		return (BASE_PRICE) * (1.0 + calculateSCT() * 0.8) + (1.0 + getValueAddedTax() / 100.0);
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public boolean equals(Object _object) {
		if (super.equals(_object)) {
			Automobile automobile = (Automobile) _object;
			return this.getEngineVolume() == automobile.getEngineVolume();
		}
		return false;
	}
}
