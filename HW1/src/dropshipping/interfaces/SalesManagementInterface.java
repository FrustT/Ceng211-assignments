package dropshipping.interfaces;
import dropshipping.classes.*;

	/** An interface that describes the operations of SalesManagement class.*/
public interface SalesManagementInterface {
	
	/**
	 * Returns the two dimensional array of suppliers and their products. 
	 * @return two dimensional copy array of Sales.
	 */
	public Sales[][] getArray();

	/**
	 * Gets the current number of sales in this SalesManagement object.
	 * @return The integer number of sales currently in the SalesManagement object.
	 */
	public int getNumberOfSales();
	
	/**
	 * Gets the Array of all Sales as one dimensional Array.
	 * @return	The copy array of sales.
	 */
	public Sales[] getAllSalesAsOneDimArray();
	
	
}
