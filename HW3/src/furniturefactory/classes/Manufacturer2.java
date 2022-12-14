package furniturefactory.classes;

import furniturefactory.dataclasses.FurnitureData;
import furniturefactory.dataclasses.FurnitureParts;
import furniturefactory.dataclasses.MaterialID;

/**
 * This class is a sub-class of the abstract class Manufacture, provides
 * concrete implementations to the abstract methods in super-class
 * 
 * @author Mustafa Fatih Can 280201007
 * @author Deniz Kaya 280201033
 * @author Hakan Uskan 280201076
 * @author Burak Erinc 290201099
 */

public class Manufacturer2 extends Manufacturer {

	/**
	 * <strong>Parameterized Constructor</strong>
	 * <p>
	 * Constructs Manufacturer2 Object with required data.
	 * 
	 * @param instructions
	 */
	public Manufacturer2(FurnitureParts instructions) {
		super(instructions);
	}

	/**
	 * Takes order as FIFO.
	 */
	@Override
	public FurnitureData takeOrder() {// FIFO
		return this.getOrders().removeFirst();
	}

	/**
	 * Peeks order as FIFO.
	 */
	@Override
	public FurnitureData peekOrder() {
		return this.getOrders().peekFirst();
	}

	/**
	 * Gets material as LIFO.
	 */
	@Override
	public Material getMaterial(MaterialID ID) {// LIFO
		return this.getSupplies().findAppropriateDequePair(ID).getSecond().removeLast();
	}

}
