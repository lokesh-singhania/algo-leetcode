package algo.tree;

import models.TreeNode;

import java.util.List;

public interface DeleteNodes {
    List<TreeNode> delNodes(TreeNode root, int[] to_delete);
}
