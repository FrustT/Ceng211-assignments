package marketshipment.classes;

import marketshipment.exceptions.InvalidLoadOfSerialException;
import marketshipment.interfaces.*;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBox<T extends Item> implements Box<T>, Holder<T> {

	private List<T> contents;
	private BoxCode boxCode;
	private String serialNumber;
	private double totalVolume;
	private boolean isInContainer;
	private double maxVolume;
	private double revenue;

	protected AbstractBox() {
		boxCode = null;
		serialNumber = "Default Box. No serial number.";
		contents = new ArrayList<>();
		totalVolume = 0;
		isInContainer = false;
		maxVolume = 0;
		revenue = 0;
	}

	protected AbstractBox(AbstractBox<T> _box) {
		boxCode = _box.getBoxCode();
		serialNumber = _box.getSerialNumber();
		contents = _box.getContents();
		totalVolume = _box.getTotalVolume();
		isInContainer = _box.isInContainer();
		maxVolume = _box.getMaxVolume();
		revenue = _box.getTotalRevenue();
	}

	protected AbstractBox(BoxCode _boxCode, double _maxVolume, String _serialNumber) {
		contents = new ArrayList<>();
		boxCode = _boxCode;
		serialNumber = _serialNumber;
		totalVolume = 0;
		isInContainer = false;
		maxVolume = _maxVolume;
		revenue = 0.0;
	}

	public abstract boolean haveRoomForItem(T item);

	public abstract void updateRespectiveTotalAmount(T item);

	public String getSerialNumber() {
		return serialNumber;
	}

	public List<T> getContents() {
		List<T> result = new ArrayList<>();
		for (T item : contents) {
			result.add(item);
		}
		return result;
	}

	public int getIndexOf(T _element) {
		return getIndexOfWithSerial(_element.getSerialNumber());

	}

	public int getIndexOfWithSerial(String s) {
		for (int i = 0; i < contents.size(); i++) {
			if (contents.get(i).getSerialNumber().equals(s))
				return i;
		}
		return -1;
	}

	public int getPriceOfItems() {
		int result = 0;
		for (Item item : contents) {
			result += item.getPrice();
		}
		return result;
	}

	public boolean isInContainer() {
		return isInContainer;
	}

	public BoxCode getBoxCode() {
		return boxCode;
	}

	public int getCost() {
		return boxCode.getCost();
	}

	public boolean hasSpareVolume(T item) {
		return (item.getVolume() + totalVolume) <= maxVolume;
	}

	@Override
	public double getMaxVolume() {
		return maxVolume;
	}

	@Override
	public double getTotalRevenue() {
		return revenue;
	}

	@Override
	public double getTotalVolume() {
		return totalVolume;
	}

	@Override
	public void add(T _element) throws Exception {// TODO try catch
		if (isAddible(_element)) {
		contents.add(_element);
		revenue += _element.getRevenue();
		totalVolume += _element.getVolume();
		updateRespectiveTotalAmount(_element);
		_element.load();
		}
	}

	@Override
	public void putInContainer() {
		isInContainer = true;
	}

	private boolean isAddible(T item) throws Exception {//TODO change to ruleexception
		if (item.isLoaded()) {
			throw new InvalidLoadOfSerialException();
		}
		if(this.isInContainer)throw new Exception();//TODO
			
		if(!this.haveRoomForItem(item))throw new Exception();//TODO
		return true;
	}
}