package furniturefactory.adt;

import java.util.ArrayList;
import java.util.List;
import furniturefactory.interfaces.*;

public class KeyedDequePairList<K, T>  implements IKeyedDequePairList<K,T> {

	private List<IPair<K, IDeque<T>>> dequePairs;

	public KeyedDequePairList() {
		dequePairs = new ArrayList<>();
	}

	@Override
	public void addElement(K key, T element) {
		IPair<K, IDeque<T>> appropriateDequePair = findAppropriateDequePair(key);
		if (appropriateDequePair == null) {
			IDeque<T> addedDeque = new Deque<>();
			addedDeque.add(element);
			IPair<K, IDeque<T>> addedDequePair = new Pair<>(key,addedDeque);
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
	public IPair<K, IDeque<T>> findAppropriateDequePair(K key) {// Returns null if no appropriate deque exists.
		IPair<K, IDeque<T>> returned = null;
		for (IPair<K, IDeque<T>> dequePair : this.dequePairs) {
			if (dequePair.getFirst().equals(key)) {
				returned = dequePair;
			}
		}
		return returned;
	}
}
