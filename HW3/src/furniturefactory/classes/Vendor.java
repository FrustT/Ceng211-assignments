package furniturefactory.classes;

import java.util.ArrayList;
import java.util.List;

import furniturefactory.interfaces.*;

public class Vendor implements IVendor {
	private List<Deque<Material>> materials;
	
	public Vendor() {
		materials = new ArrayList<Deque<Material>>();
	}
	
	public void addMaterial(Material material) {
		Deque<Material> appropriateDeque = findAppropriateDeque(material.getID());
		if(appropriateDeque == null) {
			Deque<Material> addedDeque = new Deque<Material>();
			addedDeque.add(material);
			materials.add(addedDeque);
			return;
		}
		appropriateDeque.add(material);
		
	}
	
	public Material getFirstOccurrence(MaterialID ID) {
		Deque<Material> materialsDeque =this.findAppropriateDeque(ID);
		if(materialsDeque == null)return null;
		return materialsDeque.removeFirst();
	}
	
	public Material getLastOccurrence(MaterialID ID) {
		Deque<Material> materialsDeque =this.findAppropriateDeque(ID);
		if(materialsDeque == null)return null;
		return materialsDeque.removeLast();
	}

	
	public Material PeekFirstOccurence(MaterialID ID) {
		Deque<Material> materialsDeque =this.findAppropriateDeque(ID);
		if(materialsDeque == null)return null;
		return materialsDeque.peekFirst();
	}

	
	public Material PeekLastOccurence(MaterialID ID) {
		Deque<Material> materialsDeque =this.findAppropriateDeque(ID);
		if(materialsDeque == null)return null;
		return materialsDeque.peekLast();
	}
	
	public Deque<Material> findAppropriateDeque(MaterialID ID) {//Returns null if no appropriate deque exists.
		Deque<Material> returned = null;
		for(Deque<Material> deque: materials) {
			if(deque.peekFirst().getID().equals(ID)) {
				returned = deque;
			}
		}
		return returned;
	}
	
}
