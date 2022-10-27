package dropshipping.interfaces;

/*
 *
 *	An interface that describes the operations of Customer objects.
 *
*/

public interface CustomerInterface {

	/*
	 * Gets the customer's id String.
	 * @return The string of customer's id.
	 */
	public String getCustomerId();
	
	/*
	 * Sets the customer's id with the input.
	 * @param The string to set new customer id.
	 */
	public void setId(String input);
	
	/*
	 * Gets the customer's name.
	 * @return The string of customer's name.
	 */
	public String getName();
	
	/*
	 * Sets the customer's name with the input.
	 * @param The string of customer's name.
	 */
	public void setName(String input);
  
  	/*
	 * Gets the customer's Email.
	 * @return The string of customer's Email.
	 */
  	public String getEmail();
  	
  	/*
	 * Sets the customer's Email with the input.
	 * @param The string of customer's Email.
	 */
  	public void setEmail(String input);
	
	/*
	 * Gets the customer's address.
	 * @return The string of customer's address.
	 */
	public String getAddress();
	
	/*
	 * Sets the customer's address with the input.
	 * @param The string of customer's address.
	 */
	public void setAddress(String address);
	
	/*
	 * Gets the customer's country.
	 * @return The string of customer's country.
	 */
	public String getCountry();
	
	/*
	 * Sets the customer's country with the input.
	 * @param The string of customer's country.
	 */
	public void setCountry(String input);
}