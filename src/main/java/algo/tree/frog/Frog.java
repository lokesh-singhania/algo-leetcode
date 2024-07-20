package algo.tree.frog;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Frog {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        // Bfs - put in the probability and divide by number of unvisited children
        // Optimization - separately handle end of roads

        //adj list
        List<List<Integer>> adj = adj(edges, n);
        // visited array
        boolean[] visited = new boolean[n + 1];

        Queue<Node> q = new ArrayDeque<>();// BFS
        q.add(new Node(1, 1.0));
        visited[1] = true;
        for (int i = 1; i <= t; i++) {
            int size = q.size();
            for (int j = 1; j <= size; j++) {
                Node node = q.remove();
                int k = node.key;
                int childCount = adj.get(k).size() - (k == 1 ? 0 : 1);
                if (childCount == 0) {
                    q.add(node);
                    continue;
                }
                for (int child : adj.get(k)) {
                    if (visited[child]) {
                        continue;
                    }
                    visited[child] = true;
                    q.add(new Node(child, node.probability / childCount));
                }
            }
        }

        return getProbability(q, target);
    }

    private double getProbability(Queue<Node> q, int target) {
        return q.stream()
                .filter(node -> node.key == target)
                .map(node -> node.probability)
                .findAny()
                .orElse(0.0);
    }

    List<List<Integer>> adj(int[][] edges, int n) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int[] e : edges) {
            int a = e[0], b = e[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        return adj;
    }

    record Node(int key, double probability) {
    }
}
