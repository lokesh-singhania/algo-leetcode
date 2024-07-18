package algo.tree.node.directions;


import algo.pojo.TreeNode;

public class SeparatePaths implements NodeDirections {
    @Override
    public String getDirections(TreeNode root, int startValue, int destValue) {
        var p1 = new StringBuilder();
        var p2 = new StringBuilder();
        getPath(root,startValue,p1);
        getPath(root,destValue,p2);

        int commonSteps=Math.min(p1.length(),p2.length());
        for(int i=0;i<Math.min(p1.length(),p2.length());i++){
            if(p1.charAt(i)!=p2.charAt(i)){
                commonSteps=i;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.repeat('U',p1.length()-commonSteps);
        sb.append(p2.substring(commonSteps));
        return sb.toString();
    }

    boolean getPath(TreeNode node, int val, StringBuilder sb){
        if(node==null){
            return false;
        }
        if(node.value==val){
            return true;
        }
        sb.append('L');
        if(getPath(node.left,val,sb)){
            return true;
        }
        sb.setLength(sb.length()-1);

        sb.append('R');
        if(getPath(node.right,val,sb)){
            return true;
        }
        sb.setLength(sb.length()-1);
        return false;
    }
}
