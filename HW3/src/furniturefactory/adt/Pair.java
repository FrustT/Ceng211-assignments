package furniturefactory.adt;

import furniturefactory.interfaces.IPair;

/**
 * This adt hold two type data in order.
 * 
 * <ul>
 * <li><strong>first</strong> type: T
 * <li><strong>second</strong> type: K
 * </ul>
 * 
 * @author Mustafa Fatih Can 280201007
 * @author Deniz Kaya 280201033
 * @author Hakan Uskan 280201076
 * @author Burak Erinc 290201099
 */
public class Pair<T, K> implements IPair<T, K> {

	private T first;
	private K second;

	/**
	 * <strong>Parameterized Constructor</strong>
	 * <p>
	 * Constructs Pair Object with required data.
	 * 
	 * @param first
	 * @param second
	 */
	public Pair(T first, K second) {
		this.first = first;
		this.second = second;
	}

	/**
	 * <strong>Copy Constructor</strong>
	 * <p>
	 * Constructs a new Pair Object with another Pair Object It does not work
	 * succesfully if T or K are mutable.
	 * 
	 * @param pair
	 */
	public Pair(Pair<T, K> pair) {
		this.first = pair.getFirst();
		this.second = pair.getSecond();
	}

	@Override
	public T getFirst() {
		return this.first;
	}

	@Override
	public K getSecond() {
		return this.second;
	}

	@Override
	public void setFirst(T first) {
		this.first = first;
	}

	@Override
	public void setSecond(K second) {
		this.second = second;
	}
}
