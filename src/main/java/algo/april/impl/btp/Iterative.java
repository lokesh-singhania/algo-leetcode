package algo.april.impl.btp;

import algo.annotations.Date;
import algo.annotations.SpaceComplexity;
import algo.annotations.TimeComplexity;
import algo.april.BinaryTreePaths;
import models.TreeNode;
import algo.util.Factory;

import java.util.*;

import static algo.annotations.ComplexityValue.LINEAR;

@Date("April 20")
@TimeComplexity(LINEAR)
@SpaceComplexity(LINEAR)
public class Iterative implements BinaryTreePaths {

    private static class Node {
        public final String path;
        public final TreeNode treeNode;

        Node(TreeNode treeNode, String path) {
            this.path = path;
            this.treeNode = treeNode;
        }
    }

    @Override
    public Set<String> binaryTreePaths(TreeNode root) {
        Deque<Node> nodes = new ArrayDeque<>();
        pushIfPresent(nodes, "", root);
        Set<String> paths = new HashSet<>();
        while (!nodes.isEmpty()) {
            Node node = nodes.pop();
            TreeNode treeNode = node.treeNode;
            String path = node.path;
            if (treeNode.isLeaf()) {
                paths.add(path);
            } else {
                pushIfPresent(nodes, path, treeNode.left);
                pushIfPresent(nodes, path, treeNode.right);
            }
        }
        return paths;
    }

    private void pushIfPresent(Deque<Node> nodes, String path, TreeNode treeNode) {
        if (treeNode != null) {
            nodes.push(new Node(treeNode, path(path, treeNode)));
        }
    }

    private String path(String prevPath, TreeNode node) {
        return prevPath.isEmpty() ? String.valueOf(node.val) : prevPath + Factory.ARROW + node.val;
    }
}
