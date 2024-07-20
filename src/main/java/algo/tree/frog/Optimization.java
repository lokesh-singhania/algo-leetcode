package algo.tree.frog;

import java.util.*;

public class Optimization {


    public class Frog {
        public double frogPosition(int n, int[][] edges, int t, int target) {
            List<List<Integer>> adj = adj(edges, n);
            boolean[] visited = new boolean[n + 1];

            Queue<algo.tree.frog.Frog.Node> q = new ArrayDeque<>();// BFS
            q.add(new algo.tree.frog.Frog.Node(1, 1.0));
            visited[1] = true;
            Map<Integer,Double> stuck = new HashMap<>();
            for (int i = 1; i <= t && !q.isEmpty(); i++) {
                int size = q.size();
                for (int j = 1; j <= size; j++) {
                    algo.tree.frog.Frog.Node node = q.remove();
                    int k = node.key();
                    int childCount = adj.get(k).size() - (k == 1 ? 0 : 1);
                    if (childCount == 0) {
                        stuck.put(k,node.probability());
                        continue;
                    }
                    for (int child : adj.get(k)) {
                        if (visited[child]) {
                            continue;
                        }
                        visited[child] = true;
                        q.add(new algo.tree.frog.Frog.Node(child, node.probability() / childCount));
                    }
                }
            }

            return getProbability(q, stuck, target);
        }

        private double getProbability(Queue<algo.tree.frog.Frog.Node> q,Map<Integer,Double> stuck, int target) {
            if(stuck.containsKey(target)){
                return stuck.get(target);
            }
            return q.stream()
                    .filter(node -> node.key() == target)
                    .map(algo.tree.frog.Frog.Node::probability)
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

}
