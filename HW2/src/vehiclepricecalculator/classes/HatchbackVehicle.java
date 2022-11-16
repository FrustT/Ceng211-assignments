package vehiclepricecalculator.classes;

	/**
	 * This Class is a sub class of Automobile and more spesified than vehicle.
	 * Has concrete implementations for abstract class in the superclasses.
	 * <ul>
	 * <li><strong>cityMode</strong> type: boolean
	 * </ul>
	 * @author  Mustafa Fatih Can 280201007
	 * @author  Deniz Kaya 280201033
	 * @author  Hakan Uskan 280201076
	 * @author  Burak Erinç 290201099
	 */

public class HatchbackVehicle extends Automobile{
	private boolean cityMode;
	
	/**
	 * <strong>No Argument Constructor</strong><p>
	 */
	 
	public HatchbackVehicle () {
		super();
		cityMode = false;
	}
	
	/**
	 * <strong>Copy Constructor</strong><p>
	 * Constructs a new HatchbackVehicle Object with another HatchbackVehicle Object
	 * @param _hatchbackVehicle
	 */
	
	public HatchbackVehicle (HatchbackVehicle _hatchbackVehicle) {
		super(_hatchbackVehicle);
		this.setCityMode(_hatchbackVehicle.getCityMode());
	}
	
	/**
	 * <strong>Parameterized Constructor</strong><p>
	 * Constructs HatchbackVehicle Object with required data.
	 * @param _vehicleId
	 * @param _monthOfSale
	 * @param _cityOfSale
	 * @param _productionYear
	 * @param _valueAddedTax
	 * @param _cityMode
	 * @param _engineVolume
	 */
	 
	public HatchbackVehicle(String _vehicleId, String _monthOfSale, String _cityOfSale, int _productionYear, int _valueAddedTax, boolean _cityMode, double _engineVolume) {
		super(_vehicleId, _monthOfSale, _cityOfSale, _productionYear, _valueAddedTax,_engineVolume);
		this.setCityMode(_cityMode);
	}
	
	/**
	 * Gets the Hatchback Object's <b>cityMode</b> variable as considering privacy leak.
	 * @return The boolean value of Hatchback's situation of having city mode or not.
	 */
	public boolean getCityMode() {
		return cityMode;
	}
	
	/**
	 * Sets the Hatchback Object's <b>cityMode</b> variable after input validation.
	 * @param The boolean city mode value which we want to set.
	 */
	public void setCityMode(boolean _cityMode) {
		this.cityMode = _cityMode;
	}

   /**
	* Gets the Hatchback Object's SCT valuebased on bicycle's city mode.
	*
	* @return double SCT value of Hatchback. 
	*/
	public double calculateSCT() {
		return this.getEngineVolume()*0.3*this.getProductionYearSCTValue() + getCityModeSCTValue();
	}
	
	@Override
	public String toString() {
		return "Vehicle: Hatchback " + super.toString();
	}
	
	@Override
	public boolean equals(Object _object) {
		if(super.equals(_object)) {
			HatchbackVehicle hatchbackVehicle = (HatchbackVehicle) _object;
			return this.getCityMode() == hatchbackVehicle.getCityMode();
		}
		return false;
	}
   
   /**
	* Gets the Hatchback Object's SCT value based on city mode.
	* 
	* @return double SCT value of Hatchback's city mode. 
	*/
	private double getCityModeSCTValue(){
		if (this.cityMode){
			return 0.15;
		}
		else {
			return 0.1;
		}
	}

}
