package dropshipping.interfaces;

/*
*
*	An interface that describes the operations of product objects.
*
*/

public interface ProductInterface {

	/*
	 * Gets the product's id
	 * @return	id.
	 */
	public String getId();
	/*
	 * Sets the product's id with the input.
	 * @param string The string to set new product id.
	 */
	public void setId(String input);
	/*
	 * Gets the product's title
	 * @return string Title of product
	 */
	public String getTitle();
	/*
	 * Sets the product's title with the input.
	 * @param string The string to set new product's title.
	 */
	public  void setTitle(String input);
	/*
	 * Sets the product's rate with the input
	 * @param float The float to set as products rate.
	 */
	public void setRate(float input);
	/*
	 * Gets the product's rate
	 * @return	float rate of product
	 */
	public float getRate();
	/*
	 * Gets the product's number of reviews
	 * @return	The integer number of reviews of the product
	 */
	public int getNumberOfReviews();
	/*
	 * Sets the product's number of reviews
	 * @param int The integer to set as new number of reviews
	 */
	public void setNumberOfReviews(int input);
	/*
	 * Gets the product's price
	 * @return float products price
	 */
	public float getPrice();
	/*
	 * Sets the product's price with the input.
	 * @param The float of product's price.
	 */
	public void setPrice(float input);
	
}
