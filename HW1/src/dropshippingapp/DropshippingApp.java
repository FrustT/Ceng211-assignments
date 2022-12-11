package dropshippingapp;

import dropshipping.classes.*;

/**
 * While initializing Display,Display's Constructor calls dropshipping.Initializer class for creating an object that holds the data.
 * Then calls Display Class's executeQueries() method which uses Initializer Class's data for queries.
 *
 * @author  Mustafa Fatih Can 280201007
 * @author  Deniz Kaya 280201033
 * @author  Hakan Uskan 280201076
 * @author  Burak Erinç 290201099
 */

public class DropshippingApp {

	public static void main(String[] args) {
		Display output = new Display();
		output.executeQueries();
	}

}
