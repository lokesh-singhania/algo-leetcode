package algo.random.msa;

import algo.random.MaxSubarray;

public class BruteForce implements MaxSubarray{

	@Override
	public int maxSubArray(int[] nums) {
		int maxSum=Integer.MIN_VALUE;
		for(int size=1;size<=nums.length;size++) {
			maxSum=Math.max(maxSubArray(nums,size),maxSum);
		}
		return maxSum;
	}

	private int maxSubArray(int[] nums, int size) {
		int maxSum=Integer.MIN_VALUE;
		for(int i=0;i<nums.length+1-size;i++) {
			int sum=0;
			for(int k=i;k<i+size;k++) {
				sum+=nums[k];
			}
			maxSum=Math.max(maxSum, sum);
		}
		return maxSum;
	}

}
