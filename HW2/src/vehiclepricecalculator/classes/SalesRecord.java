package vehiclepricecalculator.classes;

import java.util.ArrayList;

public class SalesRecord {
	private ArrayList<Vehicle> vehicleArrayList;
	
	public SalesRecord(ArrayList<Vehicle> _arrayList) {
		this.vehicleArrayList = this.copyArrayListOfVehicles(_arrayList);
	}
	
	public ArrayList<Vehicle> getSedansAsArrayList() {
		
		ArrayList<Vehicle> sedanArrayList = new ArrayList<Vehicle>();
		
		for (Vehicle vehicle : vehicleArrayList){
			if(vehicle.getVehicleID().substring(0, 1).equals("S")){
				sedanArrayList.add(new SedanVehicle((SedanVehicle) vehicle));
			}
		}
		
		return sedanArrayList;
	}
	
	public ArrayList<Vehicle> getBicyclesAsArrayList() {
		
		ArrayList<Vehicle> bicycleArrayList = new ArrayList<Vehicle>();
		
		for (Vehicle vehicle : vehicleArrayList){
			if(vehicle.getVehicleID().substring(0, 1).equals("B")){
				bicycleArrayList.add(new BicycleVehicle((BicycleVehicle) vehicle));
			}
		}
		
		return bicycleArrayList;
	}
	
	public ArrayList<Vehicle> getHatchbacksAsArrayList() {
		
		ArrayList<Vehicle> hatchbackArrayList = new ArrayList<Vehicle>();
		
		for (Vehicle vehicle : vehicleArrayList){
			if(vehicle.getVehicleID().substring(0, 1).equals("H")){
				hatchbackArrayList.add(new HatchbackVehicle((HatchbackVehicle) vehicle));
			}
		}
		
		return hatchbackArrayList;
	}
	
	public ArrayList<Vehicle> getMinivansAsArrayList() {
		
		ArrayList<Vehicle> minivanArrayList = new ArrayList<Vehicle>();
		
		for (Vehicle vehicle : vehicleArrayList){
			if(vehicle.getVehicleID().substring(0, 1).equals("M")){
				minivanArrayList.add(new MinivanVehicle((MinivanVehicle) vehicle));
			}
		}
		
		return minivanArrayList;
	}
	
	public ArrayList<Vehicle> getPickupTrucksAsArrayList() {
		
		ArrayList<Vehicle> pickupTruckArrayList = new ArrayList<Vehicle>();
		
		for (Vehicle vehicle : vehicleArrayList){
			if(vehicle.getVehicleID().substring(0, 1).equals("P")){
				pickupTruckArrayList.add(new PickupTruckVehicle((PickupTruckVehicle) vehicle));
			}
		}
		
		return pickupTruckArrayList;
	}
	
	public ArrayList<Vehicle> getVehicleArrayList(){
		return copyArrayListOfVehicles(this.vehicleArrayList);
	}
	
	public void setVehicleArrayList(ArrayList<Vehicle> _arrayList) {
		if(_arrayList == null) {
			System.out.println("SalesRecord.setVehicleArrayList.Given arraylist is null");
			System.exit(0);
		}
		this.vehicleArrayList = copyArrayListOfVehicles(_arrayList);
	}
	
	private ArrayList<Vehicle> copyArrayListOfVehicles(ArrayList<Vehicle> _vehicleArray){
		ArrayList<Vehicle> vehicleArrayList = new ArrayList<Vehicle>();
		for (Vehicle _vehicle : _vehicleArray){
			if (_vehicle == null){
				System.out.println("Null pointer exception while copying arraylist");
				System.exit(0);
			}
			Vehicle copiedVehicle;
			String vehicleType = _vehicle.getVehicleID().substring(0, 1);
			
			switch(vehicleType) {
			case ("B"):
				copiedVehicle = new BicycleVehicle((BicycleVehicle) _vehicle);
				break;
			case ("H"):
				copiedVehicle = new HatchbackVehicle((HatchbackVehicle) _vehicle);
				break;
			case ("M"):
				copiedVehicle = new MinivanVehicle((MinivanVehicle) _vehicle);
				break;
			case ("P"):
				copiedVehicle = new PickupTruckVehicle((PickupTruckVehicle) _vehicle);
				break;
			case ("S"):
				copiedVehicle = new SedanVehicle((SedanVehicle) _vehicle);
				break;
			default:
				copiedVehicle = null;
			}
		vehicleArrayList.add(copiedVehicle);
		}
		return vehicleArrayList;
	}
}