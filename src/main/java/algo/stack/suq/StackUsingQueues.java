package algo.stack.suq;

public interface StackUsingQueues<T> {

	void push(T element);
	
	T pop();
	
	boolean isEmpty();
	
	T peek();
	
}
