package marketshipment.classes;


import marketshipment.interfaces.*;

public class MassBox<T extends Uncountable & Item> extends AbstractBox<T> {
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
		
	public int getMass() {
		return mass;
	}
	
	public void add(T _element) throws Exception {
		if(_element.getClass() != class.Uncountable) {
			throw new InvalidBoxException();
		}
		
		if (isAddible(_element)) {
		contents.add(_element);
		revenue += _element.getRevenue();
		totalVolume += _element.getVolume();
		updateRespectiveTotalAmount(_element);
		_element.load();
		}
	}

	@Override
	public boolean haveRoomForItem(T item) {
		return hasSpareVolume(item) && ((mass + item.getMass()) <= maxMass);
	}

	@Override
	public void updateRespectiveTotalAmount(T item) {
		this.mass += item.getMass();
	}	
	@Override
	public String toString() {
		return this.getMaxVolume()+" liter(s) of Mass Box with capacity of "+ this.getMaxMass()+" with Serial Number of "+ this.getSerialNumber();
	}
}
