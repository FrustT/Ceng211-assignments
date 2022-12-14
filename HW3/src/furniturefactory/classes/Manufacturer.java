package furniturefactory.classes;

import java.util.List;
import java.util.Locale;
import java.util.ArrayList;

import furniturefactory.adt.*;
import furniturefactory.dataclasses.*;
import furniturefactory.interfaces.*;

/**
 * This abstract class is hold common implementations for the sub-classes and
 * leaves some of the method implementations for the sub-classes
 * 
 * <ul>
 * <li><strong>supplies</strong> type: IKeyedDequePairList<MaterialID, Material>
 * <li><strong>orders</strong> type: IDeque<FurnitureData>
 * <li><strong>leftOverOrders</strong> type: IDeque<FurnitureData>
 * <li><strong>instructions</strong> type: FurnitureParts
 * </ul>
 * 
 * @author Mustafa Fatih Can 280201007
 * @author Deniz Kaya 280201033
 * @author Hakan Uskan 280201076
 * @author Burak Erinc 290201099
 */
public abstract class Manufacturer {

	private IKeyedDequePairList<MaterialID, Material> supplies;
	private IDeque<FurnitureData> orders;
	private IDeque<FurnitureData> leftOverOrders;
	private FurnitureParts instructions;

	/**
	 * <strong>Parameterized Constructor</strong>
	 * <p>
	 * Constructs Manufacturer Object with required data.
	 * 
	 * @param instructions
	 */
	protected Manufacturer(FurnitureParts instructions) {
		supplies = new KeyedDequePairList<>();
		orders = new Deque<>();
		leftOverOrders = new Deque<>();
		this.instructions = instructions;
	}

	/**
	 * This method takes an order from orders deque (LIFO or FIFO depending on the
	 * manufacturer) and crafts it if manufacturer has enough supplies.
	 * 
	 * @return Furniture crafted furniture.
	 */
	public Furniture processOrder() {
		FurnitureData order = this.takeOrder();
		if (!hasEnoughSupplies(order)) {
			this.leftOverOrders.add(order);
			return null;
		}
		return this.craftFurniture(order);
	}

	/**
	 * This method crafts a furniture assuming manufacturer has enough supplies.
	 * 
	 * @param FurnitureData order
	 * @return Furniture craftedFurniture
	 */
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
		Furniture furniture;

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

	/**
	 * Adds the material to the stock of the Manufacturer
	 * 
	 * @param material type: Material
	 */
	public void addMaterial(Material material) {
		supplies.addElement(material.getID(), material);
	}

	/**
	 * Adds the order to the list of Orders the Manufacturer
	 * 
	 * @param ID type: FurnitureID
	 */
	public void addOrder(FurnitureID ID) {
		orders.add(instructions.getPropertiesDataFromID(ID));
	}

	/**
	 * Takes the orders from leftOverOrders and adds them to the ordinary orders
	 * deque.
	 */
	public void endDay() {
		while (leftOverOrders.getLength() > 0) {
			orders.add(leftOverOrders.removeFirst());
		}
	}

	/**
	 * This method removes the order from the order deque and returns it according
	 * to the rule of the manufacturer.(LIFO,FIFO)
	 * 
	 * @return FurnitureData order
	 */
	public abstract FurnitureData takeOrder();

	/**
	 * This method does not remove the order but only peeks it from the order deque
	 * and returns itaccording to the rule of the manufacturer.(LIFO,FIFO)
	 * 
	 * @return FurnitureData order
	 */
	public abstract FurnitureData peekOrder();

	/**
	 * This method removes and returns a material from the supplies of the
	 * manufacturer according to the materials ID and the rules of that
	 * manufacturer.(LIFO,FIFP)
	 * 
	 * @param MaterialID ID
	 * @return Material
	 */
	public abstract Material getMaterial(MaterialID ID);

	/**
	 * This method returns the supplies of the manufacturer.
	 * 
	 * @return IKeyedDequePairList<MaterialID, Material> supplies
	 */
	public IKeyedDequePairList<MaterialID, Material> getSupplies() {
		return supplies;
	}

	/**
	 * This method returns the left over order's deep copy.
	 * 
	 * @return IDeque<FurnitureData> leftOverOrders
	 */
	public IDeque<FurnitureData> getLeftOverOrders() {
		List<FurnitureData> temp = new ArrayList<FurnitureData>();
		IDeque<FurnitureData> returned = new Deque<>();
		for (int i = 0; i < this.leftOverOrders.getLength(); i++) {
			temp.add(this.leftOverOrders.removeFirst());
		}
		for (FurnitureData order : temp) {
			this.leftOverOrders.add(new FurnitureData(order));
			returned.add(new FurnitureData(order));
		}
		return this.leftOverOrders;
	}

	/**
	 * Returns a shallow copy of orders.
	 * 
	 * @return IDeque<FurnitureData> orders
	 */
	public IDeque<FurnitureData> getOrders() {
		return orders;
	}

	/**
	 * Returns a shallow copy of instructions.
	 * 
	 * @return FurnitureParts instructions.
	 */
	public FurnitureParts getInstructions() {
		return instructions;
	}

	/**
	 * This method checks if there is enough supplies in the supplies of the
	 * manufacturer for the given order. Returns true if there is enough supplies.
	 * 
	 * @param FurnitureData order
	 * @return boolean
	 */
	public boolean hasEnoughSupplies(FurnitureData order) {
		List<Pair<MaterialID, Integer>> neededMaterialsPairs = order.getRequirementList();
		for (Pair<MaterialID, Integer> pair : neededMaterialsPairs) {
			int neededAmount = pair.getSecond();
			int materialInStock = this.supplies.findAppropriateDequePair(pair.getFirst()).getSecond().getLength();
			if (neededAmount > materialInStock) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Returns true if there are still orders left.
	 * 
	 * @return boolean
	 */
	public boolean hasOrderLeft() {
		return orders.getLength() > 0;
	}

}
