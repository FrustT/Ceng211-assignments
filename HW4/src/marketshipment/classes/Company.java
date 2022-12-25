package marketshipment.classes;

import java.util.ArrayList;
import java.util.List;

import marketshipment.interfaces.*;

@SuppressWarnings("rawtypes")
public class Company {
	private List<IContainer> containers;
	private List<Item> items;
	private List<Box> boxes;
	private double revenue;
	private double unearnedRevenue;
	
	public Company() {
		containers = new ArrayList<IContainer>();
		items = new ArrayList<Item>();
		boxes = new ArrayList<Box>();
		revenue = 0;
		unearnedRevenue = 0;
	}
	
	public void produceCountableItem(ItemCode _itemCode, double _volume, String _serialNumber) {
		if(isInList(_serialNumber,items)){
			
		}//TODO eksepşın unearned revenue
		CountableItem item = new CountableItem(_itemCode, _volume, _serialNumber);
		items.add(item);
		revenue -= item.getCost();
		//TODO print
	}
	
	public void produceUncountableItem(ItemCode _itemCode, int _mass, double _volume, String _serialNumber){
		if(isInList(_serialNumber, items)){
			
		}//TODO ekspenşın unearned revenue
		UncountableItem item = new UncountableItem(_itemCode, _mass, _volume, _serialNumber);
		items.add(item);
		revenue -= item.getCost();
		//TODO print
	}
	
	public void produceContainer(ContainerCode _containerCode, double _volume, String _serialNumber){
		if(isInList(_serialNumber,containers)){
			
		}//TODO eksepşın unearned revenue
		Container container = new Container(_containerCode, _volume, _serialNumber);
		containers.add(container);
		revenue += container.getRevenue();
		//TODO print
	}
	
	public void produceBox(BoxCode _boxCode, int _maxMass, double _maxVolume, String _serialNumber) {
		switch(_boxCode.getName()){
			
			case "B1":
			if(isInList(_serialNumber, boxes)){
				
			}//TODO exception unearned revenue
			NumberBox numberBox = new NumberBox(_boxCode, _maxMass, _maxVolume, _serialNumber);
			boxes.add(numberBox);
			revenue += numberBox.getRevenue();
			//TODO print
			break;
			
			case "B2":
			if(isInList(_serialNumber, boxes)){
				
			}//TODO exception unearned revenue
			MassBox massBox = new MassBox(_boxCode, _maxMass, _maxVolume, _serialNumber);
			boxes.add(massBox);
			revenue += massBox.getRevenue();
			//TODO print
			break;
		}
	}
	
	private <T extends Serial> boolean isInList(String _serialNumber, List<T> elementsContainer){
		for (Serial s : elementsContainer){
			if (s.getSerialNumber().equals(_serialNumber)){
				return true;
			}
		}
		return false;
	}
}