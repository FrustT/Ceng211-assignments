package furniturefactory.classes;

import java.util.List;

import furniturefactory.dataclasses.FurnitureID;

public class Table extends Furniture {

	public Table(FurnitureID id, List<Material> materials) {
		super(id, materials);
	}

	public Table(Table table) {
		super(table);
	}

	public float initializeProfitMargin() {
		return 300;
	}

}
