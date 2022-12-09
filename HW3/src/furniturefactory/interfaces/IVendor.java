package furniturefactory.interfaces;
import furniturefactory.classes.Material;
import furniturefactory.classes.MaterialID;

public interface IVendor {
	public void addMaterial(Material material);
	
	public Material getFirstOccurrence(MaterialID ID);
	public Material getLastOccurrence(MaterialID ID);
	
	public Material PeekFirstOccurence(MaterialID ID);
	public Material PeekLastOccurence(MaterialID ID);
}
