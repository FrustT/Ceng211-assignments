package furniturefactory.classes;

import furniturefactory.adt.KeyedDequePairList;
import furniturefactory.dataclasses.MaterialID;
import furniturefactory.interfaces.*;

public class Vendor implements IVendor {
	private IKeyedDequePairList<MaterialID, Material> materials;

	public Vendor() {
		this.materials = new KeyedDequePairList<>();
	}

	public void addMaterial(Material material) {
		materials.addElement(material.getID(), material);
	}

	public Material removeFirstOccurrence(MaterialID ID) {
		return materials.removeFirstOccurrence(ID);
	}

	public Material removeLastOccurrence(MaterialID ID) {
		return materials.removeLastOccurrence(ID);
	}

	public Material peekFirstOccurence(MaterialID ID) {
		return materials.peekFirstOccurence(ID);
	}

	public Material peekLastOccurence(MaterialID ID) {
		return materials.peekLastOccurence(ID);
	}

}
