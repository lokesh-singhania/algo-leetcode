package algo.stack.medium.impl.preoder;

import java.util.ArrayList;
import java.util.List;

import algo.pojo.TreeNode;
import algo.stack.medium.BinaryTreePreorderTraversal;

public class Recursive implements BinaryTreePreorderTraversal{

	@Override
	public List<Integer> traverse(TreeNode root) {
		List<Integer> values=new ArrayList<>();
		preOrder(values,root);
		return values;
	}

	private void preOrder(List<Integer> values, TreeNode node) {
		values.add(node.value);
		if(node.hasLeftChild()) {
			traverse(node.left);
		}
		if(node.hasRightChild()) {
			traverse(node.right);
		}
	}

}
