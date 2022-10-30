package dropshipping.classes;

import dropshipping.interfaces.SalesManagementInterface;

public class SalesManagement implements SalesManagementInterface {
	private Sales[][] salesArr;
	
	public SalesManagement(Sales[]... args) {
		this.salesArr = new Sales[args.length][];
		for(int i = 0; i < args.length; i++){
			salesArr[i] = args[i];
		}
	}
	
	public SalesManagement(SalesManagement saleManager){
		salesArr = saleManager.getArray();
	}
	
	// We should copy the array before returning it
	public Sales[][] getArray() {
		
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
