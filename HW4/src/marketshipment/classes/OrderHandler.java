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

	public void delegate(String order) {
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

	public void produce(ArrayList<String> operations) {
		String code = operations.remove(0);
		switch(code) {
			case "B1": case "B2":
				company.produceBox(BoxCode.valueOf(code),Integer.valueOf(operations.remove(0)),Double.valueOf(operations.remove(0)),operations.remove(0));
				break;
			case "M1": case "W1": case "O1":
				company.produceCountableItem(ItemCode.valueOf(code), Double.valueOf(operations.remove(0)), operations.remove(0));
				break;
			case "S1": case "F1": case "P1": case "R1":
				company.produceUncountableItem(ItemCode.valueOf(code), Integer.valueOf(operations.remove(0)), Double.valueOf(operations.remove(0)), operations.remove(0));
			case "C1":
				company.produceContainer(ContainerCode.valueOf(code), Double.valueOf(operations.remove(0)), operations.remove(0));
		}
	}

	public void load(ArrayList<String> operations) {
		
	}

	public void ship(ArrayList<String> operations) {

	}

	public void show(ArrayList<String> operations) {
		
		switch(operations.remove(0)){
			case "1":
			break;
			case "2":
			break;
			default:
			break;
		}
	}

	public boolean hasMoreOrders() {
		return orders.size() != 0;
	}

	public void executeAnOrder() {
		this.delegate(this.orders.remove(0));
	}

}