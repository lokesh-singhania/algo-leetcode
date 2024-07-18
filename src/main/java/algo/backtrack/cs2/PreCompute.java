package algo.backtrack.cs2;

import algo.backtrack.CombinationSum2;

import java.util.*;

public class PreCompute implements CombinationSum2 {
    @Override
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // freq map
        // create sums as per that

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (var c : candidates) {
            freqMap.merge(c, 1, Integer::sum); //1->2
        }

        Map<Integer, List<List<Integer>>> combinations = new HashMap<>();
        combinations.put(0, List.of(List.of()));
        for (var entry : freqMap.entrySet()) {
            int candidate = entry.getKey();//1
            var maxFreq = entry.getValue();//2
            Map<Integer, List<List<Integer>>> newCombinations = new HashMap<>();//
            for (int sum : combinations.keySet()) {
                for (int freq = 1; freq <= maxFreq && sum + freq * candidate <= target; freq++) {
                    var container = newCombinations.computeIfAbsent(sum + freq * candidate, (k) -> new ArrayList<>());
                    for (var prevList : combinations.get(sum)) {
                        var newList = new ArrayList<>(prevList);
                        for (int i = freq; i > 0; i--) {
                            newList.add(candidate);
                        }
                        container.add(newList);
                    }
                }
            }
            newCombinations.forEach((k, lol) -> combinations.merge(k, lol, (ov, nv) -> {
                ov.addAll(nv);
                return ov;
            }));
        }


        return combinations.getOrDefault(target, Collections.emptyList());
    }
}
