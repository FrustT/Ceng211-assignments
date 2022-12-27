package marketshipmentsimulation;

import marketshipment.classes.*;

public class MarketShipmentApp {
	public static void main(String[] args) throws Exception {// Debug reasons

		MarketShipmentSimulator simulator = new MarketShipmentSimulator();
		Initializer init = simulator.getInitializer();
		Company comp = init.getCompany();
		OrderHandler ord = init.getHandler();

		while (ord.hasMoreOrders()) {
			ord.executeAnOrder();
		}
	}
}
