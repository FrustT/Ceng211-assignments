package vehiclepricecalculatorapp;


/**
 * While initializing UserInterface,UserInterface's Constructor calls vehiclepricecalculator.
 * Initializer class for creating an object that holds the data.
 * Then calls UserInterface Class's printUI() method which uses Initializer Class's data for queries.
 *
 * @author  Mustafa Fatih Can 280201007
 * @author  Deniz Kaya 280201033
 * @author  Hakan Uskan 280201076
 * @author  Burak Erinç 290201099
 */
public class VehiclePriceApp {
	public static void main(String[] args) {
		UserInterface UI = new UserInterface();
		UI.printUI();
	}
}