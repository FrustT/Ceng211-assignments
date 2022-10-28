package dropshipping.classes;

import dropshipping.interfaces.SalesManagementInterface;

public class SalesManagement implements SalesManagementInterface {
	private Sales[][] salesArr;
	
	public SalesManagement(Sales[] _sales1, Sales[] _sales2, Sales[] _sales3) {
		this.salesArr = new Sales[3][];
		salesArr[0] = _sales1;
		salesArr[1] = _sales2;
		salesArr[2] = _sales3;
	}
	/*Copy Const
	 * public SalesManagement(SalesManagement _SalesManagemnt) {
		SalesManagement();
		
	}*/
	

	//We should copy the array before returning it
	public Sales[][] toArray() {
		
		return this.salesArr;
	}
	
}
