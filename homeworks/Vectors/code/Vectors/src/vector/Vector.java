package vector;

public class Vector<T> implements List<T> {
	
	private T[] data;
	private int size = 0;
	private static final int INITIAL_CAPACITY = 100;
	
	public Vector(){
		this(INITIAL_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public Vector(int capacity) {
		this.data = (T[])new Object[capacity];
		this.size = 0;
	}
	
	public int capacity() {
		return this.data.length;
	}

	/**
	 * When the underlying array fills up, we need to resize it to accommodate the stack's elements
	 * Ignores the request if the new capacity is too small to fit the elements already in the stack
	 */
	public void resize(int newCapacity){
		//TODO: Implement this method
		T[] d = this.data;
		this.data = (T[])new Object[newCapacity];
		for(int i=0; i < d.length; i++){
			this.data[i] = d[i];
		}
	}

	@Override
	/**
	 * Returns the size of the list 
	 */
	public int size() {
		//TODO: Implement this method
		return this.size;
	}

	@Override
	/**
	 * clears out entire list
	 */
	public void clear() {
		//TODO: Implement this method
		this.size = 0;
	}

	@Override
	/**
	 * Inserts new data at the end of the list
	 */
	public void insertAtTail(T data) {
		//TODO: Implement this method
		if(this.size+1 >= this.data.length) resize(2*this.data.length);
		this.data[this.size] = data;
		this.size ++;
	}

	@Override
	/**
	 * INserts data at head
	 */
	public void insertAtHead(T obj) {
		//TODO: Implement this method
		insertAt(0, obj);
		

	}

	@Override
	/**
	 * Inserts at an index
	 */
	public void insertAt(int index, T obj) {
		//TODO: Implement this method
		if(size+1 > data.length){
			resize(2*data.length);
		}
		for(int i=size-1; i >= index; i--){
			data[i+1] = data[i];
		}
		data[index] = obj;
		size += 1;
	}
	/**
	 * Removes the laze value;
	 */
	@Override
	public T removeAtTail() {
		//TODO: Implement this method
		size -= 1;
		return this.data[size];
		
	}

	@Override
	/**
	 * Removes the first value
	 */
	public T removeAtHead() {
		//TODO: Implement this method
		T retval = data[0];
		int idx = 1;
		while(idx < size){
			data[idx-1] = data[idx];
			idx ++;
		}
		size -= 1;
		return retval;
	}

	@Override
	/**
	 * Find the first element which equals the value
	 */
	public int find(T val) {
		//TODO: Implement this method
		for(int i=0; i < size; i++){
			if(data[i].equals(val)){
				return i;
			}
		}
		return -1;
	}

	@Override
	/**
	 * Gets value at index
	 */
	public T get(int index) {
		//TODO: Implement this method
		return data[index];
	}

}
