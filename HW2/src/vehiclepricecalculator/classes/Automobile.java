package vehiclepricecalculator.classes;

public abstract class Automobile extends Vehicle {
	public final int BASEPRICE = 200000;
	private double engineVolume;

	public Automobile() {
		super();
		this.engineVolume = 0.0;
	}

	public Automobile(String _vehicleId, String _monthOfSale, String _cityOfSale, int _productionYear,
			int _valueAddedTax, double _engineVolume) {
		super(_vehicleId, _monthOfSale, _cityOfSale, _productionYear, _valueAddedTax);
		this.engineVolume = _engineVolume;
	}

	public Automobile(Automobile _automobile) {
		super(_automobile);
		this.engineVolume = _automobile.engineVolume;
	}

	public double getEngineVolume() {
		return this.engineVolume;
	}

	public void setEngineVolume(double _engineVolume) {
		if (_engineVolume < 1 || _engineVolume > 2) {
			System.out.println("Invalid engine volume");
			System.exit(0);
		}
		this.engineVolume = _engineVolume;
	}

	public abstract double calculateSCT();

	public double calculateTotalPrice() {
		return (BASEPRICE) * (1.0 + calculateSCT() * 0.8) + (1.0 + getValueAddedTax() / 100.0);
	}

	public String toString() {
		return super.toString();
	}

	public boolean equals(Object _object) {
		if (super.equals(_object)) {
			Automobile automobile = (Automobile) _object;
			return this.getEngineVolume() == automobile.getEngineVolume();
		}
		return false;
	}
}
