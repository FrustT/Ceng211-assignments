package furniturefactory.classes;

public class Pair<T, K> {

	private T first;
	private K second;

	public Pair(T _first, K _second) {
		this.first = _first;
		this.second = _second;
	}

	public T getFirst() {
		return this.first;
	}

	public K getSecond() {
		return this.second;
	}
}
