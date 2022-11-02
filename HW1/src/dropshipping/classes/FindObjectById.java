package dropshipping.classes;


/**
 * This Class's resposibility is Fetching Objects by their id's
 * @author  Mustafa Fatih Can 280201007
 * @author  Deniz Kaya 280201033
 * @author  Hakan Uskan 280201076
 * @author  Burak Erinç 290201099
 */
public class FindObjectById {
	
	/**
	 * Fetches and returns the Customer with id given as parameter by searching in given Customer Array
	 * @param _customerId Id of the customer to be find
	 * @param _customersArray Array of customers
	 * @return	Customer
	 */
	public static Customer getCustomerById(String _customerId,Customer[] _customersArray) {
		
		for(Customer i : _customersArray) {
			if(i.customerCompareId(_customerId)) {
				Customer result = new Customer(i);	//To prevent privacy leak, we used copy constructor.
				return result;
			}
		}
		
		System.out.println("Could not find the customer associated with given id. System exiting...");
		System.exit(0);
		return null;
		
	}
	
	/**
	 * Fetches and returns with Id given as parameter by searching in given Product Array
	 * @param _productId	Id of the customer to be find
	 * @param _productArray Array of products
	 * @return Product
	 */
	public static Product getProductById (String _productId,Product[] _productArray){
		
		for (Product i: _productArray){
			if(i.compareProductId(_productId)) {
				Product result = new Product(i);	//To prevent privacy leak, we used copy constructor.
				return result;
			}
		}
		System.out.println("Could not find the product associated with given id. System exiting...");
		System.exit(0);
		return null;
	}
}
