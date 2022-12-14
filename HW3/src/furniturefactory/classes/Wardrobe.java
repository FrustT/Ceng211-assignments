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
public class Wardrobe extends Furniture {

	/**
	 * <strong>Parameterized Constructor</strong>
	 * <p>
	 * Constructs Wardrobe Object with required data.
	 * 
	 * @param id
	 * @param materials
	 */
	public Wardrobe(FurnitureID id, List<Material> materials) {
		super(id, materials);
	}

	/**
	 * <strong>Copy Constructor</strong>
	 * <p>
	 * Constructs a new Wardrobe Object with another Wardrobe Object
	 * 
	 * @param wardrobe
	 */
	public Wardrobe(Wardrobe wardrobe) {
		super(wardrobe);
	}

	public int getProfitMargin() {
		return 320;
	}

}
