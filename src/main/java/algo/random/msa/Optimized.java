package algo.random.msa;

import algo.random.MaxSubarray;

public class Optimized implements MaxSubarray{

	@Override
	public int maxSubArray(int[] nums) {
		int maxSum=Integer.MIN_VALUE;
		for(int start=0;start<nums.length;start++) {
			int sum=0;
			for(int end=start;end<nums.length;end++) {
				sum+=nums[end];
				maxSum=Math.max(sum, maxSum);
			}
		}
		return maxSum;
	}

}
