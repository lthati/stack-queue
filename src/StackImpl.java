import java.util.Iterator;

public class StackImpl<E> implements Stack<E> {

	private Node<E> top;
	
	/**
	 * constructor to create an empty stack
	 */
	public StackImpl()
	{
		top = null;
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
		E element = top.getData();
		top = top.getNextNode();
		return element;
	}

	/**
	 * inserts a new element into the stack
	 */
	@Override
	public E push(E element) {
		top = new Node<E>(element, top);
		return top.getData();
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
		return top.getData();
	}

	 /**
     * Checks if the stack is empty.
     */
	@Override
	public boolean isEmpty() {
		return top == null;
	}

	/**
	 * Implementing a stack iterator
	 */
	@Override
	public Iterator<E> iterator() {
		return new StackIterator();
	}
	
    private class StackIterator implements Iterator<E> {
		private Node current = top;
        public boolean hasNext()  
        { 
        	return current != null;                     
        }

        public E next() 
        {
            if (!hasNext())
            {	
    			throw new StackOrQueueException("Stack is empty"); 
            }
            E element = (E)current.getData();
            current = current.getNextNode();
            return element;
        }
        
        @Override
		public void remove() {
			throw new UnsupportedOperationException();			
		}
    }
}
