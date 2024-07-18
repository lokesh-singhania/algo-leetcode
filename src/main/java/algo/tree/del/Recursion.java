package algo.tree.del;

import models.TreeNode;
import algo.tree.DeleteNodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Recursion implements DeleteNodes {
    @Override
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        return new Deletion(to_delete).delete(root);
    }

    private final class Deletion {
        private final Set<Integer> deletes;
        private final List<TreeNode> roots;

        Deletion(int[] toDelete) {
            deletes = Arrays.stream(toDelete)
                    .boxed()
                    .collect(Collectors.toSet());
            roots = new ArrayList<>();
        }

        List<TreeNode> delete(TreeNode root) {
            delete(root, true);
            return roots;
        }

        private TreeNode delete(TreeNode node, boolean isRoot) {
            if (node == null) return node;

            var deleted = deletes.contains(node.val);
            if (isRoot && !deleted) {
                roots.add(node);
            }
            node.left = delete(node.left, deleted);
            node.right = delete(node.right, deleted);
            return deleted ? null : node;
        }

    }
}
