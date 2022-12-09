package furniturefactory.classes;

public class Deque<T> {
	private Node firstNode;
	private Node lastNode;
	private int numberOfEntries;

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
		assert(!isEmpty());
		T removed = firstNode.data;
		if(firstNode == lastNode) {
			firstNode = null;
			lastNode = firstNode;
		}else {
			firstNode = firstNode.nextNode;
			firstNode.setBefore(null);
		}
		numberOfEntries--;
		return removed;
	}
	public T removeLast(){
		assert(!isEmpty());
		T removed = lastNode.getData();
		if(firstNode == lastNode){
			firstNode = null;
			lastNode=firstNode;	
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
		return firstNode.getData();
	}
	
	public T peekLast() {
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
		return numberOfEntries == 0;
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
			this(null,data, null);
		}

		private Node(Node nodeBefore,T anEntry, Node nextNode) {
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
		
		private boolean hasNext() {
			return this.getNext() != null;
		}

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
