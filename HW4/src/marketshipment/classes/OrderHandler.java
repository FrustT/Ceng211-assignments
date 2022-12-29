package marketshipment.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import marketshipment.exceptions.RuleException;

/**
 * This Class acts as a layer between Data Layer and Business Layer.
 * Gets Orders from the file and delegates to company
 * <ul>
 * <li><strong>orders</strong> type: List<String>
 * <li><strong>company</strong> type: Company
 * </ul>
 * 
 * @author Mustafa Fatih Can 280201007
 * @author Deniz Kaya 280201033
 * @author Hakan Uskan 280201076
 * @author Burak Erinc 290201099
 */
public class OrderHandler {
	private List<String> orders;
	private Company company;

	/**
	 * <strong>Parameterized Constructor</strong>
	 * <p>
	 * Constructs OrderHandler object with required data.
	 * 
	 * @param _orders
	 */
	public OrderHandler(List<String> _orders) {
		orders = _orders;
		company = new Company();
	}
	
	
	/**
	 * Gets the Orders of the OrderHandler
	 * @return orders : List<String>
	 */
	public List<String> getOrders() {
		return orders;
	}
	
	/**
	 * Decides and delegates the company according to the Order
	 * @param order
	 * @throws RuleException
	 */
	public void delegate(String order) throws RuleException {
		ArrayList<String> operations = new ArrayList<>();
		Collections.addAll(operations, order.split(","));
		switch (operations.remove(0)) {
		case "1":
			produce(operations);
			break;
		case "2":
			load(operations);
			break;
		case "3":
			ship(operations);
			break;
		case "4":
			show(operations);
			break;
		default:
			break;
		}
	}
	
	/**
	 * Delegates company to produce with given data.May throw exception-
	 * @throws RuleException
	 */
	public void produce(List<String> operations) throws RuleException {
		company.produce(operations);
	}
	
	/**
	 * Delegates company to load with given data.May throw exception
	 * @param operations
	 * @throws RuleException
	 */
	public void load(List<String> operations) throws RuleException {
		company.load(operations.remove(0), operations.remove(0));
	}
	
	/**
	 * Delegates company to ship with the given data.May throw exception
	 * @param operations
	 * @throws RuleException
	 */
	public void ship(List<String> operations) throws RuleException {
		company.ship(operations.remove(0));
	}
	
	/**
	 * Delegates company to show data with the given instructions.
	 * @param operations
	 */
	public void show(List<String> operations) {
		company.show(operations.remove(0));
	}
	
	/**
	 * Returns True if has more orders otherwise returns false
	 * @return  type: Boolean
	 */
	public boolean hasMoreOrders() {
		return !orders.isEmpty();
	}
	
	/**
	 * Pops the top of the stack and delegates the operation.
	 * @throws RuleException
	 */
	public void executeAnOrder() throws RuleException {
		this.delegate(this.orders.remove(0));
	}

}