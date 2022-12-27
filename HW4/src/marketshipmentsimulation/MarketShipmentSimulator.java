package marketshipmentsimulation;

import marketshipment.classes.*;

public class MarketShipmentSimulator {
	private Initializer init;
		
		public MarketShipmentSimulator(){
			init = new Initializer();	
		}
		public Initializer getInitializer(){//DEBUG REASONS
			return init;
		}

}
