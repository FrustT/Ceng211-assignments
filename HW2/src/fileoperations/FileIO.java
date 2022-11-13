package fileoperations;

import vehiclepricecalculator.classes.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * 
 *
 */
public class FileIO {
	
	public static ArrayList<Vehicle> getAllSalesAsArrayList() {
		ArrayList<Vehicle> vehicleArrayList = new ArrayList<Vehicle>();
		try {
			File file = new File("Files/HW2_SoldVehicles.csv");
			Scanner scanner = new Scanner(file);
			//Builder builder = new Builder();
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