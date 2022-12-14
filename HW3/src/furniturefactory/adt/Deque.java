package furniturefactory.adt;

import furniturefactory.interfaces.IDeque;

/**
 * This is adt provides ways for adding and removing from both front and back of
 * the list
 * 
 * <ul>
 * <li><strong>firstNode</strong> type: Node
 * <li><strong>lastNode</strong> type: Node
 * <li><strong>numberOfEntries</strong> type: int
 * </ul>
 * 
 * @author Mustafa Fatih Can 280201007
 * @author Deniz Kaya 280201033
 * @author Hakan Uskan 280201076
 * @author Burak Erinc 290201099
 */
public class Deque<T> implements IDeque<T> {
	private Node firstNode;
	private Node lastNode;
	private int numberOfEntries;

	/**
	 * <strong>No Argument Constructor</strong>
	 * <p>
	 */
	public Deque() {
		firstNode = null;
		lastNode = null;
		numberOfEntries = 0;
	}

	public void add(T entry) {
		Node newNode = new Node(entry);
		if (isEmpty()) {
			firstNode = newNode;
			lastNode = newNode;
		} else {
			lastNode.setNext(newNode);
			newNode.setBefore(lastNode);
			lastNode = newNode;

		}
		numberOfEntries++;
	}

	public T removeFirst() { // Removes the first element from the list
		if (isEmpty()) {
			return null;
		}
		T removed = firstNode.data;
		if (firstNode == lastNode) {
			firstNode = null;
			lastNode = firstNode;
		} else {
			firstNode = firstNode.nextNode;
			firstNode.setBefore(null);
		}
		numberOfEntries--;
		return removed;
	}

	public T removeLast() {
		if (isEmpty()) {
			return null;
		}
		T removed = lastNode.getData();
		if (firstNode == lastNode) {
			firstNode = null;
			lastNode = firstNode;
		} else {
			Node nodeBeforeLast = lastNode.getBefore();
			lastNode.setBefore(null);
			nodeBeforeLast.setNext(null);
			lastNode = nodeBeforeLast;

		}
		numberOfEntries--;
		return removed;
	}

	public T peekFirst() {
		if (isEmpty()) {
			return null;
		}
		return firstNode.getData();
	}

	public T peekLast() {
		if (isEmpty()) {
			return null;
		}
		return lastNode.getData();
	}

	public void clear() {
		firstNode = null;
		lastNode = null;
		numberOfEntries = 0;
	}

	public int getLength() {
		return numberOfEntries;
	}

	public boolean isEmpty() {
		return numberOfEntries <= 0;
	}

	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Comparable[numberOfEntries];
		int index = 0;
		Node currentNode = firstNode;
		while ((index < numberOfEntries) && (currentNode != null)) {
			array[index] = currentNode.getData();
			currentNode = currentNode.getNext();
			index++;
		}
		return array;
	}

	private class Node {
		private T data;
		private Node nextNode;
		private Node nodeBefore;

		private Node(T data) {
			this(null, data, null);
		}

		private Node(Node nodeBefore, T anEntry, Node nextNode) {
			this.nodeBefore = nodeBefore;
			data = anEntry;
			this.nextNode = nextNode;
		}

		private T getData() {
			return data;
		}

		private Node getNext() {
			return nextNode;
		}

		private Node getBefore() {
			return nodeBefore;
		}

		@SuppressWarnings("unused")
		private boolean hasNext() {
			return this.getNext() != null;
		}

		@SuppressWarnings("unused")
		private void setData(T entry) {
			data = entry;
		}

		private void setNext(Node nextNode) {
			this.nextNode = nextNode;
		}

		private void setBefore(Node nodeBefore) {
			this.nodeBefore = nodeBefore;
		}
	}
}
