package furniturefactory.interfaces;

public interface IDeque<T> {
	public void add(T entry);

	public T removeFirst();

	public T removeLast();

	public T peekFirst();

	public T peekLast();

	public void clear();

	public int getLength();

	public boolean isEmpty();

	public T[] toArray();
}
