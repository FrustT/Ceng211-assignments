package dropshippingapp;

import dropshipping.classes.*;
import fileoperations.FileIO;
import me.group12.hw1.Customer;
import me.group12.hw1.Product;
import me.group12.hw1.Supplier;

public class DropshippingApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer[] customers =FileIO.getCustomersDataFromFile();
		System.out.println(customers.length);
		Supplier<Product> supplier1 = FileIO.getProductDataFromFile("S1_Products.csv");
		Supplier<Product> supplier2 = FileIO.getProductDataFromFile("S2_Products.csv");
		Supplier<Product> supplier3 = FileIO.getProductDataFromFile("S3_Products.csv");
		Sales[] s1_sales = FileIO.getSalesDataFromFile("S1_Sales.csv",customers,supplier1.getProductsAsArray());//TBD

	}

}
