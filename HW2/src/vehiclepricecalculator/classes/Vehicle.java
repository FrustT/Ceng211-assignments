package vehiclepricecalculator.classes;

import java.util.Locale;
import java.time.Month;

import vehiclepricecalculator.interfaces.VehicleInterface;

public abstract class Vehicle implements VehicleInterface {

	private enum CityName {
		IZMIR, ISTANBUL, ANKARA
	};

	private String vehicleId;
	private Month monthOfSale;
	private CityName cityOfSale;
	private int productionYear;
	private int valueAddedTax;

	/**
	 * <b>No Argument Constructor</b>
	 */
	public Vehicle() {
		this("None", "", "", 0, 0);// null needs to be checked
	}

	/**
	 * <b>Copy Constructor</b>
	 */
	public Vehicle(Vehicle _vehicle) {
		this(_vehicle.getVehicleID(), _vehicle.getMonthOfSale(), _vehicle.getCityOfSale(),
				_vehicle.getProductionYearOfVehicle(), _vehicle.getValueAddedTax());
	}

	/**
	 * <b>Parameterized Constructor</b>
	 */
	public Vehicle(String _vehicleId, String _monthOfSale, String _cityOfSale, int _productionYear,
			int _valueAddedTax) {
		this.setVehicleID(_vehicleId);
		this.setMonthOfSale(_monthOfSale);
		this.setCityOfSale(_cityOfSale);
		this.setProductionYearOfVehicle(_productionYear);
		this.setValueAddedTax(_valueAddedTax);
	}

	public void setVehicleID(String _ID) {
		if (_ID.length() != 4) {
			System.out.println("The vehicle id is invalid.");
			System.exit(0);
		}
		this.vehicleId = _ID;
	}

	public String getVehicleID() {
		return this.vehicleId;
	}

	public void setMonthOfSale(String _monthOfSale) {
		_monthOfSale = _monthOfSale.toUpperCase(Locale.ROOT);
		this.monthOfSale = Month.valueOf(_monthOfSale);
	}

	public String getMonthOfSale() {
		return this.monthOfSale.toString();
	}

	public void setCityOfSale(String _cityOfSale) {
		_cityOfSale = _cityOfSale.toUpperCase(Locale.ROOT);
		CityName city = CityName.valueOf(_cityOfSale);
		this.cityOfSale = city;
	}

	public String getCityOfSale() {
		return this.cityOfSale.toString();
	}

	public void setProductionYearOfVehicle(int _year) {
		if (_year < 2001 || _year > 2022) {
			System.out.println("Invalid production year");
			System.exit(0);
		} else {
			this.productionYear = _year;
		}

	}

	public int getProductionYearOfVehicle() {
		return this.productionYear;
	}

	public void setValueAddedTax(int _valueAddedTax) {
		if (_valueAddedTax < 0) {
			System.out.println("The VAT must be equal to or greater than zero.");
			System.exit(0);
		}
		this.valueAddedTax = _valueAddedTax;
	}

	public int getValueAddedTax() {
		return valueAddedTax;
	}

	public abstract double calculateSCT();

	public abstract double calculateTotalPrice();

	public String toString() {
		return "Vehicle ID:" + getVehicleID() + "  // Month:" + getMonthOfSale() + " // City:" + getCityOfSale()
				+ "  // Production Year:" + getProductionYearOfVehicle() + " // SCT:"+ calculateSCT() +" // Total Price: " + calculateTotalPrice();
	}

	public boolean equals(Object _object) {
		if (_object == null)
			return false;
		if (this.getClass() != _object.getClass())
			return false;
		Vehicle _vehicle = (Vehicle) _object;
		return _vehicle.getVehicleID().equals(this.getVehicleID())
				&& _vehicle.getMonthOfSale().equals(this.getMonthOfSale())
				&& _vehicle.getCityOfSale().equals(this.getCityOfSale())
				&& _vehicle.getProductionYearOfVehicle() == this.getProductionYearOfVehicle()
				&& _vehicle.getValueAddedTax() == this.getValueAddedTax();
	}

	/*
	 * public boolean equals(Vehicle _vehicle) { if (_vehicle == null)return false;
	 * if(this.getClass() != _vehicle.getClass())return false; return
	 * _vehicle.getVehicleID().equals(this.getVehicleID()) &&
	 * _vehicle.getMonthOfSale().equals(this.getMonthOfSale()) &&
	 * _vehicle.getCityOfSale().equals(this.getCityOfSale()) &&
	 * _vehicle.getProductionYearOfVehicle() == this.getProductionYearOfVehicle() &&
	 * _vehicle.getValueAddedTax() == this.getValueAddedTax(); }
	 */

	protected double getMonthOfSaleSCTValue() {
		switch (this.monthOfSale) {
		case AUGUST:
			return 0.5;
		case DECEMBER:
			return 0.7;
		case JANUARY:
			return 0.3;
		case MAY:
			return 0.4;
		case OCTOBER:
			return 0.6;
		default:
			return -1.0;
		}
	}

	protected double getProductionYearSCTValue() {
		double productionYearSCTValue = 0.0;
		int year = this.getProductionYearOfVehicle();
		if (year >= 2001 && year <= 2008) {
			productionYearSCTValue = 1.0;
		} else if (year >= 2012 && year <= 2017) {
			productionYearSCTValue = 1.2;
		} else if (year >= 2018 && year <= 2022) {
			productionYearSCTValue = 1.6;
		} else {
			System.out.println("Invalid year value");
			System.exit(0);
		}
		return productionYearSCTValue;
	}
	/*
	 * protected double getProductionYearSCTValue(){ DateTimeFormatter formatter =
	 * DateTimeFormatter.ofPattern("uuuu"); int year productionYear.getYear();
	 * if(year.isAfter(Year.parse("2001").atDay(1)) &&
	 * year.isBefore(Year.parse("2008").atDay(1))){
	 * 
	 * } else if (year.isAfter(Year.parse("2012").atDay(1)) &&
	 * year.isBefore(Year.parse("2017").atDay(1))){
	 * 
	 * } else if (year.isAfter(Year.parse("2018").atDay(1)) &&
	 * year.isBefore(Year.parse("2022").atDay(1))){
	 * 
	 * } }
	 */
}
