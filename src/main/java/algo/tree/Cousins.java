package algo.tree;

import algo.pojo.TreeNode;
import algo.tree.cousins.CousinsImpl;

public interface Cousins {

	boolean areCousins(TreeNode root, int x, int y);
	
}
