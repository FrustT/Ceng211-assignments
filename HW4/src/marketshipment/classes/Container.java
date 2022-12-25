package marketshipment.classes;

import java.util.ArrayList;
import java.util.List;

import marketshipment.interfaces.Box;
import marketshipment.interfaces.IContainer;

public class Container<T extends Box> implements IContainer<T> {
	private ContainerCode containerCode;
	private List<T> contents;
	private String serialNumber;
	private boolean isShipped;
	private double maxVolume;
	private double totalVolume;
	private double revenue;

	public Container() {
		containerCode = null;
		contents = new ArrayList<T>();
		serialNumber = "Container is not initialized.";
		isShipped = false;
		maxVolume = 0;
		totalVolume = 0;
		revenue = 0;
	}
	
	public Container(Container<T> _container) {
		containerCode = _container.getContainerCode();
		contents = _container.getContents();
		serialNumber = _container.getSerialNumber();
		isShipped = _container.isShipped();
		maxVolume = _container.getMaxVolume();
		totalVolume = _container.getTotalVolume();
		revenue = _container.getRevenue(); 
	}

	public Container(ContainerCode _containerCode, double _maxVolume, String _serialNumber) {
		containerCode = _containerCode;
		contents = new ArrayList<T>();
		serialNumber = _serialNumber;
		isShipped = false;
		maxVolume = _maxVolume;
		totalVolume = 0;
		revenue = 0 - containerCode.getCost();
	}
	

	public ContainerCode getContainerCode() {
		return containerCode;
	}

	public List<T> getContents() {
		List<T> result = new ArrayList<T>();
		for(T item: contents) {
			result.add(item);
		}
		return result;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public boolean isShipped() {
		return isShipped;
	}

	public double getMaxVolume() {
		return maxVolume;
	}

	public double getTotalVolume() {
		return totalVolume;
	}

	public double getRevenue() {
		return revenue;
	}

	@Override
	public void ship() {
		this.isShipped = true;
	}

	@Override
	public void add(T box) {
		if(!isAddible(box)) {
			
		}//TODO exception olayları
		contents.add(box);
		box.putInContainer();
		revenue += box.getRevenue();
		totalVolume += box.getMaxVolume();
	}
	public boolean haveRoomForBox(T box) {
		return this.maxVolume - this.totalVolume > box.getMaxVolume();
	}

	public boolean isAddible(T box) {
		return this.haveRoomForBox(box) && !this.isShipped;
	}
}
