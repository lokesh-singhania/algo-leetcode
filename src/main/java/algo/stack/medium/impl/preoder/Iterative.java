package algo.stack.medium.impl.preoder;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import models.TreeNode;
import algo.stack.medium.BinaryTreePreorderTraversal;

public class Iterative implements BinaryTreePreorderTraversal{

	@Override
	public List<Integer> traverse(TreeNode root) {
		Deque<TreeNode> deque=new ArrayDeque<>();
		deque.push(root);
		List<Integer> values = new ArrayList<>();
		while(!deque.isEmpty()) {
			TreeNode node = deque.pop();
			values.add(node.val);
			if(node.hasRightChild()) deque.push(node.right);
			if(node.hasLeftChild()) deque.push(node.left);
		}
		return values;
	}
}
