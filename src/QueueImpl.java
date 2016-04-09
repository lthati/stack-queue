import java.util.Iterator;

public class QueueImpl<E> implements Queue<E> {

	private Node<E> front;
	private Node<E> rear;
	
	/**
	 * constructor to create an empty queue
	 */
	public QueueImpl() {
		front = null;
		rear = null;
	}
	
	/**
	 * Add an element at the end of the queue
	 */
	@Override
	public E enqueue(E element) {
		Node<E> node = new Node<E>(element,null);
		if(isEmpty())
		{
			front = node;
			rear = front;
		}
		else
		{
			rear.setNextNode(node);
			rear = node;
		}
		return rear.getData();
	}

	/**
	 * removes the element from the front of the queue.	 
	 * @return the removed element
	 */
	@Override
	public E dequeue() {
		if(isEmpty())
		{
			throw new StackOrQueueException("Queue is Empty");
		}
		E removedElement = front.getData();
		if(front.getNextNode() == null)
		{
			rear = null;
		}
		front = front.getNextNode();
		return removedElement;
	}

	/**
	 * @return the element at the front of the queue.
	 */
	@Override
	public E front() {
		if(isEmpty())
		{
			throw new StackOrQueueException("Queue is Empty");
		}
		return front.getData();
	}

	 /**
     * Checks if the queue is empty.
     * @return true or false depending on whether the queue is empty or not.
     */
	@Override
	public boolean isEmpty() {
		return front==null;
	}
	
	public int size()
	{
		int size= 0;
		Iterator<E> queueItr = iterator();
		while(queueItr.hasNext())
		{
			size++;
			queueItr.next();
		}
		return size;
	}

	/**
	 * Implementing a iterator for this queue
	 * @return queue iterator
	 */
	@Override
	public Iterator<E> iterator() {
		 return new QueueIterator();  
		 }
	
	private class QueueIterator implements Iterator<E> {
	    Node current = front;
	    
	    public boolean hasNext()  
	    { 
	    	return current != null; 
	    }

	    public E next() {
	    	if (!hasNext())
            {	
    			throw new StackOrQueueException("Queue is empty"); 
            }
	    	E element = (E) current.getData();
	        current = current.getNextNode(); 
	        return element;
	    }

		@Override
		public void remove() {
			throw new UnsupportedOperationException();			
		}
	}
	

}
