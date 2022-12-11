package furniturefactory.classes;

import furniturefactory.dataclasses.*;

public class Manufacturer1 extends Manufacturer {

	public Manufacturer1(FurnitureParts instructions) {
		super(instructions);
		
	}

	@Override
	public FurnitureData takeOrder() {//LIFO
		return this.getOrders().removeLast();
	}

	@Override
	public FurnitureData peekOrder() {
		return this.getOrders().peekLast();
	}

	@Override
	public Material getMaterial(MaterialID ID) {//FIFO
		return this.getSupplies().findAppropriateDequePair(ID).getSecond().removeFirst();
	}

}
