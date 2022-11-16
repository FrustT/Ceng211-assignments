package vehiclepricecalculator.classes;

import java.util.Locale;
import java.time.Month;

import vehiclepricecalculator.interfaces.VehicleInterface;

    /**
	 * This Class is not a concrete implementation and has most general description about implementations.
	 * We will spesify them later in creation of the classes
	 * <ul>
	 * <li><strong>CityName {IZMIR, ISTANBUL, ANKARA}</strong> type: enum
	 * <li><strong>vehicleId</strong> type: String
	 * <li><strong>monthOfSale</strong> type: Month
	 * <li><strong>cityOfSale</strong> type: CityName
	 * <li><strong>productionYear</strong> type: int
	 * <li><strong>valueAddedTax</strong> type: int
	 * <li><strong>BASE_PRICE</strong> type: int
	 * </ul>
	 * @author  Mustafa Fatih Can 280201007
	 * @author  Deniz Kaya 280201033
	 * @author  Hakan Uskan 280201076
	 * @author  Burak Erinç 290201099
	 */

public abstract class Vehicle implements VehicleInterface {

	private enum CityName {
		IZMIR, ISTANBUL, ANKARA
	}

	private String vehicleId;
	private Month monthOfSale;
	private CityName cityOfSale;
	private int productionYear;
	private int valueAddedTax;
	public final int BASE_PRICE;

	/**
	 * <b>No Argument Constructor</b>
	 */
	public Vehicle() {
		this("None", "", "", 0, 0);// null needs to be checked
	}

	/**
	 * <strong>Copy Constructor</strong><p>
	 * Constructs a new Vehicle Object with another Vehicle Object
	 * @param _vehicle
	 */
	public Vehicle(Vehicle _vehicle) {
		this(_vehicle.getVehicleID(), _vehicle.getMonthOfSale(), _vehicle.getCityOfSale(),
				_vehicle.getProductionYearOfVehicle(), _vehicle.getValueAddedTax());
	}

	/**
	 * <strong>Parameterized Constructor</strong><p>
	 * Constructs Vehicle Object with required data.
	 * @param _vehicleId
	 * @param _monthOfSale
	 * @param _cityOfSale
	 * @param _productionYear
	 * @param _valueAddedTax
	 */
	public Vehicle(String _vehicleId, String _monthOfSale, String _cityOfSale, int _productionYear,
			int _valueAddedTax) {
		this.setVehicleID(_vehicleId);
		this.setMonthOfSale(_monthOfSale);
		this.setCityOfSale(_cityOfSale);
		this.setProductionYearOfVehicle(_productionYear);
		this.setValueAddedTax(_valueAddedTax);
		this.BASE_PRICE = getBASE_PRICE();
	}

	public abstract int getBASE_PRICE();

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

	@Override
	public String toString() {
		return "Vehicle ID:" + getVehicleID() + "  // Month:" + getMonthOfSale() + " // City:" + getCityOfSale()
				+ "  // Production Year:" + getProductionYearOfVehicle() + " // SCT:" + calculateSCT()
				+ " // Total Price: " + calculateTotalPrice();
	}

	@Override
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
	
	/**
	 * Calculates the month of sale sct value of the vehicle according to its month of sale.
	 * @return double month of sale sct value
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
	
	/**
	 * Calculates the production year sct value of the vehicle according to its production year.
	 * @return int production year sct value.
	 */
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
}
