package algo.graph.mht;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Centroids {

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		if (n == 1) {
			return List.of(0);
		}

		Set<Integer>[] adj = (Set<Integer>[]) new Set[n];
		Arrays.setAll(adj, i->new HashSet<>());
		for (int[] edge : edges) {
			int a = edge[0];
			int b = edge[1];
			adj[a].add(b);
			adj[b].add(a);
		}

		// find leafs - go towards centre
		Queue<Integer> leaves = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			if (adj[i].size() == 1) {
				leaves.add(i);
			}
		}

		int remaining = n;
		while (remaining > 2) {
			int size = leaves.size();
			remaining -= size;

			for (int i = 0; i < size; i++) {
				int leaf = leaves.remove();
				// go through its adj list - remove this node from them
				int neighbor = adj[leaf].iterator().next();
				adj[neighbor].remove(Integer.valueOf(leaf));
				if (adj[neighbor].size() == 1) {
					leaves.add(neighbor);
				}
			}
		}
		return new ArrayList<>(leaves);
	}
}
