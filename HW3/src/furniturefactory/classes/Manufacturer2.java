package furniturefactory.classes;

import furniturefactory.dataclasses.FurnitureData;
import furniturefactory.dataclasses.FurnitureParts;
import furniturefactory.dataclasses.MaterialID;

public class Manufacturer2 extends Manufacturer {

	public Manufacturer2(FurnitureParts instructions) {
		super(instructions);
	}

	@Override
	public FurnitureData takeOrder() {//FIFO
		return this.getOrders().removeFirst();
	}

	@Override
	public FurnitureData peekOrder() {
		return this.getOrders().peekFirst();
	}

	@Override
	public Material getMaterial(MaterialID ID) {//LIFO
		return this.getSupplies().findAppropriateDequePair(ID).getSecond().removeLast();
	}

}
