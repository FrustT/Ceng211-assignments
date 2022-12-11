package furniturefactory.interfaces;

public interface IKeyedDequePairList<K, T> {

	public void addElement(K key, T element);

	public T removeFirstOccurrence(K key);

	public T removeLastOccurrence(K key);

	public T peekFirstOccurence(K key);

	public T peekLastOccurence(K key);

	public IPair<K, IDeque<T>> findAppropriateDequePair(K key);

}