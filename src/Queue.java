import java.util.Iterator;

/**
 *  The business logic of Queue 
 */
public interface Queue<E> extends Iterable<E>{
	
	/**
	 * adds an element to the end of the queue
	 * @return the element argument
	 */
	public E enqueue(E element);
	
	/**
	 * if the queue is non-empty removes the element from the front of the queue.
	 * @throws if the queue is empty
	 * @return the first element in the queue
	 */
	public E dequeue();
	
	/**
	 * if the queue is non-empty, returns the element at the front of the queue.
	 * @throws If the queue is empty, an exception is thrown and handled gracefully.
	 * @return  if the queue is non-empty, returns the element at the front of the queue.
	 */
	public E front();
	
	/**
	 * 
	 * @return true if and only if this Queue contains no elements; false otherwise.
	 */
	public boolean isEmpty();
	
}
