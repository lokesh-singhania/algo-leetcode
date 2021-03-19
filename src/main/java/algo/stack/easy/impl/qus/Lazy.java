package algo.stack.easy.impl.qus;

public class Lazy extends TwoStacks{
	
	@Override
	public void push(int e) {
		if(!popStack.isEmpty()) {
			emptyInto(popStack, pushStack);
		}
		super.push(e);
	}

	@Override
	public int pop() {
		if(!pushStack.isEmpty()) {
			emptyInto(pushStack, popStack);
		}
		int popped = popStack.pop();
		updateTop(popStack);
		return popped;
	}

	@Override
	public int peek() {
		return top;
	}

	@Override
	public boolean isEmpty() {
		return pushStack.isEmpty() && popStack.isEmpty();
	}

}
