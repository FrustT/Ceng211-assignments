package dropshipping.interfaces;

import java.time.LocalDate;
import dropshipping.classes.Customer;
import dropshipping.classes.Product;

public interface SalesInterface {

	/*
	 * Gets the sale's id String.
	 * @return The string of sale's id.
	 */
	public String getSalesId();
	
	/*
	 * Sets the sale's id with the input.
	 * @param The string to set new sales id.
	 */
	public void setSalesId(String input);
	
	/*
	 * Gets the customers name.
	 * @return The string of costumers name.
	 */
	public Customer getCustomer();
	
	/*
	 * Sets the sale's customer name with the input.
	 * @param The string of customer's name.
	 */
	public void setCustomer(Customer input);
  
  	/*
	 * Gets the Product.
	 * @return The string of Product.
	 */
  	public Product getProduct();
  	
  	/*
	 * Sets the Product.
	 * @param The string of Product..
	 */
  	public void setProduct(Product input);
	
	/*
	 * Gets the Sales date.
	 * @return Date .
	 */
	public LocalDate getDate();
	
	/*
	 * Sets the the Sales date.
	 * @param Date.
	 */
	public void setDate(LocalDate input);
	
	/*
	 * Gets the Sales price.
	 * @return the float of the price.
	 */
	public float getPrice();
	
	/*
	 * Sets the Sales price.
	 * @param the float of the price.
	 */
	public void setPrice(float input);
	 
	
	}
