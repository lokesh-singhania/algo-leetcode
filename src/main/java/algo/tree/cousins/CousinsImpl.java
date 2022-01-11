package algo.tree.cousins;

import java.util.ArrayDeque;
import java.util.Queue;

import algo.pojo.TreeNode;
import algo.tree.Cousins;

public class CousinsImpl implements Cousins {

	// Idea
	// BFS
	// Check if found in same level and not from same parent
	//

	@Override
	public boolean areCousins(TreeNode root, int x, int y) {

		return new CousinsBfs(root, x, y).find();
	}

	class CousinsBfs {
		private Queue<TreeNode> nodes;
		int x;
		int y;

		CousinsBfs(TreeNode root, int x, int y) {
			nodes = new ArrayDeque<>();
			this.x = x;
			this.y = y;

			// case for root
			considerNode(root);
		}

		boolean find() {
			int found = 0;
			while (!nodes.isEmpty() || found == 0) {
				int levelSize = nodes.size();
				for (int i = 0; i < levelSize; i++) {
					TreeNode node = nodes.remove();
					int local = considerNode(node.left) + considerNode(node.right);
					if (local == 2) {
						return false;
					}
					found += local;
				}
			}
			return found == 2;
		}

		int considerNode(TreeNode node) {
			if (node == null)
				return 0;

			nodes.add(node);
			int val = node.value;
			if (val == x || val == y) {
				return 1;
			}
			return 0;
		}
	}
}
