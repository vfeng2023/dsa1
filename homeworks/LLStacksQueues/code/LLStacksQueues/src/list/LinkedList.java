package list;

/**
 * 
 * A custom built linked list
 * T here is the type the list stores
 */
public class LinkedList<T> implements List<T>{

	/* Dummy head and tail */
	private ListNode<T> head, tail;
	private int size;
	
	public LinkedList() {
		/* TODO: Implement this method */
		head = new ListNode<T>(null);
		tail = new ListNode<T>(null);
		tail.prev = head;
		head.next = tail;
		size = 0;  
	}
	
	public int size() {
		/* TODO: Implement this method */  
		return size;
	}
	
	/**
	 * Clears out the entire list
	 */
	public void clear() {
		/* TODO: Implement this method */
		//set head next pointer to tail, head.prev to null;
		head.next = tail;
		head.prev = null;
		//set tail next pointer to null, tail.prev to head
		tail.next = null;
		tail.prev = head;
		size = 0;
	}
	
	/**
	 * Inserts new data at the end of the list (i.e., just before the dummy tail node)
	 * @param data
	 */
	public void insertAtTail(T data) {
		/* TODO: Implement this method */ 
		ListNode<T> prevNode = tail.prev;
		ListNode<T> newNode = new ListNode<>(data);
		//new node needs to point to tail, tail needs to point to new node, prevNode needs references to newNode
		newNode.next = tail;
		newNode.prev = prevNode;
		tail.prev = newNode;
		prevNode.next = newNode;
		size ++;


	}
	
	/**
	 * Inserts data at the front of the list (i.e., just after the dummy head node
	 * @param data
	 */
	public void insertAtHead(T data) {
		/* TODO: Implement this method */ 
		ListNode<T> newNode = new ListNode<>(data);
		ListNode<T> nextNode = head.next;
		//head points to new node
		head.next = newNode;
		//new node points to rest of list
		newNode.next = nextNode;
		newNode.prev = head;
		//rest of list points to  new node
		nextNode.prev = newNode;
		size ++;
	}
	
	/**
	 * Inserts node such that index becomes the position of the newly inserted data
	 * @param data
	 * @param index
	 */
	public void insertAt(int index, T data) {
		/* TODO: Implement this method */
		if(index < 0||index >size){
			//return null;
			return;
		}
		//iterate to node before index;
		int stepcount = 0;
		ListNode <T> p = head;
		for(int i=0; i < index; i++){
			p = p.next;
			stepcount += 1;
		}
		// System.out.print(stepcount);
		// if(p.getData()==null){
		// 	//System.out.println(" null");
			
		// }else{
		// 	System.out.println(" "+ p.getData().toString());
		// }
		ListNode<T> nextNode = p.next;
		ListNode<T> newNode = new ListNode<T>(data);
		//p should point to next, next prev should be nn, nn should have next next and p prev
		p.next = newNode;
		newNode.prev = p;
		newNode.next = nextNode;
		nextNode.prev = newNode;
		size ++;
	}
	
	/**
	 * Inserts data after the node pointed to by iterator
	 */
	public void insert(ListIterator<T> it, T data) {
		/* TODO: Implement this method */ 
		ListNode<T> node = it.curNode;
		ListNode<T> newNode = new ListNode<T>(data);
		ListNode<T> nextNode = node.next;
		//node.next = 
		node.next = newNode;
		newNode.prev = node;
		newNode.next = nextNode;
		nextNode.prev = newNode;
		size ++;
		
	}
	
	
	
	public T removeAtTail(){
		/* TODO: Implement this method */ 
		if(size==0){
			return null;
		}
		ListNode<T> removedNode = tail.prev;
		ListNode<T> newLast = tail.prev.prev;
		//set the previous node for tail to be prevNode
		newLast.next = tail;
		tail.prev = newLast;
		//set prevNode next to tail
		size --;
		return removedNode.getData();
		//return null;
	}
	
	public T removeAtHead(){
		/* TODO: Implement this method */  
		if(size==0){
			return null;
		}
		ListNode<T> removedNode = head.next;
		ListNode<T> nextNode = removedNode.next;
		head.next = nextNode;
		nextNode.prev = head;
		//return null;
		size --;
		return removedNode.getData();
	}
	
	/**
	 * Remove based on Iterator position
	 * Sets the iterator to the node AFTER the one removed
	 */
	public T remove(ListIterator<T> it) {
		/* TODO: Implement this method */  
		ListNode<T> currNode = it.curNode;
		ListNode<T> newNode = currNode.next;
		//newNode.prev = currNode.prev
		//curNode.prev.next = newNode
		newNode.prev = currNode.prev;
		currNode.prev.next = newNode;
		it.curNode = newNode;
		size --;
		return currNode.getData();
	}
	
	/**
	 * Returns index of first occurrence of the data in the list, or -1 if not present
	 * @param data
	 * @return
	 */
	public int find(T data) {
		/* TODO: Implement this method */
		if(size==0){
			return -1;
		}
		ListNode<T> p = head.next;
		int idx = 0;
		while(p!=null && p.next!=null){
			if(data.equals(p.getData())){
				return idx;
			}
			p = p.next;
			idx += 1;
		}
		return -1;
	}
	
	/**
	 * Returns the data at the given index, null if anything goes wrong (index out of bounds, empty list, etc.)
	 * @param index
	 * @return
	 */
	public T get(int index) { 
		/* TODO: Implement this method */  
		//return null;
		if(index < 0||index > size){
			return null;
		}else{
			ListNode<T> p = head;
			for(int i=0; i <= index; i++){
				p = p.next;
			}
			return p.getData();
		}
	}
	
	/**
	 * Returns the list as space separated values
	 */
	public String toString() {
		String toRet = "[";
		
		ListNode<T> curNode = head.next;
		while(curNode != tail) {
			toRet += curNode.getData() + ", ";
			curNode = curNode.next;
		}
		
		return toRet + "]";
	}
	
	/* Return iterators at front and end of list */
	public ListIterator<T> front(){ 
		/* TODO: Implement this method */  
		return new ListIterator<T>(head.next);
	}

	public ListIterator<T> back(){
		/* TODO: Implement this method */ 
		return new ListIterator<T>(tail.prev);
	}
	
	
}
