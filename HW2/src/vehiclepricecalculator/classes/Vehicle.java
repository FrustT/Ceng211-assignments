package vehiclepricecalculator.classes;

import java.time.LocalDate;
import java.util.Locale;

import vehiclepricecalculator.interfaces.VehicleInterface;

public class Vehicle implements VehicleInterface {
	
	public enum CityName{IZMIR, ISTANBUL, ANKARA};

	private String vehicleId;
	private LocalDate monthOfSale;
	private CityName cityOfSale;
	private LocalDate productionYear;
	private int valueAddedTax;
	
	/**
	 * <b>No Argument Constructor</b>
	 */
	public Vehicle() {
		this("", null, null, null, 0);//null needs to be checked
	}
	
	/**
	 * <b>Copy Constructor Constructor</b>
	 */
	public Vehicle(Vehicle _vehicle) {
		this(_vehicle.getVehicleID(), _vehicle.getMonthOfSale(), _vehicle.getCityOfSale(), _vehicle.getProductionYearOfVehicle(), _vehicle.getValueAddedTax());
	}
	
	/**
	 * <b>Parameterized Constructor</b>
	 */
	public Vehicle(String _vehicleId, LocalDate _monthOfSale, String _cityOfSale, LocalDate _productionYear, int _valueAddedTax) {
		//TODO input Validity must be added
		this.setVehicleID(_vehicleId);
		this.setMonthOfSale(_monthOfSale);
		this.setCityOfSale(_cityOfSale);
		this.setProductionYearOfVehicle(_productionYear);
		this.setValueAddedTax(_valueAddedTax);
	}
	
	
	public void setVehicleID(String _ID) {
		if (_ID.length()==4)
		{
			System.out.println("The vehicle id is invalid.");
			System.exit(0);
		}
		this.vehicleId = _ID;
	}
	
	public String getVehicleID() {
		return this.vehicleId;
	}
	
	public void setMonthOfSale(LocalDate _monthOfSale) {
		this.monthOfSale = _monthOfSale;
	}
	
	public LocalDate getMonthOfSale() {
		return this.monthOfSale;
	}
	
	public void setCityOfSale(String _cityOfSale) {
		_cityOfSale = _cityOfSale.toUpperCase(Locale.ROOT);
		CityName city = CityName.valueOf(_cityOfSale);
		this.cityOfSale = city;
	}
	
	public String getCityOfSale() {
		return this.cityOfSale.toString();
	}
	
	public void setProductionYearOfVehicle(LocalDate _year) {
		this.productionYear = _year;
	}
	
	public LocalDate getProductionYearOfVehicle() {
		return this.productionYear;
	}

	public void setValueAddedTax(int _valueAddedTax) {
		if (_valueAddedTax < 0){
			System.out.println("The VAT must be equal to or greater than zero.");
			System.exit(0);
		}
		this.valueAddedTax = _valueAddedTax;
	}
		
	public int getValueAddedTax() {
			return valueAddedTax;
		}
	//Will be overrided in every subclass.If not, will return -1.
	public double calculateSCT() {
		double error = -1.0;
		return error;
	}
	//Will be overrided in every subclass.If not, will return -1.
	public double calculateTotalPrice() {
		double error = -1.0;
		return error;
	}
	public String toString() {//TODO
		return "";
	}
	public boolean equals() {//TODO
		return false;
	}
}
