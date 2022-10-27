package dropshippingapp;

import dropshipping.classes.*;
import fileoperations.FileIO;

public class DropshippingApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer[] customers =FileIO.getCustomersDataFromFile();
		System.out.println(customers.length);
		Supplier supplier1 = FileIO.getProductDataFromFile("S1_Products.csv");
		Supplier supplier2 = FileIO.getProductDataFromFile("S2_Products.csv");
		Supplier supplier3 = FileIO.getProductDataFromFile("S3_Products.csv");
		Sales[] s1_sales = FileIO.getSalesDataFromFile("S1_Sales.csv",customers,supplier1.toArray());//TBD
		System.out.println(s1_sales[0]);

	}

}
