package marketshipment.classes;

import marketshipment.interfaces.Countable;

public class CountableItem extends AbstractItem implements Countable {
	
	public CountableItem() {
		super();
	}
	
	public CountableItem(CountableItem _item) {
		super(_item);
	}
	
	public CountableItem(ItemCode _itemCode, double _volume, String _serialNumber) {
		super(_itemCode, _volume, _serialNumber);
	}
	
}
