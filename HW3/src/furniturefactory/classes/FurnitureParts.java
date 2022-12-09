package furniturefactory.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FurnitureParts {
private List<FurnitureData> partsList;
	
	public FurnitureParts() {
		partsList = new ArrayList<FurnitureData>();
	}
	
	public void addPropertiesRow(FurnitureData data) {
		partsList.add(data);
	}
	
	public FurnitureData getPropertiesDataFromID(String ID) {
		FurnitureID enumID = FurnitureID.valueOf(ID.toUpperCase(Locale.ROOT));
		FurnitureData returnedData = null;
		for(FurnitureData data:partsList) {
			if(data.getID().equals(enumID)) {
				returnedData = data;
				break;
			}
		}
		
		return returnedData;
	}

	public List<FurnitureData> getList(){
		return partsList;
	}
	
}
