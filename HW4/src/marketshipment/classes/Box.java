package marketshipment.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import marketshitment.interfaces.IContainer;

public class Box<E> implements IContainer<E> {
	List<E> contents;

	public Box() {
		contents = new ArrayList<>();
	}
	
	public String toString() {//TODO test this
		return Arrays.deepToString(contents.toArray());
	}

	@Override
	public int size() {
		return contents.size();
	}

	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	@Override
	public boolean contains(Object o) {
		return contents.indexOf(o) != -1;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		return contents.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return contents.toArray(a);
	}

	@Override
	public boolean add(E e) {
		contents.add(e);
		return true;
	}

	@Override
	public boolean remove(Object o) {
		contents.remove(o);
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		for (Object element : c) {
			if (!this.contains(element))
				return false;
		}
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		for (E element : c) {
			if (!this.add(element))
				return false;
		}

		return true;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		for (Object element : c)
			if (!this.remove(element))
				return false;
		return true;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		for(E element : this.contents) {
			if(!c.contains(element))this.remove(element);
		}
		return true;
	}

	@Override
	public void clear() {
		this.contents = new ArrayList<>();
	}

}
