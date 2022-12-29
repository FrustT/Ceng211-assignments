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

/**
 * This class is essentially the class that produces,loads and ships the necessary elements.
 *
 * <ul>
 * <li><strong>allSerials</strong> type: List<Serial>
 * <li><strong>actualRevenue</strong> type: double
 * <li><strong>unearnedRevenue</strong> type: double
 * <li><strong>totalCost</strong> type: double
 * <li><strong>possibleTotalPrice</strong> type: double
 * </ul>
 * 
 * @author Mustafa Fatih Can 280201007
 * @author Deniz Kaya 280201033
 * @author Hakan Uskan 280201076
 * @author Burak Erinc 290201099
 */

public class Company {
	private List<Serial> allSerials;
	private double actualRevenue;
	private double unearnedRevenue;
	private double totalCost;
	private double possibleTotalPrice;
	
	/**
	 * <strong>No Argument Constructor</strong>
	 * <p>
	 */
	public Company() {
		allSerials = new ArrayList<>();
		actualRevenue = 0.0;
		unearnedRevenue = 0.0;
	}
	
	
	/**
	 * Gets the revenue of Company object.
	 *
	 * @return type: double
	 */
	public double getRevenue() {
		return actualRevenue;
	}
	
	/**
	 * Gets the unearned revenue of Company Object.
	 *
	 * @return type: double
	 */
	public double getUnearnedRevenue() {
		return unearnedRevenue;
	}
	
	/**
	 * Produce elements with respect to data in List.
	 * 
	 * @param data type: List<String>
	 * @throws RuleException
	 */
	public void produce(List<String> data) throws RuleException {
		String elementCode = data.remove(0);
		String serialNumber = data.get(data.size() - 1);
		try {
			switch (elementCode) {
			case "M1", "W1", "O1":
				produceCountableItem(elementCode, serialNumber, data);
				break;
			case "S1", "F1", "P1", "R1":
				produceUncountableItem(elementCode, serialNumber, data);
				break;
			case "B1":
				produceNumberBox(elementCode, serialNumber, data);
				break;
			case "B2":
				produceMassBox(elementCode, serialNumber, data);
				break;
			case "C1":
				produceContainer(elementCode, serialNumber, data);
				break;
			default:
				break;
			}
			System.out.print(" has been produced! ");
		} catch (ExistingSerialNumberException e) {
			System.out.print("Element with the serial number " + serialNumber + " cannot be produced " + e.getMessage());
		}
		System.out.print(" ");
		show("2");
	}
	
	/**
	 * Loads the load whose serial number is given in the argument, to holder whose serial number is given in the argument.
	 *
	 * @param _loadSerialNumber type: String
	 * @param _holderSerialNumber type: String
	 * @throws RuleException
	 */
	public void load(String _loadSerialNumber, String _holderSerialNumber) throws RuleException {

		int indexOfHolder = getIndexOfWithSerial(_holderSerialNumber);
		@SuppressWarnings("unchecked")
		Holder<Serial> holder = (Holder<Serial>) allSerials.get(indexOfHolder);
		int indexOfLoad = getIndexOfWithSerial(_loadSerialNumber);
		Serial load = allSerials.get(indexOfLoad);

		try {
			if (indexOfHolder == -1)
				throw new SerialNumberNotFoundException("Holder with SerialNumber " + _holderSerialNumber + " is not Found");

			if (indexOfLoad == -1)
				throw new SerialNumberNotFoundException("Load with SerialNumber " + _loadSerialNumber + " is not Found!");// serial not Found
			
			holder.add(load);
			System.out.print(load.getClass().getSimpleName() + " " + load.getSerialNumber() + " has been placed to "
					+ holder.getClass().getSimpleName() + " " + _holderSerialNumber);
		} catch (SerialNumberNotFoundException e) {
			System.out.print(e.getMessage());
		} catch (LoadIsAlreadyLoadedException e) {
			System.out.print(load.getClass().getSimpleName() + " with the serial number " + load.getSerialNumber()
					+ " is already loaded " + e.getMessage());
		} catch (HolderIsFullException e) {
			System.out.print("The holder " + holder.getSerialNumber() + " is full. " + e.getMessage());
		} catch (HolderIsNotAccessibleException e) {
			System.out.print("You cannot load any load to " + holder.getClass().getSimpleName() + " with serial number "
					+ holder.getSerialNumber() + " " + e.getMessage());
		} catch (InvalidBoxException e) {
			System.out.print("You cannot load " + load.getClass().getSimpleName() + " to "
					+ holder.getClass().getSimpleName() + " box " + e.getMessage());
		}
		System.out.print(" ");
		show("2");
	}
	
	/**
	 * Ships the container whose serial number is given in the argument.
	 *
	 * @param _containerSerialNumber type: String
	 * @throws RuleException
	 */
	public void ship(String _containerSerialNumber) throws RuleException {

		IContainer<?> container = (IContainer<?>) allSerials.get(getIndexOfWithSerial(_containerSerialNumber));
		try {
			if (container.isShipped()) {
				throw new HolderIsNotAccessibleException();
			}
			container.ship();
			actualRevenue += container.getTotalPrice();
			unearnedRevenue = possibleTotalPrice - totalCost - actualRevenue;
			System.out.print("Container " + _containerSerialNumber + " has been shipped");
		} catch (HolderIsNotAccessibleException e) {
			System.out.print("Exception: Container with Serial Number " + _containerSerialNumber + " already Shipped!"
					+ e.getMessage());
		}
		System.out.print("       ");
		show("2");
	}
	
	/**
	 * Prints the revenue or unearned revenue with respect to the argument.
	 *
	 * @param _code type: String
	 */
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
	
	private void produceCountableItem(String elementCode, String serialNumber, List<String> data) throws ExistingSerialNumberException {
		CountableItem countableItem = new CountableItem(ItemCode.valueOf(elementCode),
				Double.valueOf(data.remove(0)), serialNumber);
		if (isProduced(countableItem.getSerialNumber())) {
			throw new ExistingSerialNumberException();
		}
		actualRevenue -= countableItem.getCost();
		possibleTotalPrice += countableItem.getPrice();
        totalCost  += countableItem.getCost();
		allSerials.add(countableItem);
		System.out.print(countableItem);
	}
	
	private void produceUncountableItem(String elementCode, String serialNumber, List<String> data) throws ExistingSerialNumberException {
		UncountableItem uncountableItem = new UncountableItem(ItemCode.valueOf(elementCode),
				Integer.valueOf(data.remove(0)), Double.valueOf(data.remove(0)), serialNumber);
		if (isProduced(uncountableItem.getSerialNumber())) {
			throw new ExistingSerialNumberException();
		}
		actualRevenue -= uncountableItem.getCost();
		possibleTotalPrice += uncountableItem.getPrice();
        totalCost  += uncountableItem.getCost();
		allSerials.add(uncountableItem);
		System.out.print(uncountableItem);
	}
	
	private void produceNumberBox(String elementCode, String serialNumber, List<String> data) throws ExistingSerialNumberException {
		NumberBox<CountableItem> numberBox = new NumberBox<>(BoxCode.valueOf(elementCode),
				Integer.valueOf(data.remove(0)), Double.valueOf(data.remove(0)), serialNumber);
		if (isProduced(numberBox.getSerialNumber())) {
			throw new ExistingSerialNumberException();
		}
		actualRevenue -= numberBox.getTotalCost();
        totalCost  += numberBox.getTotalCost();
		allSerials.add(numberBox);
		System.out.print(numberBox);
	}

	private void produceMassBox(String elementCode, String serialNumber, List<String> data) throws ExistingSerialNumberException{
		MassBox<UncountableItem> massBox = new MassBox<>(BoxCode.valueOf(elementCode),
				Integer.valueOf(data.remove(0)), Double.valueOf(data.remove(0)), serialNumber);

		if (isProduced(massBox.getSerialNumber())) {
			throw new ExistingSerialNumberException();
		}
		actualRevenue -= massBox.getTotalCost();
        totalCost  += massBox.getTotalCost();
		allSerials.add(massBox);
		System.out.print(massBox);
	}
	
	private void produceContainer(String elementCode, String serialNumber, List<String> data) throws ExistingSerialNumberException {
		Container<Box<Item>> container = new Container<>(ContainerCode.valueOf(elementCode),
				Double.valueOf(data.remove(0)), serialNumber);

		if (isProduced(container.getSerialNumber())) {
			throw new ExistingSerialNumberException();
		}
		actualRevenue -= container.getTotalCost();
        totalCost  += container.getTotalCost();
		allSerials.add(container);
		System.out.print(container);
	}
}