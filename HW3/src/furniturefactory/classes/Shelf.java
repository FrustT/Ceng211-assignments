package furniturefactory.classes;

import java.util.List;

import furniturefactory.dataclasses.FurnitureID;

public class Shelf extends Furniture {

	
	
	public Shelf(FurnitureID id, List<Material> materials) {
		super(id, materials);
	}
	
	public Shelf(Shelf shelf){
		super(shelf);
	}
	
	
	public float initializeProfitMargin() {
		return 280;
	}

}
