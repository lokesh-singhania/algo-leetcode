package algo.stack.suq;

import java.util.LinkedList;
import java.util.Queue;

public class SingleQueue<T> implements StackUsingQueues<T>{

	private Queue<T> queue;
	
	public SingleQueue() {
		queue=new LinkedList<>();
	}
	
	@Override
	public void push(T element) {
		int prevElements = queue.size();
		queue.add(element);
		for(int i=1;i<=prevElements;i++) {
			queue.add(queue.remove());
		}
	}

	@Override
	public T pop() {
		return queue.remove();
	}

	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	@Override
	public T peek() {
		return queue.element();
	}

}
