package algo.stack.easy.impl.qus;

import java.util.LinkedList;

import algo.stack.easy.QueueUsingStacks;

public class TwoStacks implements QueueUsingStacks {

	private static final int INITIAL_TOP_VALUE = -1;
	protected LinkedList<Integer> pushStack;
	protected LinkedList<Integer> popStack;
	protected int top;

	public TwoStacks() {
		pushStack = new LinkedList<>();
		popStack = new LinkedList<>();
		top = INITIAL_TOP_VALUE;
	}

	@Override
	public void push(int e) {
		if (pushStack.isEmpty()) {
			top = e;
		}
		pushStack.push(e);
	}

	@Override
	public int pop() {
		emptyInto(pushStack, popStack);
		int poppedValue = popStack.pop();
		updateTop(popStack);
		emptyInto(popStack, pushStack);
		return poppedValue;
	}

	protected void updateTop(LinkedList<Integer> popStack) {
		top = !popStack.isEmpty() ? popStack.peek() : INITIAL_TOP_VALUE;
	}

	protected void emptyInto(LinkedList<Integer> source, LinkedList<Integer> destination) {
		while (!source.isEmpty()) {
			destination.push(source.pop());
		}
	}

	@Override
	public int peek() {
		return top;
	}

	@Override
	public boolean isEmpty() {
		return pushStack.isEmpty();
	}

}
