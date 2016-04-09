import java.util.Iterator;

import javax.swing.text.StyledEditorKit.ForegroundAction;


public class QueueImplUsingStack<E> implements Queue<E> {
	private StackImpl<E> inputStack;
	private StackImpl<E> outputStack;

	/**
	 * constructor to create an empty queue
	 */
	public QueueImplUsingStack() {
		inputStack = new StackImpl<E>();
		outputStack = new StackImpl<E>();
	}
	
	/**
	 * Add an element at the end of the queue
	 */
	@Override
	public E enqueue(E element) {
		inputStack.push(element);
		return inputStack.top();
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
		if(outputStack.isEmpty())
		{
			moveInputStackToOutputStack();
		}
		return outputStack.pop();
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
		if(outputStack.isEmpty())
		{
			moveInputStackToOutputStack();
		}
		return outputStack.top();
	}

	 /**
     * Checks if the queue is empty.
     * @return true or false depending on whether the queue is empty or not.
     */
	@Override
	public boolean isEmpty() {
		return inputStack.isEmpty() && outputStack.isEmpty();
	}
	
	 private void moveInputStackToOutputStack() {
	    while (inputStack.iterator().hasNext())
	    {
	       outputStack.push(inputStack.pop());
	    }
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
		private StackImpl<E> stack1 = new StackImpl<E>();
		private Iterator<E> stack1Itr; 
		
		public QueueIterator()
		{
			for (E e : inputStack) {
				stack1.push(e);
			}
			stack1Itr = stack1.iterator();
		}
	    
	    public boolean hasNext()  
	    { 
	    	return stack1Itr.hasNext(); 
	    }

	    public E next() {
	    	if (!hasNext())
            {	
    			throw new StackOrQueueException("Queue is empty"); 
            }
	    	E element =  stack1Itr.next();
	        return element;
	    }

		@Override
		public void remove() {
			throw new UnsupportedOperationException();			
		}
	}

}
