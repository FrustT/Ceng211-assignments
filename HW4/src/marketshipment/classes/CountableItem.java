package marketshipment.classes;

import marketshipment.interfaces.Countable;

/**
 * This class is a sub-class of the abstract class AbstractItem, provides concrete
 * implementations to the abstract methods in super-class.
 * 
 * @author Mustafa Fatih Can 280201007
 * @author Deniz Kaya 280201033
 * @author Hakan Uskan 280201076
 * @author Burak Erinc 290201099
 */

public class CountableItem extends AbstractItem implements Countable {
	
	/**
	 * <strong>No Argument Constructor</strong>
	 * <p>
	 */
	public CountableItem() {
		super();
	}
	/**
	 * <strong>Copy Constructor</strong>
	 * <p>
	 * Constructs a new CountableItem Object with another CountableItem Object.
	 * 
	 * @param _item
	 */
	public CountableItem(CountableItem _item) {
		super(_item);
	}
	
	/**
	 * <strong>Parameterized Constructor</strong>
	 * <p>
	 * Constructs CountableItem object with required data.
	 * 
	 * @param _itemCode
	 * @param _volume
	 * @param _serialNumber
	 */
	public CountableItem(ItemCode _itemCode, double _volume, String _serialNumber) {
		super(_itemCode, _volume, _serialNumber);
	}
	
	
	@Override
	public String toString() {
		return this.getVolume()+" liter(s) of "+this.getItemCode().getName()+" with Serial Number of "+ this.getSerialNumber();
	}
	
}
