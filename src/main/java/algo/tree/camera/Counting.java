package algo.tree.camera;

import models.TreeNode;
import algo.tree.Camera;

public class Counting implements Camera {
    private int cameras;

    public int minCameraCover(TreeNode root) {
        if(cameras(root)==2) cameras++;
        return cameras;
    }

    int cameras(TreeNode node) {
        if(node==null){
            return 1;
        }

        int right = cameras(node.right);
        int left = cameras(node.left);
        if (left == 2 || right==2 ) {
            cameras++;
            return 0;
        }
        return Math.min(left,right)+1;
    }

    boolean isLeaf(TreeNode node){
        return node!=null && node.left==null && node.right==null;
    }

    boolean twoFromLeaf(TreeNode node){
        return isLeaf(node.left) || isLeaf(node.right);
    }

}
