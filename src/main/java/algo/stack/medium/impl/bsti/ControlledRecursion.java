package algo.stack.medium.impl.bsti;

import java.util.ArrayDeque;
import java.util.Deque;

import algo.pojo.TreeNode;
import algo.stack.medium.BinarySearchTreeIterator;

public class ControlledRecursion implements BinarySearchTreeIterator {

	private Deque<TreeNode> stack;

	public ControlledRecursion(TreeNode root) {
		stack = new ArrayDeque<>();
		leftMostNode(root);
	}

	private void leftMostNode(TreeNode node) {
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
	}

	@Override
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	@Override
	public int next() {
		TreeNode node = stack.pop();
		leftMostNode(node.right);
		return node.value;
	}

}
