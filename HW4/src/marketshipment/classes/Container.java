package marketshipment.classes;

import java.util.ArrayList;
import java.util.List;

import marketshipment.exceptions.CannotBeAddedToHolderException;
import marketshipment.exceptions.HolderIsFullException;
import marketshipment.exceptions.HolderIsNotAccessibleException;
import marketshipment.exceptions.LoadIsAlreadyLoadedException;
import marketshipment.interfaces.Box;
import marketshipment.interfaces.IContainer;
import marketshipment.interfaces.Item;

/**
 * This class implements container interface and holds box of items as list.
 *
 * <ul>
 * <li><strong>containerCode</strong> type: ContainerCode
 * <li><strong>contents</strong> type: List<T>
 * <li><strong>serialNumber</strong> type: String
 * <li><strong>isShipped</strong> type: boolean
 * <li><strong>maxVolume</strong> type: double
 * <li><strong>totalVolume</strong> type: double
 * <li><strong>totalPrice</strong> type: double
 * <li><strong>totalCost</strong> type: double
 * </ul>
 * 
 * @author Mustafa Fatih Can 280201007
 * @author Deniz Kaya 280201033
 * @author Hakan Uskan 280201076
 * @author Burak Erinc 290201099
 */

public class Container<T extends Box<Item>> implements IContainer<T> {
	private ContainerCode containerCode;
	private List<T> contents;
	private String serialNumber;
	private boolean isShipped;
	private double maxVolume;
	private double totalVolume;
	private double totalPrice;
	private double totalCost;
	/**
	 * <strong>No Argument Constructor</strong>
	 * <p>
	 */
	public Container() {
		containerCode = null;
		contents = new ArrayList<>();
		serialNumber = "Container is not initialized.";
		isShipped = false;
		maxVolume = 0;
		totalVolume = 0;
		totalPrice = 0.0;
		totalCost = 0.0;
	}
	
	/**
	 * <strong>Copy Constructor</strong>
	 * <p>
	 * Constructs a new Container Object with another Container Object
	 * 
	 * @param _container
	 */
	public Container(Container<T> _container) {
		containerCode = _container.getContainerCode();
		contents = _container.getContents();
		serialNumber = _container.getSerialNumber();
		isShipped = _container.isShipped();
		maxVolume = _container.getMaxVolume();
		totalVolume = _container.getTotalVolume();
		totalPrice = _container.getTotalPrice();
		totalCost = _container.getTotalCost();
	}
	
	/**
	 * <strong>Parameterized Constructor</strong>
	 * <p>
	 * Constructs Container object with required data.
	 * 
	 * @param _containerCode
	 * @param _maxVolume
	 * @param _serialNumber
	 */
	public Container(ContainerCode _containerCode, double _maxVolume, String _serialNumber) {
		containerCode = _containerCode;
		contents = new ArrayList<>();
		serialNumber = _serialNumber;
		isShipped = false;
		maxVolume = _maxVolume;
		totalVolume = 0.0;
		totalPrice = 0.0;
		totalCost = _containerCode.getCost() * _maxVolume;
	}
	
	
	@Override
	public ContainerCode getContainerCode() {
		return containerCode;
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
	public boolean isShipped() {
		return isShipped;
	}
	
	/**
	 * Returns the maximum value of the Container object can have.
	 *
	 * @return type: double
	 */
	public double getMaxVolume() {
		return maxVolume;
	}
	
	/**
	 * Returns the total volume value in the Container object.
	 *
	 * @return type: double
	 */
	public double getTotalVolume() {
		return totalVolume;
	}

	@Override
	public double getTotalRevenue() {
		return totalPrice - totalCost;
	}

	@Override
	public void ship() {
		this.isShipped = true;
	}

	@Override
	public void add(T box) throws CannotBeAddedToHolderException{
		if (isAddible(box)) {
		contents.add(box);
		box.putInContainer();
		totalPrice += box.getTotalPrice();
		totalCost += box.getTotalCost();
		totalVolume += box.getMaxVolume();
		}
	}
	
    
	/**
	 * Returns true if element can load to Container object, otherwise returns false.
	 *
	 * @param box
	 * @return
	 */
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
	
	@Override
	public String toString() {
		return this.getMaxVolume()+" liter(s) of Container with Serial Number of "+ this.getSerialNumber();
	}
	
	private boolean isAddible(T box) throws CannotBeAddedToHolderException {
		if(box.isInContainer()) {
			throw new LoadIsAlreadyLoadedException();
		}
		
		if(!haveRoomForBox(box)) {
			throw new HolderIsFullException();
		}
		
		if(isShipped) {
			throw new HolderIsNotAccessibleException();
		}
		
		return true;
	}
}
