package furniturefactory.classes;

import furniturefactory.adt.KeyedDequePairList;
import furniturefactory.dataclasses.MaterialID;
import furniturefactory.interfaces.*;

/**
 * This Vendor class holds materials and sells them for manufacturers
 * 
 * @author Mustafa Fatih Can 280201007
 * @author Deniz Kaya 280201033
 * @author Hakan Uskan 280201076
 * @author Burak Erinc 290201099
 */
public class Vendor implements IVendor {
	private IKeyedDequePairList<MaterialID, Material> materials;

	/**
	 * <strong>No Argument Constructor</strong>
	 * <p>
	 */
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
