package furniturefactory.dataclasses;

import java.util.ArrayList;
import java.util.List;

/**
 * Holds the FurnitureData objects in it and returns a furniture data for an id.
 * 
 * <ul>
 * <li><strong>partsList</strong> type: List<FurnitureData>
 * </ul>
 * 
 * @author Mustafa Fatih Can 280201007
 * @author Deniz Kaya 280201033
 * @author Hakan Uskan 280201076
 * @author Burak Erinc 290201099
 */
public class FurnitureParts {
	private List<FurnitureData> partsList;

	/**
	 * <strong>No Argument Constructor</strong>
	 * <p>
	 * Initializes an empty array list.
	 */
	public FurnitureParts() {
		partsList = new ArrayList<>();
	}

	/**
	 * Adds a row of properties to the list.
	 * 
	 * @param FurnitureData data
	 */
	public void addPropertiesRow(FurnitureData data) {
		partsList.add(data);
	}

	/**
	 * Gets a properties data from id.
	 * 
	 * @param FurnitureID ID
	 * @return FurnitureData
	 */
	public FurnitureData getPropertiesDataFromID(FurnitureID ID) {
		FurnitureData returnedData = null;
		for (FurnitureData data : partsList) {
			if (data.getID().equals(ID)) {
				returnedData = data;
				break;
			}
		}

		return returnedData;
	}

	/**
	 * Returns a shallow copy of the partsList.
	 * 
	 * @return List<FurnitureData> partsList
	 */
	public List<FurnitureData> getList() {
		return partsList;
	}

}
