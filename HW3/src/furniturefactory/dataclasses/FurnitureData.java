package furniturefactory.dataclasses;

import java.util.List;

import furniturefactory.adt.Pair;


public class FurnitureData {
	
	private FurnitureID id;
	private List<Pair<MaterialID,Integer>> materialRequirementList;
	
	
	public FurnitureData(FurnitureID id,List<Pair<MaterialID,Integer>> requiredMaterials){
		this.id = id;
		this.materialRequirementList = requiredMaterials;
	}
	public FurnitureID getID(){
		return this.id;
	}
	
	//FOR DEBUGGING
	public List<Pair<MaterialID,Integer>> getRequirementList(){
		return this.materialRequirementList;
	}
}