package marketshipment.classes;

import marketshipment.exceptions.CannotBeAddedToHolderException;
import marketshipment.exceptions.HolderIsFullException;
import marketshipment.exceptions.HolderIsNotAccessibleException;
import marketshipment.exceptions.LoadIsAlreadyLoadedException;
import marketshipment.interfaces.*;

import java.util.ArrayList;
import java.util.List;

/**
 *	This abstract class implements the box interface and partially implements 
 *  the descendants of this class.
 * <ul>
 * <li><strong>contents</strong> type: List<T>
 * <li><strong>boxCode</strong> type: BoxCode
 * <li><strong>serialNumber</strong> type: String
 * <li><strong>totalVolume</strong> type: double
 * <li><strong>isInContainer</strong> type: boolean
 * <li><strong>maxVolume</strong> type: double
 * <li><strong>totalPrice</strong> type: double
 * <li><strong>totalCost</strong> type: double
 * </ul>
 * 
 * @author Mustafa Fatih Can 280201007
 * @author Deniz Kaya 280201033
 * @author Hakan Uskan 280201076
 * @author Burak Erinc 290201099
 */

public abstract class AbstractBox<T extends Item> implements Box<T>, Holder<T> {

	private List<T> contents;
	private BoxCode boxCode;
	private String serialNumber;
	private double totalVolume;
	private boolean isInContainer;
	private double maxVolume;
	private double totalPrice;
	private double totalCost;

	/**
	 * <strong>No Argument Constructor</strong>
	 * <p>
	 */
	protected AbstractBox() {
		boxCode = null;
		serialNumber = "Default Box. No serial number.";
		contents = new ArrayList<>();
		totalVolume = 0;
		isInContainer = false;
		maxVolume = 0;
		totalPrice = 0;
		totalCost = 0;
	}
	
	/**
	 * <strong>Copy Constructor</strong>
	 * <p>
	 * Constructs a new AbstractBox Object with another AbstractBox Object
	 * 
	 * @param _box
	 */
	protected AbstractBox(AbstractBox<T> _box) {
		boxCode = _box.getBoxCode();
		serialNumber = _box.getSerialNumber();
		contents = _box.getContents();
		totalVolume = _box.getTotalVolume();
		isInContainer = _box.isInContainer();
		maxVolume = _box.getMaxVolume();
		totalPrice = _box.getTotalPrice();
		totalCost = _box.getTotalCost();
	}
	
	/**
	 * <strong>Parameterized Constructor</strong>
	 * <p>
	 * Constructs AbstractBox object with required data.
	 * 
	 * @param _boxCode
	 * @param _maxVolume
	 * @param _serialNumber
	 */
	protected AbstractBox(BoxCode _boxCode, double _maxVolume, String _serialNumber) {
		contents = new ArrayList<>();
		boxCode = _boxCode;
		serialNumber = _serialNumber;
		totalVolume = 0;
		isInContainer = false;
		maxVolume = _maxVolume;
		totalCost = boxCode.getCost() * maxVolume;
		totalPrice = 0;
	}
	
	
	/**
	 * Returns true if element can load to Box object, otherwise returns false.
	 *
	 * @param item type: T The item Element to be put in the box.
	 * @return type: boolean
	 * @throws CannotBeAddedToHolderException
	 */
	public abstract boolean haveRoomForItem(T item) throws CannotBeAddedToHolderException;
	 
	/**
	 *  Updates the mass or number of items in a box respect to its type.(NumberBox -> numberOfItems, MassBox -> mass)
	 * 
	 * @param item type: T
	 */
	public abstract void updateRespectiveTotalAmount(T item);
	
	@Override
	public double getTotalPrice() {
		return totalPrice;
	}
	
	@Override
	public double getTotalCost() {
		return totalCost;
	}
	
	@Override
	public String getSerialNumber() {
		return serialNumber;
	}

	@Override
	public List<T> getContents() {
		List<T> result = new ArrayList<>();
		for (T item : contents) {
			result.add(item);
		}
		return result;
	}

	@Override
	public int getIndexOf(T _element) {
		return getIndexOfWithSerial(_element.getSerialNumber());

	}

	@Override
	public int getIndexOfWithSerial(String _serialNumber) {
		for (int i = 0; i < contents.size(); i++) {
			if (contents.get(i).getSerialNumber().equals(_serialNumber))
				return i;
		}
		return -1;
	}

    @Override
	public boolean isInContainer() {
		return isInContainer;
	}
	
    /**
     * Gets the BoxCode.
     *
     * @return type: BoxCode
     */
	public BoxCode getBoxCode() {
		return boxCode;
	}

	/**
	 * Returns true if the box will not be full even after we add the item.
	 *
	 * @param item
	 * @return boolean
	 */
	public boolean hasSpareVolume(T item) {
		return (item.getVolume() + totalVolume) <= maxVolume;
	}

	@Override
	public double getMaxVolume() {
		return maxVolume;
	}

	@Override
	public double getRevenue() {
		return totalPrice - totalCost;
	}

	@Override
	public double getTotalVolume() {
		return totalVolume;
	}

	@Override
	public void add(T _element) throws CannotBeAddedToHolderException {
		contents.add(_element);
		totalPrice += _element.getPrice();
		totalCost += _element.getCost();
		totalVolume += _element.getVolume();
		updateRespectiveTotalAmount(_element);
		_element.load();
	}

	@Override
	public void putInContainer() {
		isInContainer = true;
	}
	
	/**
	 * Returns true if element can load to Box object, otherwise returns false.
	 *
	 * @param item type: T
	 * @return type: boolean
	 * @throws CannotBeAddedToHolderException
	 */
	protected boolean isAddible(T item) throws CannotBeAddedToHolderException {
		if (item.isLoaded()) {
			throw new LoadIsAlreadyLoadedException();
		}
		
		if(this.isInContainer) {
			throw new HolderIsNotAccessibleException();
		}
			
		if(!this.haveRoomForItem(item)){
			throw new HolderIsFullException();
		}
		
		return true;
	}
}