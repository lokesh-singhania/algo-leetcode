package algo.tree.lib;

import algo.pojo.TreeNode;

public class TreeFunctions {

	public int depth(TreeNode root) {
		return depth(root, 0);
	}

	private int depth(TreeNode node, int maxDepth) {
		if(node == null)
			return 0;
		return 1 + Math.max(depth(node.left), depth(node.right));
	}
}
