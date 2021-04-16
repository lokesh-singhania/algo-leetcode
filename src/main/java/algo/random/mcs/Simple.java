package algo.random.mcs;

import static algo.annotations.ComplexityValue.CONSTANT;
import static algo.annotations.ComplexityValue.QUADRATIC;
import static algo.util.ArrayUtil.isEmpty;
import static algo.util.ArrayUtil.minIndex;
import static algo.util.Factory.EMPTY_ARRAY;

import algo.annotations.Complexity;
import algo.random.MostCompetitiveSubsequence;

@Complexity(time = QUADRATIC, space = CONSTANT)
public class Simple implements MostCompetitiveSubsequence {

	@Override
	public int[] mostCompetitive(int[] nums, int k) {
		if (isEmpty(nums) || k == 0) {
			return EMPTY_ARRAY;
		}
		int[] mostCompetitive = new int[k];
		int lo = 0;
		int hi = nums.length - k;
		int i = 0;
		while (i < k) {
			int minIndex = minIndex(nums, lo, hi);
			mostCompetitive[i++] = nums[minIndex];
			lo = minIndex + 1;
			hi++;
		}
		return mostCompetitive;
	}

}
