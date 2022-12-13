package furniturefactory.dataclasses;

import java.util.ArrayList;
import java.util.List;

import furniturefactory.adt.Pair;

public class FurnitureData {

	private FurnitureID id;
	private List<Pair<MaterialID, Integer>> materialRequirementList;

	public FurnitureData(FurnitureID id, List<Pair<MaterialID, Integer>> requiredMaterials) {
		this.id = id;
		this.materialRequirementList = requiredMaterials;
	}
	
	public FurnitureData(FurnitureData data) {
		this.id = data.getID();
		this.materialRequirementList = data.getRequirementList();
	}

	public FurnitureID getID() {
		return this.id;
	}

	public List<Pair<MaterialID, Integer>> getRequirementList() {
		List<Pair<MaterialID, Integer>> returned = new ArrayList<>();
		for(Pair<MaterialID, Integer> pair: this.materialRequirementList) {
			returned.add(new Pair<MaterialID, Integer>(pair));//Since the types in pair are immutable, it is safe to do it here.
		}
		return returned;
	}
}
