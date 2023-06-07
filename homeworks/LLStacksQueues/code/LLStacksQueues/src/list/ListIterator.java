package list;

public class ListIterator<T> {
	
	protected ListNode<T> curNode;
	
	public ListIterator(ListNode<T> curNode) {
		this.curNode = curNode;
	}
	
	/**
	 * These two methods tell us if the iterator has run off
	 * the list on either side
	 */
	public boolean isPastEnd() {
		/* TODO: Implement this method */
		// last values in linked list are null
		if(curNode==null) return true;
		if(curNode.next==null){
			return true;
		}
		return false;
		//return false;
	}
	
	public boolean isPastBeginning() {
		/* TODO: Implement this method */
		if(curNode==null) return true;
		if(curNode.prev==null)
			return true;
		return false;
	}
	
	/**
	 * Get the data at the current iterator position
	 */
	public T value() {
		/* TODO: Implement this method */
		if(curNode!=null) return curNode.getData();
		return null;
	}
	
	/**
	 * These two methods move the cursor of the iterator
	 * forward / backward one position
	 */
	public void moveForward() {
		/* TODO: Implement this method */
		curNode = curNode.next;
	}
	
	public void moveBackward() {
		/* TODO: Implement this method */
		curNode = curNode.prev;
	}

	// protected ListNode<T> getcurNode(){
	// 	return curNode;
	// }
}
