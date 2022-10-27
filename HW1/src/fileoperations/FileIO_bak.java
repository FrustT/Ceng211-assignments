package fileoperations;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.*;
import java.util.Locale;
import java.util.Scanner;

import dropshipping.classes.Customer;
import dropshipping.classes.Product;
import dropshipping.classes.Sales;
import dropshipping.classes.Supplier;

public class FileIO_bak {
		
		
	public Customer[] getCustomersData() {		
		String basePath = new File("").getAbsolutePath();
		File file = new File(basePath + "/Files/Customers.csv");
		int lineCount = getNumberOfLines(file);
		Customer[] customers = new Customer[lineCount];
		try {
			
			Scanner reader = new Scanner(file);
			reader.nextLine();	//Blank data is being denied here
			int indexCounter = 0;
			while(reader.hasNextLine()) {
				String[] data = reader.nextLine().split(",");
				String id = data[0];
				String name = data[1];
				String email = data[2];
				String country = data[3];
				String address = data[4];
				
				Customer newCustomer = new Customer(id, name, email,country,address);
				System.out.println("index "+indexCounter+" length ="+customers.length);
				customers[indexCounter] = newCustomer;
				indexCounter++;
			}
			reader.close();
			}	catch(FileNotFoundException e) {
				e.printStackTrace();
			}
		return customers;
	}
	
	public  Supplier<Product> getProductData(String productFileName){
		String basePath = new File("").getAbsolutePath();
		File file = new File(basePath + "/Files/"+ productFileName);
		int lineCount = getNumberOfLines(file);
		Product[] products = new Product[lineCount];
		
		
		try{
			Scanner reader = new Scanner(file);
			reader.nextLine();   //Blank data is being denied here
			
			int indexCounter = 0;			
			while(reader.hasNextLine()){
				String[] data = reader.nextLine().split(",");
				String id = data[0];
				String title = data[1];
				float rate = Float.parseFloat(data[2]);
				int numberOfReviews = Integer.parseInt(data[3]);
				int price = Integer.parseInt(data[4]);
				
				Product newProduct = new Product(id, title, rate, numberOfReviews, price);
				products[indexCounter]= newProduct;
				indexCounter++;
			}			
			
			reader.close();
			
			
		}	catch(FileNotFoundException e){
			e.printStackTrace();
		}
		Supplier<Product> supplier = new Supplier<Product>(products);
		return supplier;
	}
	
	public  Sales[] getSalesData(String salesFileName,Customer[] customerArray,Product[] productArray) {
		
		String basePath = new File("").getAbsolutePath();
		File file = new File(basePath + "/Files/"+ salesFileName);
		int lineCount = getNumberOfLines(file);
		Sales[] sales = new Sales[lineCount];
		
		try{
			
			Scanner reader = new Scanner(file);
			reader.nextLine();	//Blank data is being denied here
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-uu",Locale.US);
			
			int indexCounter = 0;
			while(reader.hasNextLine()){
				String[] data = reader.nextLine().split(",");
				String id = data[0];
				Customer customer = getCustomerById(data[1],customerArray);
				Product product = getProductById(data[2],productArray);
				LocalDate salesDate = LocalDate.parse(data[3],formatter);
				
				Sales newSale = new Sales(id,customer,product,salesDate);
				sales[indexCounter]= newSale;
				indexCounter++;
			}
			
			reader.close();
			
		}	catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
		return sales;
		
	}
	
	private static Customer getCustomerById(String id,Customer[] CustomersArray) {
		
		for(Customer i : CustomersArray) {
			if(i.compareId(id))return (Customer)i;
		}
		
		return null;
		
	}
	
	private static Product getProductById ( String id, Product[] ProductArray){
		
		for (Product i: ProductArray){
			
			if(i.compareId(id))return (Product)i;
		}
		
		return null;
	}
	
	public  Object[] doubleTheLengthOfArray(Object[]array) {
		 Object result[] ;
		 result =new Object[array.length*2];
		
		for(int i = 0;i<array.length;i++) {
			result[i] = array[i];
			
		}
		 return result;
	}
	
	public int getNumberOfLines(File file) {
		int lineCount = 0;
		try {
			Scanner scanner = new Scanner(file);
			scanner.nextLine();
			String deneme = scanner.toString();
			System.out.println(deneme);
			while(scanner.hasNextLine()) {
				lineCount++;
				scanner.nextLine();
			}
			scanner.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		return lineCount;
		
	}
	
}
