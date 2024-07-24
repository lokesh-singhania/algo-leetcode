package algo.array.sort.remapped;

import java.util.Arrays;

public class TopDownMergeSort extends NumberConversion {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        int[] aux = Arrays.copyOf(nums, n);
        for (int size = 1; size < n; size <<= 1) {
            for (int lo = 0; lo < n; lo += size * 2) {
                int mid = lo + size - 1;
                int hi = Math.min(mid + size, n - 1);

                int i = lo;
                int j = mid + 1;
                for (int k = lo; k <= hi; k++) {
                    var takeFirst = (j > hi) || (i <= mid && lessOrEqual(nums[i], nums[j], mapping));
                    if (takeFirst) {
                        aux[k] = nums[i++];
                    } else {
                        aux[k] = nums[j++];
                    }
                }
            }
            var t = aux;
            aux = nums;
            nums = t;
        }
        return nums;
    }

    boolean lessOrEqual(int n1, int n2, int[] mapping) {
        return convert(n1, mapping) <= convert(n2, mapping);
    }
}
