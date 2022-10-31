package dropshipping.classes;
import dropshipping.interfaces.ProductInterface;

public class Product implements ProductInterface {

	private String productId;
	private String productTitle;
	private float productRate;
	private int productNumberOfReviews;
	private float productPrice;
	
	public Product(String _productId, String _productTitle, float _productRate, int _productNumberOfReviews, float _productPrice){
		this.productId = _productId;
		this.productTitle = _productTitle;
		this.productRate = _productRate;
		this.productNumberOfReviews = _productNumberOfReviews;
		this.productPrice = _productPrice;
	}
	
	public Product(Product _product) {
		this.productId = _product.getProductId();
		this.productTitle = _product.getProductTitle();
		this.productRate = _product.getProductRate();
		this.productNumberOfReviews = _product.getProductNumberOfReviews();
		this.productPrice = _product.getProductPrice();
	}

	public String getProductId() { //Since String class is immutable, there is no need for copy constructor here.
		return this.productId;
	}
	
	public void setProductId(String _id) {
		if (isNull(_id)) {
			System.out.println("This id is invalid.");
			System.exit(0);
		}
		this.productId = _id;
	}
	
	public String getProductTitle() {
		return this.productTitle;
	}

	public void setProductTitle(String _title) {
		if (isNull(_title)) {
			System.out.println("This title is invalid.");
			System.exit(0);
		}
		this.productTitle = _title;
	}

	public float getProductRate() {
		return this.productRate;
	}
	
	public void setProductRate(float _rate) {
		if (_rate > 5 || _rate < 0) {
			System.out.println("The rate must be in between 0 and 5.");
			System.exit(0);
		}
		this.productRate = _rate;
		
	}

	public int getProductNumberOfReviews() {
		return this.productNumberOfReviews;
	}
	
	public void setProductNumberOfReviews(int _numberOfReviews) {
		if (_numberOfReviews < 0) {
			System.out.println("This title is invalid.");
			System.exit(0);
		}
		this.productNumberOfReviews = _numberOfReviews;
	}
	
	public float getProductPrice() {
		return this.productPrice;	
	}
	
	public void setProductPrice(float _price) {
		if (_price < 0) {
			System.out.println("This title is invalid.");
			System.exit(0);
		}
		this.productPrice = _price;		
	}
	
	public boolean compareProductId(String _id) {
		return productId.equals(_id);
	}
	
	public String toString(){
		return "(Id: "+productId+") (Title: "+productTitle +") (Rate: "+ productRate + ") (Number of reviews: "+ productNumberOfReviews+ ") (Price: "+ productPrice+")" ;
	}
	
	// Checks the string if it is null or made by spaces.
	private boolean isNull(String _string){
		_string = _string.strip();
		if(_string == null) return true;
		return false;
	}	
	
}
