package marketshipment.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import marketshipment.exceptions.ExistingSerialNumberException;
import marketshipment.exceptions.InvalidHolderException;
import marketshipment.exceptions.RuleException;
import marketshipment.interfaces.*;

public class Company {
	private List<Item> items;
	private List<Box<? extends Item>> boxes;
	private List<Container<Box<Item>>> containers;
	private List<Holder<? extends Serial>> holders;
	private List<Serial> allSerials;
	private double revenue;
	private double unearnedRevenue;

	public Company() {
		containers = new ArrayList<>();
		items = new ArrayList<>();
		boxes = new ArrayList<>();
		holders = new ArrayList<>();
		allSerials = new ArrayList<>();
		revenue = 0;
		unearnedRevenue = 0;
	}

	public double getRevenue() {
		return revenue;
	}

	public double getUnearnedRevenue() {
		return unearnedRevenue;
	}

	public void produce(List<String> data) throws Exception {
		String ElementCode = data.remove(0);
		String serialNumber = data.get(data.size() - 1);
		try {
			switch (ElementCode) {
			case "M1", "W1", "O1":
				CountableItem countableItem = new CountableItem(ItemCode.valueOf(ElementCode),
						Double.valueOf(data.remove(0)), serialNumber);
				isProduced(countableItem.getSerialNumber());
				revenue -= countableItem.getCost();
				items.add(countableItem);
				allSerials.add(countableItem);
				break;

			case "S1", "F1", "P1", "R1":
				UncountableItem uncountableItem = new UncountableItem(ItemCode.valueOf(ElementCode),
						Integer.valueOf(data.remove(0)), Double.valueOf(data.remove(0)), serialNumber);
				isProduced(uncountableItem.getSerialNumber());
				revenue -= uncountableItem.getCost();
				items.add(uncountableItem);
				allSerials.add(uncountableItem);
				break;

			case "B1":
				NumberBox<CountableItem> numberBox = new NumberBox<>(BoxCode.valueOf(ElementCode),
						Integer.valueOf(data.remove(0)), Double.valueOf(data.remove(0)), serialNumber);
				isProduced(numberBox.getSerialNumber());
				revenue += numberBox.getRevenue();
				boxes.add(numberBox);
				holders.add(numberBox);
				allSerials.add(numberBox);
				break;

			case "B2":
				MassBox<UncountableItem> massBox = new MassBox<>(BoxCode.valueOf(ElementCode),
						Integer.valueOf(data.remove(0)), Double.valueOf(data.remove(0)), serialNumber);
				isProduced(massBox.getSerialNumber());
				revenue += massBox.getRevenue();
				boxes.add(massBox);
				holders.add(massBox);
				allSerials.add(massBox);
				break;

			case "C1":
				Container<Box<Item>> container = new Container<>(ContainerCode.valueOf(ElementCode),
						Double.valueOf(data.remove(0)), serialNumber);
				isProduced(container.getSerialNumber());
				revenue += container.getRevenue();
				containers.add(container);
				holders.add(container);
				allSerials.add(container);
				break;
			default:
				break;
			}
			// TODO print
		} catch (ExistingSerialNumberException e) {
			System.out.println("Item with the serial number " + serialNumber + " cannot be produced " + e.getMessage());
		} // TODO exception
	}

	public void load(String _loadSerialNumber, String _holderSerialNumber) throws Exception {
		try {
			int indexOfHolder = getIndexOfWithSerial(_holderSerialNumber);

			if (indexOfHolder == -1)
				throw new Exception("Holder with SerialNumber" + _holderSerialNumber + " is not Found");
			
			
			@SuppressWarnings("unchecked")
			Holder<Serial> holder = (Holder<Serial>) allSerials.get(indexOfHolder);

			int indexOfLoad = getIndexOfWithSerial(_loadSerialNumber);
			
			if(indexOfLoad == -1)
				throw new Exception("Load with SerialNumber"+ _loadSerialNumber+" is not Found!");
			
			Serial load = allSerials.get(indexOfLoad);

			if (holder.getIndexOfWithSerial(_loadSerialNumber) != -1)
				throw new Exception("Can not produce Load with Serial Number"+ _loadSerialNumber+" again");
			
			holder.add(load);
			

		}catch(Exception e){
			System.out.println(e.getLocalizedMessage());
		}

		
		 /* if (load.getClass() == AbstractBox.class && holder.getClass() !=
		 Container.class) { throw new InvalidHolderException(); }*/
	}

	private int getIndexOfWithSerial(String s) {
		for (int i = 0; i < allSerials.size(); i++) {
			if ((allSerials.get(i)).getSerialNumber().equals(s))
				return i;
		}
		return -1;
	}

	public void ship(String _containerSerialNumber) throws Exception {

		IContainer<Box<Item>> container = null;
		for (IContainer<Box<Item>> containerInList : containers) {
			if (containerInList.getSerialNumber().equals(_containerSerialNumber)) {
			}
			container = containerInList;
		}

		if (container.isShipped()) {

		} // TODO epilepsişıngen

		container.ship(); // TODO print
	}

	public void show(String _code) {
		switch (_code) {
		case "1":
			System.out.println("Unearned revenue: " + unearnedRevenue);
			break;

		case "2":
			System.out.println("Total revenue: " + (revenue + unearnedRevenue));
			break;
		default:
			System.out.println("InvalidInput");// TODO exception ?
			break;
		}
	}

	private boolean isProduced(String _serialNumber) throws RuleException {
		for (Serial element : allSerials) {
			if (element.getSerialNumber().equals(_serialNumber)) {
				throw new ExistingSerialNumberException();
			}
		}
		return false;
	}

	public List<?> getItems() {// Debug REASONS
		return items;
	}
}