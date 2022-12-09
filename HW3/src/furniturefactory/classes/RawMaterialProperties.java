package furniturefactory.classes;

import java.util.ArrayList;
import java.util.List;

public class RawMaterialProperties {
	private List<MaterialData> propertiesList;
	
	public RawMaterialProperties() {
		propertiesList = new ArrayList<MaterialData>();
	}
	
	public void addPropertiesRow(MaterialData data) {
		propertiesList.add(data);
	}
	
	public MaterialData getPropertiesDataFromID(MaterialID ID) {
		MaterialData returnedData = null;
		for(MaterialData data:propertiesList) {
			if(data.getID().equals(ID)) {
				returnedData = data;
				break;
			}
		}
		
		return returnedData;
	}

	public List<MaterialData> getList(){
		return propertiesList;
	}
	
}