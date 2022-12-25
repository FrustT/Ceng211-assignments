package marketshipment.classes;

public enum BoxCode {
	B1("Number box", 2), B2("Mass box", 3);
	
	private String name;
	private int cost;
	
	private BoxCode(String _name, int _cost) {
		name = _name;
		cost = _cost;
	}
	
	public String getName() {
		return name;
	}
	
	public int getCost() {
		return cost;
	}
}
