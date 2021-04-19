package algo.april.impl.lca;

import algo.april.LowestCommonAncestor;
import algo.pojo.TreeNode;

import static algo.pojo.TreeNode.compare;

public class Concise implements LowestCommonAncestor {
    @Override
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node=root;
        while(compare(node,p)==compare(node,q)){
            node=p.value>node.value?node.right: node.left;
        }
        return  node;
    }
}
