package dropshipping.classes;

import dropshipping.interfaces.CustomerInterface;

public class Customer implements CustomerInterface {

	private String customerId;
	private String customerName;
	private String customerEmail;
	private String customerCountry;
	private String customerAddress;
	
	public Customer(String _customerId, String _customerName, String _customerEmail, String _customerCountry, String _customerAddress) { //kontrol et
		this.customerId = _customerId;
		this.customerName = _customerName;
		this.customerEmail = _customerEmail;
		this.customerCountry = _customerCountry;
		this.customerAddress = _customerAddress;
	}
		
	public Customer(Customer _customer) {
		this.customerId = _customer.getCustomerId();
		this.customerName = _customer.getCustomerName();
		this.customerEmail = _customer.getCustomerEmail();
		this.customerCountry = _customer.getCustomerCountry();
		this.customerAddress = _customer.getCustomerAddress();
	}
	
	public String getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(String _id) {
		if (isNull(_id)) {
			System.out.println("This id is invalid.");
			System.exit(0);
		}
		this.customerId = _id;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String _name) {
		if (isNull(_name)) {
			System.out.println("This name is invalid.");
			System.exit(0);
		}
		this.customerName = _name;
	}
	
	public String getCustomerEmail() {
		return customerEmail;
	}
	
	public void setCustomerEmail(String _email) {
		if (isNull(_email)) {
			System.out.println("This email is invalid.");
			System.exit(0);
		}
		this.customerEmail = _email;
	}
	
	public String getCustomerAddress() {
		return customerAddress;
	}
	
	public void SetCustomerAddress(String _address) {
		if (isNull(_address)) {
			System.out.println("This address is invalid.");
			System.exit(0);
		}
		this.customerAddress = _address;
	}
	
	public String getCustomerCountry() {
		return customerCountry;
	}
	
	public void setCustomerCountry(String _country) {
		if (isNull(_country)) {
			System.out.println("This country is invalid.");
			System.exit(0);
		}
		this.customerCountry = _country;
	}
	
	public boolean customerCompareId(String id) {
		return this.customerId.equals(id);
	}
	
	public String toString(){
		return "(Id:"+customerId+") (Name:"+customerName +") (Email:"+ customerEmail + ") (Country:"+ customerCountry+ ") (Address:"+ customerAddress+")" ; 
	}
	
	private boolean isNull(String _string){
		_string = _string.strip();
		if(_string == null)return true;
		return false;
	}
}
