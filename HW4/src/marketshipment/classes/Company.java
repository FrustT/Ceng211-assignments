package marketshipment.classes;

import java.util.ArrayList;
import java.util.List;

import marketshipment.exceptions.ExistingSerialNumberException;
import marketshipment.exceptions.InvalidHolderException;
import marketshipment.exceptions.InvalidLoadOfSerialException;
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

		show("2");
		System.out.print("       ");
		try {
			switch (ElementCode) {
			case "M1", "W1", "O1":
				CountableItem countableItem = new CountableItem(ItemCode.valueOf(ElementCode),
						Double.valueOf(data.remove(0)), serialNumber);
				unearnedRevenue += countableItem.getRevenue();
				revenue -= countableItem.getCost();
				if (isProduced(countableItem.getSerialNumber())) {
					throw new ExistingSerialNumberException();
				}
				allSerials.add(countableItem);
				System.out.print(countableItem);

				break;

			case "S1", "F1", "P1", "R1":
				UncountableItem uncountableItem = new UncountableItem(ItemCode.valueOf(ElementCode),
						Integer.valueOf(data.remove(0)), Double.valueOf(data.remove(0)), serialNumber);
				unearnedRevenue += uncountableItem.getRevenue();
				revenue -= uncountableItem.getCost();
				if (isProduced(uncountableItem.getSerialNumber())) {
					throw new ExistingSerialNumberException();
				}
				allSerials.add(uncountableItem);
				System.out.print(uncountableItem);
				break;

			case "B1":
				NumberBox<CountableItem> numberBox = new NumberBox<>(BoxCode.valueOf(ElementCode),
						Integer.valueOf(data.remove(0)), Double.valueOf(data.remove(0)), serialNumber);
				revenue -= numberBox.getCost();
				if (isProduced(numberBox.getSerialNumber())) {
					throw new ExistingSerialNumberException();
				}
				allSerials.add(numberBox);
				System.out.print(numberBox);
				break;

			case "B2":
				MassBox<UncountableItem> massBox = new MassBox<>(BoxCode.valueOf(ElementCode),
						Integer.valueOf(data.remove(0)), Double.valueOf(data.remove(0)), serialNumber);
				revenue -= massBox.getCost();
				if (isProduced(massBox.getSerialNumber())) {
					throw new ExistingSerialNumberException();
				}
				allSerials.add(massBox);
				System.out.print(massBox);
				break;

			case "C1":
				Container<Box<Item>> container = new Container<>(ContainerCode.valueOf(ElementCode),
						Double.valueOf(data.remove(0)), serialNumber);
				revenue -= container.getCost();
				if (isProduced(container.getSerialNumber())) {
					throw new ExistingSerialNumberException();
				}
				allSerials.add(container);
				System.out.print(container);
				break;
			default:
				break;
			}
			System.out.println(" has been produced! ");
		} catch (ExistingSerialNumberException e) {
			System.out.println(
					"Element with the serial number " + serialNumber + " cannot be produced " + e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void load(String _loadSerialNumber, String _holderSerialNumber) throws Exception {
		
		show("2");
		System.out.print("       ");
		
		int indexOfHolder = getIndexOfWithSerial(_holderSerialNumber);

		@SuppressWarnings("unchecked")
		Holder<Serial> holder = (Holder<Serial>) allSerials.get(indexOfHolder);

		int indexOfLoad = getIndexOfWithSerial(_loadSerialNumber);

		Serial load = allSerials.get(indexOfLoad);
		try {
			if (indexOfHolder == -1)
				throw new Exception("Holder with SerialNumber " + _holderSerialNumber + " is not Found");

			if (indexOfLoad == -1)
				throw new Exception("Load with SerialNumber " + _loadSerialNumber + " is not Found!");// serial not Found

			holder.add(load);
			System.out.println(load.getClass().getSimpleName() + " " + load.getSerialNumber() + " has been placed to"
					+ holder.getClass().getSimpleName() + " " + _holderSerialNumber);

		} catch (InvalidLoadOfSerialException e) {
			System.out.println( 
				load.getClass().getSimpleName() + " with the serial number " + load.getSerialNumber() + " is already loaded" + e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void ship(String _containerSerialNumber) throws Exception {
		show("2");
		System.out.print("       ");

		IContainer<?> container = (IContainer<?>) allSerials.get(getIndexOfWithSerial(_containerSerialNumber));
		try {
			if (container.isShipped()) {
				throw new Exception(
						"Exception: Container with Serial Number " + _containerSerialNumber + " already Shipped!");
			}
			container.ship();
			unearnedRevenue -= container.getTotalRevenue();
			revenue += container.getPriceOfItems();

			System.out.println("Container " + _containerSerialNumber + " has been shipped");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void show(String _code) {
		switch (_code) {
		case "1":
			System.out.print("Unearned revenue: " + String.format("%.2f", unearnedRevenue) + "TL");
			break;

		case "2":
			System.out.print("Total revenue: " + String.format("%.2f", revenue + unearnedRevenue) + "TL");
			break;
		default:
			System.out.print("Invalid Input");
			break;
		}
	}

	private boolean isProduced(String _serialNumber) {
		return this.getIndexOfWithSerial(_serialNumber) != -1;
	}

	private int getIndexOfWithSerial(String serialNumber) {
		for (int i = 0; i < allSerials.size(); i++) {
			if ((allSerials.get(i)).getSerialNumber().equals(serialNumber))
				return i;
		}
		return -1;
	}
}