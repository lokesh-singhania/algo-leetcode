package algo.tree.node.directions;

import algo.pojo.TreeNode;

import java.util.*;

public class ParentLinks implements NodeDirections{
    public String getDirections(TreeNode root, int startValue, int destValue) {
        List<TreeNode> parents = new ArrayList<>();
        add(parents,root.value,null);
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
            if(node.value==destValue){
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
            val = pathNodes.get(val).value;
        }
        return sb.reverse().toString();
    }

    TreeNode getParent(List<TreeNode> parents,TreeNode node){
        if(node==null){
            return null;
        }
        return parents.get(node.value);
    }

    void addNeighbor(Queue<TreeNode> q,List<Character> path,List<TreeNode> pathNodes,TreeNode node,char label,TreeNode original){
        if(node!=null && (path.size() <= node.value || path.get(node.value)==null)){
            q.add(node);
            add(path,node.value,label);
            add(pathNodes,node.value,original);
        }
    }

    TreeNode getNode(int v,List<TreeNode> parents,TreeNode root){
        var parent = parents.get(v);
        if(parent==null && root.value == v){
            return root;
        }
        return Optional.ofNullable(parent.left)
                .filter(t->t.value==v)
                .orElse(parent.right);
    }

    void dfs(TreeNode node,List<TreeNode> parents){
        if(node.left!=null){
            add(parents,node.left.value,node);
            dfs(node.left,parents);
        }
        if(node.right!=null){
            add(parents,node.right.value,node);
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
