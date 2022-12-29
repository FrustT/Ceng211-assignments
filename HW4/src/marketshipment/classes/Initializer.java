package marketshipment.classes;

import fileoperations.FileIO;

/**
 * This class holds data for the simulation.
 *
 * <ul>
 * <li><strong>company</strong> type: Company
 * <li><strong>orderHandler</strong> type: OrderHandler
 * </ul>
 * 
 * @author Mustafa Fatih Can 280201007
 * @author Deniz Kaya 280201033
 * @author Hakan Uskan 280201076
 * @author Burak Erinc 290201099
 */

public class Initializer {
	private Company company;
	private OrderHandler orderHandler;
	
	/**
	 * <strong>No Argument Constructor</strong>
	 * <p>
	 */
	public Initializer(){
		company = new Company();
		orderHandler = new OrderHandler(FileIO.getOrdersFromFile("commands.csv"));
	}
	
	
	/**
	 * Gets the OrderHandler object in the Initializer object.
	 *
	 * @return type: OrderHandler
	 */
	public OrderHandler getHandler(){
		return orderHandler;
	}
	
	/**
	 * Gets the Company object in the Initializer object.
	 *
	 * @return type: Company
	 */
	public Company getCompany(){
		return company;
	}
}
