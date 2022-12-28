package marketshipment.classes;

import marketshipment.interfaces.Uncountable;

public class UncountableItem extends AbstractItem implements Uncountable {
	
	private int mass;
	
	public UncountableItem() {
		super();
		mass = 0;
	}
	
	public UncountableItem(UncountableItem _item) {
		super(_item);
		mass = _item.getMass();
	}
	
	public UncountableItem(ItemCode _itemCode, int _mass, double _volume, String _serialNumber) {
		super(_itemCode, _volume,  _serialNumber);
		mass = _mass;
	}
	
	@Override
	public double getCost() {
		return (double) mass * getItemCode().getCost();
	}

	@Override
	public int getMass() {
		return mass;
	}
}
