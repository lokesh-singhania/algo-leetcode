package algo.array.ksmall;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Incremental implements KthSmallestDiff {
    @Override
    public int smallestDistancePair(int[] nums, int k) {
        PriorityQueue<Edge> diffs = new PriorityQueue<>(Comparator.comparing(Edge::distance));
        int n = nums.length;
        // insert one diff
        Arrays.sort(nums);
        for (int i = 0; i < n-1;i++){
            var diff = nums[i+1]-nums[i];
            diffs.add(new Edge(i,i+1,diff));
        }

        for(int i=1;i<k;i++){
            var edge = diffs.remove();
            int otherIndex = edge.otherIndex + 1;
            if(otherIndex <n){
                var newEdge = new Edge(edge.index,otherIndex,nums[otherIndex]-nums[edge.index]);
                diffs.add(newEdge);
            }
        }

        return diffs.remove().distance;
    }

    record Edge(int index, int otherIndex, int distance) {
    }
}
