package dropshipping.interfaces;


	/** An interface that describes the operations of Customer class.*/
public interface CustomerInterface {

	/**
	 * Gets the customer's id String.
	 * @return The string of customer's id.
	 */
	public String getCustomerId();
	
	/**
	 * Sets the customer's id with the input.
	 * @param The string to set new customer id.
	 */
	public void setCustomerId(String input);
	
	/**
	 * Gets the customer's name.
	 * @return The string of customer's name.
	 */
	public String getCustomerName();
	
	/**
	 * Sets the customer's name with the input.
	 * @param The string of customer's name.
	 */
	public void setCustomerName(String input);
  
  	/**
	 * Gets the customer's Email.
	 * @return The string of customer's Email.
	 */
  	public String getCustomerEmail();
  	
  	/**
	 * Sets the customer's Email with the input.
	 * @param The string of customer's Email.
	 */
  	public void setCustomerEmail(String input);
	
	/**
	 * Gets the customer's address.
	 * @return The string of customer's address.
	 */
	public String getCustomerAddress();
	
	/**
	 * Sets the customer's address with the input.
	 * @param The string of customer's address.
	 */
	public void SetCustomerAddress(String input);
	
	/**
	 * Gets the customer's country.
	 * @return The string of customer's country.
	 */
	public String getCustomerCountry();
	
	/**
	 * Sets the customer's country with the input.
	 * @param The string of customer's country.
	 */
	public void setCustomerCountry(String input);
	
	/**
	 * Compares the specific customers' String id's.
	 * @return The Boolean True if the customers id's are equal, false if not.
	 */
	public boolean customerCompareId(String input);
}