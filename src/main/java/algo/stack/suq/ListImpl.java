package algo.stack.suq;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListImpl<T> implements StackUsingQueues<T>{

	private List<T> filled;
	private List<T> empty;
	
	public ListImpl() {
		filled = new ArrayList<>();
		empty=new ArrayList<>();
	}
	
	@Override
	public void push(T element) {
		empty.add(element);
		Iterator<T> iterator = filled.iterator();
		while(iterator.hasNext()) {
			empty.add(iterator.next());
			iterator.remove();
		}
		swapQueues();
	}

	private void swapQueues() {
		List<T> temp = empty;
		empty = filled;
		filled = temp;
	}

	@Override
	public T pop() {
		return filled.remove(0);
	}

	@Override
	public boolean isEmpty() {
		return filled.isEmpty();
	}

	@Override
	public T peek() {
		return filled.get(0);
	}

}
