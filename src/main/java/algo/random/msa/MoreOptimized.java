package algo.random.msa;

import java.util.Arrays;

import algo.random.MaxSubarray;

public class MoreOptimized implements MaxSubarray{

	@Override
	public int maxSubArray(int[] nums) {

		int[] maxSum=new int[nums.length];
		maxSum[0]=nums[0];
		for(int i=1;i<nums.length;i++) {
			maxSum[i]=Math.max(maxSum[i-1]+nums[i],nums[i]);
		}
		return Arrays.stream(maxSum).max().getAsInt();
	}

}
