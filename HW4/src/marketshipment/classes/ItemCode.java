package marketshipment.classes;

public enum ItemCode {
	M1("Box of milk", 5, 11), W1("Box of water", 1, 3), O1("Box of oil", 20, 45), S1("Sugar", 13, 25), F1("Flour", 5, 12), P1("Pasta", 12, 28), R1("Rice", 16, 32);
	
	private String name;
	private int cost;
	private int price;
	
	private ItemCode(String _name, int _cost, int _price) {
		name = _name;
		cost = _cost;
		price = _price;
	}
	
	
	public String getName() {
		return name;
	}
	
	public int getCost() {
		return cost;
	}
	
	public int getPrice() {
		return price;
	}
}
