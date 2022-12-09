package furniturefactoryapp;

import java.util.List;

import fileoperations.FileIO;
import furniturefactory.classes.*;

public class FurnitureFactoryApp {

	public static void main(String[] args) {

	    
	    RawMaterialProperties data = FileIO.getRawMaterialPropertiesFromFile("Files/RawMaterialProperties.csv");
	    
	    Vendor vendor = FileIO.getVendorFromFile("Files/VendorPossessions.csv", data);
	    
	    System.out.println();
	    Deque<Material> deque = vendor.findAppropriateDeque(MaterialID.PL013);
		int length = deque.getLength();
		for(int i = 0; i < length; i++) {
			System.out.println(deque.removeFirst());
		}
	    
	    //System.out.println(vendor.getLastOccurrence(MaterialID.WB121));
	    
		/*System.out.println(data.getPropertiesDataFromID("WB131").getCost());
		List<MaterialData> list= data.getList();
		for(MaterialData fdfd : list) {
			System.out.println(fdfd);
			System.out.println(fdfd.getID()+" "+ fdfd.getLength()+" "+fdfd.getWidth()+" "+ fdfd.getHeight());
		}
		
		FurnitureParts furnitureData = FileIO.getFurniturePartsFromFile("Files/FurnitureParts.csv");
		List<FurnitureData> liste = furnitureData.getList();
		for(FurnitureData fdfd : liste) {
			System.out.println("\n"+ fdfd.getID()+"\n____________________________");
			List<Pair<MaterialID, Integer>> lissst = fdfd.getRequirementList();
			for(Pair<MaterialID, Integer> pair : lissst){
				System.out.println(pair.getFirst()+" "+pair.getSecond());
			}
		}*/
		/*
		String[] deneme = {"aefawfaw","3342fefwef","32311ffsdfsf","32432ddfdsf","32432ggfgffgf","34gfdkmkdmflk"};
		Deque<String> deque = new Deque<String>();
		for(String string:deneme) {
			deque.add(string);
		}
		int length = deque.getLength();
		for(int i = 0; i < length; i++) {
			System.out.println(deque.removeLast());
		}*/
	}
}
