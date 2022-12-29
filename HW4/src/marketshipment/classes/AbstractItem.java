package marketshipment.classes;

import marketshipment.interfaces.*;

/**
 * This abstract class partially implements item interface and partially implements
 * descendants of this class.
 *
 * <ul>
 * <li><strong>price</strong> type: double
 * <li><strong>cost</strong> type: double
 * <li><strong>volume</strong> type: double
 * <li><strong>itemCode</strong> type: ItemCode
 * <li><strong>serialNumber</strong> type: String
 * <li><strong>loaded</strong> type: boolean
 * </ul>
 * 
 * @author Mustafa Fatih Can 280201007
 * @author Deniz Kaya 280201033
 * @author Hakan Uskan 280201076
 * @author Burak Erinc 290201099
 */

public abstract class AbstractItem implements Item {
	private double price;
	private double cost;
	private double volume;
	private ItemCode itemCode;
	private String serialNumber;
	private boolean loaded;
	
	/**
	 * <strong>No Argument Constructor</strong>
	 * <p>
	 */
	protected AbstractItem() {
		price = 0;
		cost = 0;
		volume = 0;
		itemCode = null;
		serialNumber = "Default item. No serial number.";
		loaded = false;
	}
	
	/**
	 * <strong>Copy Constructor</strong>
	 * <p>
	 * Constructs a new AbstractItem Object with another AbstractItem Object
	 * 
	 * @param _item
	 */
	protected AbstractItem(AbstractItem _item) {
		price = _item.getPrice();
		cost = _item.getCost();
		volume = _item.getVolume();
		itemCode = _item.getItemCode();
		serialNumber = _item.getSerialNumber();
		loaded = _item.isLoaded();
	}
	
	/**
	 * <strong>Parameterized Constructor</strong>
	 * <p>
	 * Constructs AbstractItem object with required data.
	 * 
	 * @param _itemCode
	 * @param _volume
	 * @param _serialNumber
	 */
	protected AbstractItem(ItemCode _itemCode, double _volume, String _serialNumber) {
		volume = _volume;
		itemCode = _itemCode;
		serialNumber = _serialNumber;
		price = _itemCode.getPrice() * _volume;
		cost = getCost();
		loaded = false;
	}
	
	
	@Override
	public double getCost() {
		return volume * itemCode.getCost();
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public double getRevenue() {
		return price - cost;
	}

	@Override
	public double getVolume() {
		return volume;
	}

	@Override
	public String getSerialNumber() {
		return serialNumber;
	}

	@Override
	public ItemCode getItemCode() {
		return itemCode;
	}
	
	@Override
	public boolean isLoaded() {
		return loaded;
	}
	
	@Override
	public void load() {
		loaded = true;
	}
}
