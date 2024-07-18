package algo.april.impl.lca;

import algo.april.LowestCommonAncestor;
import models.TreeNode;

import static models.TreeNode.compare;

public class Concise implements LowestCommonAncestor {
    @Override
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node=root;
        while(compare(node,p)==compare(node,q)){
            node=p.val >node.val ?node.right: node.left;
        }
        return  node;
    }
}
