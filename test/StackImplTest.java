import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class StackImplTest {
	
	private StackImpl<Student> studentRecords;

	@Before
	public void setUp() throws Exception {
		studentRecords = new StackImpl<Student>();
	}

	/**
	 * Should be able push into the empty stack
	 */
	@Test
	public void shouldBeAbleToPushIntoTheEmptyStack() {
		studentRecords.push(new Student("leela", "thati"));
		studentRecords.push(new Student("sahiti", "thati"));
		studentRecords.push(new Student("virat", "k"));
	}

	/**
	 * if the stack is empty , pop should throw exception
	 */
	@Test
	public void popShouldThrowExceptionWhenStackIsEmpty()
	{
		try
		{
		studentRecords.pop();
		}
		catch(StackOrQueueException e)
		{
			return;
		}
		assertFalse(true);
	}
	
	/**
	 * when stack is not empty should return the newly inserted element
	 */
	@Test
	public void popShouldReturnNewlyInsertedElement()
	{
		studentRecords.push(new Student("leela", "thati"));
		Student sahiti = new Student("sahiti", "thati");
		studentRecords.push(sahiti);
		Student virat = new Student("virat", "k");
		studentRecords.push(virat);
		assertEquals(virat, studentRecords.pop());
		assertEquals(sahiti, studentRecords.pop());
	}
	
	/**
	 * pop Should ThrowException Only After Stack Has Become Empty
	 */
	@Test
	public void popShouldThrowExceptionOnlyAfterStackHasBecomeEmpty()
	{
		Student sahiti = new Student("sahiti", "thati");
		studentRecords.push(sahiti);
		Student virat = new Student("virat", "k");
		studentRecords.push(virat);
		assertEquals(virat, studentRecords.pop());
		assertEquals(sahiti, studentRecords.pop());
		try
		{
			studentRecords.pop();
		}
		catch(StackOrQueueException e)
		{
			return;
		}
		assertFalse(true);
	}
	
	/**
	 * Insert elements into a stack after pop
	 */
	@Test
	public void shouldBeAbleToInsertElementsIntoTheStack()
	{
		studentRecords.push(new Student("leela", "thati"));
		Student sahiti = new Student("sahiti", "thati");
		studentRecords.push(sahiti);
		Student virat = new Student("virat", "k");
		studentRecords.push(virat);
		assertEquals(virat, studentRecords.pop());
		assertEquals(sahiti, studentRecords.pop());
		studentRecords.push(virat);
		assertEquals(virat, studentRecords.pop());
	}
	
	/**
	 * If the stack is empty top should return exception
	 */
	@Test
	public void topShouldThrowExceptionWhenStackIsEmpty()
	{
		try
		{
		studentRecords.top();
		}
		catch(StackOrQueueException e)
		{
			return;
		}
		assertFalse(true);
	}
	
	/**
	 * if the stack is not empty should return the top element but shouldn't remove it
	 */
	@Test
	public void topShouldReturnTheTopElementInTheStack()
	{
	studentRecords.push(new Student("leela", "thati"));
	Student sahiti = new Student("sahiti", "thati");
	studentRecords.push(sahiti);
	Student virat = new Student("virat", "k");
	studentRecords.push(virat);
	assertEquals(virat, studentRecords.top());
	assertEquals(virat, studentRecords.top());
	}
	
	/**
	 * If the stack is empty isEmpty Should Return true
	 */
	@Test
	public void shouldReturnTrueIfStackIsEmpty()
	{
		assertTrue(studentRecords.isEmpty());
	}
	
	/**
	 * If the stack is not empty isEmpty Should Return false
	 */
	@Test
	public void shouldReturnFalseIfStackIsNotEmpty()
	{
		studentRecords.push(new Student("leela", "thati"));
		assertFalse(studentRecords.isEmpty());
	}
	
	/**
	 * Should be able to iterate through the stack
	 */
	@Test
	public void shouldBeAbleToIterateThroughTheStack() {
		Student leela = new Student("leela", "thati");
		studentRecords.push(leela);
		Student sahiti = new Student("sahiti", "thati");
		studentRecords.push(sahiti);
		Student virat = new Student("virat", "k");
		studentRecords.push(virat);
		Iterator<Student> studentItr = studentRecords.iterator();
		if(studentItr.hasNext()) {
			 Student element =  studentItr.next();
			 assertEquals(virat, element);
		}
		if(studentItr.hasNext()) {
			 Student element =  studentItr.next();
			 assertEquals(sahiti, element);
		}
		if(studentItr.hasNext()) {
			 Student element =  studentItr.next();
			 assertEquals(leela, element);
		}
		if(studentItr.hasNext())
		{
		assertFalse(true);
		}
	}
	
	/**
	 * Should be able to iterate through the stack after pop
	 */
	@Test
	public void shouldBeAbleToIterateThroughTheStackAfterPop() {
		Student leela = new Student("leela", "thati");
		studentRecords.push(leela);
		Student sahiti = new Student("sahiti", "thati");
		studentRecords.push(sahiti);
		Student virat = new Student("virat", "k");
		studentRecords.push(virat);
		Iterator<Student> studentItrInitial = studentRecords.iterator();
		studentRecords.pop();
		if(studentItrInitial.hasNext()) {
			 Student element =  studentItrInitial.next();
			 assertEquals(virat, element);
		}
		if(studentItrInitial.hasNext()) {
			 Student element =  studentItrInitial.next();
			 assertEquals(sahiti, element);
		}
		if(studentItrInitial.hasNext()) {
			 Student element =  studentItrInitial.next();
			 assertEquals(leela, element);
		}
		if(studentItrInitial.hasNext())
		{
		assertFalse(true);
		}
		Iterator<Student> studentItr = studentRecords.iterator();
		if(studentItr.hasNext()) {
			 Student element =  studentItr.next();
			 assertEquals(sahiti, element);
		}
		if(studentItr.hasNext()) {
			 Student element =  studentItr.next();
			 assertEquals(leela, element);
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
