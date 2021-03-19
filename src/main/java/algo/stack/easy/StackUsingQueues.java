package algo.stack.easy;

public interface StackUsingQueues<T> {

	void push(T element);
	
	T pop();
	
	boolean isEmpty();
	
	T peek();
	
}
