package furniturefactory.interfaces;
import furniturefactory.classes.Material;
import furniturefactory.dataclasses.MaterialID;

public interface IVendor {
	public void addMaterial(Material material);
	
	public Material removeFirstOccurrence(MaterialID ID);
	public Material removeLastOccurrence(MaterialID ID);
	
	public Material peekFirstOccurence(MaterialID ID);
	public Material peekLastOccurence(MaterialID ID);
	
}
