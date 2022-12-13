package furniturefactory.classes;

import java.util.List;

import furniturefactory.dataclasses.FurnitureID;

public class Wardrobe extends Furniture {

	
	public Wardrobe(FurnitureID id, List<Material> materials) {
		super(id, materials);
	}
	
	public Wardrobe(Wardrobe wardrobe){
		super(wardrobe);
	}
	
	public int getProfitMargin() {
		return 320;
	}

}
