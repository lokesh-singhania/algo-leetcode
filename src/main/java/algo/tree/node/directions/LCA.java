package algo.tree.node.directions;

import algo.pojo.TreeNode;

import java.util.Optional;

public class LCA implements NodeDirections {

    public String getDirections(TreeNode root, int startValue, int destValue) {
        //lca
        TreeNode lca = lca(root,startValue,destValue);
        // search left - with path    
        return path(lca,startValue,destValue);
    }

    String path(TreeNode lca,int start, int dest){
        // search the left and lca for both the values while creating path
        var path1 = new StringBuilder();
        var path2 = new StringBuilder();
        path1.append('L');
        TreeNode left = search(lca.left,start,dest,path1);
        if(left==null)
            path1.setLength(0);
        path2.append('R');
        TreeNode right = search(lca.right,start,dest,path2);
        if(right==null){
            path2.setLength(0);
        }
        var reverse = matches(left,dest) || (matches(lca,dest) && matches(right,start));
        if(reverse){
            var t = path1;
            path1 = path2;
            path2 = t;
        }
        StringBuilder sb = new StringBuilder();
        sb.repeat('U',path1.length());
        sb.append(path2);
        return sb.toString();
    }

    boolean matches(TreeNode node,int val){
        return node!=null && node.value == val;
    }

    TreeNode search(TreeNode node,int v1,int v2,StringBuilder path){
        if(node==null){
            return null;
        }
        if(node.value == v1 || node.value==v2){
            return node;
        }
        path.append('L');
        var result = search(node.left,v1,v2,path);
        if(result!=null){
            return result;
        }
        path.setCharAt(path.length()-1,'R');
        result = search(node.right,v1,v2,path);
        if(result!=null){
            return result;
        }
        path.setLength(path.length()-1);
        return null;
    }


    TreeNode lca(TreeNode node,int v1,int v2){
        if(node==null){
            return null;
        }
        if(node.value==v1 || node.value==v2){
            return node;
        }
        var left = lca(node.left,v1,v2);
        var right = lca(node.right,v1,v2);
        if(left!=null && right!=null){
            return node;
        }
        return Optional.ofNullable(left)
                .orElse(right);
    }


}
