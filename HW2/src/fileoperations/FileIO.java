package fileoperations;

import vehiclepricecalculator.classes.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This class handles all of the file reading operations of the program.
 * <p>
 * Reads the data that is used to initialize program's data holder class Initializer
 * 
 * <ul>
 * <li>{@link #getAllSalesAsArrayList() getAllSalesAsArrayList()}
 * </ul> 
 * @author  Mustafa Fatih Can 280201007
 * @author  Deniz Kaya 280201033
 * @author  Hakan Uskan 280201076
 * @author  Burak Erinc 290201099
 */
public class FileIO {
	
    /**
	* Gets the all vehicles from the csv file as ArrayList.
	*/
	public static ArrayList<Vehicle> getAllSalesAsArrayList() {
		ArrayList<Vehicle> vehicleArrayList = new ArrayList<Vehicle>();
		try {
			File file = new File("Files/HW2_SoldVehicles.csv");
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String newData = scanner.nextLine();
				String firstLetter = newData.substring(0,1);
				switch (firstLetter) {
				case "B":
					vehicleArrayList.add(VehicleBuilder.createBicycle(newData));
					break;
				case "S":
					vehicleArrayList.add(VehicleBuilder.createSedanVehicle(newData));
					break;
				case "H":
					vehicleArrayList.add(VehicleBuilder.createHatchbackVehicle(newData));
					break;
				case "M":
					vehicleArrayList.add(VehicleBuilder.createMinivanVehicle(newData));
					break;
				case "P":
					vehicleArrayList.add(VehicleBuilder.createPickupTruckVehicle(newData));
					break;
				default:
				    System.out.println("Invalid input");
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			e.printStackTrace();
			System.exit(0);
		}
		return vehicleArrayList;
	}
}