package furniturefactoryapp;

import furniturefactory.adt.*;
import furniturefactory.dataclasses.*;
import furniturefactory.classes.*;
import furniturefactory.interfaces.*;
import java.util.List;

public class Simulator {
	private Initializer init;
	private Manufacturer1 manufacturer1;
	private Manufacturer2 manufacturer2;
	private IVendor vendor;

	public Simulator() {
		this.init = new Initializer();
		this.manufacturer1 = init.initializeManufacturer1();
		init.initializeManufacturer2();
		this.vendor = init.initializeVendor();
	}

	public Initializer getInitializer() {
		return init;
	}

	public void simulateDayOne() {
		float totalIncome = 0;
		List<Pair<MaterialID, Integer>> manufacturer1MaterialsToBuy = init.getManufacturer1MaterialsToBuy()[0];
		List<Pair<FurnitureID, Integer>> manufacturer1FurnituresToCraft = init.getManufacturer1FurnituresToCraft()[0];
		float totalExpenseOfManufacturer1 = buyMaterials(init.getManufacturer1MaterialsToBuy()[0], this.manufacturer1);
		takeOrders(manufacturer1FurnituresToCraft, this.manufacturer1);

	}

	// Adds materials to manufacturer and returns the total expense of the bought
	// materials.
	public float buyMaterials(List<Pair<MaterialID, Integer>> materialsToBuy, Manufacturer manufacturer) {
		float totalExpense = 0;
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

}
