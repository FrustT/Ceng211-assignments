package marketshipment.classes;

import marketshipment.exceptions.CannotBeAddedToHolderException;
import marketshipment.exceptions.HolderIsFullException;
import marketshipment.exceptions.InvalidBoxException;
import marketshipment.exceptions.RuleException;
import marketshipment.interfaces.*;

public class NumberBox<T extends Item> extends AbstractBox<T>{
	private int maxNumberOfItems;
	private int numberOfItems;
	
	public NumberBox() {
		super();
		maxNumberOfItems = 0;
		numberOfItems = 0;
	}
	
	public NumberBox(NumberBox<T> _box) {
		super(_box);
		maxNumberOfItems = _box.getNumberOfItems();
		numberOfItems = _box.getNumberOfItems();
	}
	
	public NumberBox(BoxCode _boxCode, int _maxNumberOfItems, double _maxVolume, String _serialNumber){
		super(_boxCode, _maxVolume, _serialNumber);
		maxNumberOfItems = _maxNumberOfItems;
		numberOfItems = 0;
	}
	
	
	public int getNumberOfItems() {
		return numberOfItems;
	}
	
	public int getMaxNumberOfItems() {
		return maxNumberOfItems;
	}
	
	public void add(T _element) throws CannotBeAddedToHolderException {
		if(!(_element instanceof Countable)) {
			throw new InvalidBoxException();
		}
		if (isAddible(_element)) {
			super.add(_element);
		}
	}
	
	public boolean haveRoomForItem(T item) throws CannotBeAddedToHolderException{
		if(hasSpareVolume(item) && (numberOfItems < maxNumberOfItems)) {
			return true;
		}
		throw new HolderIsFullException();
	}

	@Override
	public void updateRespectiveTotalAmount(T item) {
		numberOfItems++;
	}
	
	@Override
	public String toString() {
		return this.getMaxVolume()+" liter(s) of Number Box with capacity of "+ this.getMaxNumberOfItems()+" with Serial Number of "+ this.getSerialNumber();
	}
}
