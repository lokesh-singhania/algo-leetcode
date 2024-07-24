package algo.array.sort.freq;

import algo.array.FreqSort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Functional implements FreqSort {

    @Override
    public int[] frequencySort(int[] nums) {
        Map<Integer,Integer> freq = new HashMap<>();
        Arrays.stream(nums)
                .forEach(n->freq.merge(n,1,Integer::sum));
        return Arrays.stream(nums)
                .boxed()
                .sorted(Comparator.<Integer,Integer>comparing(freq::get)
                        .thenComparing(Comparator.reverseOrder()))
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
