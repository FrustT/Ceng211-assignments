package dropshipping.classes;


//This Class is for Fetching Objects by their id's
public class FindObjectById {

	public static Customer getCustomerById(String _customerId,Customer[] _customersArray) {
		
		for(Customer i : _customersArray) {
			if(i.customerCompareId(_customerId)) {
				Customer result = new Customer(i);
				return result;
			}
		}
		System.out.println("Could not find the customer associated with given id. System exiting...");
		System.exit(0);
		return null;
		
	}
	
	public static Product getProductById (String _productId,Product[] _productArray){
		
		for (Product i: _productArray){
			if(i.compareProductId(_productId)) {
				Product result = new Product(i);
				return result;
			}
		}
		System.out.println("Could not find the product associated with given id. System exiting...");
		System.exit(0);
		return null;
	}
}
