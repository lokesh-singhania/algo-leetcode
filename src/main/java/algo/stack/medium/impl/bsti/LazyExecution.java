package algo.stack.medium.impl.bsti;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import models.TreeNode;
import algo.stack.medium.BinarySearchTreeIterator;

public class LazyExecution implements BinarySearchTreeIterator{

	private Deque<TreeNode> stack = new ArrayDeque<>();
	private Set<TreeNode> visited= new HashSet<>();
	
	public LazyExecution(TreeNode root) {
		Optional.ofNullable(root).ifPresent(stack::push);
	}
	
	@Override
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	@Override
	public int next() {
		if(!hasNext()) throw new UnsupportedOperationException();
		
		while(stack.peek().hasLeftChild() && !visited.contains(stack.peek().left)) {
			stack.push(stack.peek().left);
		}
		TreeNode popped=stack.pop();
		visited.add(popped);
		
		if(popped.hasRightChild()) {
			stack.push(popped.right);
		}
		return popped.val;
	}

}
