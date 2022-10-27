package dropshipping.interfaces;


public interface SalesManagementInterface<Sales> {

	/*
	 * Add an Sales Array to the SalesManagement
	 * @param Supplier The object to be added as a item.
	 * @return	True if the addition is successful, or false if not.
	 */
	public boolean add(Sales[] array);

	/*
	 * Gets the current number of entries in this SalesManagement.
	 * @return The integer number of entries currently in the SalesManagement.
	 */
	public int getNumberOfItems();
	
	/*
	 * Gets the Array of all Products.
	 * @return	The array of contents.
	 */
	public Sales[] getSuppliersAsArray();
	
	
}
