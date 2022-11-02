package dropshipping.classes;

import dropshipping.interfaces.SalesManagementInterface;
	/**
	 * This Class holds all Supplier's Sales Objects as 2 dimentional array.
	 * First array is for seperating Suppliers, Second array is for seperating Each Suppliers Sales type objects
	 * <ul>
	 * <li><strong>SalesArr</strong> type : Sales[][]
	 * </ul>
	 * @author  Mustafa Fatih Can 280201007
	 * @author  Deniz Kaya 280201033
	 * @author  Hakan Uskan 280201076
	 * @author  Burak Erinç 290201099
	 */
public class SalesManagement implements SalesManagementInterface {
	private Sales[][] salesArr;
	
	/**
	 * <strong>Parameterized Constructor</strong><p>
	 * Constructs SalesManagement Object with Sales[] array.
	 * @param Sales[]
	 */
	public SalesManagement(Sales[]... args) {
		this.salesArr = new Sales[args.length][];
		for(int i = 0; i < args.length; i++){
			salesArr[i] = args[i];
		}
	}
	
	/**
	 * <strong>Copy Constructor</strong><p>
	 * Constructs a new SalesManagement Object with another SalesManagement Object
	 * @param Sales[]
	 */
	public SalesManagement(SalesManagement saleManager){
		this.salesArr = saleManager.getArray();
	}
	
	public Sales[][] getArray() {
		//This code copies the objects for preventing privacy leak
		Sales[][] result = new Sales[salesArr.length][];
		
		for(int a = 0; a < salesArr.length; a++){
			result[a] = new Sales[salesArr[a].length];
		}
		
		for(int i = 0; i < salesArr.length; i++){
			for(int j = 0; j < salesArr[i].length; j++){
				result[i][j] = new Sales(salesArr[i][j]);
			}
		}
		
		return result;
	}
	
	public int getNumberOfSales() {
		int sum = 0;
		for(Sales[] arr : salesArr) {
			sum += arr.length;
		}
		return sum;
	}

	public Sales[] getAllSalesAsOneDimArray() {
		//This code copies the objects for preventing privacy leak
		Sales[] result = new Sales[this.getNumberOfSales()];
		int index = 0;
		
		for(Sales[] arr: salesArr){
			for(Sales sale :arr){
				result[index++] = new Sales(sale);
			}
		}
		
		return result;
	}
	
}
