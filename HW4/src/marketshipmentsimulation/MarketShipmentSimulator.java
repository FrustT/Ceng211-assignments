package marketshipmentsimulation;

import marketshipment.classes.*;
import marketshipment.exceptions.RuleException;
 /**
 * This is the simulator class of this project.
 * Its only purpose is to create a initializer object and simulates orders while orders list has orders.
 * <ul>
 * <li><strong>inits</strong> type: Initializer
 * </ul>
 * @author Mustafa Fatih Can 280201007
 * @author Deniz Kaya 280201033
 * @author Hakan Uskan 280201076
 * @author Burak Erinç 290201099
 *
 */
public class MarketShipmentSimulator {
	private Initializer init;
		
		public MarketShipmentSimulator(){
			init = new Initializer();	
		}
		public void simulate() throws RuleException {
			OrderHandler handler = init.getHandler();

			while (handler.hasMoreOrders()) {
				handler.executeAnOrder();
			}
		}

}
