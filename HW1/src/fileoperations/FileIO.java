package fileoperations;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;
import java.util.StringTokenizer;
import dropshipping.classes.*;

public class FileIO {
	
	static final String  NEWLINE_SEPERATOR = System.getProperty("line.separator");//This line handles different OS's escape Characters for newlines
	
	@SuppressWarnings("resource")
	public static String readFileAsString(String _path) {
		String content = "";
		try {
			Scanner s = new Scanner(new FileReader(_path)).useDelimiter("\\A");
			content = s.next();
			s.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("The file you requested has not found.");
			e.printStackTrace();
		}
		
		return content;
	}
	public static Customer[] getCustomersDataFromFile()  {
		
			String fileContent = readFileAsString("Files/Customers.csv");			
			
			StringTokenizer newLineTokenizer = new StringTokenizer(fileContent,NEWLINE_SEPERATOR);
			StringTokenizer inLineTokenizer ;
			
			
			newLineTokenizer.nextToken();//For eliminating first blank line	
			Customer[] result = new Customer[newLineTokenizer.countTokens()];
			
			for(int i = 0;i<result.length;i++) {

				inLineTokenizer = new StringTokenizer(newLineTokenizer.nextToken(),",");
				String id = inLineTokenizer.nextToken();
				String name = inLineTokenizer.nextToken();
				String email = inLineTokenizer.nextToken();
				String country = inLineTokenizer.nextToken();
				String address = inLineTokenizer.nextToken();
				
				Customer newCustomer = new Customer(id, name, email,country,address);
				result[i] = newCustomer;
			}
		return result;
	}
	public static Supplier getProductDataFromFile(String _productFileName){
		String fileContent = readFileAsString("Files/"+_productFileName);
		
		StringTokenizer newLineTokenizer = new StringTokenizer(fileContent,NEWLINE_SEPERATOR);
		StringTokenizer inLineTokenizer ;
		
		newLineTokenizer.nextToken();//For eliminating first blank line	
		Product[] result = new Product[newLineTokenizer.countTokens()];
		for(int i = 0;i<result.length;i++) {
			
			inLineTokenizer = new StringTokenizer(newLineTokenizer.nextToken(),",");
			String id = inLineTokenizer.nextToken();
			String title = inLineTokenizer.nextToken();
			float rate = Float.parseFloat(inLineTokenizer.nextToken());
			int numberOfReviews = Integer.parseInt(inLineTokenizer.nextToken());
			int price = Integer.parseInt(inLineTokenizer.nextToken());
			
			Product newProduct = new Product(id, title, rate, numberOfReviews, price);
			result[i]= newProduct;
		}
		Supplier supplier = new Supplier(result);
		return supplier;
		}
	 public static Sales[] getSalesDataFromFile(String _salesFileName,Customer[] customerArray,Product[] productArray) {
		
		String fileContent = readFileAsString("Files/"+_salesFileName);
		
		StringTokenizer newLineTokenizer = new StringTokenizer(fileContent,NEWLINE_SEPERATOR);
		StringTokenizer inLineTokenizer ;
		
		newLineTokenizer.nextToken();//For eliminating first blank line	
		Sales[] result = new Sales[newLineTokenizer.countTokens()];
		
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-uu",Locale.US);
			
			for(int i = 0;i<result.length;i++){
				inLineTokenizer = new StringTokenizer(newLineTokenizer.nextToken(),",");
				String id = inLineTokenizer.nextToken();
				Customer customer = FindObjectById.getCustomerById(inLineTokenizer.nextToken(),customerArray);
				Product product = FindObjectById.getProductById(inLineTokenizer.nextToken(),productArray);
				LocalDate salesDate = LocalDate.parse(inLineTokenizer.nextToken(),formatter);
				
				Sales newSale = new Sales(id,customer,product,salesDate);
				result[i]= newSale;
				
			}
		return result;
		
	}
}
