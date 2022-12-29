package marketshipment.classes;

/**
 * Holds data about ItemCode.
 *
 * <ul>
 * <li><strong>name</strong> type: String
 * <li><strong>cost</strong> type: int
 * <li><strong>price</strong> type: int
 * </ul>
 * 
 * @author Mustafa Fatih Can 280201007
 * @author Deniz Kaya 280201033
 * @author Hakan Uskan 280201076
 * @author Burak Erinc 290201099
 */

public enum ItemCode {
	M1("Box of milk", 5, 11), W1("Box of water", 1, 3), O1("Box of oil", 20, 45), S1("Sugar", 13, 25), F1("Flour", 5, 12), P1("Pasta", 12, 28), R1("Rice", 16, 32);
	
	private String name;
	private int cost;
	private int price;
	/**
	 * <strong>Parameterized Constructor</strong>
	 * <p>
	 * Constructs AbstractBox object with required data.
	 * 
	 * @param _name
	 * @param _cost
	 * @param _price
	 */
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
