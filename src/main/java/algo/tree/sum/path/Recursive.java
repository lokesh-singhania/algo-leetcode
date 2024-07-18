package algo.tree.sum.path;

import models.TreeNode;
import algo.tree.SumRootToLeaf;

public class Recursive implements SumRootToLeaf {

	@Override
	public int sumRootToLeaf(TreeNode root) {
		return sum(root, 0);
	}

	private int sum(TreeNode node, int num) {
		if (node == null) {
			return 0;
		}
		num = num << 1 + node.val;
		if (node.isLeaf()) {
			return num;
		}
		return sum(node.left, num) + sum(node.right, num);
	}

}
