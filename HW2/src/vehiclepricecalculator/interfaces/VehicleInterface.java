package vehiclepricecalculator.interfaces;

import java.time.LocalDate;
/**
 * An interface for our Base class(Superclass) Vehicle which is ancestor of all of our Vehicle Classes   
 * @author burak
 *
 */
public interface VehicleInterface {
	
	
	/**
	 * Sets Vehicle Object's id with given input string after checking for validity.
	 * @param String _ID
	 */
	public void setVehicleID(String _ID);
	/**
	 * Gets Vehicle Object's id as considering privacy leak which in string's case, its immutable.
	 * @return String ID
	 */
	public String getVehicleID();
	/**
	 * Sets Vehicle Object's City of sale variable with given input string after checking for validity.
	 * @param String _cityOfSale
	 */
	public void setCityOfSale(String _cityOfSale);
	/**
	 * Gets Vehicle Object's City of sale variable as considering privacy leak which in string's case, its immutable.
	 * @return String City of sale
	 */
	public String getCityOfSale();
	/**
	 * Sets Vehicle Object's <b>month of sale></b> variable with given LocalDate Object after checking for validity.
	 * @param LocalDate _monthOfSale
	 */
	public void setMonthOfSale(LocalDate _monthOfSale);
	/**
	 * Gets Vehicle Object's <b>month of sale></b> variable as considering privacy leak.
	 * @return LocalDate month of sale
	 */
	public LocalDate getMonthOfSale();
	/**
	 * Sets Vehicle Object's <b>ProductionYear</b> variable with given LocalDate Object after checking for validity.
	 * @param LocalDate _year
	 */
	public void setProductionYearOfVehicle(LocalDate _year);
	/**
	 * Gets Vehicle Object's <b>ProductionYear</b> variable as considering privacy leak.
	 * @return LocalDate Production year of vehicle
	 */
	public LocalDate getProductionYearOfVehicle();

	
}
