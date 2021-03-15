package algo.stack.using.queues;

import org.testng.annotations.Factory;

import algo.stack.suq.LinkedListImpl;
import algo.stack.suq.ListImpl;
import algo.stack.suq.SingleQueue;

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
