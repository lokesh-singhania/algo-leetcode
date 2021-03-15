package algo.stack.suq;

import java.util.LinkedList;

public class LinkedListImpl<T> implements StackUsingQueues<T> {

	private LinkedList<T> empty;
	private LinkedList<T> filled;

	public LinkedListImpl() {
		empty = new LinkedList<>();
		filled = new LinkedList<>();
	}

	@Override
	public void push(T element) {
		empty.addLast(element);
		while(!filled.isEmpty()) {
			empty.addLast(filled.removeFirst());
		}
		LinkedList<T> temp = empty;
		empty=filled;
		filled=temp;
	}

	@Override
	public T pop() {
		return filled.removeFirst();
	}

	@Override
	public boolean isEmpty() {
		return filled.isEmpty();
	}

	@Override
	public T peek() {
		return filled.getFirst();
	}

}
