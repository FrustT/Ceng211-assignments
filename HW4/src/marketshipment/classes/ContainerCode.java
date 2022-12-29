package marketshipment.classes;

/**
 * Holds data about ContainerCode.
 *
 * <ul>
 * <li><strong>name</strong> type: String
 * <li><strong>cost</strong> type: int
 * </ul>
 * 
 * @author Mustafa Fatih Can 280201007
 * @author Deniz Kaya 280201033
 * @author Hakan Uskan 280201076
 * @author Burak Erinc 290201099
 */

public enum ContainerCode {
	C1("Container", 1);
	
	private String name;
	private int cost;
	/**
	 * <strong>Parameterized Constructor</strong>
	 * <p>
	 * Constructs ContainerCode object with required data.
	 * 
	 * @param _name
	 * @param _cost
	 */
	private ContainerCode(String _name, int _cost) {
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