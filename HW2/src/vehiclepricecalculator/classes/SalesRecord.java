package vehiclepricecalculator.classes;

import java.util.ArrayList;

	/**
	 * This Class's responsibility is to return vehicles Objects as list 
	 * <ul>
	 * <li><strong>vehicleArrayList</strong> type: ArrayList<Vehicle>
	 * </ul>
	 * @author  Mustafa Fatih Can 280201007
	 * @author  Deniz Kaya 280201033
	 * @author  Hakan Uskan 280201076
	 * @author  Burak Erinç 290201099
	 */
public class SalesRecord {
	private ArrayList<Vehicle> vehicleArrayList;
	
	/**
	 * <strong>Parameterized Constructor</strong><p>
	 * Constructs SalesRecord Object with required data.
	 * @param _arrayList
	 */
	public SalesRecord(ArrayList<Vehicle> _arrayList) {
		this.vehicleArrayList = this.copyArrayListOfVehicles(_arrayList);
	}
	
	/**
    	* Gets the all Sedan Object's from vehicle list as ArrayList as considering privacy leak.
    	*
    	* @return ArrayList<Vehicle> All Sedan Object's as ArrayList.
	*/
	public ArrayList<Vehicle> getSedansAsArrayList() {
		
		ArrayList<Vehicle> sedanArrayList = new ArrayList<Vehicle>();
		
		for (Vehicle vehicle : vehicleArrayList){
			if(vehicle.getVehicleID().substring(0, 1).equals("S")){
				sedanArrayList.add(new SedanVehicle((SedanVehicle) vehicle));
			}
		}
		
		return sedanArrayList;
	}
	
	/**
    	* Gets the all Bicycle Object's from vehicle list as ArrayList as considering privacy leak.
    	*
    	* @return ArrayList<Vehicle> All Bicycle Object's as ArrayList.
	*/
	public ArrayList<Vehicle> getBicyclesAsArrayList() {
		
		ArrayList<Vehicle> bicycleArrayList = new ArrayList<Vehicle>();
		
		for (Vehicle vehicle : vehicleArrayList){
			if(vehicle.getVehicleID().substring(0, 1).equals("B")){
				bicycleArrayList.add(new BicycleVehicle((BicycleVehicle) vehicle));
			}
		}
		
		return bicycleArrayList;
	}
	
	/**
    	* Gets the all Hatchback Object's from vehicle list as ArrayList as considering privacy leak.
    	*
    	* @return ArrayList<Vehicle> All Hatchback Object's as ArrayList.
	*/
	public ArrayList<Vehicle> getHatchbacksAsArrayList() {
		
		ArrayList<Vehicle> hatchbackArrayList = new ArrayList<Vehicle>();
		
		for (Vehicle vehicle : vehicleArrayList){
			if(vehicle.getVehicleID().substring(0, 1).equals("H")){
				hatchbackArrayList.add(new HatchbackVehicle((HatchbackVehicle) vehicle));
			}
		}
		
		return hatchbackArrayList;
	}
	
	/**
    	* Gets the all Minivan Object's from vehicle list as ArrayList as considering privacy leak.
    	*
    	* @return ArrayList<Vehicle> All Minivan Object's as ArrayList.
	*/
	public ArrayList<Vehicle> getMinivansAsArrayList() {
		
		ArrayList<Vehicle> minivanArrayList = new ArrayList<Vehicle>();
		
		for (Vehicle vehicle : vehicleArrayList){
			if(vehicle.getVehicleID().substring(0, 1).equals("M")){
				minivanArrayList.add(new MinivanVehicle((MinivanVehicle) vehicle));
			}
		}
		
		return minivanArrayList;
	}
	
	/**
    	* Gets the all Pickup Truck Object's from vehicle list as ArrayList as considering privacy leak.
    	*
    	* @return ArrayList<Vehicle> All Pickup Truck Object's as ArrayList.
	*/
	public ArrayList<Vehicle> getPickupTrucksAsArrayList() {
		
		ArrayList<Vehicle> pickupTruckArrayList = new ArrayList<Vehicle>();
		
		for (Vehicle vehicle : vehicleArrayList){
			if(vehicle.getVehicleID().substring(0, 1).equals("P")){
				pickupTruckArrayList.add(new PickupTruckVehicle((PickupTruckVehicle) vehicle));
			}
		}
		
		return pickupTruckArrayList;
	}
	
	/**
	 * Gets the all Vehicle Object's list as ArrayList as considering privacy leak.
	 *
	 * @return ArrayList<Vehicle> All Vehicle Object's as ArrayList.
	 */
	public ArrayList<Vehicle> getVehicleArrayList(){
		return copyArrayListOfVehicles(this.vehicleArrayList);
	}
	
	/**
	 * Sets the Vehicle ArrayList with input validation.
	 * 
	 * @param _arrayList ArrayList of all Vehicle Object's.
	 */
	public void setVehicleArrayList(ArrayList<Vehicle> _arrayList) {
		if(_arrayList == null) {
			System.out.println("SalesRecord.setVehicleArrayList.Given arraylist is null");
			System.exit(0);
		}
		this.vehicleArrayList = copyArrayListOfVehicles(_arrayList);
	}
	
   /**
    * Gets the copy of given ArrayList as considering privacy leak.
    *
    * @param _vehicleArray ArrayList<Vehicle> Arraylist of vehicles.
	*/
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