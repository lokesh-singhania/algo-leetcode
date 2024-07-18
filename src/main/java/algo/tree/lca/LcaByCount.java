package algo.tree.lca;

import algo.pojo.TreeNode;
import algo.tree.LowestCommonAncestor;

public class LcaByCount implements LowestCommonAncestor {
    TreeNode lca;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        count(root,p,q);
        return lca;
    }

    int count(TreeNode node, TreeNode a, TreeNode b) {
        int count = 0;
        if (node == a || node == b) {
            count++;
        }
        if (node.left != null) {
            count += count(node.left, a, b);
        }
        if (node.right != null) {
            count += count(node.right, a, b);
        }
        if (lca == null && count == 2) {
            lca = node;
        }
        return count;
    }
}
