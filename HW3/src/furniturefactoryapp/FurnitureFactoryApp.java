package furniturefactoryapp;

/**
 * App's main method initializes an Simulator object which has-a Initializer
 * Object in it. So , Simulator is our layer between client and calculation
 * layer
 *
 * @author Mustafa Fatih Can 280201007
 * @author Deniz Kaya 280201033
 * @author Hakan Uskan 280201076
 * @author Burak Erinç 290201099
 */
public class FurnitureFactoryApp {

	public static void main(String[] args) {
		Simulator sim = new Simulator();
		sim.simulate();

	}
}
