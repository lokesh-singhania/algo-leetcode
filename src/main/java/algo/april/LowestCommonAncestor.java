package algo.april;

import algo.annotations.Date;
import models.TreeNode;

@Date("April 19 2021")
public interface LowestCommonAncestor {

    TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q);
}
