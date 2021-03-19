package algo.stack.easy;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.function.Supplier;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import algo.stack.easy.impl.suq.LinkedListImpl;
import algo.stack.easy.impl.suq.ListImpl;
import algo.stack.easy.impl.suq.SingleQueue;

public class StackUsingQueuesTest {
	Supplier<StackUsingQueues<Integer>> newStackSupplier;

	@Factory
	public Object[] tests() {
		return new Object[] {
			new StackUsingQueuesTest(LinkedListImpl<Integer>::new),
			new StackUsingQueuesTest(ListImpl<Integer>::new),
			new StackUsingQueuesTest(SingleQueue<Integer>::new)
		};
	}
	
	public StackUsingQueuesTest(Supplier<StackUsingQueues<Integer>> newStackSupplier) {
		this.newStackSupplier=newStackSupplier;
	}
	
	
	@Test
	public void test() {
		StackUsingQueues<Integer> stack = newStackSupplier.get();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		assertFalse(stack.isEmpty());
		assertEquals((int)stack.pop(), 3);
		assertEquals((int)stack.pop(), 2);
		assertEquals((int)stack.peek(), 1);
		assertEquals((int)stack.pop(), 1);
		assertTrue(stack.isEmpty());
	}
}
