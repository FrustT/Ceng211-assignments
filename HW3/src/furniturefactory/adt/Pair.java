package furniturefactory.adt;

import furniturefactory.interfaces.IPair;

public class Pair<T, K> implements IPair<T, K> {

	private T first;
	private K second;

	public Pair(T first, K second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public T getFirst() {
		return this.first;
	}

	@Override
	public K getSecond() {
		return this.second;
	}
}
