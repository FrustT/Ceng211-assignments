package marketshipment.classes;

import marketshipment.interfaces.*;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBox<T extends Item> implements Box<T> {
	private List<T> contents;
	private BoxCode boxCode;
	private String serialNumber;
	private double totalVolume;
	private boolean isInContainer;
	private double maxVolume;
	private double revenue;

	public AbstractBox() {
		boxCode = null;
		serialNumber = "Default Box. No serial number.";
		contents = new ArrayList<T>();
		totalVolume = 0;
		isInContainer = false;
		maxVolume = 0;
		revenue = 0;
	}

	public AbstractBox(AbstractBox<T> _box) {
		boxCode = _box.getBoxCode();
		serialNumber = _box.getSerialNumber();
		contents = _box.getContents();
		totalVolume = _box.getTotalVolume();
		isInContainer = _box.getIsInContainer();
		maxVolume = _box.getMaxVolume();
		revenue = _box.getRevenue();
	}

	public AbstractBox(BoxCode _boxCode, double _maxVolume, String _serialNumber) {
		contents = new ArrayList<T>();
		boxCode = _boxCode;
		serialNumber = _serialNumber;
		totalVolume = 0;
		isInContainer = false;
		maxVolume = _maxVolume;
		revenue = 0 - boxCode.getCost();
	}


	public abstract boolean haveRoomForItem(T item);
	
	public abstract void updateRespectiveTotalAmount(T item);
	
	public String getSerialNumber() {
		return serialNumber;
	}

	public List<T> getContents() {
		List<T> result = new ArrayList<T>();
		for (T item : contents) {
			result.add(item);
		}
		return result;
	}

	public boolean getIsInContainer() {
		return isInContainer;
	}

	public BoxCode getBoxCode() {
		return boxCode;
	}
	
	public boolean hasSpareVolume(T item) {
		return (item.getVolume() + this.totalVolume) <= this.maxVolume;
	}

	public boolean isAddible(T item) {
		return this.haveRoomForItem(item) && !this.isInContainer;
	}
	
	@Override
	public double getMaxVolume() {
		return maxVolume;
	}


	@Override
	public double getRevenue() {
		return revenue;
	}

	@Override
	public double getTotalVolume() {
		return totalVolume;
	}
	
	@Override
	public void add(T _element) {
		if (!isAddible(_element)) {

		} // TODO THROW EXCEPTION
		contents.add(_element);
		revenue += _element.getRevenue();
		totalVolume += _element.getVolume();
		updateRespectiveTotalAmount(_element);
	}

	@Override
	public void putInContainer() {
		isInContainer = true;
	}
}