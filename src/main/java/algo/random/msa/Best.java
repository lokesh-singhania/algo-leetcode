package algo.random.msa;

import algo.random.MaxSubarray;

public class Best implements MaxSubarray{

	@Override
	public int maxSubArray(int[] nums) {
        int prevMax=nums[0]; 
        int max=nums[0];
		for(int i=1;i<nums.length;i++) {
			int sum=Math.max(prevMax+nums[i],nums[i]);
            max=Math.max(max,sum);
            prevMax=sum;
		}
		return max;
	}

}
