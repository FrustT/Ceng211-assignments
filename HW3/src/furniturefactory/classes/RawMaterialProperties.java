package furniturefactory.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class RawMaterialProperties {
	private List<Data> propertiesList;
	
	public RawMaterialProperties(int rowCount, int columnCount) {
		propertiesList = new ArrayList<Data>();
	}
	
	public void addPropertiesRow(Data data) {
		propertiesList.add(data);
	}
	
	public Data getPropertiesDataFromID(String ID) {
		MaterialID enumID = MaterialID.valueOf(ID.toUpperCase(Locale.ROOT));
		Data returnedData = null;
		for(Data data:propertiesList) {
			if(data.getID().equals(enumID)) {
				returnedData = data;
				break;
			}
		}
		
		return returnedData;
	}
	
}