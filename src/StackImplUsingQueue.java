import java.util.Iterator;

public class StackImplUsingQueue<E> implements Stack<E> {
	private QueueImpl<E> inputQueue;
	private QueueImpl<E> outputQueue;

	/**
	 * constructor to create an empty stack
	 */
	public StackImplUsingQueue() {
		inputQueue = new QueueImpl<E>();
		outputQueue = new QueueImpl<E>();
	}
	
	/**
     *  Removes and returns the element at the top of this stack.
     */
	@Override
	public E pop() {
		if(isEmpty())
		{
			throw new StackOrQueueException("Stack is empty"); 
		}
		moveElementsFromInputQueueToOutputQueue();
		E element = inputQueue.dequeue();
		swapInputAndOutput();
		return element;
	}

	/**
	 * inserts a new element into the stack
	 */
	@Override
	public E push(E element) {
		inputQueue.enqueue(element);
		return element;
	}

	/**
	 * returns the top element without removing 
	 */
	@Override
	public E top() {
		if(isEmpty())
		{
			throw new StackOrQueueException("Stack is empty"); 
		}
		moveElementsFromInputQueueToOutputQueue();
		E element = inputQueue.front();
		outputQueue.enqueue(inputQueue.dequeue());
		swapInputAndOutput();
		return element;	
		}

	 /**
     * Checks if the stack is empty.
     */
	@Override
	public boolean isEmpty() {
		return inputQueue.isEmpty();
	}
	
	private void moveElementsFromInputQueueToOutputQueue()
	{
		while(inputQueue.size()>1)
		{
			outputQueue.enqueue(inputQueue.dequeue());
		}
	}
	
	private void swapInputAndOutput()
	{
		QueueImpl<E> temp = inputQueue;
		inputQueue = outputQueue;
		outputQueue = temp;
	}

	/**
	 * Implementing a stack iterator
	 */
	@Override
	public Iterator<E> iterator() {
		return new StackIterator();
	}
	
    private class StackIterator implements Iterator<E> {
    	QueueImpl<E> queue1 = new QueueImpl<E>();
    	QueueImpl<E> queue2 = new QueueImpl<E>();
    	Iterator<E> queueItr;
    	
    	public StackIterator() {
    		for (E e : inputQueue) {
				queue2.enqueue(e);
				for (E element : queue1) {
					queue2.enqueue(queue1.dequeue());
				}
				QueueImpl<E> temp = queue1;
				queue1 = queue2;
				queue2 = temp;
			}
    		queueItr = queue1.iterator();
		}
    	
        public boolean hasNext()  
        { 
        	return queueItr.hasNext();                     
        }

        public E next() 
        {
            if (!hasNext())
            {	
    			throw new StackOrQueueException("Stack is empty"); 
            }
    		return queueItr.next();	
        }
        
        @Override
		public void remove() {
			throw new UnsupportedOperationException();			
		}
    }
}
