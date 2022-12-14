package furniturefactoryapp;

import furniturefactory.adt.*;
import furniturefactory.dataclasses.*;
import furniturefactory.classes.*;
import furniturefactory.interfaces.*;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

/**
 * This class holds methods that is been need for the simulation.
 * 
 * <ul>
 * <li><strong>init</strong> type: Initializer
 * <li><strong>manufacturer1</strong> type: Manufacturer1
 * <li><strong>manufacturer2</strong> type: Manufacturer2
 * <li><strong>vendor</strong> type: IVendor
 * </ul>
 * 
 * @author Mustafa Fatih Can 280201007
 * @author Deniz Kaya 280201033
 * @author Hakan Uskan 280201076
 * @author Burak Erinc 290201099
 */
public class Simulator {

	private Initializer init;
	private Manufacturer1 manufacturer1;
	private Manufacturer2 manufacturer2;
	private IVendor vendor;

	/**
	 * <strong>Default Constructor</strong>
	 * <p>
	 * Initializes needed classes for simulator to work.
	 */
	public Simulator() {
		this.init = new Initializer();
		this.manufacturer1 = init.initializeManufacturer1();
		this.manufacturer2 = init.initializeManufacturer2();
		this.vendor = init.initializeVendor();
	}

	public Initializer getInitializer() {
		return init;
	}

	/**
	 * Simulates 3 days.
	 */
	public void simulate() {
		for (int i = 1; i < 4; i++) {
			simulateDay(i);
		}
	}

	/**
	 * Simulates the given day integer.
	 * 
	 * @param day
	 */
	public void simulateDay(int day) {
		int totalExpenseOfManufacturer1 = buyMaterials(init.getManufacturer1MaterialsToBuy()[day - 1],
				this.manufacturer1);
		int totalExpenseOfManufacturer2 = buyMaterials(init.getManufacturer2MaterialsToBuy()[day - 1],
				this.manufacturer2);

		takeOrders(init.getManufacturer1FurnituresToCraft()[day - 1], this.manufacturer1);
		takeOrders(init.getManufacturer2FurnituresToCraft()[day - 1], this.manufacturer2);

		Dictionary<FurnitureID, int[]> printedDictOfManufacturer1 = this.processOrders(this.manufacturer1);
		Dictionary<FurnitureID, int[]> printedDictOfManufacturer2 = this.processOrders(this.manufacturer2);

		System.out.println("Day" + day + ":");
		System.out.println("Manufacturer1:");
		printDay(printedDictOfManufacturer1, totalExpenseOfManufacturer1, this.manufacturer1);
		System.out.println("Manufacturer2:");
		printDay(printedDictOfManufacturer2, totalExpenseOfManufacturer2, this.manufacturer2);
		this.manufacturer1.endDay();
		this.manufacturer2.endDay();
		System.out.println();

	}

	/**
	 * This method takes the will be printed dictionary , total expense and the
	 * manufacturer and prints them on console.
	 * 
	 * @param Dictionary<FurnitureID,    int[]> printedDict
	 * @param totalExpenseOfManufacturer
	 * @param manufacturer
	 */
	public void printDay(Dictionary<FurnitureID, int[]> printedDict, int totalExpenseOfManufacturer,
			Manufacturer manufacturer) {
		for (FurnitureID id : FurnitureID.values()) {
			int[] dataArray = printedDict.get(id);
			System.out.println(id.getName() + ":    \tBad Qlt: " + dataArray[0] + ",Normal Qlt: " + dataArray[1]
					+ ",Good Qlt: " + dataArray[2] + ",Very Good Qlt: " + dataArray[3] + ",Perfect Qlt: " + dataArray[4]
					+ ",Earning:" + dataArray[5]);
		}
		System.out.println("Total Expense: " + totalExpenseOfManufacturer +" TL");
		System.out.println("Total Income: " + this.getTotalIncome(printedDict) + " TL");

		System.out.println("Unproduced Furnitures:");
		Dictionary<FurnitureID, Integer> orders = new Hashtable();
		IDeque<FurnitureData> leftOverOrdersOfManufacturer = manufacturer.getLeftOverOrders();
		for (int i = 0; i < leftOverOrdersOfManufacturer.getLength(); i++) {
			FurnitureData order = leftOverOrdersOfManufacturer.removeFirst();
			FurnitureID id = order.getID();
			if (orders.get(id) == null) {
				orders.put(id, 1);
			} else {
				int newValue = orders.get(id) + 1;
				orders.put(id, newValue);
			}
		}
		for (FurnitureID id : FurnitureID.values()) {
			if (orders.get(id) != null) {
				int count = orders.get(id);
				System.out.print(id.getName()+":"+count + " ");
			}
		}
		System.out.println();
	}

	/**
	 * Adds materials to manufacturer and returns the total expense of the bought
	 * materials.
	 * 
	 * @param List<Pair<MaterialID, Integer>> materialsToBuy
	 * @param manufacturer
	 * @return total expense of bought materials.
	 */
	public int buyMaterials(List<Pair<MaterialID, Integer>> materialsToBuy, Manufacturer manufacturer) {
		int totalExpense = 0;
		for (Pair<MaterialID, Integer> materialCountPair : materialsToBuy) {
			MaterialID id = materialCountPair.getFirst();
			int count = materialCountPair.getSecond();
			for (int i = 0; i < count; i++) {
				Material material = vendor.removeFirstOccurrence(id);
				totalExpense += material.getCost();
				manufacturer.addMaterial(material);
			}
		}
		return totalExpense;
	}

	/**
	 * Takes orders from the furnitures to craft list and adds the orders in that
	 * list to the given manufacturer.
	 * 
	 * @param List<Pair<FurnitureID, Integer>> furnituresToCraft
	 * @param manufacturer
	 */
	public void takeOrders(List<Pair<FurnitureID, Integer>> furnituresToCraft, Manufacturer manufacturer) {
		for (Pair<FurnitureID, Integer> furnitureCountPair : furnituresToCraft) {
			FurnitureID id = furnitureCountPair.getFirst();
			int count = furnitureCountPair.getSecond();
			for (int i = 0; i < count; i++) {
				manufacturer.addOrder(id);
			}
		}
	}

	/**
	 * This method processes orders of the given manufacturer and adds the orders to
	 * the dictionary simultaneously.
	 * 
	 * @param manufacturer
	 * @return will be printed dictionary as Dictionary<FurnitureID, int[]>
	 */
	public Dictionary<FurnitureID, int[]> processOrders(Manufacturer manufacturer) {
		Furniture manufacturerFurniture = null;
		// The int array consists of quality numbers ordered from bad quality to perfect
		// and the last index is the total earning.
		Dictionary<FurnitureID, int[]> printedDict = new Hashtable<>();

		for (FurnitureID id : FurnitureID.values()) {// Initializing the deque with each id.
			printedDict.put(id, new int[6]);
		}

		int orderCount = manufacturer.getOrders().getLength();

		for (int i = 0; i < orderCount; i++) {
			manufacturerFurniture = manufacturer.processOrder();
			if (manufacturerFurniture == null) {
				continue;
			}
			int[] printedArray = printedDict.get(manufacturerFurniture.getId());
			int income = manufacturerFurniture.calculateIncome();
			switch (manufacturerFurniture.getQualityRange()) {
			case BADQLT:
				printedArray[0] += 1;
				break;
			case NORMALQLT:
				printedArray[1] += 1;
				break;
			case GOODQLT:
				printedArray[2] += 1;
				break;
			case VERYGOODQLT:
				printedArray[3] += 1;
				break;
			case PERFECTQLT:
				printedArray[4] += 1;
				break;
			}
			printedArray[5] += income;
		}
		return printedDict;
	}

	/**
	 * This method takes will be printed dictionary and gets all key's value's last
	 * index(it should be the income of the single furniture) and adds it to total
	 * income.
	 * 
	 * @param Dictionary<FurnitureID, int[]> printedDict
	 * @return total income as int
	 */
	public int getTotalIncome(Dictionary<FurnitureID, int[]> printedDict) {
		int totalIncome = 0;
		for (FurnitureID id : FurnitureID.values()) {
			int[] dataArray = printedDict.get(id);
			totalIncome += dataArray[5];
		}
		return totalIncome;
	}

}
