package dropshipping.interfaces;

	/** An interface that describes the operations of Product class.*/
public interface ProductInterface {

	/**
	 * Gets the product's id
	 * @return	id.
	 */
	public String getProductId();
	
	/**
	 * Sets the product's id with the input.
	 * @param string The string to set new product id.
	 */
	public void setProductId(String input);
	
	/**
	 * Gets the product's title
	 * @return string Title of product
	 */
	public String getProductTitle();
	
	/**
	 * Sets the product's title with the input.
	 * @param string The string to set new product's title.
	 */
	public  void setProductTitle(String input);
	
	/**
	 * Sets the product's rate with the input
	 * @param float The float to set as products rate.
	 */
	public void setProductRate(float input);
	
	/**
	 * Gets the product's rate
	 * @return	float rate of product
	 */
	public float getProductRate();
	
	/**
	 * Gets the product's number of reviews
	 * @return	The integer number of reviews of the product
	 */
	public int getProductNumberOfReviews();
	
	/**
	 * Sets the product's number of reviews
	 * @param int The integer to set as new number of reviews
	 */
	public void setProductNumberOfReviews(int input);
	
	/**
	 * Gets the product's price
	 * @return float products price
	 */
	public float getProductPrice();
	
	/**
	 * Sets the product's price with the input.
	 * @param The float of product's price.
	 */
	public void setProductPrice(float input);
	
	/**
	 * Compares the specific products String ids.
	 * @return The Boolean True if the products ids are equal, false if not.
	 */
	public boolean compareProductId(String _id);
	
}
