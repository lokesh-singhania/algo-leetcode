package algo.tree.node.directions;

import algo.pojo.TreeNode;

public class SeparatePaths22 implements NodeDirections{
    public String getDirections(TreeNode root, int startValue, int destValue) {
        String startString = find(startValue, root, new StringBuilder());
        String endString = find(destValue, root, new StringBuilder());
        int i = 0;
        for (; i < Math.min(startString.length(), endString.length()); i++) {
            if (startString.charAt(i) != endString.charAt(i)) {
                break;
            }
        }
        var result = new StringBuilder();
        // reverse from
        for (int j = i; j < startString.length(); j++) {
            result.append('U');
        }
        result.append(endString.substring(i));
        return result.toString();
    }

    String find(int value, TreeNode node, StringBuilder path) {
        if (node == null) {
            return null;
        }
        if (node.value == value) {
            return path.toString();
        }
        path.append('L');
        String fromLeft = find(value, node.left, path);
        path.deleteCharAt(path.length() - 1);
        if (fromLeft != null) {
            return fromLeft;
        }

        path.append('R');
        String fromRight = find(value, node.right, path);
        path.deleteCharAt(path.length() - 1);
        return fromRight;
    }
}
