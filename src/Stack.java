
/**
 * The business logic of stack 
 */

public interface Stack<E> extends Iterable<E> {

	/**
	 *pop: if the stack is non-empty, it removes the top element off the stack. 
	 *If the stack is empty, an exception is thrown, 
	 *but it should be caught and handled gracefully.
     *@return the top element off the stack
	*/
	public E pop();
	
	/**
	 * pushes an element onto the top of the stack.
	 * @param the element to be pushed on to the stack
	 * @return the element argument 
	 */
	public E push(E element);
	
	/**
	 *  if the stack is non-empty, returns the top element.  
	 *  If the stack is empty, an exception is thrown, 
	 *  but it should be caught and handled gracefully.  This method does not remove the top element.
	 *  @return the top element of the stack
	 */
	public E top();
	
	/**
	 * returns true or false depending on whether the stack is empty or not.
	 * @return true if and only if this stack contains no elements; false otherwise.
	 */
	public boolean isEmpty();
	
}
