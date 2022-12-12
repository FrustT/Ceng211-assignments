package furniturefactory.classes;

import fileoperations.FileIO;
import java.util.List;

import furniturefactory.adt.Pair;
import furniturefactory.interfaces.IVendor;
import furniturefactory.dataclasses.*;

public class Initializer {

	private RawMaterialProperties rawMaterialCatalog;
	private FurnitureParts furnitureData;
	private List<Pair<MaterialID, Integer>>[] manufacturer1MaterialsToBuy;
	private List<Pair<MaterialID, Integer>>[] manufacturer2MaterialsToBuy;
	private List<Pair<FurnitureID, Integer>>[] manufacturer1FurnituresToCraft;
	private List<Pair<FurnitureID, Integer>>[] manufacturer2FurnituresToCraft;

	public Initializer() {
		this.rawMaterialCatalog = FileIO.getRawMaterialPropertiesFromFile("Files/RawMaterialProperties.csv");
		this.furnitureData = FileIO.getFurniturePartsFromFile("Files/FurnitureParts.csv");
		this.manufacturer1MaterialsToBuy = FileIO.getMaterialsToBuy("Files/Manufacturer1Materials.csv");
		this.manufacturer2MaterialsToBuy = FileIO.getMaterialsToBuy("Files/Manufacturer2Materials.csv");
		this.manufacturer1FurnituresToCraft = FileIO.getFurnituresToCraft("Files/Manufacturer1Furnitures.csv");
		this.manufacturer2FurnituresToCraft = FileIO.getFurnituresToCraft("Files/Manufacturer2Furnitures.csv");
	}

	public IVendor initializeVendor() {
		return FileIO.getVendorFromFile("Files/VendorPossessions.csv", this.rawMaterialCatalog);
	}

	public Manufacturer1 initializeManufacturer1() {
		return new Manufacturer1(this.furnitureData);
	}

	public Manufacturer2 initializeManufacturer2() {
		return new Manufacturer2(this.furnitureData);

	}

	public FurnitureParts getFurnitureData() {
		return furnitureData;
	}

	public RawMaterialProperties getRawMaterialProperties() {
		return rawMaterialCatalog;
	}

	public List<Pair<MaterialID, Integer>>[] getManufacturer1MaterialsToBuy() {
		return manufacturer1MaterialsToBuy;
	}

	public List<Pair<MaterialID, Integer>>[] getManufacturer2MaterialsToBuy() {
		return manufacturer2MaterialsToBuy;
	}

	public List<Pair<FurnitureID, Integer>>[] getManufacturer1FurnituresToCraft() {
		return manufacturer1FurnituresToCraft;
	}

	public List<Pair<FurnitureID, Integer>>[] getManufacturer2FurnituresToCraft() {
		return manufacturer2FurnituresToCraft;
	}
}
