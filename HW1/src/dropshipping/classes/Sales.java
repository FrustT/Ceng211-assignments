package dropshipping.classes;
import java.time.LocalDate;

import dropshipping.interfaces.SalesInterface;

public class Sales implements SalesInterface {
	private String salesId;
	private	Customer salesCustomer;
	private Product salesProduct;
	private LocalDate salesDate;
	private float salesPrice;
	
	public Sales(String _salesId, Customer _salesCustomer, Product _salesProduct, LocalDate _salesDate) {
		this.salesId = _salesId; 
		this.salesCustomer = _salesCustomer;
		this.salesProduct = _salesProduct;
		this.salesDate =  _salesDate;
		this.salesPrice = this.calculateSalesPrice(_salesProduct);
	}
	
	public Sales(Sales _sales) {
		this.salesId = _sales.getSalesId();
		this.salesCustomer = _sales.getSalesCustomer();
		this.salesProduct = _sales.getSalesProduct();
		this.salesDate = _sales.getSalesDate();
		this.salesPrice = _sales.getSalesPrice();
	}
	
	public String getSalesId() {
		return this.salesId;
	}

	public void setSalesId(String _sales) {
		this.salesId = _sales;
	}

	public Customer getSalesCustomer() {
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

	public LocalDate getSalesDate(){ //Since LocalDate class is immutable, there is no need for copy constructor here.
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
