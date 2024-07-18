package algo.tree.node.directions;

import models.TreeNode;

import java.util.*;

public class ParentLinks implements NodeDirections{
    public String getDirections(TreeNode root, int startValue, int destValue) {
        List<TreeNode> parents = new ArrayList<>();
        add(parents,root.val,null);
        dfs(root,parents);

        TreeNode startNode = getNode(startValue,parents,root);
        // path track
        List<Character> path = new ArrayList<>();
        List<TreeNode> pathNodes = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(startNode);
        add(path,startValue,null);
        while(!q.isEmpty()){
            TreeNode node = q.remove();
            if(node.val ==destValue){
                System.out.println("Got it");
                break;
            }
            addNeighbor(q,path,pathNodes,node.left,'L',node);
            addNeighbor(q,path,pathNodes,node.right,'R',node);
            addNeighbor(q,path,pathNodes,getParent(parents,node),'U',node);
        }

        // create the path
        StringBuilder sb = new StringBuilder();
        for(int val=destValue;val!=startValue;){
            char step = path.get(val);
            sb.append(step);
            val = pathNodes.get(val).val;
        }
        return sb.reverse().toString();
    }

    TreeNode getParent(List<TreeNode> parents,TreeNode node){
        if(node==null){
            return null;
        }
        return parents.get(node.val);
    }

    void addNeighbor(Queue<TreeNode> q,List<Character> path,List<TreeNode> pathNodes,TreeNode node,char label,TreeNode original){
        if(node!=null && (path.size() <= node.val || path.get(node.val)==null)){
            q.add(node);
            add(path,node.val,label);
            add(pathNodes,node.val,original);
        }
    }

    TreeNode getNode(int v,List<TreeNode> parents,TreeNode root){
        var parent = parents.get(v);
        if(parent==null && root.val == v){
            return root;
        }
        return Optional.ofNullable(parent.left)
                .filter(t->t.val ==v)
                .orElse(parent.right);
    }

    void dfs(TreeNode node,List<TreeNode> parents){
        if(node.left!=null){
            add(parents,node.left.val,node);
            dfs(node.left,parents);
        }
        if(node.right!=null){
            add(parents,node.right.val,node);
            dfs(node.right,parents);
        }
    }

    <T> void add(List<T> list, int index, T val){
        while(list.size()<index+1){
            list.add(null);
        }
        list.set(index,val);
    }
}
