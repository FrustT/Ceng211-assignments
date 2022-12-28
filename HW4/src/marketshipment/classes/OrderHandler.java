package marketshipment.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderHandler {
	private List<String> orders;
	private Company company;

	public OrderHandler(List<String> _orders) {
		orders = _orders;
		company = new Company();
	}

	public List<String> getOrders() {
		return orders;
	}

	public void delegate(String order) throws Exception {
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

	public void produce(List<String> operations) throws Exception {
		company.produce(operations);
	}

	public void load(List<String> operations) throws Exception {
		company.load(operations.remove(0), operations.remove(0));
	}

	public void ship(List<String> operations) throws Exception {
		company.ship(operations.remove(0));
	}

	public void show(List<String> operations) {
		company.show(operations.remove(0));
	}

	public boolean hasMoreOrders() {
		return !orders.isEmpty();
	}

	public void executeAnOrder() throws Exception {
		this.delegate(this.orders.remove(0));
	}

}