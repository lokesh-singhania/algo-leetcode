package algo.april.impl.lca;

import algo.april.LowestCommonAncestor;
import algo.pojo.TreeNode;

import static algo.pojo.TreeNode.compare;

public class Recursive implements LowestCommonAncestor {
    @Override
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.value > root.value && q.value > root.value) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (p.value < root.value && q.value < root.value) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }
}
