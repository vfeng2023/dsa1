package hash;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Hash Table implementation. Uses linear probing to resolve collisions.
 * @author Mark Floryan
 *
 * @param <K>
 * @param <V>
 */
public class HashTable<K,V> implements Map<K,V>{

	/* The array of objects and related things */
	private HashNode<K,V>[] table;
	private int size;
	private int elementsAdded; //rehash when elements added exceeds load factor -- new array has double the number of elements
	/* YOU WILL LIKELY WANT MORE PRIVATE VARIABLES HERE */
	//implement quadratic probing
	private static int INITIAL_CAP = 16;
	private double lambda = 0.75;
	
	
	public HashTable() {
		this(INITIAL_CAP);
	}
	
	public HashTable(int initialCapacity) {
		/* TODO: IMPLEMENT THIS METHOD */
		table = (HashNode<K,V>[])(new HashNode[initialCapacity]);
		size = 0;
		elementsAdded = 0;
	}
	
	private int hash(K key){
		int h = key.hashCode();
		//int added = Math.abs(h/table.length);
		//h = (h + (added + 1) * table.length);
		return h;
	}
	private void rehash(){
		HashNode<K,V>[] oldtable = table;
		table = (HashNode<K,V>[])(new HashNode[oldtable.length*2]);
		size = 0;
		elementsAdded = 0;
		for(HashNode<K,V> node:oldtable){
			if(node!=null && node.getKey()!=null){
				insertItem(node.getKey(), node.getValue());
				size += 1;
				elementsAdded += 1;
			}
		}
	}

	private boolean insertItem(K key, V value){
		if(key==null) return true;
		int h = (hash(key)%table.length+table.length)%table.length;
		
		for(int i=0; i < table.length; i++){
			int loc = ((hash(key) + i*i)%table.length+table.length)%table.length;
			if(table[loc]==null){
				table[loc] = new HashNode<K,V>(key, value);
				return true;
			}else if(table[loc].getKey()!=null && table[loc].getKey().equals(key)){
				table[loc].setValue(value);
				return true;
			}
		}
		return false;
		
	}
	@Override
	public void insert(K key, V value) {
		/* TODO: IMPLEMENT THIS METHOD */
		boolean success = insertItem(key, value);
		
		if(!success||elementsAdded/(1.0 * table.length) > lambda){
			rehash();
			insertItem(key, value);
		}
		
	}

	@Override
	public V retrieve(K key) {
		//System.out.println(Arrays.toString(table));
		/* TODO: IMPLEMENT THIS METHOD */
		int h = hash(key);
		for(int i=0; i < table.length; i++){
			int loc = ((hash(key) + i*i)%table.length+table.length)%table.length;
			if(table[loc]==null){
				return null;
			}
			if(table[loc].getKey()!=null && table[loc].getKey().equals(key)){
				return table[loc].getValue();
			}
		}
		return null;
	}

	@Override
	public boolean contains(K key) {
		//System.out.println(Arrays.toString(table));
		/* TODO: IMPLEMENT THIS METHOD */
		for(int i=0; i < table.length; i++){
			int loc = ((hash(key) + i*i)%table.length+table.length)%table.length;

			if(table[loc]==null){
				return false;
			}
			if(table[loc].getKey()!=null && table[loc].getKey().equals(key)){
				return true;
			}
		}

		return false;
	}

	@Override
	public void remove(K key) {
		/* TODO: IMPLEMENT THIS METHOD */
		//System.out.println(Arrays.toString(table));
		for(int i=0; i < table.length; i++){
			int loc = ((hash(key) + i*i)%table.length+table.length)%table.length;
			if(table[loc]==null) return;
			
			if(table[loc].getKey()!=null && table[loc].getKey().equals(key)){
				table[loc] = new HashNode<>(null, null);
				break;
			}
		}
		size --;
		if(elementsAdded/(1.0 * table.length) > lambda){
			rehash();
		}
		
	}

	
	
	
}
