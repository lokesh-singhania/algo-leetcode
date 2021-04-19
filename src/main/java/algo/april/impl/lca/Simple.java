package algo.april.impl.lca;

import algo.annotations.Date;
import algo.april.LowestCommonAncestor;
import algo.pojo.TreeNode;

import static algo.pojo.TreeNode.compare;


public class Simple implements LowestCommonAncestor {
    @Override
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node=root;
        while(compare(node,p)== compare(node,q)){
            switch(compare(node,p)){
                case -1:
                    node=node.right;
                    break;
                case 1:
                    node=node.left;
                    break;
                case 0:
                    return node;
            }
        }
        return node;
    }
}
