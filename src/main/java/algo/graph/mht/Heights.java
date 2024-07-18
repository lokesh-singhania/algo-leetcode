package algo.graph.mht;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Heights {

	int[] depths;
	int[] maxNeighbor;
	boolean[] closeSecond;
	List<Integer>[] adjList;

	void init(int n, int[][] edges) {
		depths = new int[n];
		maxNeighbor = new int[n];
		adjList = (List<Integer>[]) new List[n];
		Arrays.setAll(adjList, ArrayList::new);
		for (int[] edge : edges) {
			int a = edge[0];
			int b = edge[1];
			adjList[a].add(b);
			adjList[b].add(a);
		}

		// away from source

	}

	void setAwayDepths(int node) {
		for (int neighbor : adjList[node]) {
			setAwayDepths(neighbor);
			int depthFromNeighbor = depths[neighbor] + 1;
			int cmp = Integer.compare(depthFromNeighbor, depths[node]);
			if (cmp > 0) {
				closeSecond[node] = depths[node] == depthFromNeighbor - 1;
				depths[node] = depthFromNeighbor;
				maxNeighbor[node] = neighbor;
			} else if (cmp == 0) {
				maxNeighbor[node] = -1;
			} else if (depthFromNeighbor == depths[node] - 1) {
				closeSecond[node] = true;
			}
		}
	}

	void updateFromDepths(int node) {
		for (int neighbor : adjList[node]) {
			int depthFromSource;
			if (neighbor != maxNeighbor[node]) {
				depthFromSource = depths[node] + 1;
			} else if (closeSecond[node]) {
				depthFromSource = depths[node];
			}
			updateFromDepths(neighbor);
		}
	}

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		init(n, edges);

		setAwayDepths(0);
		updateFromDepths(0);

		// find min height
		return null;
	}
}
