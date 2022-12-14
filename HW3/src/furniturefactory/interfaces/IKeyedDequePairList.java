package furniturefactory.interfaces;

/**
 * KeyedDequePairList Interface defines which methods a IKeyedDequePairList
 * object should have
 *
 * @author Mustafa Fatih Can 280201007
 * @author Deniz Kaya 280201033
 * @author Hakan Uskan 280201076
 * @author Burak Erinç 290201099
 *
 * @param <K>
 * @param <T>
 */
public interface IKeyedDequePairList<K, T> {
	/**
	 * Adds A element with type T to the key with type K to the List
	 * 
	 * @param key
	 * @param element
	 */
	public void addElement(K key, T element);

	/**
	 * Removes and returns the first occurence of the T that its K key given.
	 * Returns null if key does not exist.
	 * 
	 * @param key
	 * @return element type: T
	 */
	public T removeFirstOccurrence(K key);

	/**
	 * Removes and returns the last occurence of the T that its K key given. Returns
	 * null if key does not exist.
	 * 
	 * @param key
	 * @return element type: T
	 */
	public T removeLastOccurrence(K key);

	/**
	 * Returns the first occurence of the Element typ that its ID given. Returns
	 * null if key does not exist.
	 * 
	 * @param key
	 * @return element type: T
	 */
	public T peekFirstOccurence(K key);

	/**
	 * Returns the last occurence of the Material that its ID given. Returns null if
	 * key does not exist.
	 * 
	 * @param key
	 * @return element type: T
	 */
	public T peekLastOccurence(K key);

	/**
	 * Returns IPair object in the list the that its K key given. Returns null if no
	 * appropriate deque exists.
	 * 
	 * @param key
	 * @return IPair<K, IDeque<T>>
	 */
	public IPair<K, IDeque<T>> findAppropriateDequePair(K key);

}