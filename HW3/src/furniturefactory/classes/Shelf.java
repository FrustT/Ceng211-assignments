package furniturefactory.classes;

import java.util.List;

import furniturefactory.dataclasses.FurnitureID;

/**
 * This class is a sub-class of the abstract class Furniture, provides concrete
 * implementations to the abstract methods in super-class
 * 
 * @author Mustafa Fatih Can 280201007
 * @author Deniz Kaya 280201033
 * @author Hakan Uskan 280201076
 * @author Burak Erinc 290201099
 */
public class Shelf extends Furniture {

	/**
	 * <strong>Parameterized Constructor</strong>
	 * <p>
	 * Constructs Shelf Object with required data.
	 * 
	 * @param id
	 * @param materials
	 */
	public Shelf(FurnitureID id, List<Material> materials) {
		super(id, materials);
	}

	/**
	 * <strong>Copy Constructor</strong>
	 * <p>
	 * Constructs a new Shelf Object with another Shelf Object
	 * 
	 * @param shelf
	 */
	public Shelf(Shelf shelf) {
		super(shelf);
	}

	public int getProfitMargin() {
		return 280;
	}

}
