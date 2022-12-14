package furniturefactory.adt;

import java.util.ArrayList;
import java.util.List;
import furniturefactory.interfaces.*;

/**
 * This adt holds IPair's which has-a IDeque and provides methods for finding the
 * IDeque with Id's
 * 
 * <ul>
 * <li><strong>dequePairs</strong> type: List<IPair<K, IDeque<T>>>
 * </ul>
 * 
 * @author Mustafa Fatih Can 280201007
 * @author Deniz Kaya 280201033
 * @author Hakan Uskan 280201076
 * @author Burak Erinc 290201099
 */
public class KeyedDequePairList<K, T> implements IKeyedDequePairList<K, T> {

	private List<IPair<K, IDeque<T>>> dequePairs;

	/**
	 * <strong>No Argument Constructor</strong>
	 * <p>
	 */
	public KeyedDequePairList() {
		dequePairs = new ArrayList<>();
	}

	@Override
	public void addElement(K key, T element) {
		IPair<K, IDeque<T>> appropriateDequePair = findAppropriateDequePair(key);
		if (appropriateDequePair == null) {
			IDeque<T> addedDeque = new Deque<>();
			addedDeque.add(element);
			IPair<K, IDeque<T>> addedDequePair = new Pair<>(key, addedDeque);
			dequePairs.add(addedDequePair);
			return;
		}
		appropriateDequePair.getSecond().add(element);

	}

	@Override
	public T removeFirstOccurrence(K key) {
		IDeque<T> materialsDeque = findAppropriateDequePair(key).getSecond();
		if (materialsDeque == null)
			return null;
		return materialsDeque.removeFirst();
	}

	@Override
	public T removeLastOccurrence(K key) {
		IDeque<T> materialsDeque = findAppropriateDequePair(key).getSecond();
		if (materialsDeque == null)
			return null;
		return materialsDeque.removeLast();
	}

	@Override
	public T peekFirstOccurence(K key) {
		IDeque<T> materialsDeque = findAppropriateDequePair(key).getSecond();
		if (materialsDeque == null)
			return null;
		return materialsDeque.peekFirst();
	}

	@Override
	public T peekLastOccurence(K key) {
		IDeque<T> materialsDeque = findAppropriateDequePair(key).getSecond();
		if (materialsDeque == null)
			return null;
		return materialsDeque.peekLast();
	}

	@Override
	public IPair<K, IDeque<T>> findAppropriateDequePair(K key) {
		IPair<K, IDeque<T>> returned = null;
		for (IPair<K, IDeque<T>> dequePair : this.dequePairs) {
			if (dequePair.getFirst().equals(key)) {
				returned = dequePair;
			}
		}
		return returned;
	}
}
