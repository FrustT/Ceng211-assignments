package marketshipmentsimulation;

import marketshipment.classes.*;

public class MarketShipmentSimulator {
	private Initializer init;
		
		public MarketShipmentSimulator(){
			init = new Initializer();	
		}
		public void simulate() throws Exception {
			OrderHandler handler = init.getHandler();

			while (handler.hasMoreOrders()) {
				handler.executeAnOrder();
			}
		}

}
