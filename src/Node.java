
public class Node<E> {

	private E data;
	private Node<E> next;
	
	/**
	 * Defining structure of the node
	 */
	
	public Node(E element)
	{
		this(element,null);
	}
	
	public Node(E element, Node<E> pointer)
	{
		this.data = element;
		this.next = pointer;
	}
	
	/**
	 * @return element stored in the node
	 */
	public E getData()
	{
		return data;
	}
	
	/**
	 * @return the next node
	 */
	public Node<E> getNextNode()
	{
		return next;
	}
	
	/**
	 * sets node's next to given node
	 */
	protected void setNextNode(Node<E> nextNode)
	{
		next = nextNode;
	}
}
