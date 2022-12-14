package furniturefactory.interfaces;

import furniturefactory.classes.Material;
import furniturefactory.dataclasses.MaterialID;

/**
 * Vendor Interface defines which methods a IVendor object should have
 *
 * @author Mustafa Fatih Can 280201007
 * @author Deniz Kaya 280201033
 * @author Hakan Uskan 280201076
 * @author Burak Erinç 290201099
 */
public interface IVendor {

	/**
	 * Adds A material to the Vendor
	 * 
	 * @param material
	 */
	public void addMaterial(Material material);

	/**
	 * Removes and returns the first occurence of the Material that its ID given
	 * 
	 * @param ID
	 * @return material type: Material
	 */
	public Material removeFirstOccurrence(MaterialID ID);

	/**
	 * Removes and returns the last occurence of the Material that its ID given
	 * 
	 * @param ID
	 * @return material type: Material
	 */
	public Material removeLastOccurrence(MaterialID ID);

	/**
	 * Returns the first occurence of the Material that its ID given
	 * 
	 * @param ID
	 * @return material type: Material
	 */
	public Material peekFirstOccurence(MaterialID ID);

	/**
	 * Returns the last occurence of the Material that its ID given
	 * 
	 * @param ID
	 * @return material type: Material
	 */
	public Material peekLastOccurence(MaterialID ID);

}
