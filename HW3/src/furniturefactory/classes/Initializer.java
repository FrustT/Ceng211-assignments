package furniturefactory.classes;

import fileoperations.FileIO;
import java.util.List;

import furniturefactory.adt.Pair;
import furniturefactory.interfaces.IVendor;
import furniturefactory.dataclasses.*;

/**
 * This class holds data for the simulation
 * 
 * <ul>
 * <li><strong>rawMaterialCatalog</strong> type: RawMaterialProperties
 * <li><strong>furnitureData</strong> type: FurnitureParts
 * <li><strong>manufacturer1MaterialsToBuy</strong> type: List<Pair<MaterialID,
 * Integer>>[]
 * <li><strong>manufacturer2MaterialsToBuy</strong> type: List<Pair<MaterialID,
 * Integer>>[]
 * <li><strong>manufacturer1FurnituresToCraft</strong> type:
 * List<Pair<FurnitureID, Integer>>[]
 * <li><strong>manufacturer2FurnituresToCraft</strong> type:
 * List<Pair<FurnitureID, Integer>>[]
 * </ul>
 * 
 * @author Mustafa Fatih Can 280201007
 * @author Deniz Kaya 280201033
 * @author Hakan Uskan 280201076
 * @author Burak Erinc 290201099
 */
public class Initializer {

	private RawMaterialProperties rawMaterialCatalog;
	private FurnitureParts furnitureData;
	private List<Pair<MaterialID, Integer>>[] manufacturer1MaterialsToBuy;
	private List<Pair<MaterialID, Integer>>[] manufacturer2MaterialsToBuy;
	private List<Pair<FurnitureID, Integer>>[] manufacturer1FurnituresToCraft;
	private List<Pair<FurnitureID, Integer>>[] manufacturer2FurnituresToCraft;

	/**
	 * <strong>No Argument Constructor</strong>
	 * <p>
	 * This constructor initializes the neeeded variables from the files using
	 * appropriate file IO methods.
	 */
	public Initializer() {
		this.rawMaterialCatalog = FileIO.getRawMaterialPropertiesFromFile("Files/RawMaterialProperties.csv");
		this.furnitureData = FileIO.getFurniturePartsFromFile("Files/FurnitureParts.csv");
		this.manufacturer1MaterialsToBuy = FileIO.getMaterialsToBuy("Files/Manufacturer1Materials.csv");
		this.manufacturer2MaterialsToBuy = FileIO.getMaterialsToBuy("Files/Manufacturer2Materials.csv");
		this.manufacturer1FurnituresToCraft = FileIO.getFurnituresToCraft("Files/Manufacturer1Furnitures.csv");
		this.manufacturer2FurnituresToCraft = FileIO.getFurnituresToCraft("Files/Manufacturer2Furnitures.csv");
	}

	/**
	 * Delegates FileIO for the initializition of the Vendor.
	 * 
	 * @return IVendor vendor
	 */
	public IVendor initializeVendor() {
		return FileIO.getVendorFromFile("Files/VendorPossessions.csv", this.rawMaterialCatalog);
	}

	/**
	 * Initializes a new manufacturer1 with furniture data.
	 * 
	 * @return Manufacturer1
	 */
	public Manufacturer1 initializeManufacturer1() {
		return new Manufacturer1(this.furnitureData);
	}

	/**
	 * Initializes a new manufacturer2 with furniture data
	 * 
	 * @return Manufacturer2
	 */
	public Manufacturer2 initializeManufacturer2() {
		return new Manufacturer2(this.furnitureData);

	}

	/**
	 * Returns a shallow copy of furniture data.
	 * 
	 * @return FurnitureParts furnitureData
	 */
	public FurnitureParts getFurnitureData() {
		return furnitureData;
	}

	/**
	 * Returns a shallow copy of raw material properties.
	 * 
	 * @return RawMaterialProperties rawMaterialCatalog
	 */
	public RawMaterialProperties getRawMaterialProperties() {
		return rawMaterialCatalog;
	}

	/**
	 * Returns a shallow copy of Manufacturer1's materials to buy
	 * 
	 * @return List<Pair<MaterialID, Integer>>[] Manufacturer1MaterialsToBuy
	 */
	public List<Pair<MaterialID, Integer>>[] getManufacturer1MaterialsToBuy() {
		return manufacturer1MaterialsToBuy;
	}

	/**
	 * Returns a shallow copy of Manufacturer2's materials to buy.
	 * 
	 * @return List<Pair<MaterialID, Integer>>[] Manufacturer2MaterialsToBuy
	 */
	public List<Pair<MaterialID, Integer>>[] getManufacturer2MaterialsToBuy() {
		return manufacturer2MaterialsToBuy;
	}

	/**
	 * Returns a shallow copy of Manufacturer1's Furnitures to craft.
	 * 
	 * @return List<Pair<FurnitureID, Integer>>[] manufacturer1FurnituresToCraft
	 */
	public List<Pair<FurnitureID, Integer>>[] getManufacturer1FurnituresToCraft() {
		return manufacturer1FurnituresToCraft;
	}

	/**
	 * Returns a shallow copy of Manufacturer2's Furnitures to craft.
	 * 
	 * @return List<Pair<FurnitureID, Integer>>[] manufacturer2FurnituresToCraft
	 */
	public List<Pair<FurnitureID, Integer>>[] getManufacturer2FurnituresToCraft() {
		return manufacturer2FurnituresToCraft;
	}
}
