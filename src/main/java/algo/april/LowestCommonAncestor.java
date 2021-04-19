package algo.april;

import algo.annotations.Date;
import algo.pojo.TreeNode;
import com.sun.source.tree.Tree;

@Date("April 19 2021")
public interface LowestCommonAncestor {

    TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q);
}
