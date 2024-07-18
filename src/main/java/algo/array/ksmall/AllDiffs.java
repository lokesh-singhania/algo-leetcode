package algo.array.ksmall;

import java.util.ArrayList;
import java.util.List;

public class AllDiffs implements KthSmallestDiff{
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        List<Integer> diffs = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=1+i;j<n;j++){
                diffs.add(Math.abs(nums[i]-nums[j]));
            }
        }

        return quickSelect(diffs, k);
    }

    int quickSelect(List<Integer> nums, int k)  {
//        int pivot = nums.get(i);
        throw new RuntimeException("str");
    }
}
