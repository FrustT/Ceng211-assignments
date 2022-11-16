package vehiclepricecalculatorapp;

import java.util.ArrayList;
import java.util.Scanner;

import vehiclepricecalculator.classes.*;

	/**
	 * This Class's responsibility is printing all the Queries returned from the <b>SalesRecord</b> Class
	 * <ul>
	 * <li><strong>salesRecord</strong> type: SalesRecord
	 * </ul>
	 * @author  Mustafa Fatih Can 280201007
	 * @author  Deniz Kaya 280201033
	 * @author  Hakan Uskan 280201076
	 * @author  Burak Erinç 290201099
	 */

public class UserInterface {
	
	private SalesRecord salesRecord;
	
	/**
	 * <strong>No Argument Constructor</strong><p>
	 * Creates an initializer object with its no argument constructor and initializes the salesRecord instance variable.
	 */
	
	public UserInterface() {
		Initializer initializer = new Initializer();
		this.salesRecord = initializer.getSalesRecord();
	}
	
	public void printUI(){
		
		int choice;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("Please press, ");
			System.out.println("1 to see all sold vehicle list");
			System.out.println("2 to see sold sedan list");
			System.out.println("3 to see sold hatchback list");
			System.out.println("4 to see sold minivan list");
			System.out.println("5 to see sold pickup truck list");
			System.out.println("6 to see sold bicycle list");
			System.out.println("0 to exit");
			System.out.println("Please enter your choice: ");
			choice = scanner.nextInt();
			while (choice < 0 || choice > 6) {
				System.out.println("Invalid input, try again");
				choice = scanner.nextInt();
			}
			printRequiredList(choice);
		} 
		while(choice != 0);
		scanner.close();
		System.out.println("Exiting...");
	}
	
	private void printRequiredList(int _choice) {
		switch(_choice) {
		case 0:
			return;
		case 1:
			printArrayList(this.salesRecord.getVehicleArrayList());
			break;
		case 2:
			printArrayList(this.salesRecord.getSedansAsArrayList());
			break;
		case 3:
			printArrayList(this.salesRecord.getHatchbacksAsArrayList());
			break;
		case 4:
			printArrayList(this.salesRecord.getMinivansAsArrayList());
			break;
		case 5:
			printArrayList(this.salesRecord.getPickupTrucksAsArrayList());
			break;
		case 6:
			printArrayList(this.salesRecord.getBicyclesAsArrayList());
			break;
		default:
		    	System.out.println("Invalid input");
		    	break;
		}
	}
	
	private void printArrayList(ArrayList<Vehicle> _arrayList) {
		for(Vehicle vehicle: _arrayList) {
			System.out.println(vehicle);
		}
	}
	
}