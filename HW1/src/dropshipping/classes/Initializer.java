package dropshipping.classes;
import fileoperations.FileIO;

public class Initializer {

	private Customer[] customerArray;
	private Supplier supplier1;
	private Supplier supplier2;
	private Supplier supplier3;
	private Sales[] s1Sales;
	private Sales[] s2Sales;
	private Sales[] s3Sales;
	private SalesManagement saleManager;
	
	public Initializer(){
		customerArray = FileIO.getCustomersDataFromFile();
		supplier1 = FileIO.getProductDataFromFile("S1_Products.csv");
		supplier2 = FileIO.getProductDataFromFile("S2_Products.csv");
		supplier3 = FileIO.getProductDataFromFile("S3_Products.csv");
		s1Sales = FileIO.getSalesDataFromFile("S1_Sales.csv",customerArray,supplier1.toArray());
		s2Sales = FileIO.getSalesDataFromFile("S2_Sales.csv",customerArray,supplier2.toArray());
		s3Sales = FileIO.getSalesDataFromFile("S3_Sales.csv",customerArray,supplier3.toArray());
		saleManager = new SalesManagement(s1Sales, s2Sales, s3Sales);
	}
	
	public Customer[] getCustomerArray(){
		Customer[] result = new Customer[customerArray.length];
		for(int i = 0; i < result.length; i++){
			Customer copyCustomer = new Customer(customerArray[i]);	//To prevent privacy leak, we used copy constructor.
			result[i] = copyCustomer;
		}
		return result;
	}

	public SalesManagement getSaleManager(){
		SalesManagement output = new SalesManagement(this.saleManager);
		return output;
	}
}
