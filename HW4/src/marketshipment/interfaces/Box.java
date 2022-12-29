package marketshipment.interfaces;

/**
 * Box Interface defines which methods a Box object should have.
 * 
 * @author Mustafa Fatih Can 280201007
 * @author Deniz Kaya 280201033
 * @author Hakan Uskan 280201076
 * @author Burak Erinç 290201099
 *
 * @param <T>
 */
public interface Box<T extends Item> extends Serial, Holder<T> {

	/**
	 * Gets the revenue of Box object.
	 *
	 * @return type: double
	 */
	public double getRevenue();

	/**
	 * Gets the total volume of Box object.
	 *
	 * @return type: double
	 */
	public double getTotalVolume();

	/**
	 * Gets the maximum volume the Box object can have.
	 *
	 * @return type: double
	 */
	public double getMaxVolume();

	/**
	 * Indicates that the box object is inside a container.
	 *
	 */
	public void putInContainer();

	/**
	 * Returns true if Box object is in container otherwise returns false.
	 *
	 * @return type: boolean
	 */
	public boolean isInContainer();
}
