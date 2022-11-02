package dropshipping.classes;
import fileoperations.FileIO;
	/**
	 * This Class hold all data read from the .csv files as instance variables.
	 * Uses methods from <b>FileIO</b> class in fileoperations package.(as This <b>FileIO</b> 
	 * method involves static methods this
	 * class is being used as a Object to be get this Datas from) 
	 * <ul>
	 * <li>{@link #Initializer Initializer()}
	 *<ul>
	 * @author  Mustafa Fatih Can 280201007
	 * @author  Deniz Kaya 280201033
	 * @author  Hakan Uskan 280201076
	 * @author  Burak Erinç 290201099
	 */
public class Initializer {

	private Customer[] customerArray;
	private Supplier supplier1;
	private Supplier supplier2;
	private Supplier supplier3;
	private Sales[] s1Sales;
	private Sales[] s2Sales;
	private Sales[] s3Sales;
	private SalesManagement saleManager;
	
	/**
	 * <strong>No Argument Constructor</strong><p>
	 * Constructs Initializer Object and initializes these instance variables using 
	 * static methods in <b>FileIO<b> Class which reads from .csv files.
	 */
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
	/**
	 * Gets the copy of Customer[] Array of customers to prevent privacy leak
	 * @return Customer[] Array of Customers
	 */
	public Customer[] getCustomerArray(){
		Customer[] result = new Customer[customerArray.length];
		for(int i = 0; i < result.length; i++){
			// To prevent privacy leak, we used copy constructor.
			Customer copyCustomer = new Customer(customerArray[i]);
			result[i] = copyCustomer;
		}
		return result;
	}
	/**
	 * Gets the SalesManagement Object in Initializer to prevent privacy leak
	 * @return SalesManagement
	 */
	public SalesManagement getSaleManager(){
		SalesManagement output = new SalesManagement(this.saleManager);
		return output;
	}
}
