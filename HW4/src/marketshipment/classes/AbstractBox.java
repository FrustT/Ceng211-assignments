package marketshipment.classes;

import marketshipment.exceptions.CannotBeAddedToHolderException;
import marketshipment.exceptions.HolderIsFullException;
import marketshipment.exceptions.HolderIsNotAccessibleException;
import marketshipment.exceptions.LoadIsAlreadyLoadedException;
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
	private double totalPrice;
	private double totalCost;


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

	public abstract boolean haveRoomForItem(T item) throws CannotBeAddedToHolderException;

	public abstract void updateRespectiveTotalAmount(T item);
	
	public double getTotalPrice() {
		return totalPrice;
	}
	
	public double getTotalCost() {
		return totalCost;
	}
	
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

	public boolean isInContainer() {
		return isInContainer;
	}

	public BoxCode getBoxCode() {
		return boxCode;
	}

	public boolean hasSpareVolume(T item) {
		return (item.getVolume() + totalVolume) <= maxVolume;
	}

	@Override
	public double getMaxVolume() {
		return maxVolume;
	}

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