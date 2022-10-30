package dropshipping.classes;
import java.time.LocalDate;

import dropshipping.interfaces.SalesInterface;

public class Sales implements SalesInterface {
	private String id;
	private	Customer customer;
	private Product product;
	private LocalDate salesDate;
	private float salesPrice;
	
	public Sales(String id2, Customer customer2, Product product2, LocalDate salesDate2) {
		this.id = id2; 
		this.customer = customer2;
		this.product = product2;
		this.salesDate =  salesDate2;
		this.salesPrice = this.calculatePrice(product2);
	}
	
	public String getSalesId() {
		return this.id;
	}

	public void setSalesId(String input) {
		this.id = input;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer input) {
		this.customer = input;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product input) {
		this.product = input;
	}

	public LocalDate getDate() {
		return this.salesDate;
	}

	
	public void setDate(LocalDate input) {
		this.salesDate = input;
	}

	public float getPrice() {
		return salesPrice;
	}

	public void setPrice(float input) {
		this.salesPrice = input;
	}

	private float calculatePrice (Product input){
		return  product.getPrice() + (( product.getRate() / 5) * 100) * product.getNumberOfReviews();
		
	}

		
	

}
