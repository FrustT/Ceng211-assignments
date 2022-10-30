package dropshipping.classes;

public class SalesQuery {
	
	
	public static Sales getMostProfitableSale (SalesManagement _salesManagement) {
		
		Sales[][] salesManagementArray = _salesManagement.getArray();
		Sales mostProfitableSale = salesManagementArray[0][0];
		
		for(Sales[] arr : salesManagementArray){
			for(Sales sale : arr){
				if(sale.getSaleProfit() > mostProfitableSale.getSaleProfit())mostProfitableSale = sale;
			}
		}
		return mostProfitableSale;
	}
	
	public static Sales getMostExpensiveSales (SalesManagement _salesManagement) {
		
		Sales[][] salesManagementArray = _salesManagement.getArray();
		Sales mostExpensiveSale = salesManagementArray[0][0];
		
		for(Sales[] arr : salesManagementArray){
			for(Sales sale : arr){
				if(sale.getSalesPrice() > mostExpensiveSale.getSalesPrice())mostExpensiveSale = sale;
			}
		}
		
		return mostExpensiveSale;
	}
	
	public static int[] getCustomerWhoPurchasedMost (SalesManagement _salesManagement, Customer[] _customerArray) {
		String[] customerIdsOfTheSales = getCustomerIDOfAllPurchases(_salesManagement);
		
		int[] counter =new int[_customerArray.length];
		
		for(String str : customerIdsOfTheSales){
			for(int j = 0;j< counter.length;j++){
				if(_customerArray[j].customerCompareId(str))counter[j]++;
			}
		}
		int[] result = {getIndexOfMax(counter),counter[getIndexOfMax(counter)]};
		return result;
	}
	
	public static float getTotalProfit (SalesManagement _salesManagement) {
		
		Sales[][] salesManagementArray = _salesManagement.getArray();
		float result = 0;
		
		for(Sales[] arr : salesManagementArray){
			for(Sales sale : arr){
				result += sale.getSaleProfit();
											
			}
		}
		
		return result;
		
		}
	
 	public static Sales getLeastProfitSaleOfS1 (SalesManagement _salesManagement) {
 		Sales[] salesOfSupplier1 = _salesManagement.getArray()[0];
		Sales leastProfitableSale =  salesOfSupplier1[0];
			
			for(Sales sale : salesOfSupplier1){
				if(sale.getSaleProfit() < leastProfitableSale.getSaleProfit()) {
					
					leastProfitableSale =new Sales(sale);
				}
			}
		return leastProfitableSale;
	}
	
	private static int getIndexOfMax(int[] _arr){
		int maxIndex = 0;
		
		for(int i = 0; i < _arr.length; i++){
			
			if(_arr[i] > _arr[maxIndex])maxIndex = i;
		}
		return maxIndex;
	}
	
	private static String[] getCustomerIDOfAllPurchases(SalesManagement _saleManager){
		
		Sales[] salesArray = _saleManager.getAllSalesAsOneDimArray();
		String[] result =new String[salesArray.length];
		int index = 0;
		for(Sales sale : salesArray){
			result[index++] = sale.getSalesCustomer().getCustomerId();
			
		}
		return result;
	}
	
}

