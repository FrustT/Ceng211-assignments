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

	@Override
	public boolean haveRoomForItem(T item) {
		return hasSpareVolume(item) && ((this.mass + item.getMass()) <= this.maxMass);
	}

	@Override
	public void updateRespectiveTotalAmount(T item) {
		this.mass += item.getMass();
	}	
}
