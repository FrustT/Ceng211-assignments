package furniturefactory.classes;

import furniturefactory.dataclasses.*;

/**
 * This class is a sub-class of the abstract class Manufacture, provides concrete
 * implementations to the abstract methods in super-class
 * 
 * @author Mustafa Fatih Can 280201007
 * @author Deniz Kaya 280201033
 * @author Hakan Uskan 280201076
 * @author Burak Erinc 290201099
 */
public class Manufacturer1 extends Manufacturer {

	/**
	 * <strong>Parameterized Constructor</strong>
	 * <p>
	 * Constructs Manufacturer1 Object with required data.
	 * 
	 * @param instructions
	 */
	public Manufacturer1(FurnitureParts instructions) {
		super(instructions);

	}

	/**
	 * Takes order as LIFO.
	 */
	@Override
	public FurnitureData takeOrder() {// LIFO
		return this.getOrders().removeLast();
	}

	/**
	 * Peeks order as LIFO.
	 */
	@Override
	public FurnitureData peekOrder() {
		return this.getOrders().peekLast();
	}

	/**
	 * Gets material as FIFO.
	 */
	@Override
	public Material getMaterial(MaterialID ID) {// FIFO
		return this.getSupplies().findAppropriateDequePair(ID).getSecond().removeFirst();
	}

}
