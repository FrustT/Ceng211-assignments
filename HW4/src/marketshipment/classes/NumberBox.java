package marketshipment.classes;

import marketshipment.exceptions.CannotBeAddedToHolderException;
import marketshipment.exceptions.HolderIsFullException;
import marketshipment.exceptions.InvalidBoxException;
import marketshipment.interfaces.*;

/**
 * NumberBox class holds countable items that are boxed according to their number and volume.
 *
 * <ul>
 * <li><strong>maxNumberOfItems</strong> type: int
 * <li><strong>numberOfItems</strong> type: int
 * </ul>
 * 
 * @author Mustafa Fatih Can 280201007
 * @author Deniz Kaya 280201033
 * @author Hakan Uskan 280201076
 * @author Burak Erinc 290201099
 */

public class NumberBox<T extends Item> extends AbstractBox<T>{
	private int maxNumberOfItems;
	private int numberOfItems;
	
	/**
	 * <strong>No Argument Constructor</strong>
	 * <p>
	 */
	public NumberBox() {
		super();
		maxNumberOfItems = 0;
		numberOfItems = 0;
	}
	
	/**
	 * <strong>Copy Constructor</strong>
	 * <p>
	 * Constructs a new NumberBox Object with another NumberBox Object
	 * 
	 * @param _box
	 */
	public NumberBox(NumberBox<T> _box) {
		super(_box);
		maxNumberOfItems = _box.getNumberOfItems();
		numberOfItems = _box.getNumberOfItems();
	}
	
	/**
	 * <strong>Parameterized Constructor</strong>
	 * <p>
	 * Constructs NumberBox object with required data.
	 * 
	 * @param _boxCode
	 * @param _maxNumberOfItems
	 * @param _maxVolume
	 * @param _serialNumber
	 */
	public NumberBox(BoxCode _boxCode, int _maxNumberOfItems, double _maxVolume, String _serialNumber){
		super(_boxCode, _maxVolume, _serialNumber);
		maxNumberOfItems = _maxNumberOfItems;
		numberOfItems = 0;
	}
	
	
	/**
	 * Gets the number of elements in the NumberBox object.
	 *
	 * @return type: int
	 */
	public int getNumberOfItems() {
		return numberOfItems;
	}
	
	/**
	 * Gets the maximum number of elements the NumberBox can contain.
	 *
	 * @return type: int
	 */
	public int getMaxNumberOfItems() {
		return maxNumberOfItems;
	}
	
	@Override
	public void add(T _element) throws CannotBeAddedToHolderException {
		if(!(_element instanceof Countable)) {
			throw new InvalidBoxException();
		}
		if (isAddible(_element)) {
			super.add(_element);
		}
	}
	
	@Override
	public boolean haveRoomForItem(T item) throws CannotBeAddedToHolderException{
		if(hasSpareVolume(item) && (numberOfItems < maxNumberOfItems)) {
			return true;
		}
		throw new HolderIsFullException();
	}

	@Override
	public void updateRespectiveTotalAmount(T item) {
		numberOfItems++;
	}
	
	@Override
	public String toString() {
		return this.getMaxVolume()+" liter(s) of Number Box with capacity of "+ this.getMaxNumberOfItems()+" with Serial Number of "+ this.getSerialNumber();
	}
}
