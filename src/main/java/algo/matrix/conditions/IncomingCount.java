package algo.matrix.conditions;

import java.util.*;
import java.util.stream.IntStream;

public class IncomingCount extends TopologicalSort{

    @Override
    protected List<Integer> topological(int[][] edges, int n){
        List<Node> nodes = IntStream.range(0,n)
                .mapToObj(i->new Node())
                .toList();
        for(int[] edge:edges){
            int from = edge[0]-1;
            int to = edge[1]-1;
            nodes.get(from).add(to);
            nodes.get(to).in();
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            Node node = nodes.get(i);
            if(node.free()){
                q.add(i);
            }
        }
        List<Integer> ordered = new ArrayList<>();
        while(!q.isEmpty()){
            int id = q.remove();
            ordered.add(id);
            Node node = nodes.get(id);
            for(int childId:node.adj){
                Node child=nodes.get(childId);
                child.reduceIn();
                if(child.free()){
                    q.add(childId);
                }
            }
        }
        return (ordered.size()<n) ? Collections.emptyList() : ordered;
    }

}
