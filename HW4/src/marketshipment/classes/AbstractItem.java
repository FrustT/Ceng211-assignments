package marketshipment.classes;

import marketshipment.interfaces.*;

public abstract class AbstractItem implements Item {
	private double price;
	private double cost;
	private double volume;
	private ItemCode itemCode;
	private String serialNumber;

	public AbstractItem() {
		price = 0;
		cost = 0;
		volume = 0;
		itemCode = null;
		serialNumber = "Default item. No serial number.";
	}

	public AbstractItem(AbstractItem _item) {
		price = _item.getPrice();
		cost = _item.getCost();
		volume = _item.getVolume();
		itemCode = _item.getItemCode();
		serialNumber = _item.getSerialNumber();
	}

	public AbstractItem(ItemCode _itemCode, double _volume, String _serialNumber) {
		volume = _volume;
		itemCode = _itemCode;
		serialNumber = _serialNumber;
		price = _itemCode.getPrice() * _volume;
		cost = getCost();
	}

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
}
