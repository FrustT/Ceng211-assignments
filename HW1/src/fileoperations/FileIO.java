package fileoperations;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;
import java.util.StringTokenizer;
import dropshipping.classes.*;

public class FileIO {
	
	// This line handles different OS's escape Characters for newlines.
	static final String  NEWLINE_SEPERATOR = System.getProperty("line.separator");	
	
	private static String readFileAsString(String _path) {
		String content = "";
		
						/* For reading CSV files, gathering line count was important for initializing correct size array.
						 * For that reason we implemented buffer reading approach
						 * This code uses a special delimiter "\\A" that indicates file's starting point.
						 * So , this delimiter ensures that we will only get one token from the scanner. 
						 */
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
		
			// This tokenizer's responsibility is gathering next data line
		StringTokenizer newLineTokenizer = new StringTokenizer(fileContent,NEWLINE_SEPERATOR);
			/*This tokenizer's responsibility is gathering next data in one object's line 
			* Since every line will be different so each inLineTokenizer needs to initialize in the loop 
			*/
		StringTokenizer inLineTokenizer;
		
		newLineTokenizer.nextToken(); // For eliminating first blank line
		Customer[] result = new Customer[newLineTokenizer.countTokens()];
		
		for(int i = 0; i < result.length; i++) {
			inLineTokenizer = new StringTokenizer(newLineTokenizer.nextToken(), ",");
			String id = inLineTokenizer.nextToken();
			String name = inLineTokenizer.nextToken();
			String email = inLineTokenizer.nextToken();
			String country = inLineTokenizer.nextToken();
			String address = inLineTokenizer.nextToken();
			
			Customer newCustomer = new Customer(id, name, email, country, address);
			result[i] = newCustomer;
		}
		
		return result;
	}
	
	public static Supplier getProductDataFromFile(String _productFileName){
		String fileContent = readFileAsString("Files/" + _productFileName);
		
			// This tokenizer's responsibility is gathering next data line
		StringTokenizer newLineTokenizer = new StringTokenizer(fileContent, NEWLINE_SEPERATOR);
			/*This tokenizer's responsibility is gathering next data in one object's line 
			* Since every line will be different so each inLineTokenizer needs to initialize in the loop 
			*/
		StringTokenizer inLineTokenizer;
		
		newLineTokenizer.nextToken(); // For eliminating first blank line	
		Product[] result = new Product[newLineTokenizer.countTokens()];
		for(int i = 0;i<result.length;i++) {
			inLineTokenizer = new StringTokenizer(newLineTokenizer.nextToken(), ",");
			String id = inLineTokenizer.nextToken();
			String title = inLineTokenizer.nextToken();
			float rate = Float.parseFloat(inLineTokenizer.nextToken());
			int numberOfReviews = Integer.parseInt(inLineTokenizer.nextToken());
			int price = Integer.parseInt(inLineTokenizer.nextToken());
			
			Product newProduct = new Product(id, title, rate, numberOfReviews, price);
			result[i] = newProduct;
		}
		
		Supplier supplier = new Supplier(result);
		
		return supplier;
	}
		
	public static Sales[] getSalesDataFromFile(String _salesFileName,Customer[] customerArray,Product[] productArray) {	
		String fileContent = readFileAsString("Files/" + _salesFileName);
		
			// This tokenizer's responsibility is gathering next data line
		StringTokenizer newLineTokenizer = new StringTokenizer(fileContent, NEWLINE_SEPERATOR);
			/*This tokenizer's responsibility is gathering next data in one object's line 
			 * Since every line will be different so each inLineTokenizer needs to initialize in the loop 
			 */
		StringTokenizer inLineTokenizer;
		
		newLineTokenizer.nextToken(); // For eliminating first blank line	
		Sales[] result = new Sales[newLineTokenizer.countTokens()];			
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-uu", Locale.US);
		
		for(int i = 0; i < result.length; i++){
			inLineTokenizer = new StringTokenizer(newLineTokenizer.nextToken(), ",");
			String id = inLineTokenizer.nextToken();
			
			// This next 2 line uses methods to gather the Objects that has that particular id
			Customer customer = FindObjectById.getCustomerById(inLineTokenizer.nextToken(), customerArray);
			Product product = FindObjectById.getProductById(inLineTokenizer.nextToken(), productArray);
			
			LocalDate salesDate = LocalDate.parse(inLineTokenizer.nextToken(), formatter);
			
			Sales newSale = new Sales(id, customer, product, salesDate);
			result[i] = newSale;
			
		}
		
		return result;
	}
}
