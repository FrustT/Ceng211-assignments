package marketshipmentsimulation;

import marketshipment.exceptions.RuleException;
/**
 * This is the main class of this project. Its only purpose is to create a simulator and simulate.
 * 
 * @author Mustafa Fatih Can 280201007
 * @author Deniz Kaya 280201033
 * @author Hakan Uskan 280201076
 * @author Burak Erinç 290201099
 */
public class MarketShipmentApp {
	public static void main(String[] args) throws RuleException {

		MarketShipmentSimulator simulator = new MarketShipmentSimulator();
		simulator.simulate();
		
	}
}
