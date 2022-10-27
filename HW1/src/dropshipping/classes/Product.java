package dropshipping.classes;
import dropshipping.interfaces.ProductInterface;

public class Product implements ProductInterface {

	private String id;
	private String title;
	private float rate;
	private int numberOfReviews;
	private float price;
	
	
	
	public Product(String id2, String title2, float rate2, int numberOfReviews2, float price2){
		
		this.id = id2;
		this.title = title2;
		this.rate = rate2;
		this.numberOfReviews = numberOfReviews2;
		this.price = price2;
		
	}
	public Product(Product _product) {
		new Product(_product.getId(),_product.getTitle(),_product.getRate(),_product.getNumberOfReviews(),_product.getPrice());
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setId(String input) {
		this.id = input;
	}
	
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String input) {
		this.title = input;
	}
	
	public void setRate(float input) {
		this.rate = input;
		
	}

	public float getRate() {
		return this.rate;
	}
	
	public int getNumberOfReviews() {
		return this.numberOfReviews;
	}
	
	public void setNumberOfReviews(int input) {
		this.numberOfReviews = input;
	}
	
	public float getPrice() {
		return this.price;	
	}
	
	public void setPrice(float input) {
		this.price = input;		
	}
	public boolean compareId(String id) {
		return this.id.equals(id);
	}

	
	
	
	
}
