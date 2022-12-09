package furniturefactory.classes;

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

public class HashMap<K,V> {

	private static final int INITIAL_CAPACITY=16;
	
	
	private int capacity;
	private int size;
	
	
	private HashMap.Entry[] buckets;
	
	public HashMap(){
		this(INITIAL_CAPACITY);
	}
	public HashMap(int initialCapacity){
		this.capacity = initialCapacity;
		this.buckets =new HashMap.Entry[capacity];
		this.size = 0;
	}
	
	private int hash(K key){
		int hashCode = key.hashCode();
		return hashCode % this.capacity;
	}
	
	private class Bucket{
		private List<Entry<K,V>> entries;
		
		public Bucket(){
			this.entries = new LinkedList<>();
		}
		
	}
	
	private static class Entry<K, V>{
		private K key;
		private V value;
		
		public Entry(K key, V value){
			this.key = key;
			this.value = value;
		}
		public K getKey(){
			return this.key;
		}
		public V getValue(){
			return this.value;
		}
		
	
	}
}
