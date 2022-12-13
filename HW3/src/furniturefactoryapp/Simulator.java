package furniturefactoryapp;

import furniturefactory.adt.*;
import furniturefactory.dataclasses.*;
import furniturefactory.classes.*;
import furniturefactory.interfaces.*;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class Simulator {
	private Initializer init;
	private Manufacturer1 manufacturer1;
	private Manufacturer2 manufacturer2;
	private IVendor vendor;

	public Simulator() {
		this.init = new Initializer();
		this.manufacturer1 = init.initializeManufacturer1();
		this.manufacturer2 = init.initializeManufacturer2();
		this.vendor = init.initializeVendor();
	}

	public Initializer getInitializer() {
		return init;
	}

	public void simulateDayOne() {
		int totalExpenseOfManufacturer1 = buyMaterials(init.getManufacturer1MaterialsToBuy()[0], this.manufacturer1);
		int totalExpenseOfManufacturer2 = buyMaterials(init.getManufacturer2MaterialsToBuy()[0], this.manufacturer2);
		
		takeOrders(init.getManufacturer1FurnituresToCraft()[0], this.manufacturer1);
		takeOrders(init.getManufacturer2FurnituresToCraft()[0], this.manufacturer2);
		
		Dictionary<FurnitureID, int[]> printedDictOfManufacturer1 = this.processOrders(this.manufacturer1);
		Dictionary<FurnitureID, int[]> printedDictOfManufacturer2 = this.processOrders(this.manufacturer2);
		for(FurnitureID id: FurnitureID.values()) {
			int[] dataArray = printedDictOfManufacturer1.get(id);
			System.out.println(id.getName()+":    \tBad Qlt: " + dataArray[0] + ",Normal Qlt: " + dataArray[1] + ",Good Qlt: " + dataArray[2] +
							   ",Very Good Qlt: " + dataArray[3] + ",Perfect Qlt: " + dataArray[4] + ",Earning:" + dataArray[5]);
		}
		
		IDeque<FurnitureData> leftOverOrdersOfManufacturer1 = this.manufacturer1.getLeftOverOrders();
		for(int i = 0; i < leftOverOrdersOfManufacturer1.getLength(); i++) {
			System.out.println(leftOverOrdersOfManufacturer1.removeFirst().getID().getName());
		}
		for(FurnitureID id: FurnitureID.values()) {
			int[] dataArray = printedDictOfManufacturer2.get(id);
			System.out.println(id.getName()+":    \tBad Qlt: " + dataArray[0] + ",Normal Qlt: " + dataArray[1] + ",Good Qlt: " + dataArray[2] +
							   ",Very Good Qlt: " + dataArray[3] + ",Perfect Qlt: " + dataArray[4] + ",Earning:" + dataArray[5]);
		}
		
		
		int totalIncomeOfManufacturer1 = this.getTotalIncome(printedDictOfManufacturer1);
		int totalIncomeOfManufacturer2 = this.getTotalIncome(printedDictOfManufacturer2);
		System.out.println(totalIncomeOfManufacturer1);
		System.out.println(totalIncomeOfManufacturer2);
		
		
	}

	// Adds materials to manufacturer and returns the total expense of the bought
	// materials.
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
	
	public void takeOrders(List<Pair<FurnitureID, Integer>> furnituresToCraft, Manufacturer manufacturer){
		for(Pair<FurnitureID, Integer> furnitureCountPair : furnituresToCraft){
			FurnitureID id = furnitureCountPair.getFirst();
			int count = furnitureCountPair.getSecond();
			for(int i = 0; i < count; i++){
				manufacturer.addOrder(id);
			}
		}
	}
	
	public Dictionary<FurnitureID, int[]> processOrders(Manufacturer manufacturer){
		Furniture manufacturerFurniture = null;
		//The int array consists of quality numbers ordered from bad quality to perfect and the last index is the total earning.
		Dictionary<FurnitureID, int[]> printedDict = new Hashtable();
		
		for(FurnitureID id: FurnitureID.values()) {//Initializing the deque with each id.
			printedDict.put(id, new int[6]);
		}
		
		int orderCount = manufacturer.getOrders().getLength();
		
		for(int i = 0; i < orderCount; i++) {
			manufacturerFurniture = manufacturer.processOrder();
			if(manufacturerFurniture == null) {
				continue;
			}
			int[] printedArray = printedDict.get(manufacturerFurniture.getId());
			int income = manufacturerFurniture.calculateIncome();
			switch(manufacturerFurniture.getQualityRange()) {
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
	
	public int getTotalIncome(Dictionary<FurnitureID, int[]> printedDict) {
		int totalIncome = 0;
		for(FurnitureID id: FurnitureID.values()) {
			int[] dataArray = printedDict.get(id);
			totalIncome += dataArray[5];
		}
		return totalIncome;
	}

}
