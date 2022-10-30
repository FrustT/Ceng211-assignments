package dropshipping.interfaces;
import dropshipping.classes.*;

public interface SalesManagementInterface {
	
	/*
	 * Returns the two dimensional array of suppliers and their products. 
	 * @return	The copy array of salesArr.
	 */
	public Sales[][] getArray();
	//TODO ADD METHOD CONTRACT THAT IS NOT DESCRIBED IN THIS INTERFACE
	/*
	 * Add an Sales Array to the SalesManagement
	 * @param Supplier The object to be added as a item.
	 * @return	True if the addition is successful, or false if not.
	 */
	//public boolean add(Sales[] array);

	/*
	 * Gets the current number of sales in this SalesManagement object.
	 * @return The integer number of sales currently in the SalesManagement object.
	 */
	public int getNumberOfSales();
	
	/*
	 * Gets the Array of all Sales as one dimansional.
	 * @return	The array of sales.
	 */
	public Sales[] getAllSalesAsOneDimArray();
	
	
}
