package marketshipment.interfaces;

import marketshipment.classes.ItemCode;

/**
 * Item Interface defines which methods a Item object should have. And ensures
 * all Item Objects are also a Serial Object.
 * 
 * @author Mustafa Fatih Can 280201007
 * @author Deniz Kaya 280201033
 * @author Hakan Uskan 280201076
 * @author Burak Erinç 290201099
 */
public interface Item extends Serial {

	/**
	 * Gets the cost of the Item.
	 *
	 * @return type: double
	 */
	public double getCost();

	/**
	 * Gets the price of the Item.
	 *
	 * @return type: double
	 */
	public double getPrice();

	/**
	 * Gets the revenue of the Item.
	 *
	 * @return type: double
	 */
	public double getRevenue();

	/**
	 * Gets the volume of the Item.
	 *
	 * @return type: double
	 */
	public double getVolume();

	/**
	 * Gets the Serial number of the Item.
	 *
	 * @return type: String
	 */
	public String getSerialNumber();

	/**
	 * Gets the DataHolder Enum ItemCode of the Item.
	 *
	 * @return type: ItemCode
	 */
	public ItemCode getItemCode();

	/**
	 * Returns true if Item is loaded otherwise returns false.
	 *
	 * @return type: boolean
	 */
	public boolean isLoaded();

	/**
	 * Loads the Item and makes it unable to add to another Box.
	 */
	public void load();
}
