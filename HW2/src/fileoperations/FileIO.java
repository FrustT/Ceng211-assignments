/**
 * 
 */
package fileoperations;

import vehiclepricecalculator.classes.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author mal burak kim yazdı bunu hakan yazdı mal hakan çocuklar sataşmayın
 *
 */
public class FileIO {
	public static ArrayList<Vehicle> getAllSalesAsArrayList() {
		ArrayList<Vehicle> vehicleArrayList = new ArrayList<Vehicle>();
		try {
			File file = new File("Files/HW2_SoldVehicles.csv");
			Scanner scanner = new Scanner(file);
			
			while (scanner.hasNextLine()) {
				StringTokenizer tokenizer = new StringTokenizer(scanner.nextLine(), ",");
				String ID = tokenizer.nextToken();
				String firstLetter = ID.substring(0, 1);
				switch (firstLetter) {
					
				case "B":
					String b_monthOfSale = tokenizer.nextToken();
					String b_cityOfSale = tokenizer.nextToken();
					int b_productionYear = Integer.parseInt(tokenizer.nextToken());
					String b_chainType = tokenizer.nextToken();
					String b_seatPost = tokenizer.nextToken();
					int b_valueAddedTax = Integer.parseInt(tokenizer.nextToken());
					Vehicle bicycle = new BicycleVehicle(ID, b_monthOfSale, b_cityOfSale, b_productionYear,
							b_valueAddedTax, b_chainType, b_seatPost);
					vehicleArrayList.add(bicycle);
					break;
					
				case "S":
					String s_monthOfSale = tokenizer.nextToken();
					String s_cityOfSale = tokenizer.nextToken();
					int s_productionYear = Integer.parseInt(tokenizer.nextToken());
					String s_roofType = tokenizer.nextToken();
					double s_engineVolume = Double.parseDouble(tokenizer.nextToken());
					int s_valueAddedTax = Integer.parseInt(tokenizer.nextToken());
					Vehicle sedan = new SedanVehicle(ID, s_monthOfSale, s_cityOfSale, s_productionYear, s_valueAddedTax,
							s_roofType, s_engineVolume);
					vehicleArrayList.add(sedan);
					break;
					
				case "H":
					String h_monthOfSale = tokenizer.nextToken();
					String h_cityOfSale = tokenizer.nextToken();
					int h_productionYear = Integer.parseInt(tokenizer.nextToken());
					String cityMode = tokenizer.nextToken();
					boolean h_cityMode;
					if (cityMode.equals("yes")) {
						h_cityMode = true;
					} else{
						h_cityMode = false;
					}
					double h_engineVolume = Double.parseDouble(tokenizer.nextToken());
					int h_valueAddedTax = Integer.parseInt(tokenizer.nextToken());
					Vehicle hatchback = new HatchbackVehicle(ID, h_monthOfSale, h_cityOfSale, h_productionYear, h_valueAddedTax, h_cityMode, h_engineVolume);
					vehicleArrayList.add(hatchback);
					break;
					
				case "M":
					String m_monthOfSale = tokenizer.nextToken();
					String m_cityOfSale = tokenizer.nextToken();
					int m_productionYear = Integer.parseInt(tokenizer.nextToken());
					int m_numberOfSeat = Integer.parseInt(tokenizer.nextToken());
					double m_engineVolume = Double.parseDouble(tokenizer.nextToken());
					int m_valueAddedTax = Integer.parseInt(tokenizer.nextToken());
					Vehicle minivan = new MinivanVehicle(ID, m_monthOfSale, m_cityOfSale, m_productionYear, m_valueAddedTax, m_numberOfSeat, m_engineVolume);
					vehicleArrayList.add(minivan);
					break;
					
				case "P":
					String p_monthOfSale = tokenizer.nextToken();
					String p_cityOfSale = tokenizer.nextToken();
					int p_productionYear = Integer.parseInt(tokenizer.nextToken());
					String p_cabType = tokenizer.nextToken();
					String p_truckBedType = tokenizer.nextToken();
					int p_valueAddedTax = Integer.parseInt(tokenizer.nextToken());
					Vehicle pickupTruck = new PickupTruckVehicle(ID, p_monthOfSale, p_cityOfSale, p_productionYear, p_valueAddedTax, p_cabType, p_truckBedType);
					vehicleArrayList.add(pickupTruck);
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