package furniturefactory.interfaces;

public interface IPair<T, K> {

	public T getFirst();

	public K getSecond();
	
	public void setFirst(T first);
	
	public void setSecond(K second);
}