package furniturefactory.dataclasses;

/**
 * Holds the data of the material with its id
 * 
 * <ul>
 * <li><strong>ID</strong> type: MaterialID
 * <li><strong>length</strong> type: int
 * <li><strong>width</strong> type: int
 * <li><strong>height</strong> type: int
 * <li><strong>cost</strong> type: int
 * </ul>
 * 
 * @author Mustafa Fatih Can 280201007
 * @author Deniz Kaya 280201033
 * @author Hakan Uskan 280201076
 * @author Burak Erinc 290201099
 */
public class MaterialData {

	private MaterialID ID;
	private int length;
	private int width;
	private int height;
	private int cost;

	/**
	 * <strong>Parameterized Constructor</strong>
	 * <p>
	 * Constructs Material Data with required data.
	 * 
	 * @param ID
	 * @param length
	 * @param width
	 * @param height
	 * @param cost
	 */
	public MaterialData(MaterialID ID, int length, int width, int height, int cost) {
		this.ID = ID;
		this.length = length;
		this.width = width;
		this.height = height;
		this.cost = cost;
	}

	/**
	 * Gets the Material ID.
	 * 
	 * @return MaterialID The ID of material.
	 */
	public MaterialID getID() {
		return ID;
	}

	/**
	 * Gets the length of material.
	 * 
	 * @return int The length of material.
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Gets the width of material.
	 * 
	 * @return int The width of material.
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Gets the height of material.
	 * 
	 * @return int The height of material.
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Gets the cost of material.
	 * 
	 * @return int The cost of material.
	 */
	public int getCost() {
		return cost;
	}
}
