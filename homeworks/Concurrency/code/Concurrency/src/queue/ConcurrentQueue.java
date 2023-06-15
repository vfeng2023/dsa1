package queue;
import java.util.LinkedList;
import java.util.concurrent.locks.*;
/**
 * A Linked-List based Queue
 * Is concurrent (i.e., can modify front and back in parallel)
 *
 * @param <T>
 */
public class ConcurrentQueue<T> implements IQueue<T>{


	private LinkedList<T> myqueue;
	private int size;
	private Lock qulock;
	private Condition hasitems;
	/**
	 * Constructor: Initialize the inner list
	 */
	public ConcurrentQueue(){
		//TODO: Write this method
		myqueue = new LinkedList<>();
		size = 0;
		qulock = new ReentrantLock();
		hasitems = qulock.newCondition();
	}
	
	/**
	 * Return the size by invoking the size of the list
	 */
	public int size() { 
		return myqueue.size();
	}
	

	/**
	 * Simply add the data to the tail of the linked list
	 */
	public void enqueue(T data) {
		
		//TODO: Write this method
		//lock queue
		qulock.lock();
		try{
			myqueue.add(data);
			hasitems.signalAll();
		}catch(Exception e){
			System.out.println(e.getStackTrace());
			System.exit(0);

		}finally{
			qulock.unlock();
		}
		//add element
		
		//qulock.unlock();

		
	}
	
	/**
	 * Simply remove data from the head of the list
	 */
	public T dequeue(){	
		
		//TODO: Write this method

		//lock queue
		qulock.lock();
		T elem = null;
		try{
			while(myqueue.size() == 0){
				hasitems.await();
				// if(Thread.interrupted()){
				// 	return null;
				// }
			}
			hasitems.signalAll();
			if(!Thread.interrupted()){
				elem = myqueue.removeFirst();
			}else{
				//qulock.unlock();
				return null;
			}
			
		}catch(Exception e){
			System.out.println(e.getStackTrace());
			
		}finally{
			qulock.unlock();
			
		}
		return elem;
		//delete element

	}
	
	
}
