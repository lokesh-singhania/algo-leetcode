package algo.april.impl.btp;

import algo.annotations.ComplexityValue;
import algo.annotations.Remarks;
import algo.annotations.SpaceComplexity;
import algo.annotations.TimeComplexity;
import algo.april.BinaryTreePaths;
import algo.pojo.TreeNode;

import java.util.HashSet;
import java.util.Set;

import static algo.annotations.ComplexityValue.LINEAR;

@Remarks("was faster than iterative one, why?")
@TimeComplexity(LINEAR)
@SpaceComplexity(value = LINEAR, remark = "due to recursion stack")
public class Recursive implements BinaryTreePaths {

    @Override
    public Set<String> binaryTreePaths(TreeNode root) {
        StringBuilder path = new StringBuilder();
        Set<String> paths = new HashSet<>();
        populatePaths(root, path, paths);
        return paths;
    }

    private void populatePaths(TreeNode node, StringBuilder path, Set<String> paths) {
        if (node == null) return;

        StringBuilder pathCopy = new StringBuilder(path);
        add(node, pathCopy);

        if (leaf(node)) {
            paths.add(pathCopy.toString());
        } else {
            populatePaths(node.left, pathCopy, paths);
            populatePaths(node.right, pathCopy, paths);
        }
    }

    private boolean leaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private void add(TreeNode node, StringBuilder path) {
        if (path.length() != 0) {
            path.append("->");
        }
        path.append(node.value);
    }
}
