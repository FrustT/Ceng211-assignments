package fileoperations;

import dropshipping.classes.Customer;
import dropshipping.classes.Product;

//This Class is for Fetching Objects by their id's
public class FindObjectById {

	public static Customer getCustomerById(String id,Customer[] CustomersArray) {
		
		for(Customer i : CustomersArray) {
			if(i.compareId(id))return (Customer)i;
		}
		
		return null;
		
	}
	
	public static Product getProductById (String id,Product[] ProductArray){
		
		for (Product i: ProductArray){
			
			if(i.compareId(id))return (Product)i;
		}
		
		return null;
	}
}
