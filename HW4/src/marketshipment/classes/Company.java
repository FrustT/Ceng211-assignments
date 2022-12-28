package marketshipment.classes;

import java.util.ArrayList;
import java.util.List;

import marketshipment.exceptions.ExistingSerialNumberException;
import marketshipment.exceptions.HolderIsFullException;
import marketshipment.exceptions.HolderIsNotAccessibleException;
import marketshipment.exceptions.InvalidBoxException;
import marketshipment.exceptions.LoadIsAlreadyLoadedException;
import marketshipment.exceptions.RuleException;
import marketshipment.exceptions.SerialNumberNotFoundException;
import marketshipment.interfaces.*;

public class Company {
	private List<Serial> allSerials;
	private double actualRevenue;
	private double unearnedRevenue;

	public Company() {
		allSerials = new ArrayList<>();
		actualRevenue = 0.0;
		unearnedRevenue = 0.0;
	}

	public double getRevenue() {
		return actualRevenue;
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
					throw new ExistingSerialNumberException();
				}
				actualRevenue -= countableItem.getCost();
				allSerials.add(countableItem);
				System.out.print(countableItem);
				break;

			case "S1", "F1", "P1", "R1":
				UncountableItem uncountableItem = new UncountableItem(ItemCode.valueOf(ElementCode),
						Integer.valueOf(data.remove(0)), Double.valueOf(data.remove(0)), serialNumber);
				if (isProduced(uncountableItem.getSerialNumber())) {
					throw new ExistingSerialNumberException();
				}
				actualRevenue -= uncountableItem.getCost();
				allSerials.add(uncountableItem);
				System.out.print(uncountableItem);
				break;

			case "B1":
				NumberBox<CountableItem> numberBox = new NumberBox<>(BoxCode.valueOf(ElementCode),
						Integer.valueOf(data.remove(0)), Double.valueOf(data.remove(0)), serialNumber);
				if (isProduced(numberBox.getSerialNumber())) {
					throw new ExistingSerialNumberException();
				}
				actualRevenue -= numberBox.getTotalCost();
				allSerials.add(numberBox);
				System.out.print(numberBox);
				break;

			case "B2":
				MassBox<UncountableItem> massBox = new MassBox<>(BoxCode.valueOf(ElementCode),
						Integer.valueOf(data.remove(0)), Double.valueOf(data.remove(0)), serialNumber);

				if (isProduced(massBox.getSerialNumber())) {
					throw new ExistingSerialNumberException();
				}
				actualRevenue -= massBox.getTotalCost();
				allSerials.add(massBox);
				System.out.print(massBox);
				break;

			case "C1":
				Container<Box<Item>> container = new Container<>(ContainerCode.valueOf(ElementCode),
						Double.valueOf(data.remove(0)), serialNumber);

				if (isProduced(container.getSerialNumber())) {
					throw new ExistingSerialNumberException();
				}
				actualRevenue -= container.getTotalCost();
				allSerials.add(container);
				System.out.print(container);
				break;
			default:
				break;
			}
			System.out.print(" has been produced! ");
		} catch (ExistingSerialNumberException e) {
			System.out
					.print("Element with the serial number " + serialNumber + " cannot be produced " + e.getMessage());
		}
		System.out.print(" ");
		show("2");
	}

	public void load(String _loadSerialNumber, String _holderSerialNumber) throws RuleException {

		int indexOfHolder = getIndexOfWithSerial(_holderSerialNumber);

		@SuppressWarnings("unchecked")
		Holder<Serial> holder = (Holder<Serial>) allSerials.get(indexOfHolder);

		int indexOfLoad = getIndexOfWithSerial(_loadSerialNumber);

		Serial load = allSerials.get(indexOfLoad);

		try {
			if (indexOfHolder == -1)
				throw new SerialNumberNotFoundException(
						"Holder with SerialNumber " + _holderSerialNumber + " is not Found");

			if (indexOfLoad == -1)
				throw new SerialNumberNotFoundException(
						"Load with SerialNumber " + _loadSerialNumber + " is not Found!");// serial not Found

			holder.add(load);
			System.out.print(load.getClass().getSimpleName() + " " + load.getSerialNumber() + " has been placed to "
					+ holder.getClass().getSimpleName() + " " + _holderSerialNumber);

		} catch (SerialNumberNotFoundException e) {
			System.out.print(e.getMessage());
		} catch (LoadIsAlreadyLoadedException e) {
			System.out.print(load.getClass().getSimpleName() + " with the serial number " + load.getSerialNumber()
					+ " is already loaded " + e.getMessage());
		} catch (HolderIsFullException e) {
			unearnedRevenue += load.getRevenue();
			// System.out.println(load.getSerialNumber());
			System.out.print("The holder " + holder.getSerialNumber() + " is full. " + e.getMessage());
		} catch (HolderIsNotAccessibleException e) {
			unearnedRevenue += load.getRevenue();
			// System.out.println(load.getSerialNumber());
			System.out.print("You cannot load any load to " + holder.getClass().getSimpleName() + " with serial number "
					+ holder.getSerialNumber() + " " + e.getMessage());
		} catch (InvalidBoxException e) {
			unearnedRevenue += load.getRevenue();
			// System.out.println(load.getSerialNumber());
			System.out.print("You cannot load " + load.getClass().getSimpleName() + " to "
					+ holder.getClass().getSimpleName() + " box " + e.getMessage());
		}
		System.out.print(" ");
		show("2");
	}

	public void ship(String _containerSerialNumber) throws Exception {

		IContainer<?> container = (IContainer<?>) allSerials.get(getIndexOfWithSerial(_containerSerialNumber));
		try {
			if (container.isShipped()) {
				throw new HolderIsNotAccessibleException();
			}
			container.ship();
			actualRevenue += container.getTotalPrice();
			/*
			 * System.out.println(container.getTotalPrice() + " container price");
			 * System.out.println(container.getTotalCost() + " container cost");
			 * System.out.println(container.getTotalRevenue() + " container revenue");
			 * System.out.println(unearnedRevenue);
			 */

			System.out.print("Container " + _containerSerialNumber + " has been shipped");
		} catch (HolderIsNotAccessibleException e) {
			System.out.print("Exception: Container with Serial Number " + _containerSerialNumber + " already Shipped!"
					+ e.getMessage());
		}
		System.out.print("       ");
		show("2");

	}

	public void show(String _code) {
		switch (_code) {
		case "1":
			System.out.print("Unearned revenue: " + String.format("%.2f", unearnedRevenue) + "TL" + "\n");
			break;

		case "2":
			System.out.print("Total revenue: " + String.format("%.2f", actualRevenue) + "TL" + "\n");
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