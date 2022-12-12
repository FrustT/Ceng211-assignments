package furniturefactoryapp;

import java.util.List;

import furniturefactory.classes.*;
import furniturefactory.dataclasses.*;
import furniturefactory.adt.*;

public class FurnitureFactoryApp {

	public static void main(String[] args) {

		Simulator sim =new Simulator();
		Initializer init = sim.getInitializer();
		for (List<Pair<FurnitureID, Integer>> f : init.getManufacturer1FurnituresToCraft()) {
			for (Pair<FurnitureID, Integer> h : f) {
				System.out.println(h.getFirst());
			}

		}

		for (List<Pair<FurnitureID, Integer>> f : init.getManufacturer2FurnituresToCraft()) {
			for (Pair<FurnitureID, Integer> h : f) {
				System.out.println(h.getFirst());
			}
		}
		for (List<Pair<MaterialID, Integer>> f : init.getManufacturer1MaterialsToBuy()) {
			for (Pair<MaterialID, Integer> h : f) {
				System.out.println(h.getFirst());
			}
		}

		for (List<Pair<MaterialID, Integer>> f : init.getManufacturer2MaterialsToBuy()) {
			for (Pair<MaterialID, Integer> h : f) {
				System.out.println(h.getFirst());
			}
		}

		/*
		 * RawMaterialProperties data =
		 * FileIO.getRawMaterialPropertiesFromFile("Files/RawMaterialProperties.csv");
		 * 
		 * Vendor vendor = (Vendor)
		 * FileIO.getVendorFromFile("Files/VendorPossessions.csv", data);
		 * 
		 * IDeque<Material> deque =
		 * vendor.materials.findAppropriateDequePair(MaterialID.WP403).getSecond(); int
		 * length = deque.getLength(); for(int i = 0; i < length; i++) {
		 * System.out.println(deque.removeFirst()); }
		 * 
		 * List<Pair<MaterialID, Integer>>[] sss =
		 * FileIO.getMaterialsToBuy("Files/Manufacturer1Materials.csv");
		 * System.out.println(sss[1].get(4).getSecond());
		 * 
		 * //System.out.println(vendor.getLastOccurrence(MaterialID.WB121));
		 * 
		 * /*System.out.println(data.getPropertiesDataFromID("WB131").getCost());
		 * List<MaterialData> list= data.getList(); for(MaterialData fdfd : list) {
		 * System.out.println(fdfd); System.out.println(fdfd.getID()+" "+
		 * fdfd.getLength()+" "+fdfd.getWidth()+" "+ fdfd.getHeight()); }
		 * 
		 * FurnitureParts furnitureData =
		 * FileIO.getFurniturePartsFromFile("Files/FurnitureParts.csv");
		 * List<FurnitureData> liste = furnitureData.getList(); for(FurnitureData fdfd :
		 * liste) { System.out.println("\n"+
		 * fdfd.getID()+"\n____________________________"); List<Pair<MaterialID,
		 * Integer>> lissst = fdfd.getRequirementList(); for(Pair<MaterialID, Integer>
		 * pair : lissst){ System.out.println(pair.getFirst()+" "+pair.getSecond()); } }
		 */
		/*
		 * String[] deneme =
		 * {"aefawfaw","3342fefwef","32311ffsdfsf","32432ddfdsf","32432ggfgffgf",
		 * "34gfdkmkdmflk"}; Deque<String> deque = new Deque<String>(); for(String
		 * string:deneme) { deque.add(string); } int length = deque.getLength(); for(int
		 * i = 0; i < length; i++) { System.out.println(deque.removeLast()); }
		 */
	}
}
