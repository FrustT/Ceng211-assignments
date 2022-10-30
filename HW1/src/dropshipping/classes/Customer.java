package dropshipping.classes;

import dropshipping.interfaces.CustomerInterface;

public class Customer implements CustomerInterface {

	private String id;
	private String name;
	private String email;
	private String country;
	private String address;
	
	
	public Customer(String id2, String name2, String email2, String country2, String address2) {
		this.id = id2;
		this.name = name2;
		this.email = email2;
		this.country = country2;
		this.address = address2;
	}
	//TO DO decide which variables 
	//should not have getter or setter
	public String getCustomerId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	public boolean compareId(String id) {
		return this.id.equals(id);
	}
}
