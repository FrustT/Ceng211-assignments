package furniturefactory.interfaces;

/**
 * Pair Interface defines which methods a IPair object should have
 *
 * @author Mustafa Fatih Can 280201007
 * @author Deniz Kaya 280201033
 * @author Hakan Uskan 280201076
 * @author Burak Erinç 290201099
 *
 * @param <T>
 * @param <K>
 */
public interface IPair<T, K> {
	/**
	 * Gets the first data of the IPair object
	 * 
	 * @return T type: T
	 */
	public T getFirst();

	/**
	 * Gets the second data of the IPair object
	 * 
	 * @return K type: K
	 */
	public K getSecond();

	/**
	 * Sets the first data of the IPair object with given param
	 * 
	 * @param first
	 */
	public void setFirst(T first);

	/**
	 * Sets the second data of the IPair object with given param
	 * 
	 * @param second
	 */
	public void setSecond(K second);
}