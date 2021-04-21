package algo.april.impl.rsq;

import algo.april.RangeSumQuery;

public class Sophisticated implements RangeSumQuery {

    private int[] sums;

    public Sophisticated(int[] nums) {
        sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
    }

    @Override
    public int sumRange(int left, int right) {
        return sums[right] - (left == 0 ? 0 : sums[left - 1]);
    }
}
