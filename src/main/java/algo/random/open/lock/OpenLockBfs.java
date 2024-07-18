package algo.random.open.lock;

import java.util.*;
import java.util.stream.Collectors;

public class OpenLockBfs implements OpenLock {


    public int openLock(String[] deadends, String target) {
        // Clean the API
        var bfs = new BFS(deadends);
        bfs.search(Integer.parseInt(target));
        return bfs.found() ? bfs.steps() : -1;
    }

    <T> Set<T> toSet(T[] t) {
        return Arrays.stream(t).collect(Collectors.toSet());
    }

    class BFS {
        boolean[] visited;
        Queue<Integer> q;
        int steps;
        boolean found;

        BFS(String[] preVisited) {
            this();
            for(String t:preVisited){
                visited[Integer.parseInt(t)]=true;
            }
        }

        BFS() {
            visited = new boolean[10000];
            q = new ArrayDeque<>();
        }


        int steps() {
            return steps;
        }

        boolean found() {
            return found;
        }

        void search(int target) {
            add(0);

            main:
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    int candidate = q.remove();
                    if (candidate==target) {
                        found = true;
                        break main;
                    }
                    for (int neighbor : generateNeighbors(candidate)) {
                        add(neighbor);
                    }
                }
                steps++;
            }
        }

        void add(int n) {
            if (!visited[n]) {
                visited[n]=true;
                q.add(n);
            }
        }
    }


    char increment(char a) {
        return a == '9' ? '0' : ++a;
    }

    char decrement(char a) {
        return a == '0' ? '9' : --a;
    }

    // Using ints
    // Generator/Iterator
    List<Integer> generateNeighbors(int num) {

        List<Integer> neighbors = new ArrayList<>();
        for(int i=0,place = 1;i<4;i++,place*=10){
            // digit
            int digit = (num/place)%10;
            //up
            int change = digit==9 ? -9 : 1;
            neighbors.add(num + change*place);
            // going down
            change = digit==0 ? 9 : -1;
            neighbors.add(num+change*place);
        }
        return neighbors;
    }

}
