package marketshipment.classes;

public enum ContainerCode {
	C1("Container", 1);
	
	private String name;
	private int cost;
	
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