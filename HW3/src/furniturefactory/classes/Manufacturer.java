package furniturefactory.classes;

import java.util.List;
import java.util.Locale;
import java.util.ArrayList;

import furniturefactory.adt.*;
import furniturefactory.dataclasses.*;
import furniturefactory.interfaces.*;

public abstract class Manufacturer {

	private IKeyedDequePairList<MaterialID, Material> supplies;
	private IDeque<FurnitureData> orders;
	private IDeque<FurnitureData> leftOverOrders;
	private FurnitureParts instructions;

	protected Manufacturer(FurnitureParts instructions) {
		supplies = new KeyedDequePairList<>();
		orders = new Deque<>();
		leftOverOrders = new Deque<>();
		this.instructions = instructions;
	}

	public Furniture processOrder() {
		FurnitureData order = this.takeOrder();
		if (!hasEnoughSupplies(order)) {
			this.leftOverOrders.add(order);
			return null;
		}
		return this.craftFurniture(order);
	}

	public Furniture craftFurniture(FurnitureData order) {
		List<Material> materialsNeeded = new ArrayList<>();
		for (Pair<MaterialID, Integer> pair : order.getRequirementList()) {
			MaterialID id = pair.getFirst();
			int materialCount = pair.getSecond();
			while (materialCount > 0) {
				materialsNeeded.add(getMaterial(id));
				materialCount--;
			}
		}
		String furnitureType = order.getID().toString().substring(0, 2).toUpperCase(Locale.ROOT);
		Furniture furniture = null;

		switch (furnitureType) {
		case ("TB"):
			furniture = new Table(order.getID(), materialsNeeded);
			break;
		case ("WD"):
			furniture = new Wardrobe(order.getID(), materialsNeeded);
			break;
		case ("SH"):
			furniture = new Shelf(order.getID(), materialsNeeded);
			break;
		default:
			furniture = null;
		}
		return furniture;

	}

	public void addMaterial(Material material) {
		supplies.addElement(material.getID(), material);
	}

	public void addOrder(FurnitureID ID) {
		orders.add(instructions.getPropertiesDataFromID(ID));
	}

	public void endDay() {
		while (leftOverOrders.getLength() > 0) {
			orders.add(leftOverOrders.removeFirst());
		}
	}

	public void startDay() {//TODO
	}

	public abstract FurnitureData takeOrder();

	public abstract FurnitureData peekOrder();

	public abstract Material getMaterial(MaterialID ID);

	public IKeyedDequePairList<MaterialID, Material> getSupplies() {
		return supplies;
	}

	public IDeque<FurnitureData> getLeftOverOrders() {
		List<FurnitureData> temp = new ArrayList<FurnitureData>();
		IDeque<FurnitureData> returned = new Deque<>();
		for(int i = 0; i < this.leftOverOrders.getLength(); i++) {
			temp.add(this.leftOverOrders.removeFirst());
		}
		for(FurnitureData order: temp) {
			this.leftOverOrders.add(new FurnitureData(order));
			returned.add(new FurnitureData(order));
		}
		return this.leftOverOrders;
	}
	public IDeque<FurnitureData> getOrders() {
		return orders;
	}

	public FurnitureParts getInstructions() {
		return instructions;
	}

	public boolean hasEnoughSupplies(FurnitureData data) {
		List<Pair<MaterialID, Integer>> neededMaterialsPairs = data.getRequirementList();
		for (Pair<MaterialID, Integer> pair : neededMaterialsPairs) {
			int neededAmount = pair.getSecond();
			int materialInStock = this.supplies.findAppropriateDequePair(pair.getFirst()).getSecond().getLength();
			if (neededAmount > materialInStock) {
				return false;
			}
		}
		return true;
	}

	public boolean hasOrderLeft() {
		return orders.getLength() != 0;
	}

}
