package algo.graph.clone;

import algo.graph.Clone;
import algo.graph.Node;

public class Dfs implements Clone {

	@Override
	public Node cloneGraph(Node node) {
		Node[] nodes = new Node[101];

		return clone(node, nodes);
	}

	Node clone(Node node, Node[] nodes) {
		if (node == null) {
			return null;
		}
		if (nodes[node.val] != null) {
			return nodes[node.val];
		}
		Node clone = new Node(node.val);
		nodes[clone.val] = clone;
		for (Node neighbor : node.neighbors) {
			clone.neighbors.add(clone(neighbor, nodes));
		}
		return clone;
	}

}
