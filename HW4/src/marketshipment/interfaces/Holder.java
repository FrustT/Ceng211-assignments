package marketshipment.interfaces;

import java.util.List;
import marketshipment.exceptions.CannotBeAddedToHolderException;

/**
 * Holder Interface defines which methods a Holder object should have.
 * 
 * @author Mustafa Fatih Can 280201007
 * @author Deniz Kaya 280201033
 * @author Hakan Uskan 280201076
 * @author Burak Erinç 290201099
 *
 * @param <T>
 */
public interface Holder<T extends Serial> extends Serial {

	/**
	 * Adds the element to the Holder.
	 *
	 * @param _element type: T The element to be added to he Holder.
	 * @throws CannotBeAddedToHolderException
	 */
	public void add(T _element) throws CannotBeAddedToHolderException;

	/**
	 * Gets the content of the Holder
	 *
	 * @return List<T>
	 */
	public List<T> getContents();

	/**
	 * Gets the index of the given T Object in parameter, returns -1 if not found.
	 * 
	 * @param _element type: T The element whose index we want to find.
	 * @return type: int
	 */
	public int getIndexOf(T _element);

	/**
	 * Gets the index of the String serial number in parameter, returns -1 if not
	 * found.
	 *
	 * @param _serialNumber type String The serial number whose index we want to
	 *                      find.
	 * @return type: int
	 */
	public int getIndexOfWithSerial(String _serialNumber);

	/**
	 * Gets the total price of the Elements inside.
	 *
	 * @return type: double
	 */
	public double getTotalPrice();

	/**
	 * Gets the total cost of the Elements inside plus cost of Holder.
	 *
	 * @return type: double
	 */
	public double getTotalCost();

}
