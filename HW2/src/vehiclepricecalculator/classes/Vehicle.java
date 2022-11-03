package vehiclepricecalculator.classes;

import java.time.LocalDate;

import vehiclepricecalculator.interfaces.VehicleInterface;

public class Vehicle implements VehicleInterface {

	private String vehicleId;
	private String cityOfSale;
	private LocalDate monthOfSale;
	private LocalDate productionYear;
	
	/**
	 * <b>No Argument Constructor</b>
	 */
	public Vehicle() {
		this("", "", null, null);//null needs to be checked
	}
	
	/**
	 * <b>Copy Constructor Constructor</b>
	 */
	public Vehicle(Vehicle _vehicle) {
		this(_vehicle.getVehicleID(), _vehicle.getCityOfSale(), _vehicle.getMonthOfSale(), _vehicle.getProductionYearOfVehicle());
	}
	/**
	 * <b>Parameterized Constructor</b>
	 */
	public Vehicle(String _vehicleId, String _cityOfSale, LocalDate _monthOfSale, LocalDate _productionYear) {
		//TODO input Validity must be addded
		this.vehicleId = _vehicleId;
		this.cityOfSale = _cityOfSale;
		this.monthOfSale = _monthOfSale;
		this.productionYear = _productionYear;
	}
	
	
	public void setVehicleID(String _ID) {
		//TODO Input Validity must be added
		this.vehicleId = _ID;
	}

	
	public String getVehicleID() {
		return this.vehicleId;
	}

	
	public void setCityOfSale(String _cityOfSale) {
		// TODO Input Validity
		this.vehicleId = _cityOfSale;

	}

	
	public String getCityOfSale() {
		return this.cityOfSale;
	}

	
	public void setMonthOfSale(LocalDate _monthOfSale) {
		this.monthOfSale = _monthOfSale;
		

	}

	
	public LocalDate getMonthOfSale() {
		return this.monthOfSale;//TODO implement a deep copy method
	}

	
	public void setProductionYearOfVehicle(LocalDate _year) {
		this.productionYear = _year;

	}

	
	public LocalDate getProductionYearOfVehicle() {
		return this.productionYear;//TODO implement a deep copy method
	}

}
