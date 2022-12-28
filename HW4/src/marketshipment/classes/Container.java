package marketshipment.classes;

import java.util.ArrayList;
import java.util.List;

import marketshipment.exceptions.InvalidLoadOfSerialException;
import marketshipment.interfaces.Box;
import marketshipment.interfaces.IContainer;
import marketshipment.interfaces.Item;

public class Container<T extends Box<Item>> implements IContainer<T> {
	private ContainerCode containerCode;
	private List<T> contents;
	private String serialNumber;
	private boolean isShipped;
	private double maxVolume;
	private double totalVolume;
	private double revenue;

	public Container() {
		containerCode = null;
		contents = new ArrayList<>();
		serialNumber = "Container is not initialized.";
		isShipped = false;
		maxVolume = 0;
		totalVolume = 0;
		revenue = 0.0;
	}

	public Container(Container<T> _container) {
		containerCode = _container.getContainerCode();
		contents = _container.getContents();
		serialNumber = _container.getSerialNumber();
		isShipped = _container.isShipped();
		maxVolume = _container.getMaxVolume();
		totalVolume = _container.getTotalVolume();
		revenue = _container.getTotalRevenue();
	}

	public Container(ContainerCode _containerCode, double _maxVolume, String _serialNumber) {
		containerCode = _containerCode;
		contents = new ArrayList<>();
		serialNumber = _serialNumber;
		isShipped = false;
		maxVolume = _maxVolume;
		totalVolume = 0;
		revenue = 0.0;
	}

	@Override
	public ContainerCode getContainerCode() {
		return containerCode;
	}

	public List<T> getContents() {
		List<T> result = new ArrayList<>();
		for (T item : contents) {
			result.add(item);
		}
		return result;
	}

	@Override
	public String getSerialNumber() {
		return serialNumber;
	}

	@Override
	public boolean isShipped() {
		return isShipped;
	}

	public double getMaxVolume() {
		return maxVolume;
	}

	public double getTotalVolume() {
		return totalVolume;
	}

	@Override
	public double getTotalRevenue() {
		return revenue;
	}

	@Override
	public void ship() {
		this.isShipped = true;
	}

	@Override
	public void add(T box) throws Exception{//TODO
		if (isAddible(box)) {
		contents.add(box);
		box.putInContainer();
		revenue += box.getTotalRevenue();
		totalVolume += box.getMaxVolume();
		}
	}

	public boolean haveRoomForBox(T box) {
		return (maxVolume - totalVolume) > box.getTotalVolume();
	}


	@Override
	public int getIndexOf(T _element) {
		return getIndexOfWithSerial(_element.getSerialNumber());

	}

	@Override
	public int getIndexOfWithSerial(String s) {
		for (int i = 0; i < contents.size(); i++) {
			if (contents.get(i).getSerialNumber().equals(s))
				return i;
		}
		return -1;
	}

	public double getCost() {
		return containerCode.getCost();
	}

	public int getPriceOfItems() {
		int result = 0;
		for(Box<Item> box : contents) {
			result += box.getPriceOfItems();
		}
		return result;
	}
	
	@Override
	public String toString() {
		return this.getMaxVolume()+" liter(s) of Container with Serial Number of "+ this.getSerialNumber();
	}
	
	private boolean isAddible(T box) throws Exception {//TODO
		if(box.isInContainer()) {
			throw new InvalidLoadOfSerialException();
		}
		
		if(haveRoomForBox(box)) {
			throw new Exception();//TODO
		}
		
		if(isShipped) {
			throw new Exception();//TODO
		}
		
		return true;
	}
}
