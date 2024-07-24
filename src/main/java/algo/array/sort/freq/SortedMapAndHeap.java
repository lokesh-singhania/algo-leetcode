package algo.array.sort.freq;

import algo.array.FreqSort;

import java.util.*;

public class SortedMapAndHeap implements FreqSort {
    public int[] frequencySort(int[] nums) {
        Map<Integer,Integer> numFreq = new HashMap<>();
        Arrays.stream(nums)
                .forEach(n->numFreq.merge(n,1,Integer::sum));
        Map<Integer,PriorityQueue<Integer>> fn = new TreeMap<>();
        numFreq.forEach((key, value) -> fn.computeIfAbsent(
                        value,
                        k -> new PriorityQueue<>(Comparator.reverseOrder()))
                .add(key));
        int j=0;
        for(var e:fn.entrySet()){
            var f=e.getKey();
            var ns = e.getValue();
            while(!ns.isEmpty()){
                var num = ns.remove();
                for(int i=0;i<f;i++){
                    nums[j++]=num;
                }
            }
        }
        return nums;
    }
}
