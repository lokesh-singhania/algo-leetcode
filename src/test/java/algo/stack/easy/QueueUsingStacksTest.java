package algo.stack.easy;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import algo.stack.easy.impl.qus.Lazy;
import algo.stack.easy.impl.qus.TwoStacks;

public class QueueUsingStacksTest {
	Class<? extends QueueUsingStacks> clazz; 
	
	public QueueUsingStacksTest(Class<? extends QueueUsingStacks> clazz) {
		this.clazz = clazz;
	}

	@Factory
	public static Object[] fact() {
		return new Object[] {
			new QueueUsingStacksTest(TwoStacks.class),
			new QueueUsingStacksTest(Lazy.class)
		};
	}

	
	@Test
	public void queueReturnsElementInFifoOrder() {
		QueueUsingStacks queue = newInstance();
		queue.push(1);
		queue.push(2);
		assertEquals(queue.pop(), 1);
		assertEquals(queue.pop(), 2);
	}
	
	@Test
	public void adddingAValueDoesNotChangePeekValue() {
		QueueUsingStacks queue = newInstance();
		queue.push(1);
		assertEquals(queue.peek(), 1);
		queue.push(2);
		assertEquals(queue.peek(), 1);
	}
	
	@Test
	public void removingAnElementChangesPeekValue() {
		QueueUsingStacks queue = newInstance();
		queue.push(1);
		assertEquals(queue.peek(), 1);
		queue.push(2);
		queue.pop();
		assertEquals(queue.peek(), 2);
	}

	private QueueUsingStacks newInstance(){
		QueueUsingStacks queue=null;
		try {
			queue = clazz.getDeclaredConstructor().newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return queue;
	}
}
