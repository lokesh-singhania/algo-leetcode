package algo.array.sort.freq;

import algo.array.FreqSort;

import java.util.*;
import java.util.stream.Collectors;

public class SortUnique implements FreqSort {

    public int[] frequencySort(int[] nums) {
        Map<Integer, Long> freqMap = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(k -> k, Collectors.counting()));
        List<Integer> keys = new ArrayList<>(freqMap.keySet());
        keys.sort(Comparator.<Integer, Long>comparing(freqMap::get)
                .thenComparing(Comparator.reverseOrder()));
        int j = 0;
        for (int key : keys) {
            var f = freqMap.get(key);
            for (int i = 0; i < f; i++) {
                nums[j++] = key;
            }
        }
        return nums;
    }
}

