package marketshipment.interfaces;

import marketshipment.classes.ContainerCode;

/**
 * This interface defines container's methods.IContainer is a generic typed that
 * only expects Serial Type. IContainer is also an Holder<T>
 * 
 * @author Mustafa Fatih Can 280201007
 * @author Deniz Kaya 280201033
 * @author Hakan Uskan 280201076
 * @author Burak Erinç 290201099
 * @param <T>
 */
public interface IContainer<T extends Serial> extends Serial, Holder<T> {
	/**
	 * Gets Container's Enum typed dataholder ContainerCode
	 * 
	 * @return ContainerCode
	 */
	public ContainerCode getContainerCode();

	/**
	 * Ships the container and makes it unable to add another element
	 */
	public void ship();

	/**
	 * Gets total revenue of the Container
	 * 
	 * @return double
	 */
	public double getTotalRevenue();

	/**
	 * Returns true if container is shipped otherwise returns false
	 * 
	 * @return boolean
	 */
	public boolean isShipped();

}
