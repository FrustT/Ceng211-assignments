package furniturefactory.classes;

public class Pair<K, T> {
	private K key;
	private T[] data;
	
	public Pair(K key, T... data) {
		this.key = key;
		this.data = data;
	}
}
