package dropshipping.classes;
import java.time.LocalDate;

import dropshipping.interfaces.SalesInterface;

	/**
	 * This Class holds Sales Data as instance variables for each purchase.<p>
	 * SalesPrice variable is being calculated from Product Parameter of parameterized constructor and initilized.
	 * <ul>
	 * <li><strong>salesId</strong> type: String
	 * <li><strong>salesCustomer</strong> type: Customer
	 * <li><strong>salesProduct</strong> type: Product
	 * <li><strong>salesDate</strong> type: LocalDate
	 * <li><strong>SalesPrice</strong> type: float
	 * </ul>
	 * @author  Mustafa Fatih Can 280201007
	 * @author  Deniz Kaya 280201033
	 * @author  Hakan Uskan 280201076
	 * @author  Burak Erinç 290201099
	 */
public class Sales implements SalesInterface {
	private String salesId;
	private	Customer salesCustomer;
	private Product salesProduct;
	private LocalDate salesDate;
	private float salesPrice;
	
	
	/**
	 *<strong>Parameterized Constructor</strong><p>
	 * Constructs Sales Object with required data.
	 * @param _salesId
	 * @param _salesCustomer
	 * @param _salesProduct
	 * @param _salesDate
	 */
	public Sales(String _salesId, Customer _salesCustomer, Product _salesProduct, LocalDate _salesDate) {
		this.salesId = _salesId; 
		this.salesCustomer = _salesCustomer;
		this.salesProduct = _salesProduct;
		this.salesDate =  _salesDate;
		this.salesPrice = this.calculateSalesPrice(_salesProduct);
	}
	
	/**
	 * <strong>Copy Constructor</strong><p>
	 * Constructs a new Sales Object with another Sales Object
	 * @param Sales Object
	 */
	public Sales(Sales _sales) {
		this.salesId = _sales.getSalesId();
		this.salesCustomer = _sales.getSalesCustomer();
		this.salesProduct = _sales.getSalesProduct();
		this.salesDate = _sales.getSalesDate();
		this.salesPrice = _sales.getSalesPrice();
	}
	
	
	public String getSalesId() {
		// Since String class is immutable, there is no need for copy constructor here.
		return this.salesId;
	}

	public void setSalesId(String _sales) {
		this.salesId = _sales;
	}

	public Customer getSalesCustomer() {
		// To prevent privacy leak, we used copy constructor.
		return new Customer(this.salesCustomer);
	}

	public void setSalesCustomer(Customer _sales) {
		this.salesCustomer = _sales;
	}

	public Product getSalesProduct() {
		return new Product(this.salesProduct);
	}

	public void setSalesProduct(Product _sales) {
		this.salesProduct = _sales;
	}

	
	public LocalDate getSalesDate(){
		// Since LocalDate class is immutable, there is no need for copy constructor here.
		return this.salesDate;
	}

	public void setSalesDate(LocalDate _sales) {
		this.salesDate = _sales;
	}

	public float getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(float _sales) {
		this.salesPrice = _sales;
	}

	private float calculateSalesPrice (Product _sales){
		return  _sales.getProductPrice() + (( _sales.getProductRate() / 5) * 100) * _sales.getProductNumberOfReviews();
		
	}
	public float getSaleProfit(){
		return this.salesPrice - this.salesProduct.getProductPrice();
	}
	public String toString(){
		return "(Id:"+salesId+") (Customer's Id: "+salesCustomer.getCustomerId() +") (Product's Id:"+ salesProduct.getProductId() + ") (Date:"+ salesDate.toString()+ ") (Price:"+ salesPrice+")" ;
	}	
	

}
