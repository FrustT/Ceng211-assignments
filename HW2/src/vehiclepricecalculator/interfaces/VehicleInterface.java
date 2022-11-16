package vehiclepricecalculator.interfaces;

/**
 * An interface for our Base class(Superclass) Vehicle which is ancestor of all of our Vehicle Classes   
 * @author  Mustafa Fatih Can 280201007
 * @author  Deniz Kaya 280201033
 * @author  Hakan Uskan 280201076
 * @author  Burak Erinc 290201099
 */
public interface VehicleInterface {
	
	/**
	 * Sets Vehicle Object's id with given input string after checking for validity.
	 * @param _ID
	 */
	public void setVehicleID(String _ID);
	
	/**
	 * Gets Vehicle Object's id as considering privacy leak which in string's case, its immutable.
	 * @return String ID
	 */
	public String getVehicleID();
	
	/**
	 * Sets Vehicle Object's City of sale variable with given input string after checking for validity.
	 * @param _cityOfSale
	 */
	public void setCityOfSale(String _cityOfSale);
	
	/**
	 * Gets Vehicle Object's City of sale variable as considering privacy leak which in string's case, its immutable.
	 * @return String City of sale
	 */
	public String getCityOfSale();
	
	/**
	 * Sets Vehicle Object's <b>month of sale></b> variable with given String after checking for validity.
	 * @param _monthOfSale
	 */
	public void setMonthOfSale(String _monthOfSale);
	
	/**
	 * Gets Vehicle Object's <b>month of sale></b> variable as considering privacy leak.
	 * @return String month of sale
	 */
	public String getMonthOfSale();
	
	/**
	 * Sets Vehicle Object's <b>ProductionYear</b> variable with given integer after checking for validity.
	 * @param _year
	 */
	public void setProductionYearOfVehicle(int _year);
	
	/**
	 * Gets Vehicle Object's <b>ProductionYear</b> variable as considering privacy leak.
	 * @return int Production year of vehicle
	 */
	public int getProductionYearOfVehicle();
	
	/**
	 * Gets Vehicle's <b>Value added tax</b> variable.
	 * @return int Value added tax of vehicle
	 */
	public int getValueAddedTax();
	
	/**
	 * Sets Vehicle's <b>Value added tax</b> variable.
	 * @param int _valueAddedTax
	 */
	public void setValueAddedTax(int _valueAddedTax);
	
	/**
	 * Calculates Vehicle's <b>SCT</b> value.
	 * @return SCT of vehicle as double.
	 */
	public double calculateSCT();
	
	/**
	 * Calculates Vehicle's <b>Total price</b> value.
	 * @return Total price of vehicle as double.
	 */
	public double calculateTotalPrice();
}
