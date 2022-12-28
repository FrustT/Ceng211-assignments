package marketshipment.classes;

import fileoperations.FileIO;

public class Initializer {
	private Company company;
	private OrderHandler orderHandler;
	
	public Initializer(){
		company = new Company();
		orderHandler = new OrderHandler(FileIO.getOrdersFromFile("Files/ExampleCommands.csv"));
	}
	public OrderHandler getHandler(){
		return orderHandler;
	}
	public Company getCompany(){
		return company;
	}
}
