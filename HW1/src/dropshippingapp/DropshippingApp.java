package dropshippingapp;

import dropshipping.classes.*;
import fileoperations.FileIO;

public class DropshippingApp {

	public static void main(String[] args) {

		Customer[] customers =FileIO.getCustomersDataFromFile();
		System.out.println(customers.length);
		Supplier supplier1 = FileIO.getProductDataFromFile("S1_Products.csv");
		Supplier supplier2 = FileIO.getProductDataFromFile("S2_Products.csv");
		Supplier supplier3 = FileIO.getProductDataFromFile("S3_Products.csv");
		Sales[] s1Sales = FileIO.getSalesDataFromFile("S1_Sales.csv",customers,supplier1.toArray());
		Sales[] s2Sales = FileIO.getSalesDataFromFile("S2_Sales.csv",customers,supplier2.toArray());
		Sales[] s3Sales = FileIO.getSalesDataFromFile("S3_Sales.csv",customers,supplier3.toArray());
		SalesManagement saleManager =new SalesManagement(s1Sales, s2Sales, s3Sales);
		Sales[][] salesArr = saleManager.toArray();
		System.out.println("SalesArr length "+ salesArr.length+"\nSalesArr[0] "+ salesArr[0].length+"\nSalesArr[1] "+ salesArr[1].length+"\nSalesArr[2] "+ salesArr[2].length);

	}

}
