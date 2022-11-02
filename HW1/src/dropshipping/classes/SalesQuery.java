package dropshipping.classes;

	/**
	 * This class gets the required objects for questions in homework.
	 * <p>
	 * Methods in this class gets SalesManagement objects and returns the associated data to print.
	 * 
	 * <ul>
	 * <li>{@link #getMostProfitableSale(SalesManagement) getMostProfitableSale(Path)}
	 * <li>{@link #getMostExpensiveSales(SalesManagement) getMostExpensiveSales(Path)}
	 * <li>{@link #getCustomerWhoPurchasedMost(SalesManagement, Customer[]) getCustomerWhoPurchasedMost(Path)}
	 * <li>{@link #getTotalProfit(SalesManagement) getTotalProfit(Path)}
	 * <li>{@link #getLeastProfitSaleOfS1(SalesManagement) getLeastProfitSaleOfS1(Path)}
	 * </ul>
	 * @author  Mustafa Fatih Can 280201007
	 * @author  Deniz Kaya 280201033
	 * @author  Hakan Uskan 280201076
	 * @author  Burak Erinç 290201099
	 */
public class SalesQuery {
	
	
	/**
	 * Gets the SalesManagement object and returns the most profitable sale in all sales.
	 * @param _salesManagement Object that has all the sales as two dimensional array.
	 * @return Most profitable sale.
	 */
	public static Sales getMostProfitableSale (SalesManagement _salesManagement) {
		Sales[][] salesManagementArray = _salesManagement.getArray();
		//Sample variable to start comparing profits.
		Sales mostProfitableSale = salesManagementArray[0][0];
		//A for loop to traverse through two dimensional array of sales.
		for(Sales[] arr : salesManagementArray){
			for(Sales sale : arr){
				//Assigns the sample value to compared value if compared value's profit is higher.
				if(sale.getSaleProfit() > mostProfitableSale.getSaleProfit())mostProfitableSale = sale;
			}
		}
		return mostProfitableSale;
	}
	
	/**
	 * Gets the SalesManagement object and returns the most expensive sale in all sales.
	 * @param _salesManagement Object that has all the sales as two dimensional array.
	 * @return Most expensive sale.
	 */
	
	public static Sales getMostExpensiveSales (SalesManagement _salesManagement) {
		Sales[][] salesManagementArray = _salesManagement.getArray();
		//Sample variable to start comparing price.
		Sales mostExpensiveSale = salesManagementArray[0][0];
		//A for loop to traverse through two dimensional array of sales.
		for(Sales[] arr : salesManagementArray){
			for(Sales sale : arr){
				//Assigns the sample adress to compared adress if compared value's price is higher.
				if(sale.getSalesPrice() > mostExpensiveSale.getSalesPrice())mostExpensiveSale = sale;
			}
		}
		
		return mostExpensiveSale;
	}
	
	/**
	 * Gets the SalesManagement object and customer array as parameters and 
	 * returns integer array containing index of customer who purchased the most and how many times they purchased.
	 * <p>
	 * We used counter array as something like a dictionary here.
	 * Index of integers in counter array corresponds to the same index customer in customer array.
	 * @param _salesManagement Object that has all the sales as two dimensional array.
	 * @param _customerArray Array of customers that has all the customer data read from fileIO.
	 * @return Integer array containing index of customer who purchased the most and how many times they purchased.
	 */
	 
	public static int[] getCustomerWhoPurchasedMost (SalesManagement _salesManagement, Customer[] _customerArray) {
		//For every sale, gets all the repeating customer ids and adds them to array.
		String[] customerIdsOfTheSales = getCustomerIDOfAllPurchases(_salesManagement); 
		
		//Counter array same lenght with the customer array.
		int[] counter = new int[_customerArray.length];
		
		//For each customer in id array, we find the associated customer id in the customer array and increment its counter value in counter array.
		for(String str : customerIdsOfTheSales){
			for(int j = 0;j< counter.length;j++){
				if(_customerArray[j].customerCompareId(str)) counter[j]++;
			}
		}
		//Index of max will be the customer adress and the count of purchases will be its value in counter array.
		int[] result = {getIndexOfMax(counter),counter[getIndexOfMax(counter)]};
		return result;
	}
	
	/**
	 * Gets the SalesManagement object and returns the total profit.
	 * @param _salesManagement Object that has all the sales as two dimensional array.
	 * @return Total profit.
	 */
	 
	public static float getTotalProfit (SalesManagement _salesManagement) {
		Sales[][] salesManagementArray = _salesManagement.getArray();
		//Starting point of adding process.
		float result = 0;
		
		for(Sales[] arr : salesManagementArray) {
			for(Sales sale : arr){
				//Traverse two dimensional array and add each profit to the total profit value.
				result += sale.getSaleProfit();
															
			}
		}
		
		return result;
	}
	
	/**
	 * Gets the SalesManagement object and returns the least profitable sale of supplier 1.
	 * @param _salesManagement Object that has all the sales as two dimensional array.
	 * @return Sales object that contains the least profitable sale in supplier 1.
	 */
	 
 	public static Sales getLeastProfitSaleOfS1 (SalesManagement _salesManagement) {
		//This is the one dimensional array that contains the sales of supplier1.
 		Sales[] salesOfSupplier1 = _salesManagement.getArray()[0];
 		//Sample value to start comparing to other profits.
		Sales leastProfitableSale =  salesOfSupplier1[0];
		//While iterating through the sales of s1, 
		//if the compared element is lower than the sample,
		//assign the adress of the object to sample.	
		for(Sales sale : salesOfSupplier1){
			if(sale.getSaleProfit() < leastProfitableSale.getSaleProfit()) {
				leastProfitableSale = sale;					
			}
		}
		return leastProfitableSale;
	}
	
	private static int getIndexOfMax(int[] _arr){
		//Starting point of the array.Initialized there to ensure
		//there will be a return value and the code will not give exception.
		int maxIndex = 0;
		
		//A loop to iterate through the array and change the index of maximum value if necessary.
		for(int i = 0; i < _arr.length; i++){
			if(_arr[i] > _arr[maxIndex]) maxIndex = i;
		}
		
		return maxIndex;
	}
	
	private static String[] getCustomerIDOfAllPurchases(SalesManagement _saleManager) {
		//Using a salesmanager class method to get all the sales as one dimensional array.
		Sales[] salesArray = _saleManager.getAllSalesAsOneDimArray();
		String[] result =new String[salesArray.length];
		int index = 0;
		
		//Getting every customer id in all sales as strings and adding them to our result array.
		for(Sales sale : salesArray) {
			result[index++] = sale.getSalesCustomer().getCustomerId();
		}
		
		return result;
	}
	
}

