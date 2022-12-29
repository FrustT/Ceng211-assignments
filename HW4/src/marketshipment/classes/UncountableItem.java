package marketshipment.classes;

import marketshipment.interfaces.Uncountable;

/**
 * This class is a sub-class of the abstract class AbstractItem, provides
 * concrete implementations to the abstract methods in super-class.
 *
 * <ul>
 * <li><strong>mass</strong> type: int
 * </ul>
 * 
 * @author Mustafa Fatih Can 280201007
 * @author Deniz Kaya 280201033
 * @author Hakan Uskan 280201076
 * @author Burak Erinc 290201099
 */
public class UncountableItem extends AbstractItem implements Uncountable {

	private int mass;

	/**
	 * <strong>No Argument Constructor</strong>
	 * <p>
	 */
	public UncountableItem() {
		super();
		mass = 0;
	}

	/**
	 * <strong>Copy Constructor</strong>
	 * <p>
	 * Constructs a new UncountableItem Object with another UncountableItem Object
	 * 
	 * @param _item
	 */
	public UncountableItem(UncountableItem _item) {
		super(_item);
		mass = _item.getMass();
	}

	/**
	 * <strong>Parameterized Constructor</strong>
	 * <p>
	 * Constructs UncountableItem object with required data.
	 * 
	 * @param _itemCode
	 * @param _mass
	 * @param _volume
	 * @param _serialNumber
	 */
	public UncountableItem(ItemCode _itemCode, int _mass, double _volume, String _serialNumber) {
		super(_itemCode, _volume, _serialNumber);
		mass = _mass;
	}
	

	@Override
	public double getCost() {
		return (double) mass * getItemCode().getCost();
	}

	@Override
	public int getMass() {
		return mass;
	}

	@Override
	public String toString() {
		return this.getMass() + " kilogram(s) of " + this.getItemCode().getName() + " with Serial Number of "
				+ this.getSerialNumber();
	}
}
