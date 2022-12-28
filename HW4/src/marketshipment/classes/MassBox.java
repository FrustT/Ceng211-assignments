package marketshipment.classes;


import marketshipment.exceptions.CannotBeAddedToHolderException;
import marketshipment.exceptions.InvalidBoxException;
import marketshipment.exceptions.RuleException;
import marketshipment.interfaces.*;

public class MassBox<T extends Item> extends AbstractBox<T> {
	private int maxMass;
	private int mass;
	
	public MassBox() {
		super();
		maxMass = 0;
		mass = 0;
	}
	
	public MassBox(MassBox<T> _box) {
		super(_box);
		mass = _box.getMass();
		maxMass = _box.getMaxMass();
	}
	
	public MassBox(BoxCode _boxCode, int _maxMass, double _maxVolume, String _serialNumber) {
		super(_boxCode, _maxVolume, _serialNumber);
		maxMass = _maxMass;
		mass = 0;
	}
	
	public int getMaxMass() {
		return maxMass;
	}
		
	public int getMass(){
		return mass;
	}
	
	public void add(T _element) throws CannotBeAddedToHolderException {
		if(!(_element instanceof Uncountable)) {
			throw new InvalidBoxException();
		}
		if (isAddible(_element)) {
			super.add(_element);
		}
	}

	@Override
	public boolean haveRoomForItem(T item) {
		Uncountable uncountableItem = (Uncountable) item;
		return hasSpareVolume(item) && ((mass + uncountableItem.getMass()) <= maxMass);
	}

	@Override
	public void updateRespectiveTotalAmount(T item) {
		Uncountable uncountableItem = (Uncountable) item;
		this.mass += uncountableItem.getMass();
	}	
	@Override
	public String toString() {
		return this.getMaxVolume()+" liter(s) of Mass Box with capacity of "+ this.getMaxMass()+" with Serial Number of "+ this.getSerialNumber();
	}
}
