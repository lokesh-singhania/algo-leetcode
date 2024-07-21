package algo.matrix.conditions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReversePostOrder extends TopologicalSort {

    protected List<Integer> topological(int[][] edges, int n) {
        List<Integer> order = new ArrayList<>();
        List<Integer>[] adj = (List<Integer>[]) new List[n];
        Arrays.setAll(adj, i -> new ArrayList<>());
        for (int[] edge : edges) {
            int from = edge[0] - 1;
            int to = edge[1] - 1;
            adj[from].add(to);
        }
        boolean[] visited = new boolean[n];
        boolean[] local=new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            postOrder(order, visited, local, adj, i);
        }
        return order.size() == n ? order.reversed() : Collections.emptyList();
    }

    void postOrder(List<Integer> order, boolean[] visited,boolean[] local, List<Integer>[] adj, int i) {
        local[i] = true;
        visited[i] = true;
        for (int neigh : adj[i]) {
            if (local[neigh]) {
                return;
            }
            if(visited[neigh]){
                continue;
            }
            postOrder(order, visited, local, adj, neigh);
        }
        order.add(i);
        local[i]=false;
    }


}
