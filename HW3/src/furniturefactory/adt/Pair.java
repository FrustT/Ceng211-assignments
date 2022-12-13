package furniturefactory.adt;

import furniturefactory.interfaces.Copyable;
import furniturefactory.interfaces.IPair;

public class Pair<T,K> implements IPair<T, K> {

	private T first;
	private K second;

	public Pair(T first, K second) {
		this.first = first;
		this.second = second;
	}
	
	public Pair(Pair<T,K> pair) {
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
