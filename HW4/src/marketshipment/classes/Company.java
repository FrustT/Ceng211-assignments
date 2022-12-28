package marketshipment.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import marketshipment.exceptions.ExistingSerialNumberException;
import marketshipment.exceptions.InvalidHolderException;
import marketshipment.exceptions.RuleException;
import marketshipment.interfaces.*;

public class Company {
	private List<Serial> allSerials;
	private double revenue;
	private double unearnedRevenue;

	public Company() {
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
				if (isProduced(countableItem.getSerialNumber())) {
					unearnedRevenue += countableItem.getRevenue();// XXX i think it may be just cost
					revenue -= countableItem.getCost();
					throw new ExistingSerialNumberException();
				}
				unearnedRevenue += countableItem.getRevenue();
				revenue -= countableItem.getCost();
				allSerials.add(countableItem);
				break;

			case "S1", "F1", "P1", "R1":
				UncountableItem uncountableItem = new UncountableItem(ItemCode.valueOf(ElementCode),
						Integer.valueOf(data.remove(0)), Double.valueOf(data.remove(0)), serialNumber);
				if (isProduced(uncountableItem.getSerialNumber())) {
					unearnedRevenue += uncountableItem.getRevenue();// XXX i think it may be just cost
					revenue -= uncountableItem.getCost();
					throw new ExistingSerialNumberException();
				}
				unearnedRevenue += uncountableItem.getRevenue();
				revenue -= uncountableItem.getCost();
				allSerials.add(uncountableItem);
				break;

			case "B1":
				NumberBox<CountableItem> numberBox = new NumberBox<>(BoxCode.valueOf(ElementCode),
						Integer.valueOf(data.remove(0)), Double.valueOf(data.remove(0)), serialNumber);
				if (isProduced(numberBox.getSerialNumber())) {
					revenue -= numberBox.getCost();
					throw new ExistingSerialNumberException();
				}
				revenue -= numberBox.getCost();
				allSerials.add(numberBox);
				break;

			case "B2":
				MassBox<UncountableItem> massBox = new MassBox<>(BoxCode.valueOf(ElementCode),
						Integer.valueOf(data.remove(0)), Double.valueOf(data.remove(0)), serialNumber);
				if (isProduced(massBox.getSerialNumber())) {
					revenue -= massBox.getCost();
					throw new ExistingSerialNumberException();
				}
				revenue -= massBox.getCost();
				allSerials.add(massBox);
				break;

			case "C1":
				Container<Box<Item>> container = new Container<>(ContainerCode.valueOf(ElementCode),
						Double.valueOf(data.remove(0)), serialNumber);
				if (isProduced(container.getSerialNumber())) {
					revenue -= container.getCost();
					throw new ExistingSerialNumberException();
				}
				revenue -= container.getCost();
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

			if (indexOfLoad == -1)
				throw new Exception("Load with SerialNumber" + _loadSerialNumber + " is not Found!");

			Serial load = allSerials.get(indexOfLoad);

			if (holder.getIndexOfWithSerial(_loadSerialNumber) != -1)
				throw new Exception("Can not produce Load with Serial Number" + _loadSerialNumber + " again");

			holder.add(load);

		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	private int getIndexOfWithSerial(String serialNumber) {
		for (int i = 0; i < allSerials.size(); i++) {
			if ((allSerials.get(i)).getSerialNumber().equals(serialNumber))
				return i;
		}
		return -1;
	}

	public void ship(String _containerSerialNumber) throws Exception {

		IContainer<?> container = (IContainer<?>) allSerials.get(getIndexOfWithSerial(_containerSerialNumber));
		try {
			if (container.isShipped()) {
				throw new Exception(
						"Exception: Container with Serial Number " + _containerSerialNumber + " already Shipped!");

			}
			container.ship();
			int shippedItemsRevenue = container.getRevenueOfItems();
			unearnedRevenue -= shippedItemsRevenue;
			revenue += shippedItemsRevenue;

			// TODO print
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}

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
			System.out.println("Invalid Input");
			break;
		}
	}

	private boolean isProduced(String _serialNumber) {
		for (Serial element : allSerials) {
			if (element.getSerialNumber().equals(_serialNumber)) {
				return true;
			}
		}
		return false;
	}
}