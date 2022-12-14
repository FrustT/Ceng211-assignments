package furniturefactory.dataclasses;

import java.util.ArrayList;
import java.util.List;
import furniturefactory.adt.Pair;

/**
 * Hold the data of the furniture with its id
 * 
 * <ul>
 * <li><strong>id</strong> type: FurnitureID
 * <li><strong>materialRequirementList</strong> type: List<Pair<MaterialID,
 * Integer>>
 * </ul>
 * 
 * @author Mustafa Fatih Can 280201007
 * @author Deniz Kaya 280201033
 * @author Hakan Uskan 280201076
 * @author Burak Erinc 290201099
 */
public class FurnitureData {

	private FurnitureID id;
	private List<Pair<MaterialID, Integer>> materialRequirementList;

	/**
	 * <strong>Parameterized Constructor</strong>
	 * <p>
	 * Constructs FurnitureData Object with required data.
	 * 
	 * @param id
	 * @param requiredMaterials
	 */
	public FurnitureData(FurnitureID id, List<Pair<MaterialID, Integer>> requiredMaterials) {
		this.id = id;
		this.materialRequirementList = requiredMaterials;
	}

	/**
	 * <strong>Copy Constructor</strong>
	 * <p>
	 * Constructs a new FurnitureData Object with another FurnitureData Object
	 * 
	 * @param data
	 */
	public FurnitureData(FurnitureData data) {
		this.id = data.getID();
		this.materialRequirementList = data.getRequirementList();
	}

	public FurnitureID getID() {
		return this.id;
	}

	/**
	 * Returns a deep copy of requirementList.
	 * 
	 * @return List<Pair<MaterialID, Integer>> requirementList
	 */
	public List<Pair<MaterialID, Integer>> getRequirementList() {
		List<Pair<MaterialID, Integer>> returned = new ArrayList<>();
		for (Pair<MaterialID, Integer> pair : this.materialRequirementList) {
			returned.add(new Pair<MaterialID, Integer>(pair));// Since the types in pair are immutable, it is safe to do
																// it here.
		}
		return returned;
	}
}
