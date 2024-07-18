package algo.backtrack.cs;

import algo.backtrack.CombinationSum;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumBacktrack implements CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return new Backtrack(candidates).compute(target);
    }

    static class Backtrack{
        int[] candidates;
        List<List<Integer>> result;

        Backtrack(int[] a){
            candidates = a;
            result = new ArrayList<>();
        }

        public List<List<Integer>> compute(int target){
            backtrack(0,target,new ArrayList<>());
            return result;
        }

        private void backtrack(int i, int target, List<Integer> acc){
            if(target==0){
                if(!acc.isEmpty()){
                    result.add(acc);
                }
            }
            if(target<0 || i==candidates.length){
                return;
            }

            var candidate = candidates[i];
            var copy = new ArrayList<>(acc);
            while(target>=0){
                target-=candidate;
                copy.add(candidate);
                backtrack(i+1,target,new ArrayList<>(copy));
            }
        }
    }
}
