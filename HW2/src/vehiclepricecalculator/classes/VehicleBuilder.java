package vehiclepricecalculator.classes;

import java.util.StringTokenizer;

public class VehicleBuilder {

	public static Vehicle createBicycle(String data) {
		StringTokenizer tokenizer = new StringTokenizer(data, ",");
		String ID = tokenizer.nextToken();
		String monthOfSale = tokenizer.nextToken();
		String cityOfSale = tokenizer.nextToken();
		int productionYear = Integer.parseInt(tokenizer.nextToken());
		String chainType = tokenizer.nextToken();
		String seatPost = tokenizer.nextToken();
		int valueAddedTax = Integer.parseInt(tokenizer.nextToken());
		Vehicle bicycle = new BicycleVehicle(ID, monthOfSale, cityOfSale, productionYear, valueAddedTax, chainType,
				seatPost);
		return bicycle;
	}

	public static Vehicle createSedanVehicle(String data) {
		StringTokenizer tokenizer = new StringTokenizer(data, ",");
		String ID = tokenizer.nextToken();
		String monthOfSale = tokenizer.nextToken();
		String cityOfSale = tokenizer.nextToken();
		int productionYear = Integer.parseInt(tokenizer.nextToken());
		String roofType = tokenizer.nextToken();
		double engineVolume = Double.parseDouble(tokenizer.nextToken());
		int valueAddedTax = Integer.parseInt(tokenizer.nextToken());
		Vehicle sedan = new SedanVehicle(ID, monthOfSale, cityOfSale, productionYear, valueAddedTax, roofType,
				engineVolume);
		return sedan;
	}

	public static Vehicle createHatchbackVehicle(String data) {
		StringTokenizer tokenizer = new StringTokenizer(data, ",");
		String ID = tokenizer.nextToken();
		String monthOfSale = tokenizer.nextToken();
		String cityOfSale = tokenizer.nextToken();
		int productionYear = Integer.parseInt(tokenizer.nextToken());
		boolean cityMode = tokenizer.nextToken().equals("yes") ? true : false;
		double engineVolume = Double.parseDouble(tokenizer.nextToken());
		int valueAddedTax = Integer.parseInt(tokenizer.nextToken());
		Vehicle hatchback = new HatchbackVehicle(ID, monthOfSale, cityOfSale, productionYear, valueAddedTax, cityMode,
				engineVolume);
		return hatchback;
	}

	public static Vehicle createMinivanVehicle(String data) {
		StringTokenizer tokenizer = new StringTokenizer(data, ",");
		String ID = tokenizer.nextToken();
		String monthOfSale = tokenizer.nextToken();
		String cityOfSale = tokenizer.nextToken();
		int productionYear = Integer.parseInt(tokenizer.nextToken());
		int numberOfSeat = Integer.parseInt(tokenizer.nextToken());
		double engineVolume = Double.parseDouble(tokenizer.nextToken());
		int valueAddedTax = Integer.parseInt(tokenizer.nextToken());
		Vehicle minivan = new MinivanVehicle(ID, monthOfSale, cityOfSale, productionYear, valueAddedTax, numberOfSeat,
				engineVolume);
		return minivan;
	}

	public static Vehicle createPickupTruckVehicle(String data) {
		StringTokenizer tokenizer = new StringTokenizer(data, ",");
		String ID = tokenizer.nextToken();
		String monthOfSale = tokenizer.nextToken();
		String cityOfSale = tokenizer.nextToken();
		int productionYear = Integer.parseInt(tokenizer.nextToken());
		String cabType = tokenizer.nextToken();
		String truckBedType = tokenizer.nextToken();
		int valueAddedTax = Integer.parseInt(tokenizer.nextToken());
		Vehicle pickupTruck = new PickupTruckVehicle(ID, monthOfSale, cityOfSale, productionYear, valueAddedTax,
				cabType, truckBedType);
		return pickupTruck;
	}
}
