package vehiclepricecalculator.classes;

import java.util.StringTokenizer;

public class VehicleBuilder {
	
    /**
   	 * Creates an Sedan object according to the String data 
     * given in the specific order(ID,monthOfSale,cityOfSale,productionYear,chainType,seatPost,valueAddedTax)
   	 * @param data String The data about bicycle. 
   	 * @return	BicycleVehicle bicycle object.
   	 */
	public static Vehicle createBicycle(String data) {
		StringTokenizer tokenizer = new StringTokenizer(data, ",");
		String ID = tokenizer.nextToken();
		String monthOfSale = tokenizer.nextToken();
		String cityOfSale = tokenizer.nextToken();
		int productionYear = Integer.parseInt(tokenizer.nextToken());
		String chainType = tokenizer.nextToken();
		String seatPost = tokenizer.nextToken();
		int valueAddedTax = Integer.parseInt(tokenizer.nextToken());
		return new BicycleVehicle(ID, monthOfSale, cityOfSale, productionYear, valueAddedTax, chainType,
				seatPost);
	}
	
	/**
     * Creates an Sedan object according to the String data 
     * given in the specific order(ID,monthOfSale,cityOfSale,productionYear,roofType,engineVolume,valueAddedTax)
     * @param data String The data about sedan. 
     * @return SedanVehicle sedan object.
     */
	public static Vehicle createSedanVehicle(String data) {
		StringTokenizer tokenizer = new StringTokenizer(data, ",");
		String ID = tokenizer.nextToken();
		String monthOfSale = tokenizer.nextToken();
		String cityOfSale = tokenizer.nextToken();
		int productionYear = Integer.parseInt(tokenizer.nextToken());
		String roofType = tokenizer.nextToken();
		double engineVolume = Double.parseDouble(tokenizer.nextToken());
		int valueAddedTax = Integer.parseInt(tokenizer.nextToken());
		return new SedanVehicle(ID, monthOfSale, cityOfSale, productionYear, valueAddedTax, roofType,
				engineVolume);
	}
	
	/**
	 * Creates an Hatchbakc object according to the String data 
	 * given in the specific order(ID,monthOfSale,cityOfSale,productionYear,cityMode,engineVolume,valueAddedTax)
	 * @param data String The data about hatchback. 
	 * @return HatchbackVehicle hatchback object.
	 */
	public static Vehicle createHatchbackVehicle(String data) {
		StringTokenizer tokenizer = new StringTokenizer(data, ",");
		String ID = tokenizer.nextToken();
		String monthOfSale = tokenizer.nextToken();
		String cityOfSale = tokenizer.nextToken();
		int productionYear = Integer.parseInt(tokenizer.nextToken());
		boolean cityMode = tokenizer.nextToken().equals("yes");
		double engineVolume = Double.parseDouble(tokenizer.nextToken());
		int valueAddedTax = Integer.parseInt(tokenizer.nextToken());
		return new HatchbackVehicle(ID, monthOfSale, cityOfSale, productionYear, valueAddedTax, cityMode,
				engineVolume);
	}
	
	/**
   	 * Creates an Minivan object according to the String data 
         * given in the specific order(ID,monthOfSale,cityOfSale,productionYear,numberOfSeat,engineVolume,valueAddedTax)
   	 * @param  data String The data about minivan. 
   	 * @return	MinivanVehicle minivan object.
   	 */
	public static Vehicle createMinivanVehicle(String data) {
		StringTokenizer tokenizer = new StringTokenizer(data, ",");
		String ID = tokenizer.nextToken();
		String monthOfSale = tokenizer.nextToken();
		String cityOfSale = tokenizer.nextToken();
		int productionYear = Integer.parseInt(tokenizer.nextToken());
		int numberOfSeat = Integer.parseInt(tokenizer.nextToken());
		double engineVolume = Double.parseDouble(tokenizer.nextToken());
		int valueAddedTax = Integer.parseInt(tokenizer.nextToken());
		return new MinivanVehicle(ID, monthOfSale, cityOfSale, productionYear, valueAddedTax, numberOfSeat,
				engineVolume);
	}
	
	/**
   	 * Creates an Pickup Truck object according to the String data 
         * given in the specific order(ID,monthOfSale,cityOfSale,productionYear,cabType,truckBedType,valueAddedTax)
   	 * @param  data String The data about pickup truck.
   	 * @return	BicycleVehicle bicycle object.
   	 */
	public static Vehicle createPickupTruckVehicle(String data) {
		StringTokenizer tokenizer = new StringTokenizer(data, ",");
		String ID = tokenizer.nextToken();
		String monthOfSale = tokenizer.nextToken();
		String cityOfSale = tokenizer.nextToken();
		int productionYear = Integer.parseInt(tokenizer.nextToken());
		String cabType = tokenizer.nextToken();
		String truckBedType = tokenizer.nextToken();
		int valueAddedTax = Integer.parseInt(tokenizer.nextToken());
		return new PickupTruckVehicle(ID, monthOfSale, cityOfSale, productionYear, valueAddedTax,
				cabType, truckBedType);
	}
}
