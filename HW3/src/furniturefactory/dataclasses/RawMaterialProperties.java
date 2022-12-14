package furniturefactory.dataclasses;

import java.util.ArrayList;
import java.util.List;

/**
 * Holds MaterialData Objects in it
 * 
 * <ul>
 * <li><strong>propertiesList</strong> type: List<MaterialData>
 * </ul>
 * 
 * @author Mustafa Fatih Can 280201007
 * @author Deniz Kaya 280201033
 * @author Hakan Uskan 280201076
 * @author Burak Erinc 290201099
 */
public class RawMaterialProperties {
	private List<MaterialData> propertiesList;

	/**
	 * <strong>No Argument Constructor</strong>
	 * <p>
	 */
	public RawMaterialProperties() {
		propertiesList = new ArrayList<>();
	}

	/**
	 * Adds a new MaterialData to the List
	 * 
	 * @param data
	 */
	public void addPropertiesRow(MaterialData data) {
		propertiesList.add(data);
	}

	/**
	 * Gets the properties of material with respect to given ID.
	 * 
	 * @param ID
	 * @return data type: MaterialData
	 */
	public MaterialData getPropertiesDataFromID(MaterialID ID) {
		MaterialData returnedData = null;
		for (MaterialData data : propertiesList) {
			if (data.getID().equals(ID)) {
				returnedData = data;
				break;
			}
		}

		return returnedData;
	}
	/**
	 * Returns a shallow copy of the material data list.
	 * @return List<MaterialData> propertiesList
	 */
	public List<MaterialData> getList() {
		return propertiesList;
	}

}