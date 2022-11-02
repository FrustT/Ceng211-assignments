package dropshipping.interfaces;

import java.time.LocalDate;
import dropshipping.classes.Customer;
import dropshipping.classes.Product;
	
	/** An interface that describes the operations of Sales class.*/
public interface SalesInterface {

	/**
	 * Gets the sale's id String.
	 * @return The string of sale's id.
	 */
	public String getSalesId();
	
	/**
	 * Sets the sale's id with the input.
	 * @param The string to set new sales id.
	 */
	public void setSalesId(String input);
	
	/**
	 * Gets the customers name.
	 * @return The string of costumers name.
	 */
	public Customer getSalesCustomer();
	
	/**
	 * Sets the sale's customer name with the input.
	 * @param The string of customer's name.
	 */
	public void setSalesCustomer(Customer input);
  
  	/**
	 * Gets the Product.
	 * @return The string of Product.
	 */
  	public Product getSalesProduct();
  	
  	/**
	 * Sets the Product.
	 * @param The string of Product..
	 */
  	public void setSalesProduct(Product input);
	
	/**
	 * Gets the Sales date.
	 * @return Date .
	 */
	public LocalDate getSalesDate();
	
	/**
	 * Sets the the Sales date.
	 * @param Date.
	 */
	public void setSalesDate(LocalDate input);
	
	/**
	 * Gets the Sales price.
	 * @return the float of the price.
	 */
	public float getSalesPrice();
	
	/**
	 * Sets the Sales price.
	 * @param the float of the price.
	 */
	public void setSalesPrice(float input);
	 
	}
