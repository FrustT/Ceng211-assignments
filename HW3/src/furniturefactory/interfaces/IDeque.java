package furniturefactory.interfaces;

/**
 * Deque Interface defines which methods a IDeque object should have.
 * 
 * @author Mustafa Fatih Can 280201007
 * @author Deniz Kaya 280201033
 * @author Hakan Uskan 280201076
 * @author Burak Erinç 290201099
 *
 * @param <T>
 */
public interface IDeque<T> {
	/**
	 * Adds the entry to the deque.
	 * 
	 * @param entry type: T
	 */
	public void add(T entry);

	/**
	 * Removes and returns the element at the first position of the deque.Returns
	 * null if deque is empty.
	 * 
	 * @return element type: T
	 */
	public T removeFirst();

	/**
	 * Removes and returns the element at the last position of the deque.Returns
	 * null if deque is empty.
	 * 
	 * @return element type: T
	 */
	public T removeLast();

	/**
	 * Returns the element at the first position of the deque.Returns null if deque
	 * is empty.
	 * 
	 * @return element type: T
	 */
	public T peekFirst();

	/**
	 * Returns the element at the last position of the deque.Returns null if deque
	 * is empty.
	 * 
	 * @return element type: T
	 */
	public T peekLast();

	/**
	 * Clears the content of the IDeque.
	 */
	public void clear();

	/**
	 * Gets the length of the Deque.
	 * 
	 * @return length type: int
	 */
	public int getLength();

	/**
	 * Returns a boolean respect to emptiness of the deque
	 * 
	 * @return result type: boolean
	 */
	public boolean isEmpty();

	/**
	 * Returns the T[] array of the deque
	 * 
	 * @return elementArray type:T[]
	 */
	public T[] toArray();
}
