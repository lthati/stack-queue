import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class QueueImplUsingStackTest {

	private QueueImplUsingStack<Student> studentLine;

	@Before
	public void setUp() throws Exception {
		studentLine = new QueueImplUsingStack<Student>();
	}

	/**
	 * Should be able to enqueue into the empty queue
	 */
	@Test
	public void shouldBeAbleToenqueueIntoTheEmptyQueue() {
		studentLine.enqueue(new Student("leela", "thati"));
		studentLine.enqueue(new Student("sahiti", "thati"));
		studentLine.enqueue(new Student("virat", "k"));
	}

	/**
	 * if the queue is empty , dequeue should throw exception
	 */
	@Test
	public void dequeueShouldThrowExceptionWhenQueueIsEmpty()
	{
		try
		{
		studentLine.dequeue();
		}
		catch(StackOrQueueException e)
		{
			return;
		}
		assertFalse(true);
	}
	
	/**
	 * when queue has only one element i.e front = rear 
	 * should be able to return front/rear element
	 */
	@Test
	public void dequeueShouldReturnFrontOrRearElementWhenQueueSize1()
	{
		Student leela = new Student("leela", "thati");
		studentLine.enqueue(leela);
		assertEquals(leela, studentLine.dequeue());
	}
	
	/**
	 * when queue is not empty should return the first inserted element
	 */
	@Test
	public void dequeueShouldReturnFirstInsertedElement()
	{
		Student leela = new Student("leela", "thati");
		studentLine.enqueue(leela);
		Student sahiti = new Student("sahiti", "thati");
		studentLine.enqueue(sahiti);
		Student virat = new Student("virat", "k");
		studentLine.enqueue(virat);
		assertEquals(leela, studentLine.dequeue());
		assertEquals(sahiti, studentLine.dequeue());
		assertEquals(virat, studentLine.dequeue());
	}
	
	/**
	 * dequeue Should ThrowException Only After Queue Has Become Empty
	 */
	@Test
	public void dequeueShouldThrowExceptionOnlyAfterQueueHasBecomeEmpty()
	{
		Student sahiti = new Student("sahiti", "thati");
		studentLine.enqueue(sahiti);
		Student virat = new Student("virat", "k");
		studentLine.enqueue(virat);
		assertEquals(sahiti, studentLine.dequeue());
		assertEquals(virat, studentLine.dequeue());
		try
		{
			studentLine.dequeue();
		}
		catch(StackOrQueueException e)
		{
			return;
		}
		assertFalse(true);
	}
	
	/**
	 * Insert elements into a queue after dequeue
	 */
	@Test
	public void shouldBeAbleToInsertElementsIntoTheQueue()
	{	
		Student sahiti = new Student("sahiti", "thati");
		studentLine.enqueue(sahiti);
		Student virat = new Student("virat", "k");
		studentLine.enqueue(virat);
		assertEquals(sahiti, studentLine.dequeue());
		assertEquals(virat, studentLine.dequeue());
		studentLine.enqueue(virat);
		assertEquals(virat, studentLine.dequeue());
	}
	
	/**
	 * If the queue is empty front should return exception
	 */
	@Test
	public void frontShouldThrowExceptionWhenQueueIsEmpty()
	{
		try
		{
		studentLine.front();
		}
		catch(StackOrQueueException e)
		{
			return;
		}
		assertFalse(true);
	}
	
	/**
	 * if the queue is not empty should return the front element but shouldn't remove it
	 */
	@Test
	public void frontShouldReturnTheFirstElementInTheQueue()
	{
	Student sahiti = new Student("sahiti", "thati");
	studentLine.enqueue(sahiti);
	Student virat = new Student("virat", "k");
	studentLine.enqueue(virat);
	assertEquals(sahiti, studentLine.front());
	assertEquals(sahiti, studentLine.front());
	}
	
	/**
	 * If the queue is empty isEmpty Should Return true
	 */
	@Test
	public void shouldReturnTrueIfQueueIsEmpty()
	{
		assertTrue(studentLine.isEmpty());
	}
	
	/**
	 * If the queue is not empty isEmpty Should Return false
	 */
	@Test
	public void shouldReturnFalseIfQueueIsNotEmpty()
	{
		studentLine.enqueue(new Student("leela", "thati"));
		assertFalse(studentLine.isEmpty());
	}
	
	/**
	 * Should be able to iterate through the queue
	 */
	@Test
	public void shouldBeAbleToIterateThroughTheQueue() {
		Student leela = new Student("leela", "thati");
		studentLine.enqueue(leela);
		Student sahiti = new Student("sahiti", "thati");
		studentLine.enqueue(sahiti);
		Student virat = new Student("virat", "k");
		studentLine.enqueue(virat);
		Iterator<Student> studentItr = studentLine.iterator();
		if(studentItr.hasNext()) {
			 Student element =  studentItr.next();
			 assertEquals(leela, element);
		}
		if(studentItr.hasNext()) {
			 Student element =  studentItr.next();
			 assertEquals(sahiti, element);
		}
		if(studentItr.hasNext()) {
			 Student element =  studentItr.next();
			 assertEquals(virat, element);
		}
		if(studentItr.hasNext())
		{
		assertFalse(true);
		}
		try
		{
			studentItr.remove();
		}
		catch(Exception UnsupportedOperationException)
		{
			return;
		}
		assertFalse(true);
	}
	
	/**
	 * Should be able to iterate through the queue after dequeue
	 */
	@Test
	public void shouldBeAbleToIterateThroughTheQueueAfterDequeue() {
		Student leela = new Student("leela", "thati");
		studentLine.enqueue(leela);
		Student sahiti = new Student("sahiti", "thati");
		studentLine.enqueue(sahiti);
		Student virat = new Student("virat", "k");
		studentLine.enqueue(virat);
		Iterator<Student> studentItrInitial = studentLine.iterator();
		studentLine.dequeue();
		if(studentItrInitial.hasNext()) {
			 Student element =  studentItrInitial.next();
			 assertEquals(leela, element);
		}
		if(studentItrInitial.hasNext()) {
			 Student element =  studentItrInitial.next();
			 assertEquals(sahiti, element);
		}
		if(studentItrInitial.hasNext()) {
			 Student element =  studentItrInitial.next();
			 assertEquals(virat, element);
		}
		if(studentItrInitial.hasNext())
		{
		assertFalse(true);
		}
		Iterator<Student> studentItr = studentLine.iterator();
		if(studentItr.hasNext()) {
			 Student element =  studentItr.next();
			 assertEquals(sahiti, element);
		}
		if(studentItr.hasNext()) {
			 Student element =  studentItr.next();
			 assertEquals(virat, element);
		}
		if(studentItr.hasNext())
		{
		assertFalse(true);
		}
		try
		{
			studentItr.remove();
		}
		catch(Exception UnsupportedOperationException)
		{
			return;
		}
		assertFalse(true);
	}
}
