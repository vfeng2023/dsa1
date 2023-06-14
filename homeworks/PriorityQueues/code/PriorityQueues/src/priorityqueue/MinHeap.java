package priorityqueue;

import java.util.ArrayList;

public class MinHeap<T extends Comparable<T>> implements PriorityQueue<T> {

	/* The actual heap of data */
	private ArrayList<T> heap;
	private int size;
	
	public MinHeap() {
		/* TODO: IMPLEMENT THIS METHOD */
		heap = new ArrayList<>();
		heap.add(null); //index 0 is dummy node
		size = 0;
	}
	
	public MinHeap(ArrayList<T> data) {
		/* TODO: IMPLEMENT THIS METHOD */
		this();
		heap.addAll(data);
		size = data.size();
		heapify();
	}
	
	private void heapify() {
		/* TODO: IMPLEMENT THIS METHOD */
		for(int i=size/2; i > 0; i--){
			percolateDown(i);
		}
	}
	
	private void swap(int i, int j){
		T temp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, temp);
	}
	private void percolateUp(int index) {
		/* TODO: IMPLEMENT THIS METHOD */
		int p = index/2;
		while (p > 0){
			if(heap.get(index).compareTo(heap.get(p)) < 0){
				swap(p, index);
			}
			else{
				break;
			}
			index = p;
			p/=2;
		}
	}
	
	private void percolateDown(int index) {
		/* TODO: IMPLEMENT THIS METHOD */
		
		while(2*index <= size ){
			int left = 2*index;
			int right = 2*index + 1;
			int minChild = left;
			if(right <=size && heap.get(left).compareTo(heap.get(right)) > 0){
				minChild = right;
			}
			if(heap.get(index).compareTo(heap.get(minChild))> 0){
				swap(index, minChild);
			}else{
				break;
			}
			index = minChild;

		}
	}
	
	@Override
	public void push(T data) {
		/* TODO: IMPLEMENT THIS METHOD */
	
		heap.add(size+1, data);
		size ++;
		percolateUp(size);
	}

	@Override
	public T poll() {
		/* TODO: IMPLEMENT THIS METHOD */
		T el = heap.get(1);
		swap(1, size);
		size--;
		percolateDown(1);
		return el;
	}

	@Override
	public T peek() {
		/* TODO: IMPLEMENT THIS METHOD */
		if(size >= 1){
			return heap.get(1);
		}else{
			return null;
		}
		
	}
	
	@Override
	public int size() {
		/* TODO: IMPLEMENT THIS METHOD */
		return size;
	}
	
	
}
