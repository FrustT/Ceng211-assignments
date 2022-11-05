package vehiclepricecalculator.classes;

import java.time.LocalDate;
import vehiclepricecalculator.interfaces.VehicleInterface;

public class Vehicle implements VehicleInterface {

	private String vehicleId;
	private LocalDate monthOfSale;
	private String cityOfSale; //bu enum olabilir aslında, denedim interface ağladı amk sikicem enumunu da
	private LocalDate productionYear;
	private int valudeAddedTax;
	
	/**
	 * <b>No Argument Constructor</b>
	 */
	public Vehicle() {
		this("", null, "", null, 0);//null needs to be checked
	}
	
	/**
	 * <b>Copy Constructor Constructor</b>
	 */
	public Vehicle(Vehicle _vehicle) {
		this(_vehicle.getVehicleID(), _vehicle.getMonthOfSale(), _vehicle.getCityOfSale(), _vehicle.getProductionYearOfVehicle(), _vehicle.getValudeAddedTax());
	}
	
	/**
	 * <b>Parameterized Constructor</b>
	 */
	public Vehicle(String _vehicleId, LocalDate _monthOfSale, String _cityOfSale, LocalDate _productionYear, int _valueAddedTax) {
		//TODO input Validity must be added
		this.vehicleId = _vehicleId;
		this.monthOfSale = _monthOfSale;
		this.cityOfSale = _cityOfSale;
		this.productionYear = _productionYear;
		this.valudeAddedTax = _valueAddedTax;
	}
	
	
	public void setVehicleID(String _ID) {
		if (_ID.length()==4)
		{
			this.vehicleId = _ID;
		}
		
		else 
		{
			System.out.println("The vehicle id is invalid.");
			System.exit(0);
		}
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
		if (_cityOfSale.equals("Izmir") || _cityOfSale.equals("Ankara") || _cityOfSale.equals("Istanbul"))
		{
			this.vehicleId = _cityOfSale;
		}
		
		else
		{
			System.out.println("Invalid city.");
			System.exit(0);
		}
	}
	
	public String getCityOfSale() {
		return this.cityOfSale;
	}
	
	public void setProductionYearOfVehicle(LocalDate _year) {
		this.productionYear = _year;
	}
	
	public LocalDate getProductionYearOfVehicle() {
		return this.productionYear;
	}

	public void setValudeAddedTax(int _valudeAddedTax) {
		if (_valudeAddedTax >= 0)
		{
			this.valudeAddedTax = _valudeAddedTax;
		}
		
		else 
		{
			System.out.println("The VAT must be equal or greater than zero.");
			System.exit(0);
		}
	}
		
	public int getValudeAddedTax() {
			return valudeAddedTax;
		}
}
