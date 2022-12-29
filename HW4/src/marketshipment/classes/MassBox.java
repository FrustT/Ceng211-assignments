package marketshipment.classes;


import marketshipment.exceptions.CannotBeAddedToHolderException;
import marketshipment.exceptions.InvalidBoxException;
import marketshipment.interfaces.*;

/**
 * MassBox class holds uncountable items that are boxed according to their mass and volume.
 *
 * <ul>
 * <li><strong>maxMass</strong> type: int
 * <li><strong>mass</strong> type: int
 * </ul>
 * 
 * @author Mustafa Fatih Can 280201007
 * @author Deniz Kaya 280201033
 * @author Hakan Uskan 280201076
 * @author Burak Erinc 290201099
 */

public class MassBox<T extends Item> extends AbstractBox<T> {
	private int maxMass;
	private int mass;
	
	/**
	 * <strong>No Argument Constructor</strong>
	 * <p>
	 */
	public MassBox() {
		super();
		maxMass = 0;
		mass = 0;
	}
	
	/**
	 * <strong>Copy Constructor</strong>
	 * <p>
	 * Constructs a new MassBox Object with another MassBox Object
	 * 
	 * @param _box
	 */
	public MassBox(MassBox<T> _box) {
		super(_box);
		mass = _box.getMass();
		maxMass = _box.getMaxMass();
	}
	
	/**
	 * <strong>Parameterized Constructor</strong>
	 * <p>
	 * Constructs MassBox object with required data.
	 * 
	 * @param _boxCode
	 * @param _maxMass
	 * @param _maxVolume
	 * @param _serialNumber
	 */
	public MassBox(BoxCode _boxCode, int _maxMass, double _maxVolume, String _serialNumber) {
		super(_boxCode, _maxVolume, _serialNumber);
		maxMass = _maxMass;
		mass = 0;
	}
	
	
	/**
	 * Gets the maximum mass value the MassBox object can have.
	 *
	 * @return type: int
	 */
	public int getMaxMass() {
		return maxMass;
	}
	
	/**
	 * Gets the mass volume of the MassBox object.
	 *
	 * @return type: int
	 */
	public int getMass(){
		return mass;
	}
	
	@Override
	public void add(T _element) throws CannotBeAddedToHolderException {
		if(!(_element instanceof Uncountable)) {
			throw new InvalidBoxException();
		}
		if (isAddible(_element)) {
			super.add(_element);
		}
	}

	@Override
	public boolean haveRoomForItem(T item) {
		Uncountable uncountableItem = (Uncountable) item;
		return hasSpareVolume(item) && ((mass + uncountableItem.getMass()) <= maxMass);
	}

	@Override
	public void updateRespectiveTotalAmount(T item) {
		Uncountable uncountableItem = (Uncountable) item;
		this.mass += uncountableItem.getMass();
	}	
	@Override
	public String toString() {
		return this.getMaxVolume()+" liter(s) of Mass Box with capacity of "+ this.getMaxMass()+" with Serial Number of "+ this.getSerialNumber();
	}
}
