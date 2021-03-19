package algo.stack.using.queues;

import org.testng.annotations.Factory;

import algo.stack.easy.impl.suq.LinkedListImpl;
import algo.stack.easy.impl.suq.ListImpl;
import algo.stack.easy.impl.suq.SingleQueue;

public class StackTestFactory {

	@Factory
	public Object[] tests() {
		return new Object[] {
			new StackUsingQueuesTest(LinkedListImpl<Integer>::new),
			new StackUsingQueuesTest(ListImpl<Integer>::new),
			new StackUsingQueuesTest(SingleQueue<Integer>::new)
		};
	
	}
}
