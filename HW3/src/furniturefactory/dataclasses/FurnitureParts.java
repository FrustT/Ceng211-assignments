package furniturefactory.dataclasses;

import java.util.ArrayList;
import java.util.List;

public class FurnitureParts {
	private List<FurnitureData> partsList;

	public FurnitureParts() {
		partsList = new ArrayList<>();
	}

	public void addPropertiesRow(FurnitureData data) {
		partsList.add(data);
	}

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

	public List<FurnitureData> getList() {
		return partsList;
	}

}
